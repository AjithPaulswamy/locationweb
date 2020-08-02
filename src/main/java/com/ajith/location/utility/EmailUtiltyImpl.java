package com.ajith.location.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtiltyImpl implements EmailUtility {

	@Autowired
	private JavaMailSender javaEmailsender;
	
	@Override
	public void sendEmail(String toAddress, String Subject, String Body) {
		MimeMessage mimeMessage = javaEmailsender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);
	    try {
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(Subject);
			mimeMessageHelper.setText(Body);
			javaEmailsender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
