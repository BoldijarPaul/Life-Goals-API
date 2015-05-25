package com.lifegoals.app.service.helper;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.RegisterResponse;
import com.lifegoals.app.entities.RegisterState;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

public class EntityValidationHelper {
	/*
	 * this class will hold methods to test if a entity is valid for adding to
	 * server
	 */
	public static RegisterResponse getUserRegisterResponse(User user) {
		RegisterResponse response = new RegisterResponse();
		if (!StringHelper.notNullAndEmpty(user.getName(), user.getPassword(),
				user.getEmail())) {
			response.setState(RegisterState.FIELD_EMPTY);
			response.setSuccess(false);
			return response;
		}
		// now check if user exists already
		if (ServiceLocator.get().getUserManagement()
				.usernameIsTaken(user.getName())) {
			response.setState(RegisterState.USERNAME_TAKEN);
			response.setSuccess(false);
			return response;
		}
		if (ServiceLocator.get().getUserManagement()
				.emailIsTaken(user.getEmail())) {
			response.setState(RegisterState.EMAIL_TAKEN);
			response.setSuccess(false);
			return response;
		}

		response.setState(RegisterState.SUCCESS);
		response.setSuccess(true);
		return response;
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

	public static boolean savedGoalValid(SavedGoal savedGoal) {
		if (savedGoal.getGoalId() == 0)
			return false;
		return true;
	}
}
