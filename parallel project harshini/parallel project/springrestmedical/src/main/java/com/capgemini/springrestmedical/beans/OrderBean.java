package com.capgemini.springrestmedical.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "orderdisplay")
public class OrderBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int orderId;
	@Column(name = "cid")
	private int cartId;
	@Column(name = "uid")
	private int userId;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "pid")
	private int productId;

	@Column(name = "pcategory")
	private String productCategory;
	@Column(name = "pname")
	private String productName;
	@Column(name = "pprice")
	private double productPrice;
	@Column(name = "quantity")
	private int quantity;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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

	
}
