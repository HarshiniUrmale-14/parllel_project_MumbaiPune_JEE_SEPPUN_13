package com.capgemini.hibernate.dao;

public interface AdminDao {
	public int adminLogin(String emailId, String password);

	public boolean insertProduct(String productCategory, String productName, Double productPrice, int productQuantity);

	public boolean  deleteProduct(int productId);

	public boolean updateProduct(int productId);

	public boolean getUser();

	public boolean deleteUser(int userId);

	public void sendReply();

	public void seeRequest();

}
