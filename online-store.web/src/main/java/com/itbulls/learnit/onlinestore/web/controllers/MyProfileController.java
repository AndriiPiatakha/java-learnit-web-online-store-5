package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.web.filters.PartnerCodeFilter;


@Controller
public class MyProfileController {
	
	@Autowired
	private UserFacade userFacade;
	
	@GetMapping("/my-profile")
	public String doGet(HttpSession session, HttpServletRequest request, Model model) {
		User loggedInUser = (User)session.getAttribute(SignInController.LOGGED_IN_USER_ATTR);
		
		if (loggedInUser != null) {
			String baseUrl = request.getScheme()
				      + "://"
				      + request.getServerName()
				      + ":"
				      + request.getServerPort()
				      + request.getServletContext().getContextPath();
			String partnerLink = baseUrl + "?" 
				      + PartnerCodeFilter.PARTNER_CODE_PARAMETER_NAME 
				      + "=" + loggedInUser.getPartnerCode();
			List<User> referrals = userFacade.getReferralsForUser(loggedInUser);
			loggedInUser = userFacade.getUserById(loggedInUser.getId());
			// We need to fetch latest state of the user from the database
			session.setAttribute(SignInController.LOGGED_IN_USER_ATTR, loggedInUser);
			
			model.addAttribute("referrals", referrals);
			model.addAttribute("partnerLink", partnerLink);
			return "myProfile";
		} else {
			return "signin";
		}
	}
}
