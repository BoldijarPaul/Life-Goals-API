package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.interf.IUserManagement;

public class UserManagementDemoImpl implements IUserManagement {
	private static List<User> users = new ArrayList<User>();

	public UserManagementDemoImpl() {
		users.add(new User(1, "blabla", "name", System.currentTimeMillis()));
		users.add(new User(2, "blabla", "da", System.currentTimeMillis()));
		users.add(new User(3, "blabla", "nu", System.currentTimeMillis()));
		users.add(new User(4, "blabla", "poate", System.currentTimeMillis()));
		users.add(new User(5, "blabla", "smecher", System.currentTimeMillis()));
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
				return loginResult;
			}
		}
		return loginResult;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
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
}
