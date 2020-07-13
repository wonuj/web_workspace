package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class UserController {
	private JSONView jsonView = new JSONView();
	private UserService userService = new UserService();
	
	@RequestMapping("/register.hta")
	public ModelAndView registerUser (HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(pwd);
		user.setEmail(email);
		
		boolean isSuccess = userService.addNewUser(user);
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("result", isSuccess);
		mav.setView(jsonView); // Ŭ���̾�Ʈ�� jsonText ������ ����
		// {"result:true"} Ȥ�� {"result":false} JSON �ؽ�Ʈ�� �������� �����ȴ�.
		
		return mav;
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ��û�Ķ���� ������ ��ȸ�Ѵ�.
		// UserService�� loginCheck(String id, String password) �� �����Ѵ�.
		// ��ȯ ���� null �̸� ModelAndView�� result --> false�� �����Ѵ�.
		// ��ȯ���� null�� �ƴϸ� ModelAndView�� result --> true�� �����Ѵ�.
		//					HttpSession ��ü�� ȹ���ؼ� "loginUser"��� 
		// 					�Ӽ������� ����� ������ ���ǿ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();

		String id = req.getParameter("userid");
		String password = req.getParameter("userpwd");
		System.out.println("iddddd       " + id);
		System.out.println("password       " + password);
		
		User user = userService.loginCheck(id, password);
		if (user == null ) {
			mav.addAttribute("result", false);
		} else {
			mav.addAttribute("result", true);
			
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		
		mav.setView(jsonView);
		
		return mav;
	}
	
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ������ ��ȿȭ�Ѵ�.
		// home.hta�� ���û�ϰ� �Ѵ�. --> ModelAndView�� ���ûURL�� ��´�.
		HttpSession session = req.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.hta"); // ���� ��ġ�� ������� home.hta�� �����ϱ� ������ 
		
		return mav;
	}
}

	
