package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public boolean addNewUser(User user) throws Exception {
		
		if(userDao.getUserById(user.getId()) == null) {
			userDao.insertUser(user);
			return true;
		} else {
			return false;
		}
	}
	
	public User loginCheck(String id, String password) throws Exception {
		// ���޹޾� ���̵�� ���� ������ ��ȸ�Ѵ�.
		// ����� ������ �������� ������ null ��ȯ
		// ��й�ȣ�� ��ġ���� ������ null ��ȯ
		// �� �ܴ� ��ȸ�� ����� ���� ��ȯ�Ѵ�.
		User user = userDao.getUserById(id);
		
		if (user == null) {
			return null;
		} else if (!user.getPassword().equals(password))  {
			return null;
		} else {
			return user;
		}
	}
}
