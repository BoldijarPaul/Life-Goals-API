package com.lifegoals.app.entities;

import java.io.Serializable;

public class RegisterResponse implements Serializable {

	private boolean success;
	private RegisterState state;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public RegisterState getState() {
		return state;
	}

	public void setState(RegisterState state) {
		this.state = state;
	}

}
