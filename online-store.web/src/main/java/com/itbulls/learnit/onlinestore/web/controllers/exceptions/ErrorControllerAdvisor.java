package com.itbulls.learnit.onlinestore.web.controllers.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorControllerAdvisor {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception ex) {
		return "notfound";
	}
}
