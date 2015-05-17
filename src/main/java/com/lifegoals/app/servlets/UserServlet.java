package com.lifegoals.app.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

@Path("/users")
public class UserServlet {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		return ServiceLocator.get().getUserManagement().getAllUsers();
	}

	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("param") int id) {
		return ServiceLocator.get().getUserManagement().getUserById(id);
	}

	@GET
	@Path("/login/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResult getUserById(@PathParam("name") String name,
			@PathParam("password") String password) {
		return ServiceLocator.get().getUserManagement()
				.getLoginResult(name, password);
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		return ServiceLocator.get().getUserManagement().addUser(user);
	}

}
