package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.CacheArrayList;
import com.lifegoals.app.service.interf.IUserManagement;

public class UserManagementDemoImpl implements IUserManagement {
	private static List<User> users = new CacheArrayList<User>("cache_users");

	public UserManagementDemoImpl() {

	}

	@Override
	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public LoginResult getLoginResult(String name, String password) {
		LoginResult loginResult = new LoginResult();
		loginResult.setSuccess(false);

		for (User user : users) {
			if (user.getName().equals(name)
					&& user.getPassword().equals(password)) {
				/* correct password, create a new token */
				loginResult.setSuccess(true);
				Token token = ServiceLocator.get().getTokenManagement()
						.addToken(user.getId());
				loginResult.setToken(token);
				loginResult.setTokenId(token.getId());
				loginResult.setUserId(user.getId());
				loginResult.setUser(user);
				return loginResult;
			}
		}
		return loginResult;
	}

	@Override
	public User addUser(User user) {
		/* set a unique id for the user */
		user.setId((int) (Math.random() * 10000));
		users.add(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public boolean usernameIsTaken(String username) {
		List<User> users = getAllUsers();
		for (User user : users)
			if (user.getName().toLowerCase().equals(username.toLowerCase()))
				return true;
		return false;
	}

	@Override
	public boolean emailIsTaken(String email) {
		List<User> users = getAllUsers();
		for (User user : users)
			if (user.getEmail().toLowerCase().equals(email.toLowerCase()))
				return true;
		return false;
	}

	@Override
	public String getUsernameByUserId(User user1) {
		for (User user2 : users) {
			if (user1.getId() == user2.getId()) {
				return user2.getName();
			}
		}
		return null;
	}

}
