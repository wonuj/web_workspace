package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.BoardDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDao {

	public void insertBoard(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateBoard(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoard"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHit());
		pstmt.setInt(4, board.getReplyCnt());
		pstmt.setString(5, board.getDelYn());
		pstmt.setInt(6, board.getNo());
		
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
	
	public void updateBoardHit(int boardNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardHit"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}

	public void updateBoardReplyCnt(int boardNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardReplyCnt"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public int getTotalRows() throws SQLException {
		int totalRows = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getTotalRows"));
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		return totalRows;
	}
	
	public List<BoardDto> getBoards(int beginIndex, int endIndex) throws SQLException {
		List<BoardDto> boards = new ArrayList<BoardDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoards"));
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, endIndex);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next() ) {
			BoardDto dto = new BoardDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("board_writer"));
			dto.setWriterName(rs.getString("board_writer_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setHit(rs.getInt("board_hit"));
			dto.setReplyCnt(rs.getInt("board_reply_cnt"));
			dto.setDelYn(rs.getString("board_del_yn"));
			dto.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public BoardDto getBoard(int boardNo) throws SQLException {
		BoardDto dto = null;		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoard"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			dto = new BoardDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("board_writer"));
			dto.setWriterName(rs.getString("board_writer_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setHit(rs.getInt("board_hit"));
			dto.setReplyCnt(rs.getInt("board_reply_cnt"));
			dto.setDelYn(rs.getString("board_del_yn"));
			dto.setCreateDate(rs.getDate("board_create_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();		
		return dto;
	}
}


