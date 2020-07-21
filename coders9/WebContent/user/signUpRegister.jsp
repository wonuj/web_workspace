<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	
	User user = new User();
	user.setUserId(id);
	user.setUserPwd(password);
	user.setName(name);
	
	UserDao userDao = new UserDao();
	userDao.insertUser(user);
	
	response.sendRedirect("../user/login.jsp");

%>