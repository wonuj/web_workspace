<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	StringBuilder sb = new StringBuilder();
	sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
	sb.append("<book>");
	sb.append("		<title>자바의 정석</title>");
	sb.append("		<writer>남궁성</writer>");
	sb.append("		<publisher>한빛미디어</publisher>");
	sb.append("		<price>35,000원</price>");
	sb.append("		<pubdate>2019.12.21</pubdate>");
	sb.append("</book>");

	String text = sb.toString();
	out.write(text);
%>