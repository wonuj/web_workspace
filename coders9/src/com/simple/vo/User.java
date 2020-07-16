package com.simple.vo;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String name;
	private Date userRegisteredDate;
	private String userAddr;
	private String phone;
	
	public User() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUserRegisteredDate() {
		return userRegisteredDate;
	}

	public void setUserRegisteredDate(Date userRegisteredDate) {
		this.userRegisteredDate = userRegisteredDate;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
