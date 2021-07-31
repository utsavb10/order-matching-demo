package com.navi.demo.repository.impl;

import com.navi.demo.entity.Stock;
import com.navi.demo.entity.StockOrder;
import com.navi.demo.repository.OrderRepository;

import java.util.*;

import static com.navi.demo.entity.OrderType.BUY;
import static com.navi.demo.entity.OrderType.SELL;

public class SellOrderRepository extends OrderRepository {

	{
		this.orderType = SELL;
	}
}
