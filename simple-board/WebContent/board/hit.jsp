<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
	int pageNo = NumberUtil.stringToInt(request.getParameter("page"));
	
	BoardDao boardDao = new BoardDao();
	// 게시글의 조회수를 변경한다.
	boardDao.updateBoardHit(boardNo);
	
	// 게시글번호에 해당하는 detail.jsp를 재요청 응답을 보낸다.
	response.sendRedirect("detail.jsp?no=" + boardNo + "&page=" + pageNo);
%>