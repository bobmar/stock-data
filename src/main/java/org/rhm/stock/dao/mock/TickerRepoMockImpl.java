package org.rhm.stock.dao.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.rhm.stock.dao.TickerRepo;
import org.rhm.stock.vo.StockTicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mockTickerRepo")
public class TickerRepoMockImpl implements TickerRepo {
	private Logger logger = LoggerFactory.getLogger(TickerRepoMockImpl.class);

	@PostConstruct
	public void init() {
		logger.debug("MockTickerRepo initialized");
	}
	
	@Override
	public List<StockTicker> retrieveAllTickers() {
		List<StockTicker> tickerList = new ArrayList<StockTicker>();
		tickerList.add(this.createMockTicker("AAL", "American Airlines"));
		tickerList.add(this.createMockTicker("AAPL", "Apple Computer"));
		tickerList.add(this.createMockTicker("GE", "General Electric"));
		tickerList.add(this.createMockTicker("HUN", "Huntsman"));
		tickerList.add(this.createMockTicker("IBM", "International Business Machines"));
		tickerList.add(this.createMockTicker("WFC", "Wells Fargo & Company"));
		return tickerList;
	}

	private StockTicker createMockTicker(String tickerSymbol, String companyName) {
		StockTicker ticker = new StockTicker();
		ticker.setTickerSymbol(tickerSymbol);
		ticker.setCompanyName(companyName);
		return ticker;
	}
	
	@Override
	public StockTicker retrieveTicker(String tickerSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createTicker(StockTicker ticker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTicker(String tickerSymbol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTicker(StockTicker ticker) {
		// TODO Auto-generated method stub
		return false;
	}

}
