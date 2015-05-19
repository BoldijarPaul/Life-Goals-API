package com.lifegoals.app.service.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.interf.IGoalManagement;

public class GoalManagementDemoImpl implements IGoalManagement {
	private List<Goal> goals = new ArrayList<Goal>();

	public GoalManagementDemoImpl() {
		Goal goal = new Goal();
		goal.setId(1);
		goal.setColor(Color.CYAN.getRGB());
		goal.setText("I like turtles");
		goal.setUserId(1);
		goal.setPublicGoal(true);
		goals.add(goal);

		Goal goal2 = new Goal();
		goal2.setId(2);
		goal2.setPublicGoal(true);
		goal2.setColor(Color.RED.getRGB());
		goal2.setText("Surfing");
		goal2.setUserId(1);
		goals.add(goal2);
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
		return goal;
	}

	@Override
	public Goal addGoal(Goal goal) {
		goals.add(goal);

		/* goal added, now create a saved goal for this guy */
		SavedGoal savedGoal = new SavedGoal();
		savedGoal.setDone(false);
		savedGoal.setGoalId(goal.getId());
		savedGoal.setUserId(goal.getUserId());

		ServiceLocator.get().getSavedGoalManagement().addSavedGoal(savedGoal);
		return goal;
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
