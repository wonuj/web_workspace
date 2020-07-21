<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("userid");
	String password = request.getParameter("password");
	
	UserDao userDao = new UserDao();
	User user = userDao.getUserById(id);
	
	session.setAttribute("Name", user.getName());
	session.setAttribute("ID", user.getUserId());
	session.setAttribute("IsLogined", "Yes");
	
	response.sendRedirect("../board/boardList.jsp");

%>