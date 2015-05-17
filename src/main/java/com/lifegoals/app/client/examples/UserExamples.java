package com.lifegoals.app.client.examples;

import java.util.List;

import com.lifegoals.app.client.locator.ClientContext;
import com.lifegoals.app.client.management.ClientUserManagement;
import com.lifegoals.app.entities.LoginInfo;
import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;
import com.sun.jersey.api.client.ClientResponse;

public class UserExamples {

	private static void loginExample() {
		LoginInfo info = new LoginInfo();
		info.setName("name");
		info.setPassword("blabla");

		LoginResult loginResult = ClientUserManagement.login(info);
		System.out.println(loginResult.isSuccess());
	}

	private static void showUsers() {

		 

		List<User> users = ClientUserManagement.getAllClients();
		String text = "";
		for (User user : users) {
			text += user.getName() + " ";
		}
		System.out.println(text);
	}

	public static void main(String[] args) {
		showUsers();
	}
}
