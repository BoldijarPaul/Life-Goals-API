package com.lifegoals.app.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HomeServlet {

	@GET
	public String getHomeString() {
		return "Hello there";
	}

}
