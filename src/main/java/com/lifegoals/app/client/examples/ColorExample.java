package com.lifegoals.app.client.examples;

import com.lifegoals.app.client.management.AppContext;
import com.lifegoals.app.client.management.ClientColorManagement;
import com.lifegoals.app.client.management.ContextRequestListener;

public class ColorExample {
	public static void main(String[] args) {
		AppContext.setOnRequestListener(new ContextRequestListener() {

			@Override
			public void onGetStatusCode(int code) {
				System.out.println(code + " code");
			}
		});
		System.out.println(ClientColorManagement.getAllColors().length + " nr");
	}
}
