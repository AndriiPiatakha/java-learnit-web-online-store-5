package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.core.facades.PurchaseFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Controller
public class CheckoutController {

	@Autowired
	private PurchaseFacade purchaseFacade;
	
	@Autowired
	private ProductFacade productFacade;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("/checkout")
	public String doGet(@RequestParam("guid") String productGuid, HttpSession session) {
		purchaseFacade.createPurchase(
				(User) session.getAttribute(SignInController.LOGGED_IN_USER_ATTR),
				productFacade.getProductByGuid(productGuid));

		session.setAttribute("orderStatus", messageSource.getMessage("order.created.msg", null, LocaleContextHolder.getLocale()));
		return "redirect:/product?guid=" + productGuid;
	}

}
