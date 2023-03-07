package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.PrivilegeDto;
import com.itbulls.learnit.onlinestore.persistence.entities.Privilege;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultPrivilege;

@Service
public class PrivilegesDtoToPrivilegeConverter {
	
	public List<Privilege> convertPrivilegeDtosToPrivileges(List<PrivilegeDto> privilegesDtos) {
		List<Privilege> privileges = new ArrayList<>();
		for (PrivilegeDto privilegeDto : privilegesDtos) {
			privileges.add(convertPrivilegeDtoToPrivilege(privilegeDto));
		}
		return privileges;
	}

	private Privilege convertPrivilegeDtoToPrivilege(PrivilegeDto privilegeDto) {
		Privilege p = new DefaultPrivilege();
		p.setId(privilegeDto.getId());
		p.setName(privilegeDto.getName());
		return p;
	}

}
