package com.simple.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simple.dao.TodoDao;
import com.simple.dto.TodoDto;
import com.simple.vo.Todo;

import kr.co.jhta.util.pagination.Pagination;

public class TodoService {
	private TodoDao todoDao = TodoDao.getInstance();
	
	public List<TodoDto> getRecentTodos() throws Exception {
		List<TodoDto> recentTodos = todoDao.getRecentTodos();
		
		return recentTodos;
	}
	
	public TodoDto getTodoDetail(int todoNo) throws Exception {
		TodoDto todoDto = new TodoDto();
		todoDto = todoDao.getTodoByNo(todoNo);
		
		return todoDto;
	}
	
	public TodoDto updateTodoStatus(int todoNo, String status) throws Exception {
		// ������ȣ�� �ش��ϴ� �������� ��ȸ
		TodoDto dto = todoDao.getTodoByNo(todoNo);
		// ��ȸ�� �������� ���¸� ���޹��� ���·� �����Ѵ�.
		// ������ ���°� "ó���Ϸ�"�� ��� ���������� completedDate�� ���糯¥�� ��´�.
		// �� �ܴ� completedDate�� null�� ��´�.
		// updateTodo(todoDto)�� �����ؼ� DB�� ���� �����Ѵ�.
		// ����� ���������� ��ȯ�Ѵ�.
		
		
		return null;
	}

	public Map<String, Object> getTodoList(String userId, int pageNo, int rows, String status, String keyword) throws Exception {
		// ���� ���� ��ȸ�ϱ�
		int totalRows = todoDao.getTotalRows(userId, status, keyword);
		
		// ������ �׺�Խÿ��� �ʿ��� ���� �����ϱ�
		// ���� ��������ȣ, ȭ�鿡 ǥ���� ���� ����, ��ü �������� ������ �ʿ�
		Pagination pagination = new Pagination(pageNo, rows, totalRows);
		// ���� ������ ��ȣ�� �ش��ϴ� ������ ��ȸ�� �ʿ��� ���� ����ϱ�
		int beginIndex = (pageNo -1)*rows + 1;
		int endIndex = pageNo*rows;
		
		// ��ȸ������ �����ϴ� ���� ��ȸ�ϱ�
		List<TodoDto> todos = todoDao.getTodos(userId, status, keyword, beginIndex, endIndex);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todos", todos);
		map.put("pagination", pagination);
		
		return map;
	}
}
