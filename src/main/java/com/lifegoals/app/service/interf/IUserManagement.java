package com.lifegoals.app.service.interf;

import java.util.List;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;

public interface IUserManagement {
	public User getUserById(int id);

	public LoginResult getLoginResult(String name, String password);

	public User addUser(User user);

	public List<User> getAllUsers();

}
