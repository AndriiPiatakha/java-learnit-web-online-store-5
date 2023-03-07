package com.itbulls.learnit.onlinestore.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public class DefaultAuthFailureHandler implements AuthenticationFailureHandler {

	private static final int LOGIN_FAILURE_ATTEMPTS_LIMIT = 3;
	public static final String UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY = "UNSUCCESSFUL_LOGIN_COUNT";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		HttpSession session = request.getSession();
		String contextPath = request.getServletContext().getContextPath();
		// counter for unsuccessful logins
		Integer failedLoginCounter = (Integer) session.getAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY);
		session.setAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY, failedLoginCounter == null ? 1 : ++failedLoginCounter);
		LOGGER.warn("Unsuccessful login attempt #{}",
				(Integer) session.getAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY));

		response.sendRedirect(contextPath + "/signin");
	}

}
