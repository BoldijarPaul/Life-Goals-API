package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.Token;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

@Path("/tokens")
public class TokenServlet {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Token> getAll() {
		return ServiceLocator.get().getTokenManagement().getAllTokens();
	}

}
