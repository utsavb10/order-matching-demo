package com.navi.demo;

import com.navi.demo.dagger.DaggerOrderMatchingServiceComponent;
import com.navi.demo.dagger.DaggerStockTransactionRepositoryComponent;
import com.navi.demo.repository.StockTransactionRepository;
import com.navi.demo.service.OrderMatchingService;

public class GeekTrust {
	
	private static final OrderMatchingService orderMatchingService = DaggerOrderMatchingServiceComponent.create().buildService();
	private static final StockTransactionRepository transactionRepository = DaggerStockTransactionRepositoryComponent.create().getStockTransactionRepository();
	
	public static void main(String[] args){
		orderMatchingService.createStockOrderFromFile(args[0]);
//		stocks.parallelStream()
//			.forEach(stock -> orderMatchingService.matchBuyOrdersForStock(stock));
		transactionRepository.getTransactions()
			.stream()
			.forEach(stockTransaction -> System.out.println(stockTransaction));
	}
}
