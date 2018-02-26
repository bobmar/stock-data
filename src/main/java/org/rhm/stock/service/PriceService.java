package org.rhm.stock.service;

import java.util.List;

import org.rhm.stock.dao.PriceRepo;
import org.rhm.stock.dao.StatisticRepo;
import org.rhm.stock.dao.http.YahooPriceDownloader;
import org.rhm.stock.dto.PriceBean;
import org.rhm.stock.vo.StockPrice;
import org.rhm.stock.vo.StockStatistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
//	@Autowired
//	private PriceRepo priceRepo = null;
//	@Autowired
//	private StatisticRepo statRepo = null;
	@Autowired
	private YahooPriceDownloader priceDownloader = null;
	private Logger logger = LoggerFactory.getLogger(PriceService.class);

//	public List<StockPrice> retrievePrices(String tickerSymbol) {
//		List<StockPrice> priceList = priceRepo.retrievePrices(tickerSymbol);
//		return priceList;
//	}
//	
//	public boolean createPrice(StockPrice price) {
//		return priceRepo.createPrice(price);
//	}
//	
//	public boolean deletePrice(String priceId) {
//		return priceRepo.deletePrice(priceId);
//	}
//	
//	public boolean createStat(StockStatistic stat) {
//		return statRepo.createStatistic(stat);
//	}
	
	public List<PriceBean> downloadPrices(String tickerSymbol, Integer histDays) {
		return priceDownloader.downloadPrices(tickerSymbol, histDays);
	}
}
