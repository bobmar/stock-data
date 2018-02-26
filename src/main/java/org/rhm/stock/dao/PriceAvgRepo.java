package org.rhm.stock.dao;

import java.util.List;

import org.rhm.stock.vo.StockPriceAverage;

public interface PriceAvgRepo {
	public boolean createPriceAvg(StockPriceAverage priceAvg);
	public List<StockPriceAverage> retrieveAvgPrices(String tickerSymbol);
}
