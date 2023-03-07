package com.itbulls.learnit.onlinestore.persistence.entities;

import java.util.List;

public interface User {
	
	String getFirstName();
	void setFirstName(String firstName);
	
	String getLastName();
	void setLastName(String lastName);
	
	String getPassword();
	
	String getEmail();
	
	int getId();
	void setId(int id);
	
	void setPassword(String newPassword);
	void setEmail(String newEmail);
	
	double getMoney();
	void setMoney(double money);
	
	String getCreditCard();
	void setCreditCard(String creditCard);
	
	String getPartnerCode();
	void setPartnerCode(String partnerCode);
	
	void setReferrerUser(User convertUserDtoToUser);
	User getReferrerUser();
	
	void setRoles(List<Role> convertRoleDtosToRoles);
	List<Role> getRoles();
	boolean isEnabled();
	void setIsEnabled(boolean isEnabled);
	
	
}
