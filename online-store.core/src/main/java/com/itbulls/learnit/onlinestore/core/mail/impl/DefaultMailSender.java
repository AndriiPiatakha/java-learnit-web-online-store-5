package com.itbulls.learnit.onlinestore.core.mail.impl;

import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.mail.MailSender;

@Service
public class DefaultMailSender implements MailSender {

	@Override
	public void sendEmail(String sendTo, String messageToSend) {
		// sending email here
	}

}
