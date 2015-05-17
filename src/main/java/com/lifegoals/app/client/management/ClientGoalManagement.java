package com.lifegoals.app.client.management;

import java.util.Arrays;
import java.util.List;

import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.entities.Goal;

public class ClientGoalManagement {

	public static List<Goal> getAllGoals() {
		return Arrays.asList(ClientContext.doGet("goals/getall").getEntity(
				Goal[].class));
	}

	public static Goal addGoal(Goal goal) {
		return ClientContext.doPost("goals/add", goal).getEntity(Goal.class);
	}
	public static Goal deleteGoal(Goal goal){
		return ClientContext.doDelete("goals/delete", goal).getEntity(Goal.class);
	}
}
