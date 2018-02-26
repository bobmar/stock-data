package org.rhm.stock.vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.rhm.stock.util.YahooDataHelper;

public class StockOption {
	private String id = null;
	private String tickerSymbol = null;
	private String optionSymbol = null;
	private String underlyingSymbol = null;
	private String optionType = null;
	private Date expirationDate = null;
	private String expirationDateStr = null;
	private Double strikePrice = null;
	private Double lastPrice = null;
	private Double bidPrice = null;
	private Double askPrice = null;
	private Integer volume = null;
	private Integer openInterest = null;
	private Double impliedVolatility = null;
	private Date createdDate = null;
	private Date modifiedDate = null;
	
	public StockOption() {}
	
	public StockOption(Map<String,Object> optionMap) {
		this.setOptionSymbol((String)optionMap.get("contractSymbol")); 
		this.strikePrice = Double.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("strike")).doubleValue()); 
		this.bidPrice = Double.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("bid")).doubleValue()); 
		this.askPrice = Double.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("ask")).doubleValue()); 
		this.volume = Integer.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("volume")).intValue()); 
		this.openInterest = Integer.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("openInterest")).intValue()); 
		this.impliedVolatility = Double.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("impliedVolatility")).doubleValue()); 
		this.lastPrice = Double.valueOf(YahooDataHelper.getRaw((Map<String,Object>)optionMap.get("lastPrice")).doubleValue());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOptionSymbol() {
		return optionSymbol;
	}
	private void parseOptionSymbol() {
	//WFC130927P00044000
//		int strikeStart = optionSymbol.length() - 8;
		DateFormat df = new SimpleDateFormat("yyMMdd");
		int optionTypeStart = optionSymbol.length() - 9;
		int expirationStart = optionSymbol.length() - 15;
		this.underlyingSymbol = optionSymbol.substring(0, expirationStart);
		this.optionType = optionSymbol.substring(optionTypeStart, optionTypeStart + 1);
		this.expirationDateStr = optionSymbol.substring(expirationStart, expirationStart + 6);
		try {
			this.expirationDate = df.parse(expirationDateStr);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void setOptionSymbol(String optionSymbol) {
		this.optionSymbol = optionSymbol;
		this.parseOptionSymbol();
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Double getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}
	public Double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public Double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(Double askPrice) {
		this.askPrice = askPrice;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(Integer openInterest) {
		this.openInterest = openInterest;
	}
	public String getExpirationDateStr() {
		return expirationDateStr;
	}
	public void setExpirationDateStr(String expirationDateStr) {
		this.expirationDateStr = expirationDateStr;
	}
	
	public String getUnderlyingSymbol() {
		return underlyingSymbol;
	}
	public void setUnderlyingSymbol(String underlyingSymbol) {
		this.underlyingSymbol = underlyingSymbol;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(optionSymbol);
		sb.append('|');
		sb.append(expirationDate);
		sb.append('|');
		sb.append(optionType);
		sb.append('|');
		sb.append(strikePrice);
		sb.append('|');
		sb.append(lastPrice);
		sb.append('|');
		sb.append(bidPrice);
		sb.append('|');
		sb.append(askPrice);
		sb.append('|');
		sb.append(volume);
		sb.append('|');
		sb.append(openInterest);
		return sb.toString();
	}
	public static void main(String[] args) {
		StockOption option = new StockOption();
		option.setOptionSymbol("WFC130927P00044000");
		System.out.println(option.toString());
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Double getImpliedVolatility() {
		return impliedVolatility;
	}
	public void setImpliedVolatility(Double impliedVolatility) {
		this.impliedVolatility = impliedVolatility;
	}
}
