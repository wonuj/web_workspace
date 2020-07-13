<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String value1 = request.getParameter("value1");
	String value2 = request.getParameter("value2");
	String value3 = request.getParameter("value3");
	String value4 = request.getParameter("value4");
	
	// PageContext, HttpServletRequest, HttpSession, ServletContext 객체에 속성값 담기
	pageContext.setAttribute("p", value1);
	request.setAttribute("r", value2);
	session.setAttribute("s", value3);
	application.setAttribute("a", value4);
	
	// PageContext, HttpServletRequest, HttpSession, ServletContext 객체에 저장된 속성값 꺼내기
	String pageContextValue = (String) pageContext.getAttribute("p");
	String requestValue = (String) request.getAttribute("p");
	String sessionValue = (String) session.getAttribute("p");
	String applicationValue = (String) application.getAttribute("p");
	
	System.out.println("page1.jsp의 PageContext에 저장된 값: " + pageContextValue);
	System.out.println("page1.jsp의 HttpServletRequest에 저장된 값: " + requestValue);
	System.out.println("page1.jsp의 HttpSession에 저장된 값: " + sessionValue);
	System.out.println("page1.jsp의 ServletContext에 저장된 값: " + applicationValue);
	
	// home.jsp를 재요청하는 응답을 브라우저로 보내기
	response.sendRedirect("home.jsp");
%>
