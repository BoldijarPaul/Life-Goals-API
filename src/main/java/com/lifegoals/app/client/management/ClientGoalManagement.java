package com.lifegoals.app.client.management;

import java.util.Arrays;
import java.util.List;

import com.lifegoals.app.client.locator.context.Context;
import com.lifegoals.app.entities.Goal;

public class ClientGoalManagement {

	public static List<Goal> getAllGoals() {
			Goal[] goals = Context.doGetRequest("goals/getall", Goal[].class);
			return Arrays.asList(goals);
	}

	public static Goal addGoal(Goal goal) {
		return Context.doPostRequest("goals/add", goal, Goal.class);
	}

	public static Goal deleteGoal(Goal goal) {
		return Context.doDeleteRequest("goals/delete", goal, Goal.class);
	}
}
