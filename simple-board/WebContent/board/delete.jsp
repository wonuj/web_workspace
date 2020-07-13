<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
	int pageNo = NumberUtil.stringToInt(request.getParameter("page"));
	
	BoardDao boardDao = new BoardDao();
	// 게시글 번호에 해당하는 게시글을 삭제처리합니다.
	boardDao.deleteBoard(boardNo);
	
	// list.jsp를 재요청하는 응답을 보낸다.
	response.sendRedirect("list.jsp?page=" + pageNo);
%>