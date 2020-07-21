package com.simple.util;

import java.text.DecimalFormat;

public class NumberUtil {

	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e){
			return defaultNumber;
		}
	}
	
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	
	public static Double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
	
	public static Long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	/**
	 * �젙�닔瑜� ,媛� �룷�븿�맂 �넻�솕�몴�쁽�떇 臾몄옄�뿴濡� 蹂��솚�빐�꽌 諛섑솚�븳�떎.
	 * @param number �젙�닔
	 * @return ","媛� �룷�븿�맂 臾몄옄�뿴
	 */
	public static String numberWithComma(int number) {
		return currencyFormat.format(number);
	}
}
