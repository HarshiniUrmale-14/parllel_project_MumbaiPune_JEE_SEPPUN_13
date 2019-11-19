package com.capgemini.springmvc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_req")
public class RequestBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "msgid")
	private int requestId;
	@Column(name = "uid")
	private int userId;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "msgreq")
	private String message;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
