package com.capgemini.medicalstore.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private AdminUserBean loginBean;
	private List<AdminUserBean> loginList;
	private ProductBean productBean;
	private List<ProductBean> productList;
	private CartBean cartBean;
	private List<CartBean> cartList;
	private RequestBean requestBean;
	private List<RequestBean> requestList;
	private ReplyBean replyBean;
	private List<ReplyBean> replyList;
	private OrderBean orderBean;
	private List<OrderBean> orderList;
	private String role;
	private double bill;

	public int getStatusCode() {
		return statusCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdminUserBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(AdminUserBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<AdminUserBean> getLoginList() {
		return loginList;
	}

	public void setLoginList(List<AdminUserBean> loginList) {
		this.loginList = loginList;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public List<ProductBean> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}

	public CartBean getCartBean() {
		return cartBean;
	}

	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}

	public List<CartBean> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartBean> cartList) {
		this.cartList = cartList;
	}

	public RequestBean getRequestBean() {
		return requestBean;
	}

	public void setRequestBean(RequestBean requestBean) {
		this.requestBean = requestBean;
	}

	public List<RequestBean> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<RequestBean> requestList) {
		this.requestList = requestList;
	}

	public ReplyBean getReplyBean() {
		return replyBean;
	}

	public void setReplyBean(ReplyBean replyBean) {
		this.replyBean = replyBean;
	}

	public List<ReplyBean> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyBean> replyList) {
		this.replyList = replyList;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	public List<OrderBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}
}
