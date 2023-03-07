package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.RoleDto;
import com.itbulls.learnit.onlinestore.persistence.entities.Role;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultRole;

@Service
public class RoleDtoToRoleConverter {
	
	@Autowired
	private PrivilegesDtoToPrivilegeConverter privilegeConverter;

	public RoleDto convertRoleNameToRoleDtoWithOnlyRoleName(String roleName) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(roleName);
		return roleDto;
	}
	
	public Role convertRoleDtoToTole(RoleDto roleDto) {
		Role r = new DefaultRole();
		r.setRoleName(roleDto.getRoleName());
		r.setId(roleDto.getId());
		r.setPrivileges(privilegeConverter
				.convertPrivilegeDtosToPrivileges(roleDto.getPrivileges()));
		return r;
	}

	public List<Role> convertRoleDtosToRoles(List<RoleDto> roleDtos) {
		List<Role> roles = new ArrayList<>();
		for (RoleDto roleDto : roleDtos) {
			roles.add(convertRoleDtoToTole(roleDto));
		}
		return roles;
	}

	public List<RoleDto> convertRolesToRoleDtos(List<Role> roles) {
		List<RoleDto> roleDtos = new ArrayList<>();
		for (Role role : roles) {
			roleDtos.add(convertRoleToRoleDto(role));
		}
		return roleDtos;
	}

	private RoleDto convertRoleToRoleDto(Role role) {
		RoleDto rDto = new RoleDto();
		rDto.setId(role.getId());
		rDto.setRoleName(role.getRoleName());
		return rDto;
	}
 
}
