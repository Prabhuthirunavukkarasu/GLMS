package com.psg.glms.domain;

public class Review {

	public Review() {
	}
	
	private int userId;
	private String review;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

}
