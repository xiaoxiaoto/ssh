package org.aoto.webservices.cxf.example.publish;

import javax.jws.WebService;

import org.aoto.webservices.entity.User;

@WebService
public interface IUserWebServices {
	public User getUser();
}
