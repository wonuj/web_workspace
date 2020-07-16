package com.simple.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mariadb://localhost:3306/coders9";
		String user = "root";
		String password = "zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
