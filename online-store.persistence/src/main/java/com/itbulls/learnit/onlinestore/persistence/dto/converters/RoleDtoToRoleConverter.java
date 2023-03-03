package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.RoleDto;

@Service
public class RoleDtoToRoleConverter {

	public RoleDto convertRoleNameToRoleDtoWithOnlyRoleName(String roleName) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(roleName);
		return roleDto;
	}

}
