package com.navi.demo.dagger;

import com.navi.demo.repository.StockTransactionRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class StockTransactionRepositoryModule {

	/**
	 * The Inject annotation on the constructor cannot be used when an object must be created with a factory,
	 * builder, or defined in an external library. A perfect example is a Retrofit service.
	 * The implementation is created using a Retrofit builder so the constructor of the concrete class cannot be annotated.
	 * In this case a Provides annotated method in a module can be used.
	 */
	@Provides
	@Singleton
	public StockTransactionRepository provideStockTransactionRepository(){
		return StockTransactionRepository.getStockTransactionRepository();
	}
}
