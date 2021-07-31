package com.navi.demo.repository.impl;

import com.navi.demo.repository.OrderRepository;

import static com.navi.demo.entity.OrderType.BUY;

public class BuyOrderRepository extends OrderRepository {
	{
		this.orderType = BUY;
	}
}
