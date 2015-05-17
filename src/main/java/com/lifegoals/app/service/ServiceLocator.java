package com.lifegoals.app.service;

import com.lifegoals.app.service.impl.GoalManagementDemoImpl;
import com.lifegoals.app.service.impl.SavedGoalManagementDemoImpl;
import com.lifegoals.app.service.impl.TokenManagementDemoImpl;
import com.lifegoals.app.service.impl.UserManagementDemoImpl;
import com.lifegoals.app.service.interf.IGoalManagement;
import com.lifegoals.app.service.interf.ISavedGoalManagement;
import com.lifegoals.app.service.interf.ITokenManagement;
import com.lifegoals.app.service.interf.IUserManagement;

public class ServiceLocator {
	private static ServiceLocator singleton;

	public static ServiceLocator get() {
		if (singleton == null)
			singleton = new ServiceLocator();
		return singleton;
	}

	//
	private IUserManagement userManagement;
	private ITokenManagement tokenManagement;
	private IGoalManagement goalManagement;
	private ISavedGoalManagement savedGoalManagement;

	public ServiceLocator() {
		userManagement = new UserManagementDemoImpl();
		tokenManagement = new TokenManagementDemoImpl();
		goalManagement = new GoalManagementDemoImpl();
		savedGoalManagement=new SavedGoalManagementDemoImpl();
	}

	public ISavedGoalManagement getSavedGoalManagement() {
		return savedGoalManagement;
	}
	public IUserManagement getUserManagement() {
		return userManagement;
	}

	public ITokenManagement getTokenManagement() {
		return tokenManagement;
	}
	public IGoalManagement getGoalManagement() {
		return goalManagement;
	}
}
