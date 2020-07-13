package com.simple.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.controller.Controller;
import com.simple.dao.UserDao;
import com.simple.vo.User;

public class LoginCheckController implements Controller {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userId = req.getParameter("userid");
		String userPassword = req.getParameter("userpwd");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(userId);
		
		// ����Ҵ� �����̷����� ���ؾߵ�!
		if(user == null) {
			// http://localhost/webmvc/login/
			return "redirect:form.hta?error=fail";
		}
		if(!user.getPassword().equals(userPassword)) {
			return "redirect:form.hta?error=fail";
		}
		
		// ������ ���ǰ�ü�� �α����� ����� ���� ����
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", user);
		
		// http://localhost/webmvc/login/check.hta
		return "redirect:../home.hta";
	}
}
