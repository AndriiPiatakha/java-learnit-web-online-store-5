package com.itbulls.learnit.onlinestore.core.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.RoleFacade;
import com.itbulls.learnit.onlinestore.persistence.dao.RoleDao;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.RoleDtoToRoleConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.Role;

@Service
public class DefaultRoleFacade implements RoleFacade {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleDtoToRoleConverter roleConverter;

	@Override
	public Role getRoleByName(String roleName) {
		return roleConverter.convertRoleDtoToTole(roleDao.getRoleByRoleName(roleName));
	}

}
