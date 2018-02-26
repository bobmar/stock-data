package org.rhm.stock.vo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockPrice {
	private String tickerSymbol = null;
	private Date priceDate = null;
	private String priceId = null;
	private BigDecimal closePrice = null;
	private BigDecimal openPrice = null;
	private BigDecimal lowPrice = null;
	private BigDecimal highPrice = null;
	private Long volume = null;
	private String priceDateStr = null;
	private BigDecimal putCallRatio = null;	
	private DateFormat dtFmt = new SimpleDateFormat("yyyy-MM-dd");
	public StockPrice() {}
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public Date getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
		this.priceDateStr = dtFmt.format(priceDate);
	}
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	public Long getVolume() {
		return volume;
	}
	public Double getDollarVolume() {
		return this.volume * this.closePrice.doubleValue();
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	
	public String toString() {
		return this.tickerSymbol + ":" + this.priceDateStr;
	}

	public String getPriceDateStr() {
		return priceDateStr;
	}

	public void setPriceDateStr(String priceDateStr) {
		this.priceDateStr = priceDateStr;
	}
	
	public Double getHighLowRange() {
		BigDecimal result = BigDecimal.valueOf(highPrice.doubleValue() - lowPrice.doubleValue()).round(new MathContext(3));
		return result.doubleValue();
	}
	
	public Double getOpenCloseRange() {
		BigDecimal result = BigDecimal.valueOf(closePrice.doubleValue() - openPrice.doubleValue()).round(new MathContext(3));
		return result.doubleValue();
	}
	
	public Double getHighLowVsClosePct() {
		BigDecimal result = null;
		try {
			result = BigDecimal.valueOf(((getHighLowRange() / closePrice.doubleValue()) * 100)).round(new MathContext(3));
		}
		catch (NumberFormatException e) {
			result = new BigDecimal(0.0);
		}
		return result.doubleValue();
	}
	
	public Double getOpenCloseVsHighLowPct() {
		BigDecimal result = null;
		try {
			result = BigDecimal.valueOf(((getOpenCloseRange() / getHighLowRange()) * 100)).round(new MathContext(3));
		}
		catch (NumberFormatException e) {
			result = new BigDecimal(0.0);
		}
		return result.doubleValue();
	}

	public Double getCloseVsLowDiffPct() {
		BigDecimal result = null;
		try {
			result = BigDecimal.valueOf((((closePrice.doubleValue() - lowPrice.doubleValue()) / lowPrice.doubleValue()) * 100)).round(new MathContext(3));
		}
		catch (NumberFormatException e) {
			result = new BigDecimal(0.0);
		}
		return result.doubleValue();
	}
	
	public Double getCloseVsHighDiffPct() {
		BigDecimal result = null;
		try {
			result = BigDecimal.valueOf((((highPrice.doubleValue() - closePrice.doubleValue()) / highPrice.doubleValue()) * 100)).round(new MathContext(3));
		}
		catch (NumberFormatException e) {
			result = new BigDecimal(0.0);
		}
		return result.doubleValue();
	}
	
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (this.toString().equals(((StockPrice)o).toString())) {
			isEqual = true;
		}
		return isEqual;
	}

	public BigDecimal getPutCallRatio() {
		return putCallRatio;
	}

	public void setPutCallRatio(BigDecimal putCallRatio) {
		this.putCallRatio = putCallRatio;
	}
}
