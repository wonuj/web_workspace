package com.simple.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.controller.Controller;
import com.simple.dao.BookDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;

public class AddController implements Controller {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("AddController.process(req, res) �����");
		
		// �Է����� �Է°� ��ȸ�ϱ�
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String genre = req.getParameter("genre");
		String publisher = req.getParameter("publisher");
		int price = NumberUtil.stringToInt(req.getParameter("price"));
		int discountPrice = NumberUtil.stringToInt(req.getParameter("discountPrice"));
		
		// Book ��ü �����ؼ� �Է°� ���
		Book book = new Book();
		book.setTitle(title);
		book.setWriter(writer);
		book.setGenre(genre);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		
		// DB�� å���� �����ϱ�
		BookDao bookDao = new BookDao();
		bookDao.insertBook(book);
		
		// ���û�� URI�� ��ȯ
		return "redirect:list.hta";
	}
}
