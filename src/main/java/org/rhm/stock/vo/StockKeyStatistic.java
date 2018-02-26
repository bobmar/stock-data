package org.rhm.stock.vo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.rhm.stock.util.YahooDataHelper;

public class StockKeyStatistic {
	private String tickerSymbol = null;
	private Long seqNum = null;
	private BigDecimal grossProfit = null;
	private BigDecimal bookValuePerShare = null;
	private BigDecimal p52WeekHigh = null;
	private BigDecimal fwdPeRatio = null;
	private BigDecimal pctHeldbyInstitutions = null;
	private BigDecimal enterpriseValueRevenue = null;
	private BigDecimal totalCash = null;
	private BigDecimal totalDebt = null;
	private BigDecimal marketCap = null;
	private BigDecimal pctHeldbyInsiders = null;
	private Date lastSplitDate = null;
	private BigDecimal p52WeekLow = null;
	private BigDecimal currentRatio = null;
	private BigDecimal fwdAnnualDividendRate = null;
	private BigDecimal operatingCashFlow = null;
	private BigDecimal sharesShort = null;
	private Date mostRecentQuarter = null;
	private BigDecimal enterpriseValue = null;
	private Long avgVol = null;
	private BigDecimal qtrlyRevGrowthPct = null;
	private BigDecimal leveredFreeCashFlow = null;
	private String lastSplitFactor = null;
	private BigDecimal enterpriseValueEbitda = null;
	private BigDecimal profitMarginPct = null;
	private BigDecimal revenue = null;
	private BigDecimal trailingPe = null;
	private BigDecimal trailingAnnualDivYldPct = null;
	private BigDecimal p52WeekChgPct = null;
	private BigDecimal beta = null;
	private BigDecimal totalCashPerShare = null;
	private BigDecimal shortPctOfFloat = null;
	private BigDecimal dilutedEps = null;
	private BigDecimal netIncomeAvltoCommon = null;
	private BigDecimal p5YrAvgDivYldPct = null;
	private BigDecimal sharesOutstanding = null;
	private BigDecimal sp50052WeekChgPct = null;
	private BigDecimal returnOnAssetsPct = null;
	private BigDecimal floatShrsCnt = null;
	private Date exDivDate = null;
	private BigDecimal payoutRatioPct = null;
	private BigDecimal qtrlyEarningsGrowthPct = null;
	private BigDecimal p200DayMovingAvg = null;
	private BigDecimal ebitda = null;
	private BigDecimal p50DayMovingAvg = null;
	private BigDecimal pegRatio = null;
	private BigDecimal totalDebtEquity = null;
	private BigDecimal fwdAnnualDivYldPct = null;
	private BigDecimal operatingMarginPct = null;
	private Date divDate = null;
	private BigDecimal revenuePerShare = null;
	private String fiscalYearEnds = null;
	private BigDecimal priceBook = null;
	private BigDecimal returnOnEquity = null;
	private BigDecimal shortRatio = null;
	private BigDecimal priceSales = null;
	private Date createDate = null;
	private DateFormat dtFmt = new SimpleDateFormat("yyyy-MM-dd");
	
