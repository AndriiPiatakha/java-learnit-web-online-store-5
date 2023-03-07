package com.itbulls.learnit.onlinestore.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
public class SignInController {
	
	public static final String LOGGED_IN_USER_ATTR = "loggedInUser";
	
	@GetMapping
	public String doGet() {
		return "signin";
	}


}
