package com.itbulls.learnit.onlinestore.core.services.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.services.AffiliateMarketingService;
import com.itbulls.learnit.onlinestore.persistence.dao.UserDao;

@Service
public class DefaultAffiliateMarketingService implements AffiliateMarketingService {

	private static final int MAX_CHARS_IN_PARTNER_CODE = 6;
	
	@Autowired
	private UserDao userDao;

	@Override
	public String generateUniquePartnerCode() {
		StringBuilder sb = new StringBuilder();
		char[] charactersForPartnerCode = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 
		                                   'H', 'I', 'J', 'K', 'L', 'M', 'N',
		                                   'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		                                   'V', 'W', 'X', 'Y', 'Z', '0', '1',
		                                   '2', '3', '4', '5', '6', '7', '8',
		                                   '9'};
		Random r = new Random();
		for (int i = 0; i < MAX_CHARS_IN_PARTNER_CODE; i++) {
			sb.append(charactersForPartnerCode[r.nextInt(charactersForPartnerCode.length)]);
		}
		
		
		if (userDao.getUserByPartnerCode(sb.toString()) != null) {
			return this.generateUniquePartnerCode();
		} else {
			return sb.toString();
		}
	}

}
