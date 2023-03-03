package com.itbulls.learnit.onlinestore.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "role")
public class RoleDto {
	
	public static final String ADMIN_ROLE_NAME = "ROLE_ADMIN";
	public static final String MANAGER_ROLE_NAME = "ROLE_MANAGER";
	public static final String CUSTOMER_ROLE_NAME = "ROLE_CUSTOMER";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "role_name")
	private String roleName;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
