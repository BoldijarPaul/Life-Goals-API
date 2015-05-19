package com.lifegoals.app.servlets;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifegoals.app.entities.SavedGoal;
import com.lifegoals.app.entities.User;
import com.lifegoals.app.service.ServiceLocator;
import com.lifegoals.app.service.helper.EntityValidationHelper;

@Path("/savedgoals")
public class SavedGoalServlet {

	@POST
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(User user, @HeaderParam("Token") String token) {
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token, user.getId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		List<SavedGoal> savedGoals = ServiceLocator.get()
				.getSavedGoalManagement().getUserSavedGoals(user.getId());
		ServiceLocator.get().getSavedGoalManagement()
				.loadSavedGoalsGoals(savedGoals);

		return Response.ok(savedGoals, MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSavedGoal(SavedGoal savedGoal,
			@HeaderParam("Token") String token) {
		/* first check for token */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.savedGoalValid(savedGoal)) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The goal is invalid").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token,
				savedGoal.getUserId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		return Response.ok(
				ServiceLocator.get().getSavedGoalManagement()
						.addSavedGoal(savedGoal), MediaType.APPLICATION_JSON)
				.build();
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSavedGoal(SavedGoal savedGoal,
			@HeaderParam("Token") String token) {
		/* first check for token */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token,
				savedGoal.getUserId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		return Response.ok(
				ServiceLocator.get().getSavedGoalManagement()
						.deleteSavedGoal(savedGoal.getId()),
				MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSavedGoal(SavedGoal savedGoal,
			@HeaderParam("Token") String token) {
		/* first check for token */
		if (!EntityValidationHelper.tokenValid(token)) {
			return Response.status(Response.Status.UNAUTHORIZED)
					.entity("You don't have access").build();
		}
		if (!EntityValidationHelper.tokenValidForUser(token,
				savedGoal.getUserId())) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("The token does not belong to the selected user")
					.build();
		}
		return Response
				.ok(ServiceLocator.get().getSavedGoalManagement()
						.updateSavedGoal(savedGoal), MediaType.APPLICATION_JSON)
				.build();
	}

}
