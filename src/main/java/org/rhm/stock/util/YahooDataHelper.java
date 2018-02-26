package org.rhm.stock.util;

import java.math.BigDecimal;
import java.util.Map;

public class YahooDataHelper {
	public static BigDecimal getRaw(Map<String,Object> value) {
		BigDecimal dblValue = null;
		Object valueObj = null;
		
		if (value != null) {
			valueObj = value.get("raw");
			if (valueObj instanceof Integer) {
				dblValue = BigDecimal.valueOf(Double.valueOf((Integer)valueObj));
			}
			if (valueObj instanceof Long) {
				dblValue = BigDecimal.valueOf(Double.valueOf((Long)valueObj));
			}
			if (valueObj instanceof Double) {
				dblValue = BigDecimal.valueOf((Double)valueObj);
			}
		}
		return dblValue;
	}
	
	public static BigDecimal getDouble(Double value) {
		BigDecimal dblValue = null;
		if (value != null) {
			dblValue = BigDecimal.valueOf(value);
		}
		return dblValue;
	}
	
	public static String getFmt(Map<String,Object> value) {
		String strValue = null;
		if (value != null) {
			strValue = (String)value.get("fmt");
		}
		return strValue;
	}
	
	public static BigDecimal toPct(BigDecimal dblValue) {
		BigDecimal bdValue = null;
		if (dblValue != null) {
			bdValue = BigDecimal.valueOf(dblValue.doubleValue() * 100);
		}
		return bdValue;
	}

}
