package com.lifegoals.app.service.interf;

import java.util.List;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;

public interface IUserManagement {
	public User getUserById(int id);

	public LoginResult getLoginResult(String name, String password);

	public User addUser(User user);

	public List<User> getAllUsers();

	/* checks if a username is already taken , this method is service side only */
	public boolean usernameIsTaken(String username);

	/* checks if email is already taken */
	public boolean emailIsTaken(String email);

	/* for this user id must be the only field not null */
	public String getUsernameByUserId(User user);

}
