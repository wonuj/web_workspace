package com.simple.util;

public class StringUtil {

	public static String strWithBr(String text) {
		if (text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	
	public static String nullToValue(String str, String defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		return str;
	}
	
	public static String nullToBlank(String str) {
		return nullToValue(str, "");
	}
}
