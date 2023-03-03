package com.itbulls.learnit.onlinestore.web.controllers;

import static com.itbulls.learnit.onlinestore.persistence.dto.RoleDto.ADMIN_ROLE_NAME;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.web.utils.PBKDF2WithHmacSHA1EncryptionService;

@Controller
@RequestMapping("/signin")
public class SignInController {
	
	private static final String UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY = "UNSUCCESSFUL_LOGIN_COUNT";
	public static final String LOGGED_IN_USER_ATTR = "loggedInUser";
	private static final Logger LOGGER = LoggerFactory.getLogger(SignInController.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private PBKDF2WithHmacSHA1EncryptionService encryptionService;
	
	@GetMapping
	public String doGet() {
		return "signin";
	}


	@PostMapping
	public String doPost(@RequestParam String email, HttpSession session, @RequestParam String password) throws ServletException, IOException {
		User user = userFacade.getUserByEmail(email);
		LOGGER.info("Session is requested");
		if (user != null && encryptionService.validatePassword(password, user.getPassword())) {
			session.setAttribute(LOGGED_IN_USER_ATTR, user);
			LOGGER.info("User with ID {} is added to the session", user.getId());
			if (user.getRoleName().equals(ADMIN_ROLE_NAME)) {
				LOGGER.info("User with ID {} is redirected to the admin panel", user.getId());
				return "redirect:/admin/panel";
			} else {
				LOGGER.info("User with ID {} is redirected to the homepage", user.getId());
				return "redirect:/homepage";
			}
		} else {
			// counter for unsuccessful logins 
			Integer failedLoginCounter = (Integer)session.getAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY);
			session.setAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY, 
					failedLoginCounter == null ? 1 : ++failedLoginCounter);
			LOGGER.warn("Unsuccessful login attempt #{}", (Integer)session.getAttribute(UNSUCCESSFUL_LOGIN_COUNT_ATTR_KEY));
			return "redirect:/signin";
		}
		
	}

}
