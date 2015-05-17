package com.lifegoals.app.service.helper;

import javax.xml.ws.ServiceMode;

import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

public class EntityValidationHelper {
	/*
	 * this class will hold methods to test if a entity is valid for adding to
	 * server
	 */
	public static boolean userValid(User user) {
		if (user.getName().trim().length() == 0)
			return false;
		if (user.getPassword().trim().length() == 0)
			return false;
		// now check if user exists already
		if (ServiceLocator.get().getUserManagement()
				.usernameIsTaken(user.getName()))
			return false;
		
		return true;
	}
}
