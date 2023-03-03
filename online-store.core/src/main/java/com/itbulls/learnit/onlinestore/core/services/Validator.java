package com.itbulls.learnit.onlinestore.core.services;

import java.util.List;

public interface Validator {
	
	boolean isValid(String stringValue);
	
	/**
	 * @param stringValue - any string value to validate
	 * @return the list of of error messages in case they were found during the validation
	 */
	List<String> validate(String stringValue);

}
