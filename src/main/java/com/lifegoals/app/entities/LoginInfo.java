package com.lifegoals.app.entities;

import java.io.Serializable;

public class LoginInfo implements Serializable{
	/* this entity is used with the login */
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
