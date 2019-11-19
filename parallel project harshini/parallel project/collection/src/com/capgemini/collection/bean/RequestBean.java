package com.capgemini.collection.bean;

import java.io.Serializable;

public class RequestBean implements Serializable {
	private int requestId;
	private int userId;
	private String emailId;
	private String message;

	// getter and setter
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

	// parameterized constructor
	public RequestBean(int requestId, int userId, String emailId, String message) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.emailId = emailId;
		this.message = message;
	}

}
