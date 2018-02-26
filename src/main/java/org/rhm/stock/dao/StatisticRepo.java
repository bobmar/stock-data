package org.rhm.stock.dao;

import java.util.List;

import org.rhm.stock.vo.StockStatistic;

public interface StatisticRepo {
	public boolean createStatistic(StockStatistic stat);
	public List<StockStatistic> retrieveStats(String tickerSymbol, String statCode);
}
