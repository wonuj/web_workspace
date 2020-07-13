package com.simple.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.dto.TodoDto;
import com.simple.service.TodoService;
import com.simple.util.NumberUtil;
import com.simple.util.StringUtil;
import com.simple.vo.Todo;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;
import kr.co.jhta.util.pagination.Pagination;

@Controller
public class TodoController {
	private JSONView jsonView = new JSONView();
	private TodoService todoService = new TodoService();
	private TodoDto dto = new TodoDto();
	
	@RequestMapping("/todo/detail.hta")
	public ModelAndView todoDetail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		// 요청파라미터에서 todono 조회, 번호에 해당하는 상세정보 조회
		int no = Integer.parseInt(req.getParameter("todono"));
		
		TodoDto todoContent = todoService.getTodoDetail(no);
		
		// httpsession 세션 획득
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user != null && user.getId().equals(dto.getUserId())) {
			dto.setCanModify(true);
		}
		
		// ModelAndView에 조회된 상세정보 저장, jsonView객체 저장 ---> jsonText 응답제공
		mav.addAttribute("detail", todoContent);
		mav.setView(jsonView);
		
		return mav;
	}
	
	@RequestMapping("/todo/updatestatus.hta")
	public ModelAndView updateTodoStatus(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청파라미터값 조회
		// todoService의 updateStatus(번호, 상태)를 실행하고, 변경된 정볼르 반환받는다.
		// ModelAndView를 생성해서 Ajax 응답을 제공한다.
		// ModelAndView에 반환값과 jsonView를 저장하고, mav를 반환한다.
		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		
		return null;
	}
	
	@RequestMapping("/todo/list.hta")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("todos.jsp");
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		
		int pageNo = NumberUtil.stringToInt(req.getParameter("pageNo"), 1);
		int rows = NumberUtil.stringToInt(req.getParameter("rows"), 5);
		String status = StringUtil.nullToValue(req.getParameter("status"), "전체");
		String keyword = StringUtil.nullToBlank(req.getParameter("keyword"));
		
		Map<String, Object> map = todoService.getTodoList(user.getId(), pageNo, rows, status, keyword);
		Pagination pagination = (Pagination) map.get("pagination");
		List<TodoDto> todos = (List<TodoDto>) map.get("todos");
		
		mav.addAttribute("todos", todos);
		mav.addAttribute("pagination", pagination);
		
		return mav;
	}
}
