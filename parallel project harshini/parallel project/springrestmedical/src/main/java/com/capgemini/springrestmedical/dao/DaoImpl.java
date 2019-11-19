
package com.capgemini.springrestmedical.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springrestmedical.beans.AdminBean;
import com.capgemini.springrestmedical.beans.CartBean;
import com.capgemini.springrestmedical.beans.ProductBean;
import com.capgemini.springrestmedical.beans.ReplyBean;
import com.capgemini.springrestmedical.beans.RequestBean;
import com.capgemini.springrestmedical.beans.UserBean;

@Repository
public class DaoImpl implements Dao {
	@PersistenceUnit
	EntityManagerFactory emf;

	@Override
	public List<ProductBean> getProducts() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> productList = null;
		try {
			productList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;

	}

	@Override
	public int adminLogin(String emailId, String password) {
		int id = 0;
		EntityManager entityManager = emf.createEntityManager();
		String jpql = "from AdminBean where emailId=:emailId and password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		AdminBean bean = null;
		try {
			bean = (AdminBean) query.getSingleResult();
			id = bean.getAdminId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean deleteProduct(int pId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			ProductBean bean = entityManager.find(ProductBean.class, pId);
			entityManager.remove(bean);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductBean productbean) {
		boolean isAdded = false;
		EntityManager entityManager = emf.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(productbean);
		isAdded = true;
		tx.commit();

		entityManager.close();

		return isAdded;

	}

	@Override
	public boolean updateProduct(ProductBean bean) {
		EntityManager entityManager = emf.createEntityManager();
		ProductBean Bean = entityManager.find(ProductBean.class, bean.getProductId());
		boolean isupdated = false;
		if (Bean != null) {
			String category = bean.getProductCategory();
			if (category != null) {
				Bean.setProductCategory(category);
			}
			String name = bean.getProductCategory();
			if (name != null) {
				Bean.setProductName(name);
			}
			double price = bean.getProductPrice();
			if (price != 0) {
				Bean.setProductPrice(bean.getProductPrice());
			}
			int quantity = bean.getProductQuantity();
			if (quantity != 0) {
				Bean.setProductQuantity(bean.getProductQuantity());
			}
		}

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(Bean);
			tx.commit();
			isupdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return isupdated;

	}

	@Override
	public boolean deleteUser(int uId) {

		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			UserBean bean = entityManager.find(UserBean.class, uId);
			entityManager.remove(bean);
			tx.commit();
			isDeleted = true;
			if (isDeleted = true) {
				System.out.println("USER DELETED");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;

	}

	@Override
	public List<UserBean> getUser() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;

	}

	@Override
	public boolean sendReply(int userId, String msgReply) {
		boolean isSent = false;

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		String emailId = null;

		String jpql = "from UserBean where userId=:userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			emailId = li.getEmailId();

		}

		ReplyBean bean = new ReplyBean();
		bean.setUserId(userId);
		bean.setEmailId(emailId);
		bean.setMessage(msgReply);
		tx.begin();
		manager.persist(bean);
		isSent = true;
		tx.commit();

		return isSent;

	}

	@Override
	public List<RequestBean> seeRequest() {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		String jpql = "from RequestBean";

		Query query = manager.createQuery(jpql);

		List<RequestBean> list = query.getResultList();

		tx.commit();
		return list;
	}

	@Override
	public int userLogin(String emailId, String password) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean where emailId=:emailId and password=:password";
		Query query = manager.createQuery(jpql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		int id = 0;
		UserBean bean = null;
		try {
			bean = (UserBean) query.getSingleResult();
			id = bean.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean addUser(UserBean user) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;

		try {
			tx.begin();
			manager.persist(user);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}

	@Override
	public boolean updateUser(int uId, UserBean bean) {
		EntityManager entityManager = emf.createEntityManager();

		UserBean Bean = entityManager.find(UserBean.class, uId);

		EntityTransaction tx = entityManager.getTransaction();
		boolean isupdated = false;
		if (Bean != null) {
			String email = bean.getEmailId();
			if (email != null) {
				Bean.setEmailId(email);
			}
			String pass = bean.getPassword();
			if (pass != null) {
				Bean.setPassword(pass);
			}
			long mobileNo = bean.getMobileNo();
			if (mobileNo != 0) {
				Bean.setMobileNo(mobileNo);
			}

		}
		try {
			tx.begin();
			entityManager.persist(Bean);
			tx.commit();
			isupdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return isupdated;

	}

	@Override
	public boolean addToCart(int userId, String productName, int quantity) {
		boolean isAdded = false;
		String email = null;
		String category = null;
		double price = 0;
		int id = 0;
		CartBean bean = new CartBean();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		String jpql = " from UserBean  where userId=:userId";
		tx.begin();
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			email = li.getEmailId();

		}
		Scanner scan = new Scanner(System.in);

		String jpql1 = "from ProductBean where productName=:productName";
		Query query1 = manager.createQuery(jpql1);

		query1.setParameter("productName", productName);
		List<ProductBean> list1 = query1.getResultList();
		for (ProductBean li : list1) {
			category = li.getProductCategory();
			id = li.getProductId();
			productName = li.getProductName();
			price = li.getProductPrice();

		}

		bean.setUserId(userId);
		bean.setProductId(id);
		bean.setEmailId(email);
		bean.setProductCategory(category);
		bean.setProductName(productName);
		bean.setProductPrice(price);
		bean.setQuantity(quantity);

		manager.persist(bean);
		isAdded = true;
		tx.commit();
		if (bean != null) {
			System.out.println("PRODUCT INSERTED");
		}
		return isAdded;
	}

	@Override
	public boolean deleteFromCart(int cartId, String productName) {
		Boolean isDeleted = false;

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		String jpql = "delete from CartBean where cartId=:cartId and productName=:productName";
		Query query = manager.createQuery(jpql);
		query.setParameter("cartId", cartId);
		query.setParameter("productName", productName);
		query.executeUpdate();
		isDeleted = true;
		tx.commit();

		return isDeleted;
	}

	@Override
	public double payment(int userId) {
		double bill = 0;

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		String jpql = "select SUM(pPrice*quantity) from CartBean where userId=:userId";
		tx.begin();
		Query query1 = manager.createQuery(jpql);
		query1.setParameter("userId", userId);

		List<Double> list1 = query1.getResultList();

		for (Double li : list1) {
			bill = li.doubleValue();

		}
		tx.commit();
		return bill;
	}

	@Override
	public boolean sendRequest(int userId, String msgReq) {
		boolean isSent = false;

		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();

		String emailId = null;
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			emailId = li.getEmailId();

		}

		RequestBean bean = new RequestBean();
		bean.setUserId(userId);
		bean.setEmailId(emailId);
		bean.setMessage(msgReq);
		tx.begin();
		entityManager.persist(bean);
		isSent = true;
		tx.commit();
		if (bean != null) {
			System.out.println("MESSAGE SENT SUCCESSFULLY");
		}
		return isSent;
	}

	@Override
	public List<ReplyBean> seeReply(int userId) {

		EntityManager entityManager = emf.createEntityManager();
		String jpql = "from ReplyBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		String msg = null;
		List<ReplyBean> list = query.getResultList();

		return list;
	}

	@Override
	public List<CartBean> getCart(int userId) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from CartBean where userId=:userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);

		List<CartBean> list = query.getResultList();

		return list;

	}
}
