package com.itbulls.learnit.onlinestore.web.security;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.persistence.SetupDataLoader;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.web.controllers.SignInController;
import com.itbulls.learnit.onlinestore.web.filters.RememberMeFilter;

public class DefaultAuthSuccessHandler implements AuthenticationSuccessHandler {

	
	public static final String LOGGED_IN_USER_ATTR = "loggedInUser";
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthSuccessHandler.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User user = userFacade.getUserByEmail(authentication.getName());
		HttpSession session = request.getSession();
		String contextPath = request.getServletContext().getContextPath();
		LOGGER.info("Session is requested");
		if (user != null) {
			session.setAttribute(LOGGED_IN_USER_ATTR, user);
			session.setAttribute(DefaultAuthFailureHandler.UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY, null);
			LOGGER.info("User with ID {} is added to the session", user.getId());
			if (user.getRoles().stream().map(role -> role.getRoleName())
					.collect(Collectors.toList()).contains(SetupDataLoader.ROLE_ADMIN) ) {
				LOGGER.info("User with ID {} is redirected to the admin panel", user.getId());
				response.sendRedirect(contextPath + "/admin/panel");
			} else {
				LOGGER.info("User with ID {} is redirected to the homepage", user.getId());
				response.sendRedirect(contextPath + "/homepage");
			}
		} 
	}

}
