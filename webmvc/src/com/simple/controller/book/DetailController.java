package com.simple.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.controller.Controller;
import com.simple.dao.BookDao;
import com.simple.dao.ReviewDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;
import com.simple.vo.Review;

public class DetailController implements Controller {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("DetailController.process(req, res) �����");
		
		// ��û�Ķ���� ���� ��ȸ�ϱ�
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		// å��ȣ�� �ش��ϴ� å ���� ȹ���ϱ�
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBookByNo(bookNo);
		
		// å��ȣ�� �ش��ϴ� å�� ���� ������ ȹ���ϱ�
		ReviewDao reviewDao = new ReviewDao();
		List<Review> reviews = reviewDao.getReviewsByBookNo(bookNo);
		
		// å������ ���������� �����ϱ�
		req.setAttribute("book", book);
		req.setAttribute("reviews", reviews);
		
		// �����̵��� �������� �̸� ��ȯ�ϱ�
		return "book/detail.jsp"; // �����̵��� �������� �̸�
	}
}
