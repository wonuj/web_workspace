package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.User;

public class UserDao {
	
	public void insertUser(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.insertUser"));
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getUserPwd());
		pstmt.setString(3, user.getName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public User getUserById(String userId) throws SQLException {
		User user = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserPwd(rs.getString("user_pwd"));
			user.setName(rs.getString("user_name"));
			user.setUserAddr(rs.getString("user_addr"));
			user.setPhone(rs.getString("user_phone"));
			user.setUserRegisteredDate(rs.getDate("user_registered_date"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
}
