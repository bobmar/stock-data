package org.rhm.stock.dao;

import java.util.List;

import org.rhm.stock.vo.StockTicker;

public interface TickerRepo {
	public List<StockTicker> retrieveAllTickers();
	public StockTicker retrieveTicker(String tickerSymbol);
	public boolean createTicker(StockTicker ticker);
	public boolean deleteTicker(String tickerSymbol);
	public boolean updateTicker(StockTicker ticker);
}
