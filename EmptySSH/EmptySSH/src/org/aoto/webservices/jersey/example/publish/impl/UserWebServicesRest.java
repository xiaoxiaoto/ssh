package org.aoto.webservices.jersey.example.publish.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aoto.webservices.entity.User;
import org.aoto.webservices.jersey.example.publish.IUserWebServicesRest;
import org.springframework.stereotype.Component;
@Component
@Path("/WebServices")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
public class UserWebServicesRest implements IUserWebServicesRest {
	private static Map<String,User> userMap  = new HashMap<String,User>(); 
	@GET
	@Path("/UserWebServices")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	@Override
	public User getAllUsers() {
		User user = new User();
		user.setId(123);
		user.setName("xiaoxiao");
		userMap.put("123", user);
		return user;
	}

}
