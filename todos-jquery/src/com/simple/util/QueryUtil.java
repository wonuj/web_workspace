package com.simple.util;

import java.util.Properties;

public class QueryUtil {

	// query.properties?? ?????? ?��?��?? key,value?? ???��? 보�????? �?�?
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(Class.forName("com.simple.util.QueryUtil").getResourceAsStream("query.properties"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * �????? ?��??? 쿼리문�?? �???????.
	 * @param name query.properties?? ?????? SQL?? ?��?
	 * @return SQL 구문, ???��?? ?��??? ???? 경�?? null?? �?????
	 */
	public static String getSQL(String name) {
		return prop.getProperty(name);
	}
	
}
