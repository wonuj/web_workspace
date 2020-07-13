package com.simple.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * �곗�댄�곕��댁�ㅼ�� �곌껐�� �대�뱁���� Connection 媛�泥대�� ��怨듯���� ���명�대���ㅻ��.
 * @author JHTA
 *
 */
public class ConnectionUtil {
	
	private static DataSource dataSource;
	public static void setDataSource(DataSource dataSource) {
		ConnectionUtil.dataSource = dataSource;
	}
	
	// DataBaseConnectionPool 객체에서 Connection객체를 꺼내서 제공한다.
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}

















