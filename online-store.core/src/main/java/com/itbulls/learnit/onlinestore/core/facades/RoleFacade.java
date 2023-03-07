package com.itbulls.learnit.onlinestore.core.facades;

import com.itbulls.learnit.onlinestore.persistence.entities.Role;

public interface RoleFacade {

	Role getRoleByName(String roleName);

}
