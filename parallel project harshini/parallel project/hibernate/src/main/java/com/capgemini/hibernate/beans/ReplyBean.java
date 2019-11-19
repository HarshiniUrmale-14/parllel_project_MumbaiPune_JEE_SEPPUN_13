package com.capgemini.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_reply")
public class ReplyBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "replyid")
	private int replyId;
	@Column(name = "uid")
	private int userId;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "msgreply")
	private String message;
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

	

}
