package com.capgemini.hibernate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.beans.CartBean;
import com.capgemini.hibernate.beans.ProductBean;
import com.capgemini.hibernate.beans.ReplyBean;
import com.capgemini.hibernate.beans.RequestBean;
import com.capgemini.hibernate.beans.UserBean;
import com.capgemini.hibernate.factory.Factory;
import com.capgemini.hibernate.validation.CustomValidationDao;
import com.capgemini.hibernate.validation.ValidationDao;

public class UserDaoImpl implements UserDao {

	@Override
	public int userLogin(String emailId, String password) {
		int userId = 0;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = entityMangerFactory.createEntityManager();
		String jpql = "from UserBean where emailId=:emailId and password=:password";
		Query query = manager.createQuery(jpql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			userId = li.getUserId();
			System.out.println("welcome" + li.getEmailId());
		}
		return userId;

	}

	@Override
	public boolean registration(String emailId, String password, String mobileNo) {
		boolean value = false;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		UserBean bean = new UserBean();
		bean.setEmailId(emailId);
		bean.setPassword(password);
		bean.setMobileNo(mobileNo);
		transaction.begin();
		manager.persist(bean);
		transaction.commit();
		value = true;
		if (bean != null) {
			System.out.println("USER REGISTERED SUCCESSFULLY");
		}
		return value;
	}

	@Override
	public void updateUser(int userId) {
		Scanner scan = new Scanner(System.in);
		boolean value = true;
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		ValidationDao vali = Factory.getValImplInstance();
		while (value) {
			System.out.println("ENTER 1 TO CHANGE THE EMAIL");
			System.out.println("ENTER 2 TO CHANGE THE PASSWORD");
			System.out.println("ENTER 3 TO CHANGE THE PHONENO");
			String button = scan.nextLine();
			switch (button) {
			case "1":
				while (value) {
					EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
					EntityManager manager = entityMangerFactory.createEntityManager();
					EntityTransaction transaction = manager.getTransaction();
					System.out.println("ENTER EMAILID");
					String emailId = scan.nextLine();
					if (vali.validationEmail(emailId)) {
						if (!customVali.checkUserEmail(emailId)) {
							transaction.begin();
							UserBean bean = manager.find(UserBean.class, userId);
							bean.setEmailId(emailId);
							transaction.commit();
							manager.close();
							if (bean != null) {
								System.out.println("USER PROFILE UPDATED");
								value = false;
								break;
							}

						} else {
							System.err.println("EMAILID ALREADY EXIST");
						}
					} else {
						System.err.println("EMAIL ID IS NOT VALID");
					}
				}
				break;

			case "2":
				while (value) {
					EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
					EntityManager manager = entityMangerFactory.createEntityManager();
					EntityTransaction transaction = manager.getTransaction();
					System.out.println("ENTER PASSWORD");
					String password = scan.nextLine();
					if (vali.validationPassword(password)) {
						transaction.begin();
						UserBean bean = manager.find(UserBean.class, userId);
						bean.setPassword(password);
						transaction.commit();
						manager.close();
						if (bean != null) {
							System.out.println("USER PROFILE UPDATED");
							value = false;
							break;
						}
					} else {
						System.err.println("ENTER VALID PASSWORD");
						break;
					}
				}
				break;

			case "3":
				while (value) {
					EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
					EntityManager manager = entityMangerFactory.createEntityManager();
					EntityTransaction transaction = manager.getTransaction();
					System.out.println("ENTER THE PHONE NO");
					String mobileNo = scan.nextLine();
					if (vali.validationMobileNo(mobileNo)) {
						transaction.begin();
						UserBean bean = manager.find(UserBean.class, userId);
						bean.setMobileNo(mobileNo);
						transaction.commit();
						manager.close();
						if (bean != null) {
							System.out.println("USER PROFILE UPDATED");
							value = false;
							break;
						}
					} else {
						System.err.println("ENTER 10 DIGITS ONLY ");
					}
				}
				break;
			default: {
				System.out.println("ENTER NUMBER BETWEEN 1 TO 3");
			}
			}
		}
	}

	@Override
	public void addToCart(int userId) {
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		CartBean bean = null;
		String email = null;
		String category = null;
		double price = 0;
		int pQuantity = 0;
		int id = 0;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager manager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = " from UserBean  where userId=:userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			email = li.getEmailId();

		}
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("ENTER THE NAME OF PRODUCT TO BE ADDED TO THE CART");
			String productName = scan.nextLine();
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
			System.out.println("ENTER THE NO OF QUANTITY OF SELECTED PRODUCT");
			int quantity = Integer.parseInt(scan.nextLine());
			if (customVali.checkProductQuantity(productName, quantity)) {
				bean = new CartBean();
				bean.setUserId(userId);
				bean.setProductId(id);
				bean.setEmailId(email);
				bean.setProductCategory(category);
				bean.setProductName(productName);
				bean.setProductPrice(price);
				bean.setQuantity(quantity);
				try {
					transaction.begin();
					manager.persist(bean);
					transaction.commit();
					if (bean != null) {
						System.out.println("PRODUCT INSERTED");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				System.err.println("PRODUCT IS OUT OF STOCK");
			}
			break;
		}

	}

	@Override
	public void payment(int userId) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "select SUM(productPrice*quantity) from CartBean where userId=:userId";
		Query query1 = entityManager.createQuery(jpql);
		query1.setParameter("userId", userId);

		List<Double> list1 = query1.getResultList();
		try {
			for (Double li : list1) {
				double bill = li.doubleValue();
				System.out.println("TOTAL BILL IS" + bill);

			}
		} catch (Exception e) {
			System.err.println("THERE ARE NO PRODUCTS IN THE LIST");
		}
		transaction.commit();

	}

	@Override
	public boolean deleteFromCart(String productName) {
		boolean value = false;
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from CartBean where productName=:productName";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("productName", productName);
		query.executeUpdate();
		value = true;
		transaction.commit();
		return value;
	}

	@Override
	public void sendRequest(int userId) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String emailId = null;
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<UserBean> list = query.getResultList();
		for (UserBean li : list) {
			emailId = li.getEmailId();

		}
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER THE MESSAGE TO BE SENT");
		String message = scan.nextLine();
		RequestBean bean = new RequestBean();
		bean.setUserId(userId);
		bean.setEmailId(emailId);
		bean.setMessage(message);
		transaction.begin();
		entityManager.persist(bean);
		transaction.commit();
		if (bean != null) {
			System.out.println("MESSAGE SENT SUCCESSFULLY");
		}

	}

	@Override
	public void seeReply(int userId) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		String jpql = "from ReplyBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<ReplyBean> list = query.getResultList();
		for (ReplyBean li : list) {
			System.out.println("REPLY FROM ADMIN IS   :" + li.getMessage());

		}

	}

	@Override
	public List<CartBean> seeCart(int userId) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("medicine");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		String jpql = "from CartBean";
		Query query = entityManager.createQuery(jpql);
		List<CartBean> list = query.getResultList();
		return list;

	}

}
