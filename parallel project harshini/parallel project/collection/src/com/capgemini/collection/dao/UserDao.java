package com.capgemini.collection.dao;

public interface UserDao {

	public void updateProfile(int uId);

	public void seeUser(int uId);

	public void registration(int uId, String emailId, String password, String mobileNo);

	public void sendMsg(int uId);

	public void seeReply(int uId);
}// end of interface
