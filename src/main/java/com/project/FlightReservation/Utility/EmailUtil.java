package com.project.FlightReservation.Utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Value("${Itinerary_email_body}")
	private String EMAIL_BODY;

	@Value("${Itinerary_email_subject}")
	private String EMAIL_SUBJECT;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	JavaMailSender mail;
	
	public void mailItinerary(String toAddress,String filePath)
	{
		LOGGER.info("Inside mailItinerary() Method");
		MimeMessage message = mail.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Itinerary", new File(filePath));
			mail.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception Inside mailItinerary() "+e);
		}
		
	}

}