	/*
	 * 
KeyStatDownloadTest [DEBUG] sharesShortPriorMonth={raw=26396100, fmt=26.4M, longFmt=26,396,100}
KeyStatDownloadTest [DEBUG] morningStarOverallRating={}
KeyStatDownloadTest [DEBUG] morningStarRiskRating={}
KeyStatDownloadTest [DEBUG] category=null
KeyStatDownloadTest [DEBUG] annualReportExpenseRatio={}
KeyStatDownloadTest [DEBUG] ytdReturn={}
KeyStatDownloadTest [DEBUG] beta3Year={}
KeyStatDownloadTest [DEBUG] totalAssets={}
KeyStatDownloadTest [DEBUG] yield={}
KeyStatDownloadTest [DEBUG] fundFamily=null
KeyStatDownloadTest [DEBUG] fundInceptionDate={}
KeyStatDownloadTest [DEBUG] legalType=null
KeyStatDownloadTest [DEBUG] threeYearAverageReturn={}
KeyStatDownloadTest [DEBUG] fiveYearAverageReturn={}
KeyStatDownloadTest [DEBUG] nextFiscalYearEnd={raw=1514678400, fmt=2017-12-31}
KeyStatDownloadTest [DEBUG] trailingEps={raw=4.05, fmt=4.05}
KeyStatDownloadTest [DEBUG] forwardEps={raw=4.21, fmt=4.21}
KeyStatDownloadTest [DEBUG] lastDividendValue={}
KeyStatDownloadTest [DEBUG] lastCapGain={}
KeyStatDownloadTest [DEBUG] annualHoldingsTurnover={}
KeyStatDownloadTest [DEBUG] maxAge=1
KeyStatDownloadTest [DEBUG] earnings={earningsDate=[{raw=1476403200, fmt=2016-10-14}], earningsAverage={raw=1.01, fmt=1.01}, earningsLow={raw=0.94, fmt=0.94}, earningsHigh={raw=1.07, fmt=1.07}, revenueAverage={raw=22223900000, fmt=22.22B, longFmt=22,223,900,000}, revenueLow={raw=21722000000, fmt=21.72B, longFmt=21,722,000,000}, revenueHigh={raw=22855000000, fmt=22.86B, longFmt=22,855,000,000}}
KeyStatDownloadTest [DEBUG] maxAge=86400
KeyStatDownloadTest [DEBUG] currentPrice={raw=47.97, fmt=47.97}
KeyStatDownloadTest [DEBUG] targetHighPrice={raw=64.0, fmt=64.00}
KeyStatDownloadTest [DEBUG] targetLowPrice={raw=44.0, fmt=44.00}
KeyStatDownloadTest [DEBUG] targetMeanPrice={raw=53.17, fmt=53.17}
KeyStatDownloadTest [DEBUG] targetMedianPrice={raw=53.0, fmt=53.00}
KeyStatDownloadTest [DEBUG] recommendationMean={raw=2.4, fmt=2.40}
KeyStatDownloadTest [DEBUG] recommendationKey=buy
KeyStatDownloadTest [DEBUG] numberOfAnalystOpinions={raw=29, fmt=29, longFmt=29}
KeyStatDownloadTest [DEBUG] quickRatio={}
KeyStatDownloadTest [DEBUG] earningsGrowth={raw=-0.019, fmt=-1.90%}
KeyStatDownloadTest [DEBUG] grossMargins={raw=0.0, fmt=0.00%}
KeyStatDownloadTest [DEBUG] ebitdaMargins={raw=0.0, fmt=0.00%}

	 */
	
	public StockKeyStatistic() {}
	
