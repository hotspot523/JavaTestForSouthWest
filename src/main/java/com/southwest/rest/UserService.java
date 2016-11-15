package com.southwest.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

	@POST
	@Path("/test")
	public Response addUser(@FormParam("name") String name) {

		String inputString = "";
		int length = name.length();
		for (int i = 0; i < length; i++) {
			
			char character = name.charAt(i);

			if (Character.isUpperCase(character)) {
				inputString += Character.toLowerCase(character);
			} else if (Character.isLowerCase(character)) {
				inputString += Character.toUpperCase(character);
			} else {
				return Response.serverError().entity("Invalid input; Please enter alphabate onlye [A-Za-z]").build();
			}
		}
		return Response.status(200).entity("Your output for entered '"+name+"' is : " + inputString).build();

	}	

}