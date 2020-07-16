package com.simple.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	public static String numberWithComma(long number) {
		return currencyFormat.format(number);
	}
	
	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	public static long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	public static double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
}









