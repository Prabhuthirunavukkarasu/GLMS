package com.psg.glms.domain;

// Category for Books. Independent of Department
public class Category {

	public Category() {
	}
	private int categoryId;
	private String name;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
