package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.LoginResult;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;

@Path("/goals")
public class GoalServlet {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goal> getAll() {
		return ServiceLocator.get().get().getGoalManagement().getAllGoals();
	}

	@GET
	@Path("/getbyuserid/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goal> getGoalsFromUser(@PathParam("param") int id) {
		return ServiceLocator.get().getGoalManagement().getUserGoals(id);
	}

}
