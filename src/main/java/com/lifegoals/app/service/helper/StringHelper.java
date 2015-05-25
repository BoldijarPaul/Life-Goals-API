package com.lifegoals.app.service.helper;

public class StringHelper {

	/* returns true if all the strings are not null, and not empty */
	public static boolean notNullAndEmpty(String... strings) {
		for (String string : strings) {
			if (string == null || string.trim().length() == 0)
				return false;
		}
		return true;
	}
}
