package com.lifegoals.app.entities;

public class Goal {
	private int id;
	private int color;
	private String text;
	private int userId;
	private boolean publicGoal;

	public int getId() {
		return id;
	}

	public boolean isPublicGoal() {
		return publicGoal;
	}

	public void setPublicGoal(boolean publicGoal) {
		this.publicGoal = publicGoal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
