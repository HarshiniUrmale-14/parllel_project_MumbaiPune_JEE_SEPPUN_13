package com.capgemini.hibernate.validation;

public interface CustomValidationDao {
	public boolean checkUserEmail(String emailId);
	public boolean checkAdminEmail(String emailId);
	public boolean checkProductName(String productName);
	public boolean checkProductId(int ProductId);
	public boolean checkUserId(int userId);
	public boolean checkProductQuantity(String productName,int productQuantity);
	public boolean checkProductFromCart(String productName,int UserId);
}
