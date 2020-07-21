package com.simple.vo;

import java.util.Date;

public class Todo {
	private int no;
	private String title;
	private String content;
	private Date day;
	private Date comletedDay;
	private String status;	// ó������, ó����, ����, ó���Ϸ�, ���� 
	private String userId;
	private String userName;
	private Date createdDate;
	
	public Todo() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Date getComletedDay() {
		return comletedDay;
	}

	public void setComletedDay(Date comletedDay) {
		this.comletedDay = comletedDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
