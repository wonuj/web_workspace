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
		mav.setView(jsonView); // 클라이언트에 jsonText 응답을 제공
		// {"result:true"} 혹은 {"result":false} JSON 텍스트가 응답으로 제공된다.
		
		return mav;
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청파라미터 정보를 조회한다.
		// UserService의 loginCheck(String id, String password) 를 실행한다.
		// 반환 값이 null 이면 ModelAndView에 result --> false를 저장한다.
		// 반환값이 null이 아니면 ModelAndView에 result --> true를 저장한다.
		//					HttpSession 객체를 획득해서 "loginUser"라는 
		// 					속성명으로 사용자 정보를 세션에 저장한다.
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
		// 세션을 무효화한다.
		// home.hta를 재요청하게 한다. --> ModelAndView에 재요청URL을 담는다.
		HttpSession session = req.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.hta"); // 현재 위치와 상관없이 home.hta로 가야하기 때문에 
		
		return mav;
	}
}

	
