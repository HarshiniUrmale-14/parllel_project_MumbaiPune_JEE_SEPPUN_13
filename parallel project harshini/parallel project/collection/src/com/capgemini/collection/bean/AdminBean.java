package com.capgemini.collection.bean;

import java.io.Serializable;

public class AdminBean implements Serializable {

	private int adminId;
	private String emailId;
	private String password;
 
	//getter and setter
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//parameterized constructor
	public AdminBean(int adminId, String emailId, String password) {
		super();
		this.adminId = adminId;
		this.emailId = emailId;
		this.password = password;
	}

}
