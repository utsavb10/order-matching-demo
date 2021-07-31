package com.navi.demo.entity;

import java.math.BigDecimal;

public class StockTransaction {
	//<buy-order-id> <sell-price> <qty> <sell-order-id>
	private String buyOrderId;
	private BigDecimal sellPrice;
	private Long qty;
	private String sellOrderId;

	public StockTransaction(String buyOrderId, BigDecimal sellPrice, Long qty, String sellOrderId) {
		this.buyOrderId = buyOrderId;
		this.sellPrice = sellPrice;
		this.qty = qty;
		this.sellOrderId = sellOrderId;
	}

	@Override
	public String toString() {
		return buyOrderId + " " +
			sellPrice +" " +
			qty + " " +
			sellOrderId;
	}

	public String getBuyOrderId() {
		return buyOrderId;
	}

	public void setBuyOrderId(String buyOrderId) {
		this.buyOrderId = buyOrderId;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public String getSellOrderId() {
		return sellOrderId;
	}

	public void setSellOrderId(String sellOrderId) {
		this.sellOrderId = sellOrderId;
	}
}
