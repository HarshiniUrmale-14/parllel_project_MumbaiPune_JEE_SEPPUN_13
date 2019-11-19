package com.capgemini.hibernate.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.beans.AdminBean;
import com.capgemini.hibernate.beans.CartBean;
import com.capgemini.hibernate.beans.ProductBean;
import com.capgemini.hibernate.beans.UserBean;

public class CustomValidationDaoImpl implements CustomValidationDao {

	@Override
	public boolean checkUserEmail(String emailId) {
		boolean check = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
			for (UserBean user : userList) {
				if (emailId.equals(user.getEmailId())) {

					check = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		emf.close();
		return check;

	}

	@Override
	public boolean checkAdminEmail(String emailId) {

		boolean check = false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();
		String jpql = "from AdminBean";
		Query query = manager.createQuery(jpql);

		List<AdminBean> adminList = null;
		try {
			adminList = query.getResultList();
			for (AdminBean bean : adminList) {
				if (emailId.equals(bean.getEmailId())) {

					check = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		emf.close();
		return check;

	}

	@Override
	public boolean checkProductName(String productName) {
		boolean check = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> userList = null;
		try {
			userList = query.getResultList();
			for (ProductBean bean : userList) {
				if (productName.equals(bean.getProductName())) {

					check = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		emf.close();

		return check;
	}

	@Override
	public boolean checkProductId(int productId) {
		boolean check = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> userList = null;
		try {
			userList = query.getResultList();
			for (ProductBean bean : userList) {
				if (productId == bean.getProductId()) {

					check = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		emf.close();
		return check;

	}

	@Override
	public boolean checkUserId(int userId) {
		boolean check = false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
			for (UserBean bean : userList) {
				if (userId == bean.getUserId()) {

					check = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		emf.close();
		return check;

	}

	@Override
	public boolean checkProductQuantity(String productName, int productQuantity) {
		boolean check = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();

		String jpql = " from ProductBean  where productName=:productName";
		Query query = manager.createQuery(jpql);
		query.setParameter("productName", productName);
		List<ProductBean> list = query.getResultList();
		for (ProductBean li : list) {
			if (productQuantity <= li.getProductQuantity()) {
				check = true;
			}

		}
		emf.close();
		return check;
	}

	@Override
	public boolean checkProductFromCart(String productName, int userId) {
		boolean check = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = emf.createEntityManager();

		String jpql = " from CartBean  where userId=:userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<CartBean> list = query.getResultList();
		for (CartBean li : list) {
			if (productName.equals(li.getProductName())) {
				check = true;
			}

		}
		emf.close();
		return check;
	}

}
