<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	Map<String, Object> map = new HashMap();
	map.put("name", "홍길동");
	map.put("tel", "010-1234-5464");
	map.put("email", "hong@naver.com");
	map.put("age", 46);
	map.put("married", true);
	map.put("family", new String[]{"김술녀","홍두깨","홍당무"});
	
	Gson gson = new Gson();
	String text = gson.toJson(map);
	
	out.write(text);
%>