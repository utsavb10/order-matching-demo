package com.navi.demo.entity;

import java.util.Objects;

public class Stock {
//	private Long stockId;
	private String name;

	public Stock(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Stock stock = (Stock) o;
		return  name.equals(stock.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return this.name;
	}

	//	public Long getStockId() {
//		return stockId;
//	}
//
//	public void setStockId(Long stockId) {
//		this.stockId = stockId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
