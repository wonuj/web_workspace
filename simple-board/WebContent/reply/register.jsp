<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="com.simple.vo.Reply"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	// 요청파라미터를 조회한다.
	int boardNo = NumberUtil.stringToInt(request.getParameter("boardno"));
	int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
	String content = request.getParameter("content");
	
	// Reply객체를 생성하고 댓글정보를 담는다.
	Reply reply = new Reply();
	reply.setBoardNo(boardNo);
	reply.setWriter(loginedUserId);
	reply.setContent(content);
	
	ReplyDao replyDao = new ReplyDao();
	// 댓글정보를 데이터베이스에 저장한다.
	replyDao.insertReply(reply);
	
	BoardDao boardDao = new BoardDao();
	// 게시글의 댓글갯수를 변경한다.
	boardDao.updateBoardReplyCnt(boardNo);
	
	// 게시글 detail.jsp를 재요청하는 응답을 보낸다.
	response.sendRedirect("/simple-board/board/detail.jsp?no=" + boardNo + "&page=" + pageNo);
%>