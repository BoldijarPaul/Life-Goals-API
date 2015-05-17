package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.EntityValidationHelper;

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

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGoal(Goal goal, @HeaderParam("Token") String token) {
		/* first check for token */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.goalValid(goal)) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The goal is invalid").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token, goal.getUserId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		return Response.ok(
				ServiceLocator.get().getGoalManagement().addGoal(goal),
				MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGoal(Goal goal, @HeaderParam("Token") String token) {
		/* first check for token */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token, goal.getUserId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		return Response.ok(
				ServiceLocator.get().getGoalManagement()
						.deleteGoal(goal.getId()), MediaType.APPLICATION_JSON)
				.build();
	}

}
