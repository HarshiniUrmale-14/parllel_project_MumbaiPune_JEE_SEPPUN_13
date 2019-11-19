package com.capgemini.jdbc.dao;

import java.util.List;

import com.capgemini.jdbc.bean.CartBean;

public interface UserDao {
	public int userLogin(String emailId, String password);

	public void userRegistration(String emailId, String password,String mobileNo);

	public void updateUser(int userId);

	public void addToCart(int userId);

	public void payment(int userId);
	

	public int deleteFromCart(String productName,int userId);
	public List<CartBean> seeCart(int userId);

	public void sendRequest(int userId);
	public void seeReply(int userId);


}
