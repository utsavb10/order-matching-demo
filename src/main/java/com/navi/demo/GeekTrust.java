package com.navi.demo;

import com.navi.demo.repository.StockTransactionRepository;
import com.navi.demo.service.OrderMatchingService;

public class GeekTrust {
	
	private static final OrderMatchingService orderMatchingService = new OrderMatchingService();
	private static final StockTransactionRepository transactionRepository = StockTransactionRepository.getStockTransactionRepository();
	
	public static void main(String[] args){
		orderMatchingService.createStockOrderFromFile(args[0]);
//		stocks.parallelStream()
//			.forEach(stock -> orderMatchingService.matchBuyOrdersForStock(stock));
		transactionRepository.getTransactions()
			.stream()
			.forEach(stockTransaction -> System.out.println(stockTransaction));
	}
}
