package com.simple.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.TodoDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.JdbcHelper;
import com.simple.util.QueryUtil;
import com.simple.vo.Todo;

public class TodoDao {

	public List<TodoDto> getRecentTodos() throws SQLException {
		List<TodoDto> todos = new ArrayList<TodoDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getRecentTodos"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			TodoDto dto = new TodoDto();
			dto.setNo(rs.getInt("todo_no"));
			dto.setTitle(rs.getString("todo_title"));
			dto.setContent(rs.getString("todo_content"));
			dto.setDay(rs.getDate("todo_day"));
			dto.setCompletedDay(rs.getDate("todo_completed_day"));
			dto.setStatus(rs.getString("todo_status"));
			dto.setCreateDate(rs.getDate("todo_created_date"));
			dto.setUserId(rs.getString("user_id"));
			dto.setUserName(rs.getString("user_name"));
			
			todos.add(dto);
		}
		connection.close();
		pstmt.close();
		rs.close();
		
		return todos;
	}
	
	public TodoDto getTodoByNo(int todoNo) throws SQLException {
		TodoDto dto = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getTodoByNo"));
		pstmt.setInt(1, todoNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			dto = new TodoDto();
			dto.setNo(rs.getInt("todo_no"));
			dto.setTitle(rs.getString("todo_title"));
			dto.setContent(rs.getString("todo_content"));
			dto.setDay(rs.getDate("todo_day"));
			dto.setCompletedDay(rs.getDate("todo_completed_day"));
			dto.setStatus(rs.getString("todo_status"));
			dto.setCreateDate(rs.getDate("todo_created_date"));
			dto.setUserId(rs.getString("user_id"));
			dto.setUserName(rs.getString("user_name"));
		}
		connection.close();
		pstmt.close();
		rs.close();
		
		return dto;
	}
	public void updateTodo(TodoDto tododto) throws SQLException {
		JdbcHelper.update(QueryUtil.getSQL("todo.updateTodo"), tododto.getTitle(),tododto.getContent(),tododto.getStatus(),tododto.getDay(),
				tododto.getCompletedDay(),tododto.getNo());
		
	}
	
	public int getTotalRows(String userId, String status, String keyword) throws SQLException {
		String sql = "select count(*) ";
			   sql += "from sample_todos ";
			   sql += "where user_id = '"+userId+"' ";
		if(!"전체".equals(status)) {
			sql +="and todo_status = '"+status+"' ";
		}
		if(keyword.isEmpty()) {
			sql +="and todo_title like '%' || '"+keyword+"' || '%' ";
		}
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int totalRows = rs.getInt(1); 
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalRows;
	}
	
	public List<TodoDto> getTodos(String userId, String status, String keyword, 
			int beginIndex, int endIndex) throws SQLException {
		
		String sql  = "select * ";
			   sql += "from (select A.*, row_number() over (order by todo_no desc) rn ";
			   sql += "		 from sample_todos A ";
			   sql += "      where user_id = '"+userId+"' ";
		if(!"전체".equals(status)) {
			sql +="and todo_status = '"+status+"' ";
		}
		if(keyword.isEmpty()) {
			sql +="and todo_title like '%' || '"+keyword+"' || '%'  ";
		}
			  sql += ")where rn >= ? and rn <= ? ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, endIndex);
		ResultSet rs = pstmt.executeQuery();
		List<TodoDto> todoDtoList = new ArrayList<TodoDto>();
		while(rs.next()) {
			TodoDto todo = new TodoDto();
			todo.setNo(rs.getInt("todo_no"));
			todo.setTitle(rs.getString("todo_title"));
			todo.setDay(rs.getDate("todo_day"));
			todo.setStatus(rs.getString("todo_status"));
			
			todoDtoList.add(todo);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return todoDtoList;
	}
}
