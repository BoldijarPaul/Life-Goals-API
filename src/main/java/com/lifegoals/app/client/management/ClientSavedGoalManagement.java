package com.lifegoals.app.client.management;

import java.util.Arrays;
import java.util.List;


import com.lifegoals.app.client.locator.context.Context;
import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.entities.User;

public class ClientSavedGoalManagement {

	public static List<SavedGoal> getUserSavedGoals(User user) {
		return Arrays.asList(Context.doPostRequest("savedgoals/getall", user,SavedGoal[].class));
	}

	public static SavedGoal addSavedGoal(SavedGoal savedGoal) {
		return  Context.doPostRequest("savedgoals/add", savedGoal,SavedGoal.class);
	}

	public static SavedGoal deleteSavedGoal(SavedGoal savedGoal) {
		return  Context.doDeleteRequest("savedgoals/delete", savedGoal,SavedGoal.class);
	}
}
