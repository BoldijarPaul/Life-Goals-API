package com.lifegoals.app.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/version1")
public class VersionServlet {

	public static final String VERSION = "1";

	@GET
	public String getVersion() {
		return VERSION;

	}

}