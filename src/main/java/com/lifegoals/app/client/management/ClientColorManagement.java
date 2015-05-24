package com.lifegoals.app.client.management;


public class ClientColorManagement {

	public static int[] getAllColors() {
		return AppContext.getContext().doGetRequest("colors", int[].class);
	}

}
