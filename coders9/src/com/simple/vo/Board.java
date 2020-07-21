package com.simple.vo;

import java.util.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private Date boardRegisteredDate;
	private String content;
	
	public Board() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardRegisteredDate() {
		return boardRegisteredDate;
	}

	public void setBoardRegisteredDate(Date boardRegisteredDate) {
		this.boardRegisteredDate = boardRegisteredDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
