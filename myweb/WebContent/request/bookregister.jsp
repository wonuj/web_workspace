<%@page import="com.simple.dao.BookDao"%>
<%@page import="com.simple.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Information</h1>
	
	<%
		request.setCharacterEncoding("utf-8");
	
		String title = request.getParameter("booktitle");
		String writer = request.getParameter("bookwriter");
		String genre = request.getParameter("bookgenre");
		String publisher = request.getParameter("bookpublisher");
		int price = Integer.parseInt(request.getParameter("bookprice"));
		int discountPrice = Integer.parseInt(request.getParameter("bookdiscountprice"));
		int stock = Integer.parseInt(request.getParameter("bookstock"));
		
		Book book = new Book();
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		book.setStock(stock);
		
		BookDao bookDao = new BookDao();
		bookDao.insertBook(book);

	%>
	
	<h3>Book Information</h3>
	<dl>
		<dt>title</dt>
		<dd><%=title %></dd>
	</dl>
	<dl>
		<dt>writer</dt>
		<dd><%=writer %></dd>
	</dl>
	<dl>
		<dt>genre</dt>
		<dd><%=genre %></dd>
	</dl>
	<dl>
		<dt>publisher</dt>
		<dd><%=publisher %></dd>
	</dl>
	<dl>
		<dt>price</dt>
		<dd><%=price %></dd>
	</dl>
	<dl>
		<dt>discountPrice</dt>
		<dd><%=discountPrice %></dd>
	</dl>
	<dl>
		<dt>amount</dt>
		<dd><%=stock %></dd>
	</dl>
</body>
</html>