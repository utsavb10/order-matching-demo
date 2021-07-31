package com.navi.demo.dagger;

import com.navi.demo.repository.StockTransactionRepository;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {StockTransactionRepositoryModule.class})
public interface StockTransactionRepositoryComponent {

	public StockTransactionRepository getStockTransactionRepository();
}
