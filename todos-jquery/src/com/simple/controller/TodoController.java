package com.simple.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.service.TodoService;
import com.simple.service.UserService;
import com.simple.util.NumberUtil;
import com.simple.vo.Todo;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class TodoController {

	private TodoService todoService = new TodoService();
	private UserService userService = new UserService();
	private JSONView jsonView = new JSONView();
	
	/*
	 * 신규회원 가입
	 * 요청방식 : POST
	 * 요청파라미터 : id, name, password, email
	 * 응답 : 
	 * 		{status:"success", username:"홍길동"}
	 * 		{status:"fail", message:"동일한 아이디가 이미 사용중입니다."}
	 */
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			
			
			User user = new User();
			
			userService.addNewUser(user);
			
			dataMap.put("status", "success");
			dataMap.put("username", "홍길동");
		} catch (Exception e) {
			dataMap.put("status", "fail");
			dataMap.put("message", "동일한 아이디가 이미 사용중입니다.");
		}
		
		return mav;
	}
	
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : id, password
	 * 응답
	 * 		{status:"success", username:"홍길동"}
	 * 		{status:"fail", message:"아이디 혹은 비밀번호가 올바르지 않습니다."}
	 */
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// 요청처리
		
		return mav;
	}
	
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : 없음
	 * 응답
	 * 		{status:"success"}
	 */
	@RequestMapping("/logout.hta")
	public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// 요청처리
		
		return mav;
	}
	
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : 없음
	 * 응답
	 * 		{status:"success", todos:[{no:1,title:"장보기"....},{},{}]}
	 */
	@RequestMapping("/mytodos.hta")
	public ModelAndView myTodos(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// 요청처리
		
		return mav;
	}
	
	/*
	 * 요청방식 : GET
	 * 요청파라미터 : todoNo
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/todo.hta")
	public ModelAndView todoDetail(HttpServletRequest req, HttpServletResponse  resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		int todoNo = NumberUtil.stringToInt(req.getParameter("todoNo"));
		Todo todo = todoService.getTodoDetail(todoNo);
		
		dataMap.put("status", "success");
		dataMap.put("todo", todo);
		
		return mav;
	}
	
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : title, content, day
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/addtodo.hta")
	public ModelAndView addTodo(HttpServletRequest req, HttpServletResponse  resp) 
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// 요청처리
		
		return mav;
	}
	
	/*
	 * 요청방식 : POST
	 * 요청파라미터 : no, title, content, day, status
	 * 응답
	 * 		{status:"success", todo:{no:1, title:"장보기", ...}}
	 */
	@RequestMapping("/modifytodo.hta")
	public ModelAndView modifyTodo(HttpServletRequest re, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap); 
		
		// 요청처리
		
		return mav;
	}
}










