package org.rhm.stock.dao;

import java.util.List;

import org.rhm.stock.vo.StockOption;

public interface OptionRepo {
	public boolean createOption(StockOption option);
	public List<StockOption> retrieveOptionsByTicker(String tickerSymbol);
	public StockOption retrieveOption(String optionSymbol);
	public int deleteOptionsByTicker(String tickerSymbol);
	public int deleteExpiredOptions();
	public boolean updateOption(StockOption option);
}
