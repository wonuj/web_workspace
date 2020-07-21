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
<div class="container">
	<div class="row">
		<div class="col-12">
			
		</div>
	</div>
	
	<%
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(100, "자바의 정석", "남궁성", 35000, 10));
		books.add(new Book(200, "정석", "남성", 31000, 10));
		books.add(new Book(300, "파이썬", "궁성", 25000, 10));
		books.add(new Book(400, "자석", "성", 45000, 10));
		books.add(new Book(500, "바의석", "남", 95000, 10));
		
		request.setAttribute("bookList", books);
	%>
	
	<div class="row">
		<div class="col-12">
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>저자</th>
						<th>가격</th> <%-- 콤마가 포함되도록 출력 --%>
						<th>재고현황</th>
						<th>출판일</th> <%-- 2020.03.01 형식으로 출력 --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList }" varStatus="x">
					<tr>
						<th>${book.no }</th>
						<th>${book.title }</th>
						<th>${book.writer }</th>
						<th><fmt:formatNumber value="${book.price }"/></th>
						<th>${book.stock }</th>
						<th><fmt:formatDate value="${book.pubDate }" pattern="yyyy.MM.dd"  /></th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>