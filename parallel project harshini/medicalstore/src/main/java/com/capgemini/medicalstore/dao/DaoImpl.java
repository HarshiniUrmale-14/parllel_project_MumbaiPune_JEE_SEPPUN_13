
package com.capgemini.medicalstore.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalstore.beans.AdminUserBean;
import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.beans.ReplyBean;
import com.capgemini.medicalstore.beans.RequestBean;

@Repository
public class DaoImpl implements Dao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<ProductBean> getProducts() {
		EntityManager manager = entityManagerFactory.createEntityManager();
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
	public AdminUserBean login(String emailId, String password) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where emailId=:emailId and password=:password ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		AdminUserBean bean = null;
		try {
			bean = (AdminUserBean) query.getSingleResult();
			id = bean.getId();
			return bean;
		} catch (Exception e) {
			System.out.println("ENTER CORRECT EMAIL ID AND PASSWORD");
			return null;
		}
	}

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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
	public boolean addProduct(ProductBean productbean) {
		boolean isAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductBean Bean = entityManager.find(ProductBean.class, bean.getProductId());
		boolean isupdated = false;
		if (Bean != null) {
			String category = bean.getProductCategory();
			if (category != null) {
				Bean.setProductCategory(category);
			}
			String name = bean.getProductName();
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
	public boolean deleteUser(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean isDeleted = false;
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			AdminUserBean bean = entityManager.find(AdminUserBean.class, userId);
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
	public List<AdminUserBean> getUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where role=:role";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("role", "user");
		List<AdminUserBean> userList = null;
		try {
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return userList;
	}

	@Override
	public boolean sendReply(int userId, String messageReply) {
		boolean isSent = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		String emailId = null;
		String jpql = "from AdminUserBean where id=:userId";
		tx.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<AdminUserBean> adminUserBean = query.getResultList();
		for (AdminUserBean bean : adminUserBean) {
			emailId = bean.getEmailId();
		}
		ReplyBean replyBean = new ReplyBean();
		replyBean.setUserId(userId);
		replyBean.setEmailId(emailId);
		replyBean.setMessage(messageReply);
		entityManager.persist(replyBean);
		isSent = true;
		tx.commit();
		entityManager.close();
		return isSent;
	}

	@Override
	public List<RequestBean> seeRequest() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RequestBean";
		Query query = entityManager.createQuery(jpql);
		List<RequestBean> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public boolean registration(AdminUserBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		AdminUserBean adminUserBean = new AdminUserBean();
		adminUserBean.setName(bean.getName());
		adminUserBean.setEmailId(bean.getEmailId());
		adminUserBean.setAddress(bean.getAddress());
		adminUserBean.setMobileNo(bean.getMobileNo());
		adminUserBean.setPassword(bean.getPassword());
		adminUserBean.setRole("user");
		try {
			transaction.begin();
			entityManager.persist(adminUserBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateUser(int userId, AdminUserBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		AdminUserBean Bean = entityManager.find(AdminUserBean.class, userId);
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isupdated = false;
		if (Bean != null) {
			String name = bean.getName();
			if (name != null) {
				Bean.setName(name);
			}
			String email = bean.getEmailId();
			if (email != null) {
				Bean.setEmailId(email);
			}
			String pass = bean.getPassword();
			if (pass != null) {
				Bean.setPassword(pass);
			}
			String mobileNo = bean.getMobileNo();
			if (mobileNo != null) {
				Bean.setMobileNo(mobileNo);
			}
			String address = bean.getAddress();
			if (address != null) {
				Bean.setAddress(address);
			}
		}
		try {
			transaction.begin();
			entityManager.persist(Bean);
			transaction.commit();
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
		CartBean bean = new CartBean();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = " from AdminUserBean  where id=:userId";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<AdminUserBean> list = query.getResultList();
		for (AdminUserBean li : list) {
			email = li.getEmailId();

		}
		Scanner scan = new Scanner(System.in);
		int previousQuantity = 0;
		String jpql1 = "from ProductBean where productName=:productName";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("productName", productName);
		List<ProductBean> list1 = query1.getResultList();
		for (ProductBean li : list1) {
			bean.setUserId(userId);
			bean.setProductId(li.getProductId());
			bean.setEmailId(email);
			bean.setProductCategory(li.getProductCategory());
			bean.setProductName(productName);
			bean.setProductPrice(li.getProductPrice());
			bean.setQuantity(quantity);
			entityManager.persist(bean);
			isAdded = true;
			transaction.commit();
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean deleteFromCart(int cartId) {
		Boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from CartBean where  cartId=:cartId ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cartId", cartId);
		query.executeUpdate();
		isDeleted = true;
		transaction.commit();
		entityManager.close();
		return isDeleted;
	}

	@Override
	public double payment(int userId) {
		double bill = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select SUM(productPrice*quantity) from CartBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<Double> list1 = query.getResultList();
		for (Double li : list1) {
			bill = li.doubleValue();
		}
		entityManager.close();
		if (bill > 0) {
			EntityManager entityManager1 = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager1.getTransaction();
			String jpql1 = "delete from CartBean where userId=:userId";
			Query query1 = entityManager1.createQuery(jpql1);
			query1.setParameter("userId", userId);
			transaction.begin();
			query1.executeUpdate();
			transaction.commit();
			entityManager1.close();
		}
		return bill;
	}

	@Override
	public boolean sendRequest(int userId, String msgReq) {
		boolean isSent = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String emailId = null;
		String jpql = "from AdminUserBean where id=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<AdminUserBean> list = query.getResultList();
		for (AdminUserBean li : list) {
			emailId = li.getEmailId();

		}
		RequestBean bean = new RequestBean();
		bean.setUserId(userId);
		bean.setEmailId(emailId);
		bean.setMessage(msgReq);
		transaction.begin();
		entityManager.persist(bean);
		isSent = true;
		transaction.commit();
		entityManager.close();
		return isSent;
	}

	@Override
	public List<ReplyBean> seeReply(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ReplyBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<ReplyBean> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public List<CartBean> getCart(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from CartBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<CartBean> list = query.getResultList();
		return list;

	}

	@Override
	public void order(OrderBean orderBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(orderBean);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("USER ID NOT FOUND");
		}

	}

	@Override
	public boolean placeOrder(int userId) {
		boolean isPlaced = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql1 = "from AdminUserBean where id=:userId";
		Query query = entityManager.createQuery(jpql1);
		query.setParameter("userId", userId);
		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
		String address = adminUserBean.getAddress();
		EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		String jpql = "from CartBean where userId=:userId";
		Query query1 = entityManager1.createQuery(jpql);
		query1.setParameter("userId", userId);
		List<CartBean> list1 = query1.getResultList();
		String pName = null;
		int quantity = 0;
		for (CartBean bean : list1) {
			int cId = bean.getCartId();
			int pId = bean.getProductId();
			String emailId = bean.getEmailId();
			String pCategory = bean.getProductCategory();
			pName = bean.getProductName();
			double price = bean.getProductPrice();
			quantity = bean.getQuantity();
			OrderBean orderBean = new OrderBean();
			orderBean.setCartId(cId);
			orderBean.setUserId(userId);
			orderBean.setEmailId(emailId);
			orderBean.setProductId(pId);
			orderBean.setProductCategory(pCategory);
			orderBean.setProductName(pName);
			orderBean.setProductPrice(price);
			orderBean.setQuantity(quantity);
			orderBean.setAddress(address);
			order(orderBean);
		}
		return isPlaced;
	}

	@Override
	public List<OrderBean> history() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from OrderBean";
		Query query = entityManager.createQuery(jpql);
		List<OrderBean> orderList = null;
		try {
			orderList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public AdminUserBean getUserprofile(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where id=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
		return adminUserBean;
	}

	@Override
	public boolean customEmailValidation(String emailId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isValid = false;
		String jpql = " from AdminUserBean";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		List<AdminUserBean> list = null;
		try {
			list = query.getResultList();
			for (AdminUserBean adminUserBean : list) {
				if (emailId.equals(adminUserBean.getEmailId())) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public List<OrderBean> userOrderHistory(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from OrderBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<OrderBean> orderList = null;
		try {
			orderList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public boolean customProductNameValidation(String productName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isValid = false;
		String jpql = " from ProductBean";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		List<ProductBean> list = null;
		try {
			list = query.getResultList();
			for (ProductBean productBean : list) {
				if (productName.equalsIgnoreCase(productBean.getProductName())) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public boolean customProductNameInCartValidation(int userId, String productName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isValid = false;
		String jpql = " from CartBean where userId=:userId";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<CartBean> list = null;
		try {
			list = query.getResultList();
			for (CartBean cartBean : list) {
				if (productName.equalsIgnoreCase(cartBean.getProductName())) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

}
