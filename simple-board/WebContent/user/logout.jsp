<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션을 폐기한다.
	session.invalidate();

	// home.jsp를 재요청하는 응답을 보낸다.
	response.sendRedirect("/simple-board/home.jsp");
%>