	public StockKeyStatistic(String tickerSymbol, Map<String,Object> statMap) {
		Map<String,Object> statList = this.findStatDetailMap(statMap);
		Iterator<String> iter = null;
		String key = null;
		DateFormat dtFmt = new SimpleDateFormat("yyyy-MM-dd");
		this.tickerSymbol = tickerSymbol;
		this.grossProfit = YahooDataHelper.getRaw((Map<String,Object>)statList.get("grossProfits"));
		if (statList.get("bookValue") instanceof Double) {
			this.bookValuePerShare = YahooDataHelper.getDouble((Double)statList.get("bookValue"));
		}
		else {
			this.bookValuePerShare = YahooDataHelper.getRaw((Map<String,Object>)statList.get("bookValue"));
		}
		this.fwdPeRatio = YahooDataHelper.getRaw((Map<String,Object>)statList.get("forwardPE"));
		this.pctHeldbyInstitutions = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("heldPercentInstitutions")));
		this.enterpriseValueRevenue = YahooDataHelper.getRaw((Map<String,Object>)statList.get("enterpriseToRevenue"));
		this.totalCash = YahooDataHelper.getRaw((Map<String,Object>)statList.get("totalCash"));
		this.totalDebt = YahooDataHelper.getRaw((Map<String,Object>)statList.get("totalDebt"));
		this.pctHeldbyInsiders = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("heldPercentInsiders")));
		try {
			this.lastSplitDate = dtFmt.parse(YahooDataHelper.getFmt((Map<String,Object>)statList.get("lastSplitDate")));
		}
		catch (ParseException | NullPointerException e) {
			this.lastSplitDate = null;
		}
		this.currentRatio = YahooDataHelper.getRaw((Map<String,Object>)statList.get("currentRatio"));
		this.operatingCashFlow = YahooDataHelper.getRaw((Map<String,Object>)statList.get("operatingCashflow"));
		this.sharesShort = YahooDataHelper.getRaw((Map<String,Object>)statList.get("sharesShort"));
		this.enterpriseValue = YahooDataHelper.getRaw((Map<String,Object>)statList.get("enterpriseValue"));
		this.qtrlyRevGrowthPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("revenueGrowth")));
		this.leveredFreeCashFlow = YahooDataHelper.getRaw((Map<String,Object>)statList.get("freeCashflow"));
		this.lastSplitFactor = (String)statList.get("lastSplitFactor");
		this.enterpriseValueEbitda = YahooDataHelper.getRaw((Map<String,Object>)statList.get("enterpriseToEbitda"));
		this.profitMarginPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("profitMargins")));
		this.revenue = YahooDataHelper.getRaw((Map<String,Object>)statList.get("totalRevenue"));
		this.p52WeekChgPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("52WeekChange")));
		this.beta = YahooDataHelper.getRaw((Map<String,Object>)statList.get("beta"));
		this.totalCashPerShare = YahooDataHelper.getRaw((Map<String,Object>)statList.get("totalCashPerShare"));
		this.shortPctOfFloat = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("shortPercentOfFloat")));
		this.netIncomeAvltoCommon = YahooDataHelper.getRaw((Map<String,Object>)statList.get("netIncomeToCommon"));
		this.sharesOutstanding = YahooDataHelper.getRaw((Map<String,Object>)statList.get("sharesOutstanding"));
		this.sp50052WeekChgPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("SandP52WeekChange")));
		this.returnOnAssetsPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("returnOnAssets")));
		this.floatShrsCnt = YahooDataHelper.getRaw((Map<String,Object>)statList.get("floatShares"));
		try {
			this.exDivDate = dtFmt.parse(YahooDataHelper.getFmt((Map<String,Object>)statList.get("exDividendDate")));
		}
		catch (ParseException | NullPointerException e) {
			this.exDivDate = null;
		}
		this.qtrlyEarningsGrowthPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("earningsQuarterlyGrowth")));
		this.ebitda = YahooDataHelper.getRaw((Map<String,Object>)statList.get("ebitda"));
		this.pegRatio = YahooDataHelper.getRaw((Map<String,Object>)statList.get("pegRatio"));
		this.totalDebtEquity = YahooDataHelper.getRaw((Map<String,Object>)statList.get("debtToEquity"));
		this.operatingMarginPct = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("operatingMargins")));
		try {
			this.divDate = dtFmt.parse(YahooDataHelper.getFmt((Map<String,Object>)statList.get("dividendDate")));
		}
		catch (ParseException | NullPointerException e) {
			this.divDate = null;
		}
		this.revenuePerShare = YahooDataHelper.getRaw((Map<String,Object>)statList.get("revenuePerShare"));
		this.priceBook = YahooDataHelper.getRaw((Map<String,Object>)statList.get("priceToBook"));
		this.returnOnEquity = YahooDataHelper.toPct(YahooDataHelper.getRaw((Map<String,Object>)statList.get("returnOnEquity")));
		this.shortRatio = YahooDataHelper.getRaw((Map<String,Object>)statList.get("shortRatio"));
		this.priceSales = YahooDataHelper.getRaw((Map<String,Object>)statList.get("priceToSalesTrailing12Months"));
	}

	private Map<String,Object> findStatDetailMap(Map<String,Object> keyStat) {
		Map<String,Object> quoteSummary = (Map<String,Object> )keyStat.get("quoteSummary");
		List<Map<String,Object>> result = (List<Map<String,Object>>)quoteSummary.get("result");
		Map<String,Object> statDetailMap = null;
		Map<String,Object> statMap = null;
		if (result != null) {
			statMap = result.get(0);
			Iterator<String> statKeys = statMap.keySet().iterator();
			List<Map<String,Object>> statList = new ArrayList<Map<String,Object>>();
			String statKey = null;
			statDetailMap = new HashMap<String,Object>();
			while(statKeys.hasNext()) {
				statKey = statKeys.next();
				statList.add((Map<String,Object>)statMap.get(statKey));
			}
			for (Map<String,Object> stat: statList) {
				Iterator<String> iter = stat.keySet().iterator();
				while (iter.hasNext()) {
					statKey = iter.next();
					statDetailMap.put(statKey, stat.get(statKey));
				}
			}
		}
		return statDetailMap;
	}
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public Long getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}
	public BigDecimal getGrossProfit() {
		return grossProfit;
	}
	public void setGrossProfit(BigDecimal grossProfit) {
		this.grossProfit = grossProfit;
	}
	public BigDecimal getBookValuePerShare() {
		return bookValuePerShare;
	}
	public void setBookValuePerShare(BigDecimal bookValuePerShare) {
		this.bookValuePerShare = bookValuePerShare;
	}
	public BigDecimal getP52WeekHigh() {
		return p52WeekHigh;
	}
	public void setP52WeekHigh(BigDecimal p52WeekHigh) {
		this.p52WeekHigh = p52WeekHigh;
	}
	public BigDecimal getFwdPeRatio() {
		return fwdPeRatio;
	}
	public void setFwdPeRatio(BigDecimal fwdPeRatio) {
		this.fwdPeRatio = fwdPeRatio;
	}
	public BigDecimal getPctHeldbyInstitutions() {
		return pctHeldbyInstitutions;
	}
	public void setPctHeldbyInstitutions(BigDecimal pctHeldbyInstitutions) {
		this.pctHeldbyInstitutions = pctHeldbyInstitutions;
	}
	public BigDecimal getEnterpriseValueRevenue() {
		return enterpriseValueRevenue;
	}
	public void setEnterpriseValueRevenue(BigDecimal enterpriseValueRevenue) {
		this.enterpriseValueRevenue = enterpriseValueRevenue;
	}
	public BigDecimal getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(BigDecimal totalCash) {
		this.totalCash = totalCash;
	}
	public BigDecimal getTotalDebt() {
		return totalDebt;
	}
	public void setTotalDebt(BigDecimal totalDebt) {
		this.totalDebt = totalDebt;
	}
	public BigDecimal getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}
	public BigDecimal getPctHeldbyInsiders() {
		return pctHeldbyInsiders;
	}
	public void setPctHeldbyInsiders(BigDecimal pctHeldbyInsiders) {
		this.pctHeldbyInsiders = pctHeldbyInsiders;
	}
	public Date getLastSplitDate() {
		return lastSplitDate;
	}
	public void setLastSplitDate(Date lastSplitDate) {
		this.lastSplitDate = lastSplitDate;
	}
	public BigDecimal getP52WeekLow() {
		return p52WeekLow;
	}
	public void setP52WeekLow(BigDecimal p52WeekLow) {
		this.p52WeekLow = p52WeekLow;
	}
	public BigDecimal getCurrentRatio() {
		return currentRatio;
	}
	public void setCurrentRatio(BigDecimal currentRatio) {
		this.currentRatio = currentRatio;
	}
	public BigDecimal getFwdAnnualDividendRate() {
		return fwdAnnualDividendRate;
	}
	public void setFwdAnnualDividendRate(BigDecimal fwdAnnualDividendRate) {
		this.fwdAnnualDividendRate = fwdAnnualDividendRate;
	}
	public BigDecimal getOperatingCashFlow() {
		return operatingCashFlow;
	}
	public void setOperatingCashFlow(BigDecimal operatingCashFlow) {
		this.operatingCashFlow = operatingCashFlow;
	}
	public BigDecimal getSharesShort() {
		return sharesShort;
	}
	public void setSharesShort(BigDecimal sharesShort) {
		this.sharesShort = sharesShort;
	}
	public Date getMostRecentQuarter() {
		return mostRecentQuarter;
	}
	public void setMostRecentQuarter(Date mostRecentQuarter) {
		this.mostRecentQuarter = mostRecentQuarter;
	}
	public BigDecimal getEnterpriseValue() {
		return enterpriseValue;
	}
	public void setEnterpriseValue(BigDecimal enterpriseValue) {
		this.enterpriseValue = enterpriseValue;
	}
	public Long getAvgVol() {
		return avgVol;
	}
	public void setAvgVol(Long avgVol) {
		this.avgVol = avgVol;
	}
	public BigDecimal getQtrlyRevGrowthPct() {
		return qtrlyRevGrowthPct;
	}
	public void setQtrlyRevGrowthPct(BigDecimal qtrlyRevGrowthPct) {
		this.qtrlyRevGrowthPct = qtrlyRevGrowthPct;
	}
	public BigDecimal getLeveredFreeCashFlow() {
		return leveredFreeCashFlow;
	}
	public void setLeveredFreeCashFlow(BigDecimal leveredFreeCashFlow) {
		this.leveredFreeCashFlow = leveredFreeCashFlow;
	}
	public String getLastSplitFactor() {
		return lastSplitFactor;
	}
	public void setLastSplitFactor(String lastSplitFactor) {
		this.lastSplitFactor = lastSplitFactor;
	}
	public BigDecimal getEnterpriseValueEbitda() {
		return enterpriseValueEbitda;
	}
	public void setEnterpriseValueEbitda(BigDecimal enterpriseValueEbitda) {
		this.enterpriseValueEbitda = enterpriseValueEbitda;
	}
	public BigDecimal getProfitMarginPct() {
		return profitMarginPct;
	}
	public void setProfitMarginPct(BigDecimal profitMarginPct) {
		this.profitMarginPct = profitMarginPct;
	}
	public BigDecimal getRevenue() {
		return revenue;
	}
	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}
	public BigDecimal getTrailingPe() {
		return trailingPe;
	}
	public void setTrailingPe(BigDecimal trailingPe) {
		this.trailingPe = trailingPe;
	}
	public BigDecimal getTrailingAnnualDivYldPct() {
		return trailingAnnualDivYldPct;
	}
	public void setTrailingAnnualDivYldPct(BigDecimal trailingAnnualDivYldPct) {
		this.trailingAnnualDivYldPct = trailingAnnualDivYldPct;
	}
	public BigDecimal getP52WeekChgPct() {
		return p52WeekChgPct;
	}
	public void setP52WeekChgPct(BigDecimal p52WeekChgPct) {
		this.p52WeekChgPct = p52WeekChgPct;
	}
	public BigDecimal getBeta() {
		return beta;
	}
	public void setBeta(BigDecimal beta) {
		this.beta = beta;
	}
	public BigDecimal getTotalCashPerShare() {
		return totalCashPerShare;
	}
	public void setTotalCashPerShare(BigDecimal totalCashPerShare) {
		this.totalCashPerShare = totalCashPerShare;
	}
	public BigDecimal getShortPctOfFloat() {
		return shortPctOfFloat;
	}
	public void setShortPctOfFloat(BigDecimal shortPctOfFloat) {
		this.shortPctOfFloat = shortPctOfFloat;
	}
	public BigDecimal getDilutedEps() {
		return dilutedEps;
	}
	public void setDilutedEps(BigDecimal dilutedEps) {
		this.dilutedEps = dilutedEps;
	}
	public BigDecimal getNetIncomeAvltoCommon() {
		return netIncomeAvltoCommon;
	}
	public void setNetIncomeAvltoCommon(BigDecimal netIncomeAvltoCommon) {
		this.netIncomeAvltoCommon = netIncomeAvltoCommon;
	}
	public BigDecimal getP5YrAvgDivYldPct() {
		return p5YrAvgDivYldPct;
	}
	public void setP5YrAvgDivYldPct(BigDecimal p5YrAvgDivYldPct) {
		this.p5YrAvgDivYldPct = p5YrAvgDivYldPct;
	}
	public BigDecimal getSharesOutstanding() {
		return sharesOutstanding;
	}
	public void setSharesOutstanding(BigDecimal sharesOutstanding) {
		this.sharesOutstanding = sharesOutstanding;
	}
	public BigDecimal getSp50052WeekChgPct() {
		return sp50052WeekChgPct;
	}
	public void setSp50052WeekChgPct(BigDecimal sp50052WeekChgPct) {
		this.sp50052WeekChgPct = sp50052WeekChgPct;
	}
	public BigDecimal getReturnOnAssetsPct() {
		return returnOnAssetsPct;
	}
	public void setReturnOnAssetsPct(BigDecimal returnOnAssetsPct) {
		this.returnOnAssetsPct = returnOnAssetsPct;
	}
	public BigDecimal getFloatShrsCnt() {
		return floatShrsCnt;
	}
	public void setFloatShrsCnt(BigDecimal floatShrsCnt) {
		this.floatShrsCnt = floatShrsCnt;
	}
	public Date getExDivDate() {
		return exDivDate;
	}
	public void setExDivDate(Date exDivDate) {
		this.exDivDate = exDivDate;
	}
	public BigDecimal getPayoutRatioPct() {
		return payoutRatioPct;
	}
	public void setPayoutRatioPct(BigDecimal payoutRatioPct) {
		this.payoutRatioPct = payoutRatioPct;
	}
	public BigDecimal getQtrlyEarningsGrowthPct() {
		return qtrlyEarningsGrowthPct;
	}
	public void setQtrlyEarningsGrowthPct(BigDecimal qtrlyEarningsGrowthPct) {
		this.qtrlyEarningsGrowthPct = qtrlyEarningsGrowthPct;
	}
	public BigDecimal getP200DayMovingAvg() {
		return p200DayMovingAvg;
	}
	public void setP200DayMovingAvg(BigDecimal p200DayMovingAvg) {
		this.p200DayMovingAvg = p200DayMovingAvg;
	}
	public BigDecimal getEbitda() {
		return ebitda;
	}
	public void setEbitda(BigDecimal ebitda) {
		this.ebitda = ebitda;
	}
	public BigDecimal getP50DayMovingAvg() {
		return p50DayMovingAvg;
	}
	public void setP50DayMovingAvg(BigDecimal p50DayMovingAvg) {
		this.p50DayMovingAvg = p50DayMovingAvg;
	}
	public BigDecimal getPegRatio() {
		return pegRatio;
	}
	public void setPegRatio(BigDecimal pegRatio) {
		this.pegRatio = pegRatio;
	}
	public BigDecimal getTotalDebtEquity() {
		return totalDebtEquity;
	}
	public void setTotalDebtEquity(BigDecimal totalDebtEquity) {
		this.totalDebtEquity = totalDebtEquity;
	}
	public BigDecimal getFwdAnnualDivYldPct() {
		return fwdAnnualDivYldPct;
	}
	public void setFwdAnnualDivYldPct(BigDecimal fwdAnnualDivYldPct) {
		this.fwdAnnualDivYldPct = fwdAnnualDivYldPct;
	}
	public BigDecimal getOperatingMarginPct() {
		return operatingMarginPct;
	}
	public void setOperatingMarginPct(BigDecimal operatingMarginPct) {
		this.operatingMarginPct = operatingMarginPct;
	}
	public Date getDivDate() {
		return divDate;
	}
	public void setDivDate(Date divDate) {
		this.divDate = divDate;
	}
	public BigDecimal getRevenuePerShare() {
		return revenuePerShare;
	}
	public void setRevenuePerShare(BigDecimal revenuePerShare) {
		this.revenuePerShare = revenuePerShare;
	}
	public String getFiscalYearEnds() {
		return fiscalYearEnds;
	}
	public void setFiscalYearEnds(String fiscalYearEnds) {
		this.fiscalYearEnds = fiscalYearEnds;
	}
	public BigDecimal getPriceBook() {
		return priceBook;
	}
	public void setPriceBook(BigDecimal priceBook) {
		this.priceBook = priceBook;
	}
	public Double getReturnOnEquityDbl() {
		Double dblValue = null;
		if (returnOnEquity != null) {
			dblValue = returnOnEquity.doubleValue();
		}
		return dblValue;
	}
	public BigDecimal getReturnOnEquity() {
		return this.returnOnEquity;
	}
	public void setReturnOnEquity(BigDecimal returnOnEquity) {
		this.returnOnEquity = returnOnEquity;
	}
	public BigDecimal getShortRatio() {
		return shortRatio;
	}
	public void setShortRatio(BigDecimal shortRatio) {
		this.shortRatio = shortRatio;
	}
	public BigDecimal getPriceSales() {
		return priceSales;
	}
	public void setPriceSales(BigDecimal priceSales) {
		this.priceSales = priceSales;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateStr() {
		return (createDate != null) ? dtFmt.format(createDate) : null;
	}
	public BigDecimal getSP500RelativeChg() {
		Double chg = null;
		if (this.p52WeekChgPct != null) {
			chg = this.p52WeekChgPct.doubleValue() - this.sp50052WeekChgPct.doubleValue();
		}
		else {
			chg = 0.0;
		}
		return BigDecimal.valueOf(chg);
	}

	public BigDecimal getVolFloatPct() {
		Double volPct = null;
		BigDecimal retVal = null;
		if (this.avgVol != null && this.floatShrsCnt != null) {
			volPct = (Double.valueOf((this.avgVol / this.floatShrsCnt.doubleValue()) * 100));
			retVal = BigDecimal.valueOf(volPct);
		}
		return retVal;
	}
	
	public String getMarketCapLevel() {
		String mktCap = null;
		if (this.marketCap != null) {
			if (this.marketCap.doubleValue() > 10000000000.00) {
				mktCap = "Large";
			}
			else {
				if (this.marketCap.doubleValue() > 2000000000.00 && this.marketCap.doubleValue() <= 10000000000.00) {
					mktCap = "Mid";
				}
				else {
					if (this.marketCap.doubleValue() <= 2000000000.00) {
						mktCap = "Small";
					}
				}
			}
		}
		return mktCap;
	}
}
