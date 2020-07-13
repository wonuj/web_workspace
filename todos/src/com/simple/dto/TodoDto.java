package com.simple.dto;

import java.util.Date;

public class TodoDto {
	
	private int no;
	private String title;
	private String content;
	private Date day;
	private Date completedDay; 
	private String status;
	private String statusClass;
	private String userId;
	private String userName;
	private Date createDate;
	private boolean canModify;
	
	public TodoDto() {}

	public boolean isCanModify() {
		return canModify;
	}

	public void setCanModify(boolean canModify) {
		this.canModify = canModify;
	}

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

	public Date getCompletedDay() {
		return completedDay;
	}

	public void setCompletedDay(Date completedDay) {
		this.completedDay = completedDay;
	}

	public String getStatus() {
		return status;
	}
	
	public String getStatusClass() {
		String value = "";
		if ("ó������".equals(status)) {
			value = "badge-primary";
		} else if ("ó����".equals(status)) {
			value = "badge-info";
		} else if ("����".equals(status)) {
			value = "badge-secondary";
		} else if ("����".equals(status)) {
			value = "badge-danger";
		} else if ("ó���Ϸ�".equals(status)) {
			value = "badge-success";
		}

		return value;
	}
	
	public void setStatusClass(String statusClass) {
		this.statusClass = statusClass;
	}
	
	public void setStatus(String status) {
		this.statusClass = getStatusClass();
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
