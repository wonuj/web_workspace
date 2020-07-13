<%@page import="com.sample.dao.UserDao"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 레지스터</h1>
	<h3>유저 레지스터</h3>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("username");
		String email = request.getParameter("useremail");
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		UserDao userdao = new UserDao();
		userdao.insertUsers(user);
	%>
	<dl>
		<dt>ID</dt>
		<dd><%=id %></dd>
	</dl>
	<dl>
		<dt>PASSWORD</dt>
		<dd><%=password %></dd>
	</dl>
	<dl>
		<dt>NAME</dt>
		<dd><%=name %></dd>
	</dl>
	<dl>
		<dt>EMAIL</dt>
		<dd><%=email %></dd>
	</dl>
</body>
</html>