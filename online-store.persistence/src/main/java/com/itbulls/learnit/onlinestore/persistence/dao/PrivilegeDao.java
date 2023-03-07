package com.itbulls.learnit.onlinestore.persistence.dao;

import com.itbulls.learnit.onlinestore.persistence.dto.PrivilegeDto;

public interface PrivilegeDao {

	void save(PrivilegeDto privilege);

	PrivilegeDto getPrivilegeByName(String name);

}
