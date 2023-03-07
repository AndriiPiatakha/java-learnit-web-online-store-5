package com.itbulls.learnit.onlinestore.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/panel") 
	public String adminPanel() {
		return "adminPanel";
	}

}
