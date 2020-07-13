package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.User;

public class UserDao {
	
	public User getUserById(String userId) throws SQLException {
		User user = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setName(rs.getString("user_name"));
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setRegisteredDate(rs.getDate("user_create_date"));
			
		}
		rs.next();
		pstmt.close();
		connection.close();
		
		return user;
		
	}
	
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getAllUsers"));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setName(rs.getString("user_name"));
			user.setId(rs.getString("user_id"));
			user.setEmail(rs.getString("user_email"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			
			users.add(user);
		}
		rs.next();
		pstmt.close();
		connection.close();
		
		return users;
		
	}

	public List<User> getNewUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getNewUsers"));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setName(rs.getString("user_name"));
			user.setId(rs.getString("user_id"));
			user.setEmail(rs.getString("user_email"));
			user.setRegisteredDate(rs.getDate("user_registered_date"));
			
			users.add(user);
		}
		rs.next();
		pstmt.close();
		connection.close();
		
		return users;
	}
}