package org.rhm.stock.dao;

import java.util.Date;
import java.util.List;

import org.rhm.stock.vo.StockPrice;

public interface PriceRepo {
	public List<StockPrice> retrievePrices(String tickerSymbol);
	public boolean createPrice(StockPrice price);
	public boolean deletePrice(String priceId);
	public boolean deletePrices(String tickerSymbol);
	public boolean exists(String tickerSymbol, Date priceDate);
}
