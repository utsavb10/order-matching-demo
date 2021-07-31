package com.navi.demo.dagger;

import com.navi.demo.entity.OrderType;
import com.navi.demo.repository.OrderRepository;
import com.navi.demo.repository.impl.BuyOrderRepository;
import com.navi.demo.repository.impl.SellOrderRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Thanks to the Inject annotated constructor Dagger knows how to create a new instance of the UseCase class when it’s necessary.
 * This is the easiest way to manage instances of a class using Dagger, unfortunately there are some limitations. It can be used when:
 * 	1. A class can be instantiated directly using the constructor
 * 	2. The creation is not managed by an external framework (for example activities and fragments)
 * 	3. The source code can be modified to add the annotation
 *
 *
 * 	Solution to this case -> https://stackoverflow.com/questions/39953933/dagger-2-two-provides-method-that-provide-same-interface
 */
@Module
public class OrderRepositoryModule {

	@Provides
	@Singleton
	@Named(value = "buy")
	public OrderRepository provideBuyOrderRepository(){
		return new BuyOrderRepository();
	}

	@Provides
	@Singleton
	@Named(value = "sell")
	public OrderRepository provideSellOrderRepository(){
		return new SellOrderRepository();
	}

}
