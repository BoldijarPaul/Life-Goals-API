package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.StoringHelper;
import com.lifegoals.app.service.interf.IGoalManagement;

public class GoalManagementDemoImpl implements IGoalManagement {
	private static List<Goal> goals = null;

	public GoalManagementDemoImpl() {
		if (goals == null) {
			goals = new ArrayList<Goal>();
			String goalsJson = StoringHelper.readFile("goal");
			if (goalsJson == null) {
				save();
				return;
			}
			Goal[] goalArray = new Gson().fromJson(goalsJson, Goal[].class);
			goals.addAll(Arrays.asList(goalArray));

		}
	}

	@Override
	public List<Goal> getAllGoals() {
		List<Goal> userGoals = new ArrayList<Goal>();
		for (Goal goal : goals) {
			/* only return public goals */
			if (goal.isPublicGoal()) {
				userGoals.add(goal);
			}
		}
		return userGoals;
	}

	@Override
	public List<Goal> getUserGoals(int userId) {
		List<Goal> userGoals = new ArrayList<Goal>();
		for (Goal goal : goals) {
			if (goal.getUserId() == userId && goal.isPublicGoal()) {
				userGoals.add(goal);
			}
		}
		return userGoals;
	}

	@Override
	public Goal deleteGoal(int id) {
		Goal goal = null;
		for (int i = 0; i < goals.size(); i++) {
			if (goals.get(i).getId() == id) {
				goal = goals.get(i);
				goals.remove(i--);
			}
		}
		save();
		return goal;
	}

	@Override
	public Goal addGoal(Goal goal) {
		goal.setId((int) (Math.random() * 1000));
		goals.add(goal);

		/* goal added, now create a saved goal for this guy */
		SavedGoal savedGoal = new SavedGoal();
		savedGoal.setDone(false);
		savedGoal.setGoalId(goal.getId());
		savedGoal.setUserId(goal.getUserId());

		ServiceLocator.get().getSavedGoalManagement().addSavedGoal(savedGoal);
		save();
		return goal;
	}

	private void save() {
		String gson = new Gson().toJson(goals.toArray());
		System.out.println(gson);
		StoringHelper.writeFile("goal", gson);
	}

	@Override
	public Goal getGoalById(int id) {
		for (Goal goal : goals) {
			if (goal.getId() == id) {
				return goal;
			}
		}
		return null;
	}

}
