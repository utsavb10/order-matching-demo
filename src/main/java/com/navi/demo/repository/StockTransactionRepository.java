package com.navi.demo.repository;

import com.navi.demo.entity.StockTransaction;

import java.util.ArrayList;
import java.util.List;

public class StockTransactionRepository {
	private static StockTransactionRepository transactionRepository = null;
	private List<StockTransaction> transactions;

	private StockTransactionRepository(){
		transactions = new ArrayList<>();
	}

	public static StockTransactionRepository getStockTransactionRepository(){
		if( null == transactionRepository ){
			transactionRepository = new StockTransactionRepository();
		}
		return transactionRepository;
	}

	public List<StockTransaction> getTransactions() {
		return transactions;
	}
}
