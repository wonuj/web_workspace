<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// 요청파라미터에서 폼 입력값 획득
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// User객체를 생성해서 입력값 저장
	User user = new User();
	user.setName(name);
	user.setId(id);
	user.setPassword(pwd);
	user.setEmail(email);
	
	UserDao userDao = new UserDao();
	// 입력한 아이디로 사용자정보 조회
	User savedUser = userDao.getUser(id);
	// 사용자정보가 존재하면
	if (savedUser != null) {
		// 회원가입폼을 재요청하는 응답을 보낸다.
		response.sendRedirect("form.jsp?error=dup");
		return;
	}
	// 입력한 아이디로 사용자정보를 조회했을 때 사용자정보가 존재하지 않으면
	// 사용자정보를 데이터베이스에 저장한다.
	userDao.insertUser(user);
	// 회원가입 완료 페이지를 재요청하는 응답을 보낸다.
	response.sendRedirect("complete.jsp");
	
%>