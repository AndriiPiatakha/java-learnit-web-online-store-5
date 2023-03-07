package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.UserDto;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultUser;

@Service
public class UserDtoToUserConverter {
	
	@Autowired
	private RoleDtoToRoleConverter roleConverter;
	
	public UserDto convertUserIdToUserDtoWithOnlyId(int customerId) {
		UserDto userDto = new UserDto();
		userDto.setId(customerId);
		return userDto;
	}
	
	public User convertUserDtoToUser(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new DefaultUser();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setRoles(roleConverter.convertRoleDtosToRoles(userDto.getRoles())); // here
		if (userDto.getMoney() != null) {
			user.setMoney(userDto.getMoney().doubleValue());
		}
		user.setCreditCard(userDto.getCreditCard());
		user.setPartnerCode(userDto.getPartnerCode());
		user.setReferrerUser(convertUserDtoToUser(userDto.getReferrerUser()));
		user.setIsEnabled(userDto.isEnabled());
		
		return user;
	}
	
	public UserDto convertUserToUserDto(User user) {
		UserDto userDto = null;
		if (user != null) {
			userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setPassword(user.getPassword());
			userDto.setRoles(roleConverter.convertRolesToRoleDtos(user.getRoles())); // TODO - comment this
			userDto.setMoney(BigDecimal.valueOf(user.getMoney()));
			userDto.setCreditCard(user.getCreditCard());
			userDto.setPartnerCode(user.getPartnerCode());
			userDto.setReferrerUser(convertUserToUserDto(user.getReferrerUser()));
			userDto.setIsEnabled(user.isEnabled());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ " + userDto.getRoles());
		}
		
		return userDto;
	}

	public List<User> convertUserDtosToUsers(List<UserDto> userDtos) {
		List<User> users = new ArrayList<>();
		
		for (UserDto userDto : userDtos) {
			users.add(convertUserDtoToUser(userDto));
		}
		return users;
	}

	public List<UserDto> convertUsersToUserDtos(List<User> users) {
		List<UserDto> userDtos = new ArrayList<>();
		for (User user : users) {
			userDtos.add(convertUserToUserDto(user));
		}
		return userDtos;
	}

}
