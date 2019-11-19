package com.capgemini.collection.bean;

import java.io.Serializable;

public class ReplyBean implements Serializable{
	private int replyId;
	private int userId;
	private String emailId;
	private String message;

	// getter and setter
	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	public ReplyBean(int replyId, int userId, String emailId, String message) {
		super();
		this.replyId = replyId;
		this.userId = userId;
		this.emailId = emailId;
		this.message = message;
	}

}