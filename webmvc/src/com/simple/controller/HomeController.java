package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.vo.Book;

public class HomeController implements Controller {

	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("HomeController.process(req, res) �����");
		
		req.setAttribute("message", "Ȩ������ �湮�� �������� ȯ���մϴ�.");
		
		// ��ûó���� ���� ������ ȹ��
		// �ֱ� ��ϵ� å 3�� ��ȸ
		BookDao bookDao = new BookDao();
		List<Book> recentBooks = bookDao.getRecentBooks();
		
		// ���������� ȹ��� �����͸� �����ϱ� ���ؼ�
		// HttpServletRequest ��ü�� �Ӽ����� ����
		req.setAttribute("recentBooks", recentBooks);
		
		// �����̵��� �������� �̸� ��ȯ
		return "home.jsp";
	}
}
