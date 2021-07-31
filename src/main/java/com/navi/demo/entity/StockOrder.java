package com.navi.demo.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

public class StockOrder {
	private String orderId;
	private LocalTime time;
	private Stock stock;
	private OrderType type;
	private BigDecimal price;
	private volatile Long qty;

	//<order-id> <time> <stock> <buy/sell> <price> <qty>
	public boolean isFulfilled(){
		if(qty > 0){
			return false;
		}
		return true;
	}

	public StockOrder(String orderId, LocalTime time, Stock stock, OrderType type, BigDecimal price, Long qty) {
		this.orderId = orderId;
		this.time = time;
		this.stock = stock;
		this.type = type;
		this.price = price;
		this.qty = qty;
	}

	public StockOrder(String orderId, LocalTime time, Stock stock, String type, BigDecimal price, Long qty) {
		this.orderId = orderId;
		this.time = time;
		this.stock = stock;
		this.type = getOrderType(type);
		this.price = price;
		this.qty = qty;
	}

	private static OrderType getOrderType(String type){
		if("BUY".equalsIgnoreCase(type)){
			return OrderType.BUY;
		} else if("SELL".equalsIgnoreCase(type)){
			return OrderType.SELL;
		}
		return null;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StockOrder{" +
			"orderId='" + orderId + '\'' +
			", time=" + time +
			", stock=" + stock +
			", type=" + type +
			", price=" + price +
			", qty=" + qty +
			'}';
	}
}
