package com.capgemini.hibernate.dao;

import java.util.List;

import com.capgemini.hibernate.beans.CartBean;

public interface UserDao {
	public int userLogin(String emailId, String password);

	public boolean registration(String emailId, String password, String mobileNo);

	public List <CartBean>  seeCart(int userId);

	public void updateUser(int userId);

	public void addToCart(int userId);

	public void payment(int userId);

	public boolean deleteFromCart(String productName);

	public void sendRequest(int userId);

	public void seeReply(int userId);

}