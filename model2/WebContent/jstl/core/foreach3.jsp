<%@page import="java.util.ArrayList"%>
<%@page import="com.simple.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h1>forEach태그</h1>
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
			<div class="table">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>저자</th>
							<th>가격</th>
							<th>재고현황</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="x" items="${bookList }">
							<tr>
								<td>${x.no }</td>
								<td>${x.title }</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>