package com.lifegoals.app.client.locator.examples;

import java.util.List;

import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.client.management.ClientUserManagement;
import com.lifegoals.app.entities.User;
import com.sun.jersey.api.client.ClientResponse;

public class UserExamples {

	public static void main(String[] args) {
		 
		User uzar1 = new User(69, "sample 21aname", "exzsadass2amplee", System.currentTimeMillis());
		ClientUserManagement.addUser(uzar1);
		System.out.println("Valoare");
		User uzar = new User(69, "sample name", "examplee", System.currentTimeMillis());
		ClientUserManagement.addUser(uzar);
		 
	}
}
