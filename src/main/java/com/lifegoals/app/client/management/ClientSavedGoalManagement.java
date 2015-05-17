package com.lifegoals.app.client.management;

import java.util.Arrays;
import java.util.List;

import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.entities.User;

public class ClientSavedGoalManagement {

	public static List<SavedGoal> getUserSavedGoals(User user) {
		return Arrays.asList(ClientContext.doPost("savedgoals/getall", user)
				.getEntity(SavedGoal[].class));
	}

	public static SavedGoal addSavedGoal(SavedGoal savedGoal) {
		return ClientContext.doPost("savedgoals/add", savedGoal).getEntity(
				SavedGoal.class);
	}

	public static SavedGoal deleteSavedGoal(SavedGoal savedGoal) {
		return ClientContext.doDelete("savedgoals/delete", savedGoal)
				.getEntity(SavedGoal.class);
	}
}
