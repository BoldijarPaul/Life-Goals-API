package com.lifegoals.app.entities;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String password;
	private String name;
	private String email;
	private long createdDate;

	public User() {

	}

	public User(int id, String password, String name, long createdDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

}
