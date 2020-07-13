package com.simple.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.controller.Controller;
import com.simple.dao.BookDao;
import com.simple.vo.Book;

public class ListController implements Controller {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("ListController.process(req, res) �����");
		
		// ��� å ���� ȹ���ϱ�
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getAllBooks();
		
		// ȹ���� å������ ���������� �����ϱ� ���ؼ� Request�� �Ӽ����� �����ϱ�
		req.setAttribute("books", books);
		
		// �����̵��� ���������� �̸��� ��ȯ�ϱ� 
		return "book/list.jsp"; // �� ������ �̸�
	}
}
