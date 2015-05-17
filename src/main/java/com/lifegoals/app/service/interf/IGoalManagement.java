package com.lifegoals.app.service.interf;

import java.util.List;

import com.lifegoals.app.entities.Goal;

public interface IGoalManagement {
	public List<Goal> getAllGoals();

	public List<Goal> getUserGoals(int userId);

	public Goal deleteGoal(int id);

	public Goal addGoal(Goal goal);
	
	public Goal getGoalById(int id);

}
