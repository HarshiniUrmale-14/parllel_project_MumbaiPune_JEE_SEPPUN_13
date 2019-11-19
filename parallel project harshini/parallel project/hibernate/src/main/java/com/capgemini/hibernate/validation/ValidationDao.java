package com.capgemini.hibernate.validation;



public interface ValidationDao {
	public boolean validationEmail(String emailid);

	
	public boolean validationPassword(String password);
	public boolean validationMobileNo(String mobileNo);
	public boolean validationProductName(String productName);
	public boolean validationProductCategory(String productCategory);
}
