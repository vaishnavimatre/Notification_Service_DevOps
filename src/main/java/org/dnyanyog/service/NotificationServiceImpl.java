package org.dnyanyog.service;



import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

import org.dnyanyog.Enum.ResponseCodes;
import org.dnyanyog.dto.NotificationRequest;
import org.dnyanyog.dto.NotificationResponse;
import org.dnyanyog.entity.Notification;
import org.dnyanyog.repo.NotifactionServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import javax.mail.Session;

@Service
@Component
public class NotificationServiceImpl implements NotificationService {
	

@Autowired 
NotificationResponse response;

@Autowired 
NotifactionServiceRepository notificationRepo;

public NotificationResponse ActivateNotification(NotificationRequest request ) {

	
	
	
	if(request.getClient_id().isEmpty() && request.getBody().isEmpty() && request.getFooter().isEmpty() && request.getSubject().isEmpty() && request.getTo_email().isEmpty()) {
		return response
				.setMessage(ResponseCodes.Notification_Sent_Fail.getMessage())
				.setStatus(ResponseCodes.Notification_Sent_Fail.getStatus())
				.setCode(ResponseCodes.Notification_Sent_Fail.getCode());
		
				
	}
	
	

if(request.getMode().equals("email")) {
	if(!request.getEmail().matches("[a-z0-9]{3,50}(@)[a-z]{3,50}(.)[a-z]{2,5}")){

	  return response
	.setStatus(ResponseCodes.Notification_Sent_Failed.getStatus())
	.setCode(ResponseCodes.Notification_Sent_Failed.getCode())
	.setMessage(ResponseCodes.Notification_Sent_Failed.getMessage());

}
}

Notification notificationtable =	Notification .getInstance()
.setBody(request.getBody())
.setClient_id(request.getClient_id())
.setFooter(request.getFooter())
.setSubject(request.getSubject())
.setFrom_email(request.getFrom_email())
.setTo_email(request.getTo_email());
try {
	notificationtable=  notificationRepo.save(notificationtable);
	sendEmail(request.getTo_email(), request.getSubject(), request.getBody(), request.getFooter());

	return response
       .setStatus(ResponseCodes.Notification_Sent_SUCCESS.getStatus())
	.setCode(ResponseCodes.Notification_Sent_SUCCESS.getCode())
	.setMessage(ResponseCodes.Notification_Sent_SUCCESS.getMessage());
} catch (Exception e) {
	response.setStatus(ResponseCodes.Notification_Sent_Error_occur.getStatus());
	response.setCode(ResponseCodes.Notification_Sent_Error_occur.getCode());
	response.setMessage(ResponseCodes.Notification_Sent_Error_occur.getMessage());
	e.printStackTrace();
}
return response;
}


private void sendEmail(String recipientEmail, String subject, String body, String footer) throws IOException {

	Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.config"));

	Session session = Session.getInstance(properties, new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(properties.getProperty("email.sender.address"),
                    properties.getProperty("email.sender.password"));
		}
	});
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(properties.getProperty("email.sender.address")));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
		message.setSubject(subject);
		message.setText(body + "\n" + footer);
		Transport.send(message);

		System.out.println("Email sent successfully to: " + recipientEmail);
	} catch (MessagingException e) {
		System.out.println("Failed to send email to: " + recipientEmail);
		e.printStackTrace();
	}

	
	}

}
