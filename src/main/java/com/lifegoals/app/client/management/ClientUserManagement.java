package com.lifegoals.app.client.management;

import java.util.Arrays;
import java.util.List;

import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.entities.LoginInfo;
import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;

public class ClientUserManagement {

	/* returns all the clients on the server */
	public static List<User> getAllClients() {
		return Arrays.asList(ClientContext.doGet("users/getall").getEntity(
				User[].class));
	}

	/* adds a new user */
	public static User addUser(User user) {
		return ClientContext.doPost("users/add", user).getEntity(User.class);
	}

	/* tries to login and return a LoginResult which also has a token */
	public static LoginResult login(LoginInfo loginInfo) {
		return ClientContext.doPost("users/login", loginInfo).getEntity(
				LoginResult.class);
	}

}
