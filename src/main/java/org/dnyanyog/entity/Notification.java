package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Notification {

	@Id
	@GeneratedValue
	@Column
	private long client_code;
	
	
	@Column
	private String client_id;
	
	@Column
	private String mode;
	
	@Column
	private String subject ;
	
	@Column
	private String Body;
	
	@Column
	private String footer;
	
	
	@Column
	private String from_email;

	
	@Column
	private String to_email;
	

	public String getFrom_email() {
		return from_email;
	}
	public Notification setFrom_email(String from_email) {
		this.from_email = from_email;
		return this;
	}
	public String getTo_email() {
		return to_email;
	}
	public Notification setTo_email(String to_email) {
		this.to_email = to_email;
		return this;
	}
	
	public static Notification getInstance() {
		return new Notification();
	}
	public long getClient_code() {
		return client_code;
	}

	public Notification setClient_code(long client_code) {
		this.client_code = client_code;
		return this;
	}

	public String getClient_id() {
		return client_id;
	}

	public Notification setClient_id(String client_id) {
		this.client_id = client_id;
		return this;
	}

	public String getMode() {
		return mode;
	}

	public Notification setMode(String mode) {
		this.mode = mode;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public Notification setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getBody() {
		return Body;
	}

	public Notification setBody(String body) {
		Body = body;
		return this;
	}

	public String getFooter() {
		return footer;
	}

	public Notification setFooter(String footer) {
		this.footer = footer;
		return this;
	}

}
