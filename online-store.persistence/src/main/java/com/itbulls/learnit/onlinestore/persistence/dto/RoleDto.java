package com.itbulls.learnit.onlinestore.persistence.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "role")
public class RoleDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;

	@ManyToMany(mappedBy = "roles")
    private List<UserDto> users;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_privileges", 
		joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private List<PrivilegeDto> privileges;

	public RoleDto() {
	}
	
	public RoleDto(String name) {
		this.roleName = name;
	}

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

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	public List<PrivilegeDto> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegeDto> privileges) {
		this.privileges = privileges;
	}

	
	
}
