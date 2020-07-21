<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	int boardNo = Integer.parseInt(request.getParameter("boardno"));

	Board board = new Board();
	board.setBoardNo(boardNo);
	
	BoardDao boardDao = new BoardDao();
	boardDao.deleteBoard(boardNo);
	
	response.sendRedirect("../board/boardList.jsp");

%>