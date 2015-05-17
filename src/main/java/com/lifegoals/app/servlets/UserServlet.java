package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifegoals.app.entities.LoginInfo;
import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.EntityValidationHelper;

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

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResult getUserById(LoginInfo info) {
		return ServiceLocator.get().getUserManagement()
				.getLoginResult(info.getName(), info.getPassword());
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		if (!EntityValidationHelper.userValid(user)) {
			// user not valid to add
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The user is invalid or name already taken")
					.build();
		}
		return Response.ok(
				ServiceLocator.get().getUserManagement().addUser(user),
				MediaType.APPLICATION_JSON).build();
	}

}
