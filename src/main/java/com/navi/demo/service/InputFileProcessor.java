package com.navi.demo.service;

import com.navi.demo.entity.OrderType;
import com.navi.demo.entity.Stock;
import com.navi.demo.entity.StockOrder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class InputFileProcessor {

	public static List<StockOrder> readOrdersFromFile(String fileName){
		List<StockOrder> orderList = new ArrayList<>();
		BufferedReader orderReader;
		try{
			orderReader = new BufferedReader(new FileReader(fileName));
			String line = orderReader.readLine();
			while( null != line) {
				orderList.add(convertFileLineToOrder(line));
				line = orderReader.readLine();
			}
			orderReader.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return orderList;
	}

	private static StockOrder convertFileLineToOrder(String line){
			String[] orderText = line.split(" ");
			//<order-id> <time> <stock> <buy/sell> <price> <qty>
			StockOrder order = new StockOrder(orderText[0],
				LocalTime.parse(orderText[1]),
				new Stock(orderText[2]),
				orderText[3],
				new BigDecimal(orderText[4]),
				Long.valueOf(orderText[5]));
//			System.out.println(order);
			return order;
	}

//	private static LocalTime createLocalTime(String str){
//		LocalTime localTime = null;
//		if(null != str && str.contains(":")){
//			String[] clock = str.split(":");
//			try {
//				localTime = LocalTime.of(Integer.parseInt(clock[0]), Integer.parseInt(clock[1]));
//			} catch(DateTimeException e){
//				System.out.println("Error parsing "+str+" into LocalTime object");
//			}
//		}
//		return localTime;
//	}
}
