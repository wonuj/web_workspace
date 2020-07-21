package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Todo;

public class TodoDao {
	
	/**
	 * ���� �߰��� Todo�� ������ ��ȣ�� ��ȸ�Ѵ�.
	 * @return ������ ��ȣ
	 * @throws SQLException
	 */
	public int getTodoSequence() throws SQLException {
		
		return 0;
	}
	
	/**
	 * ������ Todo ��ü�� ������ DB�� �����Ѵ�.
	 * @param todo �� ���� ����
	 * @throws SQLException
	 */
	public void insertTodo(Todo todo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.insertTodo"));
		pstmt.setInt(1, todo.getNo());
		pstmt.setString(2, todo.getTitle());
		pstmt.setString(3, todo.getContent());
		pstmt.setDate(4, todo.getDay());
		pstmt.setString(5, todo.getStatus());
		pstmt.setString(6, todo.getUserId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * ������ ����ڰ� ����� ��� ������ ������ȣ�� �������� �����ؼ� ��ȯ�Ѵ�.
	 * @param userId
	 * @return �ش� ����ڰ� ����� ��� ����
	 * @throws SQLException
	 */
	public List<Todo> getTodosByUserId(String userId) throws SQLException {
		List<Todo> todos = new ArrayList<Todo>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getTodosByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Todo todo = new Todo();
			
			todo.setNo(rs.getInt("todo_no"));
			todo.setTitle(rs.getString("todo_title"));
			todo.setContent(rs.getString("todo_content"));
			todo.setDay(rs.getDate("todo_day"));
			todo.setComletedDay(rs.getDate("todo_completed_day"));
			todo.setStatus(rs.getString("todo_status"));
			todo.setUserId(rs.getString("user_id"));
			todo.setCreatedDate(rs.getDate("todo_created_date"));
			todo.setUserName(rs.getString("user_name"));
			
			todos.add(todo);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return todos;
	}
	
	/**
	 * ������ ������ȣ�� �ش��ϴ� ���������� ��ȯ�Ѵ�.
	 * @param todoNo ������ȣ
	 * @return ���� ����
	 * @throws SQLException
	 */
	public Todo getTodoByNo(int todoNo) throws SQLException {
		Todo todo = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getTodoByNo"));
		pstmt.setInt(1, todoNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			todo = new Todo();
			todo.setNo(rs.getInt("todo_no"));
			todo.setTitle(rs.getString("todo_title"));
			todo.setContent(rs.getString("todo_content"));
			todo.setDay(rs.getDate("todo_day"));
			todo.setStatus(rs.getString("todo_status"));
			todo.setComletedDay(rs.getDate("todo_completed_day"));
		}
		
		return null;
	}
	
	/**
	 * ������ ���������� ���泻���� DB�� �ݿ��Ѵ�.
	 * @param todo ����� ������ �����ϰ� �ִ� ��������
	 * @throws SQLException
	 */
	public void updateTodo(Todo todo) throws SQLException {
		
	}
	
	
}
