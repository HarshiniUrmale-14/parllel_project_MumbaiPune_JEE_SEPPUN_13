package com.capgemini.jdbc.dao;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface AdminDao {
	public int adminLogin(String emailId, String password);

	public int insertProduct(String pCategory, String pName, Double pPrice, int pQuantity);

	public int deleteProduct(int pId);

	public void updateProduct(int pId);

	public List<UserBean> getUsers();

	public int deleteUser(int uId);

	public void sendReply();

	public void seeRequest();
}
