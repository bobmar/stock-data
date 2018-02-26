package org.rhm.stock.controller;

import java.util.Date;
import java.util.List;

import org.rhm.stock.dto.PriceBean;
import org.rhm.stock.io.TickerQueue;
import org.rhm.stock.service.PriceService;
import org.rhm.stock.vo.StockTicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockDataLoader {
	private Logger logger = LoggerFactory.getLogger(StockDataLoader.class);
	@Autowired
	private TickerQueue queue = null;
	@Autowired
	private PriceService priceSvc = null;
	public void run(String... args) throws Exception {
		logger.info("Price loader started at " + new Date());
		StockTicker ticker = null;
		List<PriceBean> priceData = null;
		while (queue.hasMore()) {
			ticker = queue.next();
			logger.debug(ticker.getTickerSymbol() + "-" + ticker.getCompanyName());
			priceData = priceSvc.downloadPrices(ticker.getTickerSymbol(), 30);
			for (PriceBean price: priceData) {
				logger.debug(ticker.getTickerSymbol() + ":" + price.toString());
			}
		}
	}

}
