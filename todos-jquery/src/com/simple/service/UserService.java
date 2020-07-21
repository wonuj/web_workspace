package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	/**
	 * ������ ����� ������ ȸ������ ��Ų��.
	 * ��, ������ ���̵� ���� ����ڰ� �ִ� ���, ���ܸ� �߻���Ų��.
	 * @param user �� ����� ����
	 * @throws Exception
	 */
	public void addNewUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new Exception("���̵� �ߺ�");
		}
		userDao.insertUser(savedUser);
	}
	
	/**
	 * ������ ���̵�� ��й�ȣ�� ���Ե� ����� ������ ���ؼ� �α��� ���θ� �����Ѵ�.
	 * ���������� ������� ���� ���, ���ܸ� �߻���Ų��.
	 * @param userId ����� ���̵�
	 * @param password ��й�ȣ
	 * @return ���������� ����� ������� ����
	 * @throws Exception
	 */
	public User getLoginUser(String userId, String password) throws Exception {
		
		return null;
	}
}
