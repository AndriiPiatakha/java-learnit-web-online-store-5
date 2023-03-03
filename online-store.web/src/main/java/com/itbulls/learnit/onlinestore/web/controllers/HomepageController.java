package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbulls.learnit.onlinestore.core.facades.CategoryFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.Category;

@Controller
public class HomepageController {

	@Autowired
	private CategoryFacade categoryFacade;
	
	@GetMapping(value = {"/homepage", "/"})
	public String doGet(Model model) {
		List<Category> categories = categoryFacade.getCategories();
		model.addAttribute("categories", categories);
		return "homepage";
	}

}
