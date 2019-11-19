package com.capgemini.hibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.beans.AdminBean;
import com.capgemini.hibernate.beans.ProductBean;
import com.capgemini.hibernate.beans.ReplyBean;
import com.capgemini.hibernate.beans.RequestBean;
import com.capgemini.hibernate.beans.UserBean;
import com.capgemini.hibernate.factory.Factory;
import com.capgemini.hibernate.validation.CustomValidationDao;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int adminLogin(String emailId, String password) {
		int id = 0;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();
		String jpql = "from AdminBean where emailId=:emailId and password=:password";
		Query query = manager.createQuery(jpql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		AdminBean bean = null;

		List<AdminBean> list = query.getResultList();
		for (AdminBean li : list) {
			id = li.getAdminId();
			System.out.println("welcome" + li.getAdminId());

		}
		if (list.isEmpty()) {

			return 0;
		} else {
			return id;
		}
	}

	@Override
	public boolean insertProduct(String productCategory, String productName, Double productPrice, int productQuantity) {
		boolean value = false;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		ProductBean product = new ProductBean();
		product.setProductCategory(productCategory);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductQuantity(productQuantity);
		transaction.begin();
		manager.persist(product);
		transaction.commit();
		value = true;
		if (product != null) {
			System.out.println("PRODUCT INSERTED");
		}
		return value;
	}

	@Override
	public boolean deleteProduct(int productId) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");

		EntityManager entityManager =entityMangerFactory.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			ProductBean bean = entityManager.find(ProductBean.class, productId);
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
	public boolean updateProduct(int productId) {
		EntityManagerFactory  entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		boolean value = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER THE CATEGORY OF PRODUCT");
		String category = sc.nextLine();

		System.out.println("ENTER THE PRODUCT NAME");
		String name = sc.nextLine();
		try {
			System.out.println("ENTER THE PRICE OF THE PRODUCT");
			double price = Double.parseDouble(sc.nextLine());
			System.out.println("ENTER THE QUANTITY OF THE PRODUCT PRESENT");
			int quant = Integer.parseInt(sc.nextLine());

			tran.begin();
			ProductBean bean = manager.find(ProductBean.class, productId);
			bean.setProductCategory(category);
			bean.setProductName(name);
			bean.setProductPrice(price);
			bean.setProductQuantity(quant);
			tran.commit();
			value=true;
			manager.close();
		} catch (NumberFormatException e) {
			System.err.println("ENTER ONLY NUMBER");
		}
		return value;

	}

	@Override
	public boolean getUser() {
		boolean value=false;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
			for (UserBean user : userList) {
				System.out.println("USER ID IS :" + user.getUserId());
				System.out.println("USER EMAILID IS :" + user.getEmailId());
				System.out.println("USER MOBILE NO IS :" + user.getMobileNo());
				System.out.println("-------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		value=true;
		return value;

	}

	@Override
	public boolean deleteUser(int userId) {

		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager =entityMangerFactory.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			UserBean bean = entityManager.find(UserBean.class, userId);
			entityManager.remove(bean);
			tx.commit();
			isDeleted = true;
			if (isDeleted = true) {
				System.out.println("USER DELETED");
			}
			isDeleted=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		entityManager.close();
		return isDeleted;

	}

	@Override
	public void sendReply() {
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		EntityManagerFactory  entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("ENTER THE USER ID");
			int userId = Integer.parseInt(scan.nextLine());
			if (customVali.checkUserId(userId)) {
				String emailId = null;
				String message = null;
				String jpql = " from UserBean  where userId=:userId";
				Query query = manager.createQuery(jpql);
				query.setParameter("userId", userId);
				List<UserBean> list = query.getResultList();
				for (UserBean li : list) {
					emailId = li.getEmailId();

				}

				System.out.println("ENTER THE MESSAGE TO BE SENT");
				message = scan.nextLine();
				ReplyBean bean = new ReplyBean();
				bean.setUserId(userId);
				bean.setEmailId(emailId);
				bean.setMessage(message);
				tx.begin();
				manager.persist(bean);
				tx.commit();
				if (bean != null) {
					System.out.println("MESSAGE SENT SUCCESSFULLY");
				}
			} else {
				System.err.println("USER ID DOES NOT EXIST");
			}
		} catch (NumberFormatException e) {
			System.err.println("ENTER ONLY NUMBER");

		}

	}

	@Override
	public void seeRequest() {

		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager =entityMangerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		String jpql = "from RequestBean";

		Query query = manager.createQuery(jpql);

		List<RequestBean> list = query.getResultList();
		for (RequestBean li : list) {

			System.out.println("USER ID  :" + li.getUserId());
			System.out.println("USER EMAILID  :" + li.getEmailId());
			System.out.println("MESSAGE FROM USER   :" + li.getMessage());
			System.out.println("--------------------------------------------------------------------");
		}
		tx.commit();
	}
}
