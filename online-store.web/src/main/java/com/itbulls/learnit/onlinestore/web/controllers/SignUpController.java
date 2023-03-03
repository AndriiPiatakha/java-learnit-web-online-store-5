package com.itbulls.learnit.onlinestore.web.controllers;

import static com.itbulls.learnit.onlinestore.web.filters.PartnerCodeFilter.PARTNER_CODE_COOKIE_NAME;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.services.Validator;
import com.itbulls.learnit.onlinestore.core.services.impl.CorePasswordValidator;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultUser;
import com.itbulls.learnit.onlinestore.web.utils.PBKDF2WithHmacSHA1EncryptionService;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private Validator passValidator;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PBKDF2WithHmacSHA1EncryptionService encryptionService;
	
	@GetMapping
	public String doGet(Model model) {
		model.addAttribute("user", new DefaultUser());
		return "signup";
	}
	
	@PostMapping
	public String doPost(@Valid @ModelAttribute("user") DefaultUser user, BindingResult br, HttpSession session, HttpServletRequest request,
			@CookieValue(value = PARTNER_CODE_COOKIE_NAME, defaultValue = "null") String partnerCodeCookie) {
		String notEncryptedPassword = user.getPassword();
		
		User userByEmail = userFacade.getUserByEmail(user.getEmail());
		
		if (userByEmail != null) {
			session.setAttribute("errMsg", messageSource.getMessage("signup.err.msg.email.exists", null, LocaleContextHolder.getLocale()));
			LOGGER.warn("Registration is failed. User with such email {} already exists", user.getEmail());
			return "redirect:/signup";
		}
		
		if (!notEncryptedPassword.equals(user.getRepeatPassword())) {
			session.setAttribute("errMsg", messageSource.getMessage("signup.err.msg.repeat.password", null, LocaleContextHolder.getLocale()));
			LOGGER.warn("Registration is failed. Repeat password is not correct");
			return "redirect:/signup";
		}
		
		if (br.hasErrors()) {
			return "signup";
		}
		
		user.setPassword(encryptionService.generatePasswordWithSaltAndHash(notEncryptedPassword));
		
		List<String> errorMessages = passValidator.validate(notEncryptedPassword);
		if (errorMessages.size() != 0) {
			String errMsg = messageSource.getMessage("signup.err.msg.general.error", null, LocaleContextHolder.getLocale());
			if (errorMessages.contains(CorePasswordValidator.LENGTH_OR_SPECIAL_CHARACTER_ERROR)) {
				errMsg = messageSource.getMessage("signup.err.msg.special.character", null, LocaleContextHolder.getLocale());
				LOGGER.warn("Registration is failed. Password shorter than 8 characters or doesn't contain a special character.");
			}
			if (errorMessages.contains(CorePasswordValidator.MOST_COMMON_PASSWORD)) {
				errMsg = messageSource.getMessage("signup.err.msg.common.password", null, LocaleContextHolder.getLocale());
				LOGGER.warn("Registration is failed. User selected one of the most common passwords.");
			}
			session.setAttribute("errMsg", errMsg);
			return "redirect:/signup";
		}
		
		String partnerCode = null;
		if (!partnerCodeCookie.equals("null")) {
			partnerCode = partnerCodeCookie;
			LOGGER.info("Partner code {} is found in cookie", partnerCode);
		}
		
		userFacade.registerUser(user, partnerCode);
		LOGGER.info("User with email {} is registered successfully", user.getEmail());
		return "redirect:/signin";
	}

}
