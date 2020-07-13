<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// Board객체를 생성하고 게시글정보를 저장한다.
	Board board = new Board();
	board.setTitle(title);
	board.setContent(content);
	board.setWriter(loginedUserId);
	
	BoardDao boardDao = new BoardDao();
	// 게시글 정보를 데이터베이스에 저장한다.
	boardDao.insertBoard(board);
	
	// list.jsp를 재요청하는 응답을 보낸다.
	response.sendRedirect("list.jsp");
%>