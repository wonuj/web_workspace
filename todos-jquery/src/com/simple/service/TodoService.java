package com.simple.service;

import java.util.List;

import com.simple.dao.TodoDao;
import com.simple.vo.Todo;

public class TodoService {
	
	private TodoDao todoDao = new TodoDao();
	
	/**
	 * ���ο� ���������� �߰��Ѵ�.
	 * ������ȣ�� ��������ȣ�� ȹ���ؼ� ������ ���� DAO�� �����Ѵ�.
	 * @param todo �� �������� 
	 * @return ��������ȣ�� ���Ե� ��������
	 * @throws Exception
	 */
	public Todo addNewTodo(Todo todo) throws Exception {
		
		return null;
	}
	
	/**
	 * ������ ����ڰ� ����� ������������ ��ȯ�Ѵ�.
	 * @param userId �α��ε� ������� ���̵�
	 * @return ������ ����ڰ� ������ ��� ����
	 * @throws Exception
	 */
	public List<Todo> getMyTodos(String userId) throws Exception {
		
		return null;
	}
	
	/**
	 * ������ ������ȣ�� �ش��ϴ� ���� �������� ��ȯ�Ѵ�.
	 * @param todoNo ��ȸ�� ������ȣ
	 * @return ���� ������
	 * @throws Exception
	 */
	public Todo getTodoDetail(int todoNo) throws Exception {
		
		return null;
	}
	
	/**
	 * ����� ���������� �����Ų��.
	 * @param todo ����� ��������
	 * @return ����� ��������
	 * @throws Exception
	 */
	public Todo updateTodo(Todo todo) throws Exception {
		
		return null;
	}
}
