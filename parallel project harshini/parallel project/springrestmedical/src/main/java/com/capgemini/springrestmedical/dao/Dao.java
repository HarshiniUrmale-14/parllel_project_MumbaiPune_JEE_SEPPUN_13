package com.capgemini.springrestmedical.dao;

import java.util.List;

import com.capgemini.springrestmedical.beans.AdminBean;
import com.capgemini.springrestmedical.beans.CartBean;
import com.capgemini.springrestmedical.beans.ProductBean;
import com.capgemini.springrestmedical.beans.ReplyBean;
import com.capgemini.springrestmedical.beans.RequestBean;
import com.capgemini.springrestmedical.beans.UserBean;



public interface Dao {
	public List<ProductBean> getProducts();

	public int adminLogin(String emailId, String password);

	public boolean deleteProduct(int pid);

	public boolean addProduct(ProductBean bean);

	public boolean updateProduct(ProductBean bean);

	public boolean deleteUser(int uId);

	public List<UserBean> getUser();

	public boolean sendReply(int uId,String msgReply);

	public List<RequestBean> seeRequest();

	public int userLogin(String emailId, String password);

	public boolean addUser(UserBean user);

	public boolean updateUser(int uId, UserBean bean);

	public boolean addToCart(int uId,  String pName, int quantity);

	public boolean deleteFromCart(int cid,String pName);

	public List<CartBean> getCart(int uId);

	public double payment(int uId);

	public boolean sendRequest(int uId,String msgReq);

	public List<ReplyBean> seeReply(int uId);

}
