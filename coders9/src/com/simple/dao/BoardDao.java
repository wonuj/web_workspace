package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDao {

	public List<Board> getAllBoards() throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoards"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardRegisteredDate(rs.getDate("board_registered_date"));
			board.setContent(rs.getString("board_content"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public Board getBoardByNo(int boardNo) throws SQLException {
		Board board = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoardByNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardRegisteredDate(rs.getDate("board_registered_date"));
			board.setContent(rs.getString("board_content"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return board;
	}
	
	public void insertBoard(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		pstmt.setString(1, board.getBoardTitle());
		pstmt.setString(2, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void modifyBoard(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.modifyBoard"));
		pstmt.setInt(1, board.getBoardNo());
		pstmt.setString(2, board.getBoardTitle());
		pstmt.setString(3, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public void deleteBoard(int boardNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.deleteBoard"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
