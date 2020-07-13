<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청파라미터값을 조회한다.
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	UserDao userDao = new UserDao();
	
	// 전달받은 아이디로 사용자 정보를 조회한다.
	User user = userDao.getUser(id);
	// 아이디에 해당하는 사용자 정보가 존재하지 않음
	if (user == null) {
		response.sendRedirect("loginform.jsp?error=fail");
		return;
	}
	// 삭제된 사용자인 경우
	if ("Y".equals(user.getDisabled())) {
		response.sendRedirect("loginform.jsp?error=disabled");
		return;
	}
	// 비밀번호가 일치하지 않는 경우
	if (!user.getPassword().equals(pwd)) {
		response.sendRedirect("loginform.jsp?error=fail");
		return;		
	}
	// 사용자 정보존재, 삭제된 사용자 아님, 비밀번호도 일치하는 경우
	// 로그인 처리를 수행한다.
	// 세션객체에 사용자아이디, 이름, 로그인여부를 저장한다.
	session.setAttribute("LOGINED_USER_ID", id);
	session.setAttribute("LOGINED_USER_NAME", user.getName());
	session.setAttribute("LOGINED_YN", "Y");
	
	// 로그인처리가 완료되면 홈페이지를 재요청하는 응답을 보낸다.
	response.sendRedirect("../home.jsp");
%>



