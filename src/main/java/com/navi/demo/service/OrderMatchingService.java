package com.navi.demo.service;

import com.navi.demo.entity.OrderType;
import com.navi.demo.entity.Stock;
import com.navi.demo.entity.StockOrder;
import com.navi.demo.entity.StockTransaction;
import com.navi.demo.repository.StockOrderRepository;
import com.navi.demo.repository.StockTransactionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Set;

import static com.navi.demo.entity.OrderType.BUY;
import static com.navi.demo.entity.OrderType.SELL;

@Singleton
public class OrderMatchingService {

	public final StockOrderRepository stockOrderRepository;
	public final StockTransactionRepository stockTransactionRepository;

	@Inject
	public OrderMatchingService(StockOrderRepository stockOrderRepository, StockTransactionRepository stockTransactionRepository) {
		this.stockOrderRepository = stockOrderRepository;
		this.stockTransactionRepository = stockTransactionRepository;
	}

	public Set<Stock> createStockOrderFromFile(String fileName){
		List<StockOrder> orders = InputFileProcessor.readOrdersFromFile(fileName);
		for(StockOrder order : orders){
			stockOrderRepository.addOrder(order);
			matchBuyOrdersForStock(order.getStock());
		}

		return stockOrderRepository.getStockSet();
	}

	// this method can be run in a separate thread everytime a stock is added
	public void matchBuyOrdersForStock(Stock stock){
		StockOrder buyOrder = stockOrderRepository.getPriorOrder(stock, BUY);
		StockOrder sellOrder = stockOrderRepository.getPriorOrder(stock, SELL);
		while(buyOrder != null && sellOrder != null){
			while(sellOrder != null && sellOrder.getPrice().compareTo(buyOrder.getPrice()) > 0){
				sellOrder = stockOrderRepository.getNextOrder(sellOrder);
			}

			while(null != sellOrder && !buyOrder.isFulfilled()){
				stockTransactionRepository.getTransactions().add(createStockTransaction(buyOrder, sellOrder));
				if(sellOrder.isFulfilled()){
					StockOrder temp = stockOrderRepository.getNextOrder(sellOrder);
					stockOrderRepository.removeOrder(sellOrder);
					sellOrder = temp;
				}
				if(buyOrder.isFulfilled()){
					break;
				}
			}
			if(buyOrder.isFulfilled()){
				StockOrder temp = stockOrderRepository.getNextOrder(buyOrder);
				stockOrderRepository.removeOrder(buyOrder);
				buyOrder = temp;
			}
		}
	}

	//this block should be executed at atomic level for multithreaded scenarios
	private synchronized StockTransaction createStockTransaction(StockOrder buyOrder, StockOrder sellOrder){
		long qty = Math.min(buyOrder.getQty(), sellOrder.getQty());
		sellOrder.setQty(sellOrder.getQty() - qty);
		buyOrder.setQty(buyOrder.getQty() - qty);
		return new StockTransaction(buyOrder.getOrderId(), sellOrder.getPrice(), qty, sellOrder.getOrderId());
	}
}
