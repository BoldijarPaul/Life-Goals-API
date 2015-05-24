package com.lifegoals.app.context;

import java.io.IOException;
import java.net.HttpURLConnection;

import com.lifegoals.app.client.management.ContextRequestListener;

public class Context {
	/* this class will handle all requests and (de)serializing of the objects */

	/* the token that we need for some requets */
	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	/* the root adress of the api */
	private String root;
	/* the request listener for the response code */
	private ContextRequestListener contextRequestListener;

	/* set the timeout for the requests, in milliseconds */

	/* set the root url adress of the server */
	public void setRoot(String root) {
		this.root = root;
	}

	public void setOnContextRequestListener(
			ContextRequestListener contextRequestListener) {
		this.contextRequestListener = contextRequestListener;
	}

	/* this method will be called for each request */
	private void handleUrlConnection(HttpURLConnection httpURLConnection) {
		if (contextRequestListener != null) {
			try {
				contextRequestListener.onGetStatusCode(httpURLConnection
						.getResponseCode());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/* for the get requests you can't set a body, for the others you can */
	public <T> T doGetRequest(String path, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper
					.createHttpUrlConnection(root + path, "GET", null, token);
			String response = HttpHelper
					.readHttpUrlConnectionResponse(urlConnection);
			handleUrlConnection(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> T doPostRequest(String path, Object body, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper
					.createHttpUrlConnection(root + path, "POST", body, token);
			String response = HttpHelper
					.readHttpUrlConnectionResponse(urlConnection);
			handleUrlConnection(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> T doDeleteRequest(String path, Object body, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper
					.createHttpUrlConnection(root + path, "DELETE", body, token);
			String response = HttpHelper
					.readHttpUrlConnectionResponse(urlConnection);
			handleUrlConnection(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> T doPutRequest(String path, Object body, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper
					.createHttpUrlConnection(root + path, "PUT", body, token);
			String response = HttpHelper
					.readHttpUrlConnectionResponse(urlConnection);
			handleUrlConnection(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
