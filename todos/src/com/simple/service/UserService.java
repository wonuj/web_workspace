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
		// 전달받안 이이디로 용자 정보를 조회한다.
		// 사용자 정보가 존재하지 않으면 null 반환
		// 비밀번호가 일치하지 않으면 null 반환
		// 그 외는 조회된 사용자 정보 반환한다.
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
