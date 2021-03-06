package com.capgemini.springmvc.services;

import java.util.List;

import com.capgemini.springmvc.beans.AdminBean;
import com.capgemini.springmvc.beans.CartBean;
import com.capgemini.springmvc.beans.OrderBean;
import com.capgemini.springmvc.beans.ProductBean;
import com.capgemini.springmvc.beans.ReplyBean;
import com.capgemini.springmvc.beans.RequestBean;
import com.capgemini.springmvc.beans.UserBean;

public interface ServiceDao {
	public List<ProductBean> getProducts();

	public AdminBean adminLogin(String emailId, String password);

	public boolean deleteProduct(int prooductId);

	public boolean addProduct(ProductBean bean);

	public boolean updateProduct(ProductBean bean);

	public boolean deleteUser(int userId);

	public List<UserBean> getUser();

	public boolean sendReply(int userId, String msgReply);

	public boolean placeOrder(int userId);

	public List<OrderBean> generateReport();

	public List<RequestBean> seeRequest();

	public int userLogin(String emailId, String password);

	public boolean registration(UserBean user);

	public boolean updateUser(int userId, UserBean bean);

	public boolean addToCart(int userId, CartBean bean, String productName, int quantity);

	public boolean deleteFromCart(int cartId, String productName);

	public List<CartBean> getCart(int userId);

	public double payment(int userId);

	public boolean sendRequest(int userId, String msgReq);

	public List<ReplyBean> seeReply(int userId);
}
