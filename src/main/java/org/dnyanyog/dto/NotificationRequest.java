package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

@Component
public class NotificationRequest {
private String client_id;


private String mode;
private String subject ;
private String Body;
private String footer;

public String getFrom_email() {
	return from_email;
}
public NotificationRequest setFrom_email(String from_email) {
	this.from_email = from_email;
	return this;
}
public String getTo_email() {
	return to_email;
}
public NotificationRequest setTo_email(String to_email) {
	this.to_email = to_email;
	return this;
}
@Pattern(regexp="[a-z0-9]{3,50}(@)[a-z]{3,50}(.)[a-z]{2,5}")
private String email;

private String from_email;

private String to_email;



public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public static NotificationRequest getInstance() {
	return  new NotificationRequest() ;
	
}
public String getClient_id() {
	return client_id;
}
public NotificationRequest setClient_id(String client_id) {
	this.client_id = client_id;
	return this;
}
public String getMode() {
	return mode;
}
public NotificationRequest setMode(String mode) {
	this.mode = mode;
	return this;
}
public String getSubject() {
	return subject;
}
public NotificationRequest setSubject(String subject) {
	this.subject = subject;
	return this;
}
public String getBody() {
	return Body;
}
public NotificationRequest setBody(String body) {
	Body = body;
	return this;
}
public String getFooter() {
	return footer;
}
public NotificationRequest setFooter(String footer) {
	this.footer = footer;
	return this;
}


}
