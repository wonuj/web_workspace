<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setBoardTitle(title);
	board.setContent(content);

	BoardDao boardDao = new BoardDao();
	boardDao.insertBoard(board);

	response.sendRedirect("../board/boardList.jsp");
	
%>