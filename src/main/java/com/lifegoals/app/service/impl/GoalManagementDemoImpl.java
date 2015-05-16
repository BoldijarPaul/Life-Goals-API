package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.service.interf.IGoalManagement;

public class GoalManagementDemoImpl implements IGoalManagement {
	private List<Goal> goals = new ArrayList<Goal>();

	@Override
	public List<Goal> getAllGoals() {
		return goals;
	}

	@Override
	public List<Goal> getUserGoals(int userId) {
		List<Goal> userGoals = new ArrayList<Goal>();
		for (Goal goal : goals) {
			if (goal.getUserId() == userId) {
				userGoals.add(goal);
			}
		}
		return userGoals;
	}

	@Override
	public Goal deleteGoal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goal addGoal(Goal goal) {
		goals.add(goal);
		return goal;
	}

}
