package com.lifegoals.app.client.locator.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Context {
	/* this class will handle all requests and (de)serializing of the objects */
	
	/* the token that we need for some requets */
	private static String token;
	public static void setToken(String token) {
		Context.token = token;
	}
	
	/* the root adress of the api */
	public static final String ROOT = "http://app-leaderboards.rhcloud.com/api/";

	 /* for the get requets you can't set a body, for the others you can */
	public static <T> T doGetRequest(String path, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper.createHttpUrlConnection(path,
					"GET", null,token);
			String response = HttpHelper.readHttpUrlConnectionResponse(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public  static<T> T doPostRequest(String path,Object body, Class<T> type)  {
		try {
		HttpURLConnection urlConnection = HttpHelper.createHttpUrlConnection(path, "POST",
				body,token);
		String response = HttpHelper.readHttpUrlConnectionResponse(urlConnection);
		return HttpHelper.stringToObject(response, type);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static <T> T doDeleteRequest(String path,Object body, Class<T> type)   {
		try {
			HttpURLConnection urlConnection = HttpHelper.createHttpUrlConnection(path, "DELETE",
					body,token);
			String response = HttpHelper.readHttpUrlConnectionResponse(urlConnection);
			return HttpHelper.stringToObject(response, type);
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	

}
