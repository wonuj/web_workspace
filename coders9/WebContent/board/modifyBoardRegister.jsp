<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	int boardNo = Integer.parseInt(request.getParameter("boardno"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setBoardNo(boardNo);
	board.setBoardTitle(title);
	board.setContent(content);
	
	BoardDao boardDao = new BoardDao();
	boardDao.modifyBoard(board);
	
	response.sendRedirect("../board/boardList.jsp");
	
%>