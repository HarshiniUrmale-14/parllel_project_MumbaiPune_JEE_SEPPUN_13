package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.capgemini.collection.bean.CartBean;
import com.capgemini.collection.bean.OrderBean;
import com.capgemini.collection.bean.ProductBean;
import com.capgemini.collection.bean.UserBean;

public class DaoImpl implements Dao {

	static List<ProductBean> list1 = null;
	static List<CartBean> cart = null;
	static List<OrderBean> order = null;

	static {
		list1 = new ArrayList<ProductBean>();
		ProductBean bean = new ProductBean(1, "babycare", "nevia", 61.2, 90);
		ProductBean bean1 = new ProductBean(2, "healthcare", "vasline", 89.8, 8);
		ProductBean bean2 = new ProductBean(3, "aurvedic", "sewendesish", 57, 9);
		ProductBean bean3 = new ProductBean(4, "skincare", "hgghhg", 56, 89);
		ProductBean bean4 = new ProductBean(5, "eyecare", "ytfty", 56, 89);

		list1.add(bean);
		list1.add(bean1);
		list1.add(bean2);
		list1.add(bean3);
		list1.add(bean4);
		cart = new ArrayList<CartBean>();
		CartBean cart0 = new CartBean(1, 1, 1, "manish@gmail.com", "babycare", "nevia", 61.2, 2);
		CartBean cart1 = new CartBean(2, 2, 2, "kanchan@gmail.com", "healthcare", "vasline", 89.8, 1);
		cart.add(cart0);
		cart.add(cart1);
		order = new ArrayList<OrderBean>();
		OrderBean order0 = new OrderBean(1, 1, 1, "manish@gmail.com", "nevia", 61.2, 3);
		OrderBean order1 = new OrderBean(2, 2, 2, "kanchan@gmail.com", "vasline", 89.8, 1);
		order.add(order0);
		order.add(order1);
	}

	@Override
	public void viewproducts() {

		for (ProductBean products : list1) {
			System.out.println("PRODUCT ID IS :" + products.getProductId());
			System.out.println("PRODUCT CATEGORY IS :" + products.getProductCategory());
			System.out.println("PRODUCT NAME IS :" + products.getProductName());
			System.out.println("PRODUCT PRICE IS :" + products.getProductPrice());
			System.out.println("NO OF PRODUCT QUANTITY PRESENT IS :" + products.getProductQuantity());
			System.out.println("-----------------------------------------------------------------");

		}

	}// end of viewProducts() method

	@Override
	public void seeCart(int uId) {
		List<CartBean> cartList = new ArrayList<CartBean>();
		CartBean bean = null;
		for (CartBean cartBean : cart) {
			if (uId == cartBean.getUserId()) {
				cartList.add(cartBean);

			}
		}

		if (cartList != null) {
			for (CartBean CartBean : cartList) {

				System.out.println("CART ID IS  :" + CartBean.getCartId());
				System.out.println("USER ID IS  :" + CartBean.getUserId());
				System.out.println("USER EMAIL ID IS  :" + CartBean.getEmailId());
				System.out.println("PRODUCT ID IS :" + CartBean.getProductId());

				System.out.println("PRODUCT CATEGORY IS :" + CartBean.getProductCategory());
				System.out.println("PRODUCT NAME IS :" + CartBean.getProductName());
				System.out.println("PRODUCT PRICE IS :" + CartBean.getProductPrice());
				System.out.println("NO OF PRODUCT QUANTITY  :" + CartBean.getQuantity());
				System.out.println("-----------------------------------------------------------------");
			}
		}

	}// end of seeCart() method

