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
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(pwd);
		user.setEmail(email);
		
		boolean result = userService.addNewUser(user);
		mav.addAttribute("result", result);
		mav.setView(jsonView); // 클라이언트에 jsonText 응답을 제공
		// {"result":true} 혹은 {"result":false} JSON 텍스트가 응답으로 제공된다.
		
		return mav;
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		// 요청파라미터 정보를 조회한다.
		String id = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		// UserService의 loginCheck(String id, String password)를 실행한다.
		User user = userService.loginCheck(id, pwd);
		// 반환값이 null이면 ModelAndView에 result -> false를 저장한다.
		if(user == null) {
			mav.addAttribute("result", false);
		} else {
			// 반환값이 null이 아니면 ModelAndView에 result -> true를 저장한다.
			//				   HttpSession객체를 획득해서 "loginUser"라는
			//				      속성명으로 사용자정보를 세션에 저장한다.
			mav.addAttribute("result", true);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		mav.setView(jsonView);
		return mav;
	}
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}
		mav.setViewName("redirect:../home.hta");
		return mav;
	}
}
