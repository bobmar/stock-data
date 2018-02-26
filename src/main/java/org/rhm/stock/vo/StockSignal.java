package org.rhm.stock.vo;

import java.util.Date;

public class StockSignal {
	private String priceId = null;
	private Date priceDate = null;
	private String signalCode = null;
	private String signalDesc = null;

	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public Date getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}
	public String getSignalCode() {
		return signalCode;
	}
	public void setSignalCode(String signalCode) {
		this.signalCode = signalCode;
	}
	public String getSignalDesc() {
		return signalDesc;
	}
	public void setSignalDesc(String signalDesc) {
		this.signalDesc = signalDesc;
	}


}
