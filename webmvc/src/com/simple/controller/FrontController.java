package com.simple.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.controller.book.AddController;
import com.simple.controller.book.DeleteReviewController;
import com.simple.controller.book.DetailController;
import com.simple.controller.book.FormController;
import com.simple.controller.book.ListController;
import com.simple.controller.login.LoginCheckController;
import com.simple.controller.login.LoginFormController;

public class FrontController extends HttpServlet {	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController.service(req, resp) 실행됨...");
		
		// 한글처리를 위한 인코딩방식 지정하기
		req.setCharacterEncoding("utf-8");
		
		// 요청 URI는 컨트롤러를 선택하기 위한 식별자, JSP 경로와는 무관하다.
		// JSP 경로는 xxxController에 return값으로 반환하여 이동.
		String requestURI = req.getRequestURI();
		requestURI = requestURI.replace("/webmvc", "");
		System.out.println("요청 URI: " + requestURI);
		
		
		try {
			Controller controller = null;
			// 요청 URI를 분석해서 요청을 처리할 적절한 Controller객체 생성하기
			if("/home.hta".equals(requestURI)) {
				controller = new HomeController();
			} else if ("/book/list.hta".equals(requestURI)) {
				controller = new ListController();
			} else if ("/book/detail.hta".equals(requestURI)) {
				controller = new DetailController();
			} else if ("/book/form.hta".equals(requestURI)) {
				controller = new FormController();
			} else if ("/book/add.hta".equals(requestURI)) {
				controller = new AddController();
			} else if ("/login/form.hta".equals(requestURI)) {
				controller = new LoginFormController();
			} else if ("/login/check.hta".equals(requestURI)) {
				controller = new LoginCheckController();
			} else if ("/book/delReview.hta".equals(requestURI)) {
				controller = new DeleteReviewController();
			} else {
				controller = new HomeController();
			}
			
			// xxxController의 process(req, res) 메소드 실행해서 요청처리하고,
			// 이동할 뷰페이지 이름 제공받기
			String path = controller.process(req, resp);
			
			if (path.startsWith("redirect:")) {
				// 재요청 URI를 응답으로 제공
				path = path.replace("redirect:", "");
				resp.sendRedirect(path);
			} else {
				// jsp페이지로 내부이동
				req.getRequestDispatcher("/WEB-INF/views/" + path).forward(req, resp);
			}
			
		} catch (Exception e ) {
			throw new ServletException(e);
		}
	}
}
