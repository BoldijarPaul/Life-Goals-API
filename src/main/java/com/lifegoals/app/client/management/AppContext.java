package com.lifegoals.app.client.management;

import com.lifegoals.app.context.Context;

public class AppContext {
	private static Context context;

	public static Context getContext() {
		if (context == null) {
			context = new Context();
			context.setRoot("http://localhost:8080/api/");
			context.setToken("Token");
		}
		return context;
	}
}
