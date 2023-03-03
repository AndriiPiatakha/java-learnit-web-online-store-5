package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;

@Controller
public class SearchController {
	
	@Value("${pagination.limit}")
	private Integer paginationLimit;
	
	@Autowired
	private ProductFacade productFacade;
	
	@GetMapping("/search")
	public String doGet(@RequestParam String searchQuery, @RequestParam Integer page, Model model) {
		List<Product> products = productFacade.getProductsLikeNameForPageWithLimit(searchQuery, page, paginationLimit);
		Integer numberOfPagesForSearchTerm = productFacade.getNumberOfPagesForSearch(searchQuery, paginationLimit);
		List<Integer> pages = IntStream.range(1, numberOfPagesForSearchTerm + 1).boxed().collect(Collectors.toList());

		model.addAttribute("products", products);
		model.addAttribute("pages", pages);
		model.addAttribute("activePage", page);
		model.addAttribute("searchQuery", searchQuery);
		
		return "plp";
	}

}