	@Override
	public void addToCart(int uId) {
		Scanner scanner = new Scanner(System.in);
		ProductBean productBean = null;
		String emailId = null;
		boolean value = true;
		for (UserBean user : UserDaoImpl.user) {
			if (uId == user.getUserId()) {
				emailId = user.getEmailId();
			}
		}
		try {
			System.out.println("ENTER CART ID ");
			int cId = Integer.parseInt(scanner.nextLine());
			System.out.println("ENTER THE PRODUCT NAME");
			String name = scanner.nextLine();
			System.out.println("ENTER THE PRODUCT QUANTITY ");
			int qua = Integer.parseInt(scanner.nextLine());

			for (ProductBean bean : list1) {
				if (name.equals(bean.getProductName())) {

					productBean = bean;
				}
			}
			if (productBean != null) {
				System.out.println("---------------------------------");

				int pId = productBean.getProductId();
				String pName = productBean.getProductName();
				String category = productBean.getProductCategory();
				double price = productBean.getProductPrice();
				int quantity = productBean.getProductQuantity();

				CartBean bean = new CartBean(cId, uId, pId, emailId, category, name, price, qua);
				cart.add(bean);
				System.out.println("PRODUCT ADDED SUCCESSFULLY");

			} else {
				System.out.println("PRODUCT IS OUT OF STOCK");
			}
		} catch (NumberFormatException e) {
			System.out.println("ENTER ONLY NUMBER");
		}
		scanner.close();
	}// end of addToCart() method

	@Override
	public void deleteFormCart() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("ENTER THE CART ID OF THE PRODUCT TO BE DELETED");
			int cId = Integer.parseInt(scanner.nextLine());
			CartBean bean = null;
			for (CartBean cartBean : cart) {
				if (cId == cartBean.getCartId()) {

					bean = cartBean;
				}
			}

			if (bean != null) {
				cart.remove(bean);
				System.out.println("PRODUCT REMOVED FROM CART SUCCESSFULLY");

			}
		} catch (NumberFormatException e) {
			System.out.println("ENTER ONLY NUMBER");
		}
		scanner.close();
	}// end of deleteFromCart() method

	@Override
	public void placeOrder(int uId) {
		Scanner scanner = new Scanner(System.in);

		int pId = 0;
		String emailId = null;
		try {
			System.out.println("ENTER THE NUMBER OF PRODUCTS TO BE ADDED TO ORDER");
			int count = Integer.parseInt(scanner.nextLine());
			for (int i = 1; i <= count; i++) {
				double price = 0;
				int quantity = 0;
				System.out.println("ENTER OREDER ID");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.println("ENTER PRODUCT NAME");
				String pName = scanner.nextLine();

				for (CartBean bean : cart) {
					if (uId == bean.getUserId() && pName.equals(bean.getProductName())) {

						pId = bean.getProductId();
						emailId = bean.getEmailId();

						price = bean.getProductPrice();
						quantity = bean.getQuantity();
						OrderBean bean1 = new OrderBean(id, uId, pId, emailId, pName, price, quantity);
						order.add(bean1);
						System.out.println("YOUR ORDER IS PLACED SUCCESSFULLY");
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("ENTER ONLY NUMBER");
		}
		scanner.close();
	}// end of placeOrder() method

	@Override
	public void viewOrder(int uId) {
		double total = 0;
		for (OrderBean bean : order) {
			if (uId == bean.getUserId()) {
				System.out.println("ORDER ID IS :" + bean.getOrderId());
				System.out.println("USER ID IS :" + bean.getUserId());
				System.out.println("EMAILID IS :" + bean.getEmailId());
				System.out.println("PRODUCT ID IS :" + bean.getProductId());
				System.out.println("PRODUCT NAME IS :" + bean.getProductName());
				System.out.println("PRODUCT PRICE IS :" + bean.getProductPrice());
				System.out.println("PRODUCT QUANTITY IS :" + bean.getQuantity());
				System.out.println("...............................................");
				double price = bean.getProductPrice();
				int quantity = bean.getQuantity();
				total = total + (price * quantity);

			}

		}
		System.out.println("YOUR TOTAL BILL IS : Rs ." + total);
	}//// end of viewOrder() method
}
