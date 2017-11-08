package org.aoto.webservices.cxf.example.publish.impl;

import javax.jws.WebService;

import org.aoto.webservices.cxf.example.publish.IUserWebServices;
import org.aoto.webservices.entity.User;

@WebService(endpointInterface = "org.aoto.webservices.cxf.example.publish.IUserWebServices", serviceName = "userWebServices")
public class UserWebServices implements IUserWebServices {

	@Override
	public User getUser() {
		User user = new User();
		user.setId(123);
		user.setName("xiaoxiao");
		return user;
	}

}
