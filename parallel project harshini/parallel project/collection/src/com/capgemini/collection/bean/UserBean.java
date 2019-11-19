package com.capgemini.collection.bean;

import java.io.Serializable;

public class UserBean  implements Serializable{
	private int userId;
	private String emailId;
	private String password;
	private String mobileNo;
	 public UserBean(){
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	// parameterized constructor
	public UserBean(int userId, String emailId, String password, String mobileNo) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
	}

}
