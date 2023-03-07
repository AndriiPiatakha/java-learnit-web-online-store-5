package com.itbulls.learnit.onlinestore.core.facades.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.services.AffiliateMarketingService;
import com.itbulls.learnit.onlinestore.persistence.SetupDataLoader;
import com.itbulls.learnit.onlinestore.persistence.dao.RoleDao;
import com.itbulls.learnit.onlinestore.persistence.dao.UserDao;
import com.itbulls.learnit.onlinestore.persistence.dto.UserDto;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.RoleDtoToRoleConverter;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.UserDtoToUserConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Service
public class DefaultUserFacade implements UserFacade {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDtoToUserConverter userConverter;
	
	@Autowired
	private AffiliateMarketingService marketingService;
	
	@Autowired
	private RoleDtoToRoleConverter roleConverter;
	

	@Override
	public void registerUser(User user, String referrerCode) {
		user.setPartnerCode(marketingService.generateUniquePartnerCode());
		user.setReferrerUser(userConverter.convertUserDtoToUser(userDao.getUserByPartnerCode(referrerCode)));
		user.setRoles(roleConverter.convertRoleDtosToRoles(Arrays.asList(roleDao.getRoleByRoleName(SetupDataLoader.ROLE_CUSTOMER))));
		userDao.saveUser(userConverter.convertUserToUserDto(user));
	}


	@Override
	public User getUserByEmail(String email) {
		return userConverter.convertUserDtoToUser(userDao.getUserByEmail(email));
	}

	@Override
	public List<User> getUsers() {
		return userConverter.convertUserDtosToUsers(userDao.getUsers());
	}

	@Override
	public User getUserById(Integer userId) {
		return userConverter.convertUserDtoToUser(userDao.getUserById(userId));
	}

	@Override
	public void updateUser(User referrerUser) {
		userDao.updateUser(userConverter.convertUserToUserDto(referrerUser));
	}

	@Override
	public List<User> getReferralsForUser(User loggedInUser) {
		return userConverter.convertUserDtosToUsers(userDao.getReferralsByUserId(loggedInUser.getId()));
	}
}
