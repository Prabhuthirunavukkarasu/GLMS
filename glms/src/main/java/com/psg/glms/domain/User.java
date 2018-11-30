package com.psg.glms.domain;

// User Object for system users like Students/Faculty
public class User {

	public User() {
	}
	
	public User(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}
	
	private int userId;
	private String name;
	private int rewardPoint;
	private String badgeName;
	
	public String getBadgeName() {
		return badgeName;
	}
	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRewardPoint() {
		return rewardPoint;
	}
	public void setRewardPoint(int rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
	
}