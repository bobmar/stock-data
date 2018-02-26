package org.rhm.stock.io;

import java.util.List;

import javax.annotation.PostConstruct;

import org.rhm.stock.dao.TickerRepo;
import org.rhm.stock.vo.StockTicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Retrieves a list of stocks and allows synchronized retrieval of the next entry.
 * @author bob
 *
 */
@Component
public class TickerQueue {
	@Autowired
	@Qualifier("mockTickerRepo")
	private TickerRepo repo = null;
	
	private Logger logger = LoggerFactory.getLogger(TickerQueue.class);
	private List<StockTicker> tickerList = null;
	private int tickerIndex = 0;
	private int maxIndex = -1;

	@PostConstruct
	private void init() {
		this.tickerList = repo.retrieveAllTickers();
		this.maxIndex = (this.tickerList.size() - 1);
		this.logger.debug("Loaded " + tickerList.size() + " tickers");
	}
	
	public void reset() {
		this.tickerIndex = 0;
	}
	
	public void reset(String tickerSymbol) {
		for (int i = 0; i < this.tickerList.size(); i++) {
			if (tickerSymbol.equals(tickerList.get(i).getTickerSymbol())) {
				this.tickerIndex = i;
				break;
			}
		}
	}
	
	public StockTicker next() {
		StockTicker ticker = null;
		if (tickerIndex <= maxIndex) {
			ticker = this.tickerList.get(tickerIndex++);
		}
		return ticker;
	}
	
	public boolean hasMore() {
		return (this.tickerIndex <= this.maxIndex);
	}
}
