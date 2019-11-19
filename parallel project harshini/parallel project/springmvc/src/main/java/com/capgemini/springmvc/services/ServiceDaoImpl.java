package com.capgemini.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.beans.AdminBean;
import com.capgemini.springmvc.beans.CartBean;
import com.capgemini.springmvc.beans.OrderBean;
import com.capgemini.springmvc.beans.ProductBean;
import com.capgemini.springmvc.beans.ReplyBean;
import com.capgemini.springmvc.beans.RequestBean;
import com.capgemini.springmvc.beans.UserBean;
import com.capgemini.springmvc.dao.Dao;

@Service
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	private Dao dao;

	@Override
	public List<ProductBean> getProducts() {
		return dao.getProducts();
	}

	@Override
	public AdminBean adminLogin(String emailId, String password) {
		return dao.adminLogin(emailId, password);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean updateProduct(ProductBean bean) {
		return dao.updateProduct(bean);
	}

	@Override
	public boolean deleteUser(int userId) {

		return dao.deleteUser(userId);
	}

	@Override
	public List<UserBean> getUser() {
		return dao.getUser();
	}

	@Override
	public boolean sendReply(int userId, String msgReply) {
		return dao.sendReply(userId, msgReply);
	}

	@Override
	public List<RequestBean> seeRequest() {
		return dao.seeRequest();

	}

	@Override
	public int userLogin(String emailId, String password) {
		return dao.userLogin(emailId, password);
	}

	@Override
	public boolean registration(UserBean user) {
		return dao.registration(user);
	}

	@Override
	public boolean updateUser(int userId, UserBean bean) {
		return dao.updateUser(userId, bean);
	}

	@Override
	public boolean addToCart(int userId, CartBean bean, String productName, int quantity) {
		return dao.addToCart(userId, bean, productName, quantity);
	}

	@Override
	public boolean deleteFromCart(int cartId, String pName) {
		return dao.deleteFromCart(cartId, pName);

	}

	@Override
	public double payment(int userId) {
		return dao.payment(userId);
	}

	@Override
	public boolean sendRequest(int userId, String msgReq) {
		return dao.sendRequest(userId, msgReq);
	}

	@Override
	public List<ReplyBean> seeReply(int userId) {
		return dao.seeReply(userId);
	}

	@Override
	public List<CartBean> getCart(int userId) {
		return dao.getCart(userId);
	}

	@Override
	public boolean placeOrder(int userId) {
		return dao.placeOrder(userId);

	}

	@Override
	public List<OrderBean> generateReport() {

		return dao.generateReport();
	}

}