package com.capgemini.medicalstore.services;

import java.util.List;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderBean;
import com.capgemini.medicalstore.beans.AdminUserBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.beans.ReplyBean;
import com.capgemini.medicalstore.beans.RequestBean;

public interface ServiceDao {
	public List<ProductBean> getProducts();

	public AdminUserBean login(String emailId, String password);

	public boolean deleteProduct(int productId);

	public boolean addProduct(ProductBean bean);

	public boolean updateProduct(ProductBean bean);

	public boolean deleteUser(int userId);

	public List<AdminUserBean> getUser();

	public boolean sendReply(int userId, String msgReply);

	public List<RequestBean> seeRequest();

	public boolean registration(AdminUserBean user);

	public boolean updateUser(int userId, AdminUserBean bean);

	public boolean addToCart(int userId, String productName, int quantity);

	public boolean deleteFromCart(int cartId);

	public List<CartBean> getCart(int userId);

	public boolean placeOrder(int userId);

	public double payment(int userId);

	public List<OrderBean> history();

	public AdminUserBean getUserprofile(int userId);

	public boolean sendRequest(int userId, String msgReq);

	public List<ReplyBean> seeReply(int userId);

	public boolean customEmailValidation(String emailId);

	public List<OrderBean> userOrderHistory(int userId);

	public boolean customProductNameValidation(String productName);

	public boolean customProductNameInCartValidation(int userId, String productName);
}
