package com.capgemini.collection.bean;

import java.io.Serializable;

public class CartBean implements Serializable {
	private int cartId;
	private int userId;
	private int productId;
	private String emailId;
	private String productCategory;
	private String productName;
	private double productPrice;
	private int quantity;
	
	//getter and setter
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//parameterized constructor
	public CartBean(int cartId, int userId, int productId, String emailId, String productCategory, String productName,
			double productPrice, int quantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.emailId = emailId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	

	


}