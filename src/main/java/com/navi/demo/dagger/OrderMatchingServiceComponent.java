package com.navi.demo.dagger;

import com.navi.demo.service.OrderMatchingService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {OrderRepositoryModule.class, StockTransactionRepositoryModule.class})
public interface OrderMatchingServiceComponent {
	public OrderMatchingService buildService();
}
