package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.BookDetailDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Book;

public class BookDao {
	
	public BookDetailDto getBookByNo(int bookNo) throws SQLException {
		BookDetailDto bookDetailDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.getBookByNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			bookDetailDto = new BookDetailDto();
			bookDetailDto.setNo(rs.getInt("book_no"));
			bookDetailDto.setTitle(rs.getString("book_title"));
			bookDetailDto.setWriter(rs.getString("book_writer"));
			bookDetailDto.setPublisher(rs.getString("book_publisher"));
			bookDetailDto.setDiscountPrice(rs.getInt("book_discount_price"));
			bookDetailDto.setPoint(rs.getInt("book_point"));
			bookDetailDto.setLikes(rs.getInt("book_likes"));
			bookDetailDto.setStock(rs.getInt("book_stock"));
			bookDetailDto.setReviewCnt(rs.getInt("review_cnt"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return bookDetailDto;
	}
	
	public List<Book> getNewBooks() throws SQLException {
		
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.getNewBooks"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setPrice(rs.getInt("book_price"));
			
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}
	
	public List<Book> getAllBooks() throws SQLException {
		
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.getAllBooks"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setPoint(rs.getInt("book_point"));
			
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}
	
	public void insertBook(Book book) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.inserBook"));
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.setInt(5, book.getDiscountPrice());
		pstmt.setInt(6, book.getStock());
		
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
		
	}
}
