package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.util.ConnectionUtil;
import com.sample.vo.User;

public class UserDao {

	public void insertUsers(User user) throws SQLException {
		
		String sql = "insert into sample_book_users "
				   + "(user_id, user_password, user_name, user_email)"
				   + "values "
				   + "( ?, ?, ?, ?) ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		
	}
}
