package org.aoto.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginedInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) {
		Object login = request.getSession().getAttribute("LOGINED");
		if(login!=null){
			return true; 
		}else{
			try {
				response.sendRedirect("../login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		return false;
		}
	}

	

}
