/**
 * 
 */
package org.rhm.stock.vo;

import java.util.Date;

/**
 * @author bob
 *
 */
public class StockStatistic {
	private String priceId = null;
	private String tickerSymbol = null;
	private Date statisticDate = null;
	private String statisticType = null;
	private Double statisticValue = null;
	private String statisticDescription = null;
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public Date getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}
	public String getStatisticType() {
		return statisticType;
	}
	public void setStatisticType(String statisticType) {
		this.statisticType = statisticType;
	}
	public Double getStatisticValue() {
		return statisticValue;
	}
	public void setStatisticValue(Double statisticValue) {
		this.statisticValue = statisticValue;
	}
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public String getStatisticDescription() {
		return statisticDescription;
	}
	public void setStatisticDescription(String statisticDescription) {
		this.statisticDescription = statisticDescription;
	}
	
	public String toString() {
		return this.priceId + "|" + this.statisticType + "|" + this.statisticValue; 
	}
}
