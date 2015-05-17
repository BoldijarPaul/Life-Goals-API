package com.lifegoals.app.client.examples;

import java.util.List;

import com.google.gson.Gson;
import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.client.management.ClientSavedGoalManagement;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.entities.User;

public class SavedGoalsExampls {

	private static void getGoalsExample() {
		ClientContext.setToken("Token");
		User user = new User();
		user.setId(1);

		List<SavedGoal> goals = ClientSavedGoalManagement
				.getUserSavedGoals(user);
		for (SavedGoal goal : goals) {
			System.out.println(goal.getGoal().getText());
			System.out.println(goal.isDone());
		}
	}

	 
	private static void addSavedGoal(){
	 
		ClientContext.setToken("Token");
		SavedGoal savedGoal=new SavedGoal();
		savedGoal.setGoalId(1);
		savedGoal.setUserId(1);
		ClientSavedGoalManagement.addSavedGoal(savedGoal);
	}
	private static void deleteSavedGoal(){
		ClientContext.setToken("Token");
		SavedGoal savedGoal=new SavedGoal();
		savedGoal.setId(1);
		savedGoal.setUserId(1);
		ClientSavedGoalManagement.deleteSavedGoal(savedGoal);
	}

	public static void main(String[] args) {

		addSavedGoal();
		 
	}
}
