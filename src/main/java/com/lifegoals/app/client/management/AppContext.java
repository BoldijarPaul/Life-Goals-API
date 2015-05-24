package com.lifegoals.app.client.management;

import com.lifegoals.app.context.Context;

public class AppContext {
	private static Context context;

	public static Context getContext() {
		if (context == null) {
			context = new Context();
			// context.setRoot("http://169.254.123.149:8080/api/");
			// context.setRoot("http://localhost:8080/api/");
			context.setRoot("http://app-leaderboards.rhcloud.com/api/");
			context.setToken("Token");
		}
		return context;
	}

	public static void setRoot(String root) {
		getContext().setRoot(root);
	}

	public static void setOnRequestListener(
			ContextRequestListener contextRequestListener) {
		getContext().setOnContextRequestListener(contextRequestListener);
	}
}
