package com.ssafy.zipsee.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
	private int commentId;
	private String boardId;
	private String content;
	private String registerDate;
	
//	public CommentDto() {
//		super();
//	}
//
//	public CommentDto(int commentId, String boardId, String content, String registerDate) {
//		super();
//		this.commentId = commentId;
//		this.boardId = boardId;
//		this.content = content;
//		this.registerDate = registerDate;
//	}
//
//	public int getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(int commentId) {
//		this.commentId = commentId;
//	}
//
//	public String getBoardId() {
//		return boardId;
//	}
//
//	public void setBoardId(String boardId) {
//		this.boardId = boardId;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getRegisterDate() {
//		return registerDate;
//	}
//
//	public void setRegisterDate(String registerDate) {
//		this.registerDate = registerDate;
//	}
//
//	@Override
//	public String toString() {
//		return "CommentDto [commentId=" + commentId + ", boardId=" + boardId + ", content=" + content
//				+ ", registerDate=" + registerDate + "]";
//	}
	
}
