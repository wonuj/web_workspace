<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.vo.User"%>
<%@page import="com.bookstore.dao.UserDao"%>
<%@page import="com.bookstore.vo.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="css/bookstore.css">
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "home";
			%>
			<%@ include file="common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>북스토어</h1>
		</div>
		<div class="body">
			<div>
				<h3>최근 입고된 책</h3>
				<%
					BookDao bookDao = new BookDao();
					List<Book> books = bookDao.getNewBooks();
				%>
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>저자</th>
							<th class="text-right">가격</th>
						</tr>
					</thead>
					<tbody>
					<%
						for (Book book : books) {
					%>
						<tr>
							<td><%=book.getNo() %></td>
							<td><a href="book/detail.jsp?bookno=<%=book.getNo()%>"><%=book.getTitle() %></a></td>
							<td><%=book.getWriter() %></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(book.getPrice()) %> 원</td>
						</tr>
					<%
						}
					%>	
					</tbody>
				</table>
			</div>
			<div>
			<%
				UserDao userDao = new UserDao();
				List<User> users = userDao.getAllUsers();
			%>
				<h3>최근 가입한 사용자</h3>
				<table class="table">
					<thead>
						<tr>
							<th>사용자명</th>
							<th>아이디</th>
							<th>이메일</th>
							<th class="text-center">가입일</th>
						</tr>
					</thead>
					<tbody>
					<%
						for (User user : users) {
					%>
						<tr>
							<td><a href="order/list.jsp?userid=<%=user.getId()%>"><%=user.getName() %></a></td>
							<td><a href="order/list.jsp?userid=<%=user.getId()%>"><%=user.getId() %></a></td>
							<td><%=user.getEmail() %></td>
							<td class="text-center"><%=user.getRegisteredDate() %></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="common/footer.jsp" %>
	</div>
</body>
</html>
