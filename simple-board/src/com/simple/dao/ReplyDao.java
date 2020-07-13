package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.ReplyDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;

public class ReplyDao {

	public void insertReply(Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.insertReply"));
		pstmt.setString(1, reply.getWriter());
		pstmt.setString(2, reply.getContent());
		pstmt.setInt(3, reply.getBoardNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateReply(Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt  = connection.prepareStatement(QueryUtil.getSQL("reply.updateReply"));
		pstmt.setString(1, reply.getContent());
		pstmt.setString(2, reply.getDelYn());
		pstmt.setInt(3, reply.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();	
	}
	
	public List<ReplyDto> getReplys(int boardNo) throws SQLException {
		List<ReplyDto> replys = new ArrayList<ReplyDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt  = connection.prepareStatement(QueryUtil.getSQL("reply.getReplys"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ReplyDto dto = new ReplyDto();
			dto.setNo(rs.getInt("reply_no"));
			dto.setWriter(rs.getString("reply_writer"));
			dto.setWriterName(rs.getString("reply_writer_name"));
			dto.setContent(rs.getString("reply_content"));
			dto.setDelYn(rs.getString("reply_del_yn"));
			dto.setBoardNo(rs.getInt("board_no"));
			dto.setCreateDate(rs.getDate("reply_create_date"));
			
			replys.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		return replys;
	}
}
























