package com.capgemini.medicalstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderBean;
import com.capgemini.medicalstore.beans.AdminUserBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.beans.ReplyBean;
import com.capgemini.medicalstore.beans.RequestBean;
import com.capgemini.medicalstore.dao.Dao;

@Service
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	private Dao dao;

	@Override
	public List<ProductBean> getProducts() {
		return dao.getProducts();
	}

	@Override
	public AdminUserBean login(String emailId, String password) {
		return dao.login(emailId, password);
	}

	@Override
	public boolean deleteProduct(int pid) {
		return dao.deleteProduct(pid);
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
	public boolean deleteUser(int uId) {

		return dao.deleteUser(uId);
	}

	@Override
	public List<AdminUserBean> getUser() {
		return dao.getUser();
	}

	@Override
	public boolean sendReply(int uId, String msgReply) {
		return dao.sendReply(uId, msgReply);
	}

	@Override
	public List<RequestBean> seeRequest() {
		return dao.seeRequest();

	}

	@Override
	public boolean registration(AdminUserBean bean) {
		return dao.registration(bean);
	}

	@Override
	public boolean updateUser(int uId, AdminUserBean bean) {
		return dao.updateUser(uId, bean);
	}

	@Override
	public boolean addToCart(int uId, String pName, int quantity) {
		return dao.addToCart(uId, pName, quantity);
	}

	@Override
	public boolean deleteFromCart(int cid) {
		return dao.deleteFromCart(cid);

	}

	@Override
	public double payment(int uId) {
		return dao.payment(uId);
	}

	@Override
	public boolean sendRequest(int uId, String msgReq) {
		return dao.sendRequest(uId, msgReq);
	}

	@Override
	public List<ReplyBean> seeReply(int uId) {
		return dao.seeReply(uId);
	}

	@Override
	public List<CartBean> getCart(int uId) {
		return dao.getCart(uId);
	}

	@Override
	public boolean placeOrder(int userId) {
		return dao.placeOrder(userId);
	}

	@Override
	public List<OrderBean> history() {
		return dao.history();
	}

	@Override
	public AdminUserBean getUserprofile(int userId) {
	return dao.getUserprofile(userId);
	}

	@Override
	public boolean customEmailValidation(String emailId) {
		return dao.customEmailValidation(emailId);
	}

	@Override
	public List<OrderBean> userOrderHistory(int userId) {
		return dao.userOrderHistory(userId);
		}

	@Override
	public boolean customProductNameValidation(String productName) {
		return dao.customProductNameValidation(productName);
		}

	@Override
	public boolean customProductNameInCartValidation(int userId,String productName) {
		return dao.customProductNameInCartValidation(userId,productName);
		}

}