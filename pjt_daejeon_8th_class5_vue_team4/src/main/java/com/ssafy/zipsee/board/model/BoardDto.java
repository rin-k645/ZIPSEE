package com.ssafy.zipsee.board.model;

public class BoardDto {
	private int boardId;
	private String userId;
	private String title;
	private String content;
	private String registerDate;
	
	private CommentDto comment;

	public BoardDto() {
		super();
	}

	public BoardDto(int boardId, String userId, String title, String content, String registerDate, CommentDto comment) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.comment = comment;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public CommentDto getComment() {
		return comment;
	}

	public void setComment(CommentDto comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", registerDate=" + registerDate + ", comment=" + comment + "]";
	}
	
}
