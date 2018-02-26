package org.rhm.stock.calculator;

import java.util.List;

import org.rhm.stock.service.PriceService;
import org.rhm.stock.vo.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Calculate price statistics for a single ticker symbol.
 * @author bob
 *
 */
@Component
public abstract class PriceStatCalculator {
	@Autowired
	private PriceService priceService = null;
	public abstract void calculate(String tickerSymbol);
	public abstract void calculate(List<StockPrice> priceList);
}
