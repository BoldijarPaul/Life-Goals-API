package com.lifegoals.app.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.StoringHelper;
import com.lifegoals.app.service.interf.ISavedGoalManagement;

public class SavedGoalManagementDemoImpl implements ISavedGoalManagement {
	private static List<SavedGoal> savedGoals = null;

	public SavedGoalManagementDemoImpl() {
		if (savedGoals == null) {
			savedGoals = new ArrayList<SavedGoal>();
		}
	}

	@Override
	public List<SavedGoal> getUserSavedGoals(int userId) {
		List<SavedGoal> userGoals = new ArrayList<SavedGoal>();
		for (SavedGoal savedGoal : savedGoals) {
			if (savedGoal.getUserId() == userId) {
				userGoals.add(savedGoal);
			}
		}
		return userGoals;
	}

	@Override
	public SavedGoal addSavedGoal(SavedGoal savedGoal) {
		/* creating a new saved goal, set an id, and current date time */
		savedGoal.setId((int) (Math.random() * 1000));
		savedGoal.setCreatedDate(System.currentTimeMillis());
		savedGoals.add(savedGoal);

		return savedGoal;
	}

	@Override
	public SavedGoal deleteSavedGoal(int id) {
		SavedGoal goal = null;
		for (int i = 0; i < savedGoals.size(); i++) {
			if (savedGoals.get(i).getId() == id) {
				/* delete this goal */
				goal = savedGoals.get(i);
				savedGoals.remove(i--);
			}
		}

		return goal;

	}

	@Override
	public void loadSavedGoalsGoals(List<SavedGoal> goals) {
		for (SavedGoal savedGoal : savedGoals) {
			Goal goal = ServiceLocator.get().getGoalManagement()
					.getGoalById(savedGoal.getGoalId());
			savedGoal.setGoal(goal);
		}

	}

	@Override
	public SavedGoal updateSavedGoal(SavedGoal savedGoal) {
		for (int i = 0; i < savedGoals.size(); i++) {
			SavedGoal goal = savedGoals.get(i);
			if (goal.getId() == savedGoal.getId()) {
				savedGoals.set(i, savedGoal);
				return savedGoal;
			}
		}

		return null;
	}

}
