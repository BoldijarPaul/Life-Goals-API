package com.lifegoals.app.service.helper;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

public class EntityValidationHelper {
	/*
	 * this class will hold methods to test if a entity is valid for adding to
	 * server
	 */
	public static boolean userValid(User user) {
		if (user.getName().trim().length() == 0)
			return false;
		if (user.getPassword().trim().length() == 0)
			return false;
		// now check if user exists already
		if (ServiceLocator.get().getUserManagement()
				.usernameIsTaken(user.getName()))
			return false;

		return true;
	}

	/* checks if a token is valid */
	public static boolean tokenValid(String hash) {
		if (hash == null)
			return false;
		Token token = ServiceLocator.get().getTokenManagement()
				.getTokenByHash(hash);
		if (token == null)
			return false;

		/* token valid */
		return true;
	}

	/* checks if goal is valid for adding */
	public static boolean goalValid(Goal goal) {
		if (goal.getText().trim().length() == 0)
			return false;
		return true;
	}

	/* checks if the user has that token */
	public static boolean tokenValidForUser(String hash, int userId) {
		Token token = ServiceLocator.get().getTokenManagement()
				.getTokenByHash(hash);
		if (token == null)
			return false;
		return token.getUserId() == userId;
	}
}
