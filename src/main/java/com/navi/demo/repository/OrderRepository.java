package com.navi.demo.repository;

import com.navi.demo.entity.OrderType;
import com.navi.demo.entity.Stock;
import com.navi.demo.entity.StockOrder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class OrderRepository {
	protected OrderType orderType;
	protected final Map<Stock, TreeSet<StockOrder>> orderMap = new HashMap<>();

	protected final Comparator<StockOrder> orderComparator = new Comparator<StockOrder>() {
		@Override
		public int compare(StockOrder o1, StockOrder o2) {
			if(0 != o1.getPrice().compareTo(o2.getPrice()))
				return o2.getPrice().compareTo(o1.getPrice());

			return o1.getTime().compareTo(o2.getTime());
		}
	};

	public void addOrder(StockOrder order){
		if(orderType == order.getType()){
			if(!orderMap.containsKey(order.getStock())){
				orderMap.put(order.getStock(), new TreeSet<>(orderComparator));
			}
			orderMap.get(order.getStock()).add(order);
		}
	}

	public Set<Stock> getStockSet(){
		return orderMap.keySet();
	}

	public StockOrder getPriorOrder(Stock stock){
		StockOrder order = null;
		if(orderMap.containsKey(stock) && !orderMap.get(stock).isEmpty()){
			order = orderMap.get(stock).first();
		}
		return order;
	}

	public StockOrder getNextOrder(StockOrder stockOrder){
		Stock stock = stockOrder.getStock();
		StockOrder nextOrder = null;
		if(orderMap.containsKey(stock) && orderMap.get(stock).contains(stockOrder)){
			nextOrder = orderMap.get(stock).higher(stockOrder);
		}
		return nextOrder;
	}

	public void removeOrder(StockOrder order){
		orderMap.get(order.getStock()).remove(order);
	}
}
