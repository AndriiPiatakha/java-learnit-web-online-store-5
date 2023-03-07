package com.itbulls.learnit.onlinestore.persistence.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity(name = "user")
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true, length = 50)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private List<RoleDto> roles;
	
	@Column(name = "enabled")
	private boolean isEnabled;
	
	@Column(name = "money")
	private BigDecimal money;
	
	@Column(name = "credit_card")
	private String creditCard;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "partner_code", unique = true, length = 50)
	private String partnerCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "referrer_user_id")
	private UserDto referrerUser;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}
	public void setReferrerUser(UserDto user) {
		this.referrerUser = user;
	}
	public UserDto getReferrerUser() {
		return this.referrerUser;
	}
	public String getPartnerCode() {
		return this.partnerCode;
	}
	public List<RoleDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIsEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}
	
}
