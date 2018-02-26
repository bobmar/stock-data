package org.rhm.stock;

import org.rhm.stock.controller.StockDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockDataApplication  implements CommandLineRunner {
	@Autowired
	private StockDataLoader dataLoader = null;
	public static void main(String[] args) {
		SpringApplication.run(StockDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataLoader.run();
	}
}
