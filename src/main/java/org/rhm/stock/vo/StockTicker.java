package org.rhm.stock.vo;

public class StockTicker {
	private String tickerSymbol = null;
	private String companyName = null;
	private String refreshPrices = null;
	private String sectorName = null;
	private String industryName = null;
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRefreshPrices() {
		return refreshPrices;
	}
	public void setRefreshPrices(String refreshPrices) {
		this.refreshPrices = refreshPrices;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
}
