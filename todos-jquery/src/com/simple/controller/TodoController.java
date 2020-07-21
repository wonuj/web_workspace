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
	 * �ű�ȸ�� ����
	 * ��û��� : POST
	 * ��û�Ķ���� : id, name, password, email
	 * ���� : 
	 * 		{status:"success", username:"ȫ�浿"}
	 * 		{status:"fail", message:"������ ���̵� �̹� ������Դϴ�."}
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
			dataMap.put("username", "ȫ�浿");
		} catch (Exception e) {
			dataMap.put("status", "fail");
			dataMap.put("message", "������ ���̵� �̹� ������Դϴ�.");
		}
		
		return mav;
	}
	
	/*
	 * ��û��� : POST
	 * ��û�Ķ���� : id, password
	 * ����
	 * 		{status:"success", username:"ȫ�浿"}
	 * 		{status:"fail", message:"���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�."}
	 */
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// ��ûó��
		
		return mav;
	}
	
	/*
	 * ��û��� : GET
	 * ��û�Ķ���� : ����
	 * ����
	 * 		{status:"success"}
	 */
	@RequestMapping("/logout.hta")
	public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// ��ûó��
		
		return mav;
	}
	
	/*
	 * ��û��� : GET
	 * ��û�Ķ���� : ����
	 * ����
	 * 		{status:"success", todos:[{no:1,title:"�庸��"....},{},{}]}
	 */
	@RequestMapping("/mytodos.hta")
	public ModelAndView myTodos(HttpServletRequest req, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// ��ûó��
		
		return mav;
	}
	
	/*
	 * ��û��� : GET
	 * ��û�Ķ���� : todoNo
	 * ����
	 * 		{status:"success", todo:{no:1, title:"�庸��", ...}}
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
	 * ��û��� : POST
	 * ��û�Ķ���� : title, content, day
	 * ����
	 * 		{status:"success", todo:{no:1, title:"�庸��", ...}}
	 */
	@RequestMapping("/addtodo.hta")
	public ModelAndView addTodo(HttpServletRequest req, HttpServletResponse  resp) 
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		// ��ûó��
		
		return mav;
	}
	
	/*
	 * ��û��� : POST
	 * ��û�Ķ���� : no, title, content, day, status
	 * ����
	 * 		{status:"success", todo:{no:1, title:"�庸��", ...}}
	 */
	@RequestMapping("/modifytodo.hta")
	public ModelAndView modifyTodo(HttpServletRequest re, HttpServletResponse resp)
		throws Exception {
		Map<String, Object> dataMap = new HashMap<>();

		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap); 
		
		// ��ûó��
		
		return mav;
	}
}










