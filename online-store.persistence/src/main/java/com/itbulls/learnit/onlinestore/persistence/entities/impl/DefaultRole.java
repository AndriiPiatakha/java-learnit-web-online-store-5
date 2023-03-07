package com.itbulls.learnit.onlinestore.persistence.entities.impl;

import java.util.List;
import java.util.Set;

import com.itbulls.learnit.onlinestore.persistence.entities.Privilege;
import com.itbulls.learnit.onlinestore.persistence.entities.Role;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public class DefaultRole implements Role {
	
	private Integer id;
	private String roleName;
	private List<User> users;
	private List<Privilege> privileges;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	@Override
	public String toString() {
		return "DefaultRole [id=" + id + ", roleName=" + roleName + ", users=" + users + ", privileges=" + privileges
				+ "]";
	}
}
