package com.lifegoals.app.client.locator;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.PartialRequestBuilder;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class ClientContext {

	/* the root url of the service */
	private static final String ROOT = "http://localhost:8080/api/";

	/* the client that we are going to use to create requests */
	private static Client client;

	public static Client getClient() {
		if (client == null)
			client = Client.create();
		return client;
	}

	private static String token = null;

	public static void setToken(String token) {
		ClientContext.token = token;
	}

	public static ClientResponse doGet(String path) {
		WebResource webResource = getClient().resource(ROOT + path);
		Builder builder = webResource.accept("application/json");
		if (token != null) {
			/* we have a token, use it */
			builder.header("Token", token);
		}
		ClientResponse response = builder.get(ClientResponse.class);
		return response;
	}

	public static ClientResponse doPost(String path, Object body) {
		WebResource webResource = getClient().resource(ROOT + path);
		Builder builder = webResource.accept("application/json");
		if (token != null) {
			/* we have a token, use it */
			builder.header("Token", token);
		}
		ClientResponse response = builder.post(ClientResponse.class, body);
		return response;
	}
}
