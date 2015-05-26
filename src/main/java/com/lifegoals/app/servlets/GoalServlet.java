package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifegoals.app.entities.Goal;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.EntityValidationHelper;

@Path("/goals")
public class GoalServlet {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goal> getAll() {
		return ServiceLocator.get().getGoalManagement().getAllGoals();
	}

	@POST
	@Path("/getfromuser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGoalsFromUser(User user,
			@HeaderParam("Token") String token) {
		/* check if token is valid and belongs to user */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token, user.getId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		/* everything is ok, return the goals */
		List<Goal> goals = ServiceLocator.get().getGoalManagement()
				.getUserGoals(user.getId(), true);
		return Response.ok(goals, MediaType.APPLICATION_JSON).build();
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
		if (!ServiceLocator.get().getColorManagement()
				.colorExists(goal.getColor())) {
			/* the request has a color which is not in the app databse */
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The color is not valid!").build();
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
