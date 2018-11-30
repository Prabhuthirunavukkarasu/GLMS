package com.psg.glms.domain;

public class BookRequest {

	public BookRequest() {
	}
	
	public BookRequest(int requestId, int userId, int bookId) {
		this.requestId = requestId;
		this.userId = userId;
		this.bookId = bookId;
	}
	
	private int requestId;
	private int userId;
	private int bookId;
	private boolean status;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
