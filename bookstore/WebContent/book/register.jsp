<%@page import="com.bookstore.dao.BookDao"%>
<%@page import="com.bookstore.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	// 요청파라미터값(폼입력값) 조회
	// Book 객체에 담기
	// BookDao 생성, 저장하기 실행
	// 클라이언트에 재요청 URL 전송

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
	
	response.sendRedirect("list.jsp");
%>

	<dl>
		<dt>제목</dt>
		<dd><%=title %></dd>
	</dl>
	<dl>
		<dt>저자</dt>
		<dd><%=writer %></dd>
	</dl>
	<dl>
		<dt>장르</dt>
		<dd><%=genre %></dd>
	</dl>
	<dl>
		<dt>출판사</dt>
		<dd><%=publisher %></dd>
	</dl>
	<dl>
		<dt>가격</dt>
		<dd><%=price %></dd>
	</dl>
	<dl>
		<dt>할인가격</dt>
		<dd><%=discountPrice %></dd>
	</dl>
	<dl>
		<dt>재고</dt>
		<dd><%=stock %></dd>
	</dl>
