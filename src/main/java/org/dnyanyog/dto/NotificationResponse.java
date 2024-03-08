package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class NotificationResponse {
	
	
	private String status ;
	private String code;
	private String message;
	private String timestamp;
	
	public static NotificationResponse getInstatnce() {
		return new NotificationResponse();
	}
	public String getStatus() {
		return status;
	}
	public NotificationResponse setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getCode() {
		return code;
	}
	public NotificationResponse setCode(String code) {
		this.code = code;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public NotificationResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public NotificationResponse setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

}
