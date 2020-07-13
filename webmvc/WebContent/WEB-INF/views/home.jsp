<%@page import="java.util.ArrayList"%>
<%@page import="com.simple.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="common/nav.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1>Home</h1>
			<p>${message }</p>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<h3>최근 등록된 책 <strong class="float-right"><a href="book/list.hta">더보기</a></strong></h3>
			<table class="table">
				<thead>
					<tr>
						<th>순번</th>
						<th>제목</th>
						<th>저자</th>
						<th>가격</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<!-- 
					forEach 태그를 사용해서 최근 등록된 책을 표현하시오 
					순번은 책번호 혹은 varStatus를 활용해서 1~3까지 표현하시오.
					가격은 자릿수가 표현되도록 표현하시오.
					등록일은 2020.9.1과 같은 형식으로 표현하시오.
				-->
				
				<c:forEach var="book" items="${recentBooks }" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${book.title }</td>
						<td>${book.writer }</td>
						<td><fmt:formatNumber value="${book.price }" /></td>
						<td><fmt:formatDate value="${book.registeredDate }" pattern="yyyy.MM.dd"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>