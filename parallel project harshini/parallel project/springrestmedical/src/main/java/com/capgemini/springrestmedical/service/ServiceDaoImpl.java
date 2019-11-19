package com.capgemini.springrestmedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrestmedical.beans.AdminBean;
import com.capgemini.springrestmedical.beans.CartBean;
import com.capgemini.springrestmedical.beans.ProductBean;
import com.capgemini.springrestmedical.beans.ReplyBean;
import com.capgemini.springrestmedical.beans.RequestBean;
import com.capgemini.springrestmedical.beans.UserBean;
import com.capgemini.springrestmedical.dao.Dao;

@Service
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	private Dao dao;

	@Override
	public List<ProductBean> getProducts() {
		return dao.getProducts();
	}

	@Override
	public int adminLogin(String emailId, String password) {
		return dao.adminLogin(emailId, password);
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
	public List<UserBean> getUser() {
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
	public int userLogin(String emailId, String password) {
		return dao.userLogin(emailId, password);
	}

	@Override
	public boolean addUser(UserBean user) {
		return dao.addUser(user);
	}

	@Override
	public boolean updateUser(int uId, UserBean bean) {
		return dao.updateUser(uId, bean);
	}

	@Override
	public boolean addToCart(int uId,  String pName, int quantity) {
		return dao.addToCart(uId, pName, quantity);
	}

	@Override
	public boolean deleteFromCart(int cid, String pName) {
		return dao.deleteFromCart(cid, pName);

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

}