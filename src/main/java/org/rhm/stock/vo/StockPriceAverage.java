/**
 * 
 */
package org.rhm.stock.vo;


/**
 * @author bob
 *
 */
public class StockPriceAverage {
	private Double avgClose10Day = null;
	private Double avgClose50Day = null;
	private Double avgClose200Day = null;
	private Long avgVol10Day = null;
	private Long avgVol50Day = null;
	private Long avgVol200Day = null;
	
	public Double getAvgClose10Day() {
		return avgClose10Day;
	}
	public void setAvgClose10Day(Double avgClose10Day) {
		this.avgClose10Day = avgClose10Day;
	}
	public Double getAvgClose50Day() {
		return avgClose50Day;
	}
	public void setAvgClose50Day(Double avgClose50Day) {
		this.avgClose50Day = avgClose50Day;
	}
	public Double getAvgClose200Day() {
		return avgClose200Day;
	}
	public void setAvgClose200Day(Double avgClose200Day) {
		this.avgClose200Day = avgClose200Day;
	}
	public Long getAvgVol10Day() {
		return avgVol10Day;
	}
	public void setAvgVol10Day(Long avgVol10Day) {
		this.avgVol10Day = avgVol10Day;
	}
	public Long getAvgVol50Day() {
		return avgVol50Day;
	}
	public void setAvgVol50Day(Long avgVol50Day) {
		this.avgVol50Day = avgVol50Day;
	}
	public Long getAvgVol200Day() {
		return avgVol200Day;
	}
	public void setAvgVol200Day(Long avgVol200Day) {
		this.avgVol200Day = avgVol200Day;
	}
}
