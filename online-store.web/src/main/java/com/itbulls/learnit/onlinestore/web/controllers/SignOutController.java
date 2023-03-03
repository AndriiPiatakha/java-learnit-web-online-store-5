package com.itbulls.learnit.onlinestore.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignOutController {

	@GetMapping("/signout")
	public String doGet(HttpSession session) {
		session.invalidate();
		return "redirect:/homepage";
	}

}
