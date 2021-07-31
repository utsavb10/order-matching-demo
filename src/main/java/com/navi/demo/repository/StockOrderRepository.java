package com.navi.demo.repository;

import com.navi.demo.entity.OrderType;
import com.navi.demo.entity.Stock;
import com.navi.demo.entity.StockOrder;
import com.navi.demo.repository.impl.BuyOrderRepository;
import com.navi.demo.repository.impl.SellOrderRepository;

import java.util.HashSet;
import java.util.Set;

import static com.navi.demo.entity.OrderType.BUY;
import static com.navi.demo.entity.OrderType.SELL;

public class StockOrderRepository {
	private static final OrderRepository buyRepository = new BuyOrderRepository();
	private static final OrderRepository sellRepository = new SellOrderRepository();

	public void addOrder(StockOrder order){
		getOrderRepository(order.getType()).addOrder(order);
	}

	public StockOrder getPriorOrder(Stock stock, OrderType type){
		return getOrderRepository(type).getPriorOrder(stock);
	}

	public StockOrder getNextOrder(StockOrder order){
		return getOrderRepository(order.getType()).getNextOrder(order);
	}

	public void removeOrder(StockOrder order){
		getOrderRepository(order.getType()).removeOrder(order);
	}

	public Set<Stock> getStockSet(){
		Set<Stock> stockSet = new HashSet<>();
		stockSet.addAll(buyRepository.getStockSet());
		stockSet.addAll(sellRepository.getStockSet());
		return stockSet;
	}

	private OrderRepository getOrderRepository(OrderType type){
		if(BUY == type){
			return buyRepository;
		}
		if(SELL == type){
			return sellRepository;
		}
		return null;
	}
}
