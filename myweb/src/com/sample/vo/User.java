package com.sample.vo;

import java.util.Date;

public class User {

	private String id;
	private String password;
	private String name;
	private String email;
	private int point;
	private Date registeredDate;
	
	
	public User() {}

	public User(String id, String password, String name, String email, int point, Date registeredDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.point = point;
		this.registeredDate = registeredDate;
	}

	public String getId() {
		return id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getDate() {
		return registeredDate;
	}

	public void setDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
