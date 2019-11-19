package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.bean.OrderBean;
import com.capgemini.collection.bean.ProductBean;
import com.capgemini.collection.bean.ReplyBean;
import com.capgemini.collection.bean.RequestBean;
import com.capgemini.collection.bean.UserBean;
import com.capgemini.collection.factory.Factory;
import com.capgemini.collection.validation.ValidationDao;

public class AdminDaoImpl implements AdminDao {
	static List<ProductBean> list1 = null;
	public static AdminBean admin = null;
	static List<ReplyBean> reply = null;

	static {

		admin = new AdminBean(1, "harshini@gmail.com", "abc123");
		reply = new ArrayList<ReplyBean>();
		ReplyBean reply0 = new ReplyBean(1, 1, "manish@gmail.com", "hello admin");
		ReplyBean reply1 = new ReplyBean(2, 2, "kanchan@gmail.com", "any new products");
		reply.add(reply0);
		reply.add(reply1);
	}

	@Override
	public void addProducts() {
		ValidationDao vali = Factory.getValImplInstance();
		Scanner scanner = new Scanner(System.in);
		boolean value = true;
		while (value) {
			try {
				System.out.println("ENTER THE PRODUCT ID");
				int productId = Integer.parseInt(scanner.nextLine());
				try {
					for (ProductBean productBean : DaoImpl.list1) {
						if (productId != productBean.getProductId()) {

							System.out.println("ENTER THE PRODUCT CATEGORY");
							String productCategory = scanner.nextLine();
							if (vali.validationProductCategory(productCategory)) {

								System.out.println("ENTER THE PRODUCT NAME");
								String productName = scanner.nextLine();

								if (!productName.equalsIgnoreCase(productBean.getProductName())) {
									if (vali.validationProductName(productName)) {

										try {
											System.out.println("ENTER THE PRODUCT PRICE");
											double productPrice = Double.parseDouble(scanner.nextLine());
											while (value) {

												System.out.println("ENTER THE PRODUCT QUANTITY PRESENT");
												int productQuantity = Integer.parseInt(scanner.nextLine());
												ProductBean bean123 = new ProductBean(productId, productCategory,
														productName, productPrice, productQuantity);
												DaoImpl.list1.add(bean123);
												if (DaoImpl.list1 != null) {
													System.out.println("PRODUCT IS INSERTED SUCCESSFULLY");
													value = false;
													break;

												}
											}
										} catch (Exception e) {
											System.err.println("ENTER NUMBER ONLY");

										}
									} else {
										System.out.println(
												"PRODUCT NAME SHOULD CONTANTS CHARACTER AND IF NECESSARY NUMBERS");

									}

								} else {
									System.err.println("PRODUCT NAME ALREADY EXIST");
								}

							} else {
								System.out.println("PRODDUCT CATEGORY SHOULD ONLY CONTAIN CHARACTERS");
							}

						} else {
							System.err.println("PRODUCT ID IS ALREADY PRESENT ");
							break;
						}
					}
					break;
				} catch (Exception e) {
					System.out.println(".............................................");
				}
			} catch (Exception e) {
				System.err.println("ENTER NUMBER ONLY");
			}
		}
		scanner.close();
	}// end of addProduct() method

	@Override
	public void deleteUser() {
		UserBean userBean = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER USER ID TO BE DELETED");
		int userId = Integer.parseInt(scanner.nextLine());
		try {
			for (UserBean bean : UserDaoImpl.user) {

				if (userId == bean.getUserId()) {
					userBean = bean;

				}
			}

			if (userBean != null) {
				UserDaoImpl.user.remove(userBean);
				System.out.println("USER REMOVED SUCCESSFULLY");
			} else {
				System.out.println("USER ID IS NOT PRESENT");
			}

		} catch (NumberFormatException e) {
			System.out.println("ENTER ONLY NUMBER");
		}
		scanner.close();
	}// end of deleteUser() method

	@Override
	public void seeAllUsers() {
		for (UserBean bean : UserDaoImpl.user) {
			System.out.println("USER ID IS  :" + bean.getUserId());
			System.out.println("USER EMAIL ID IS  : " + bean.getEmailId());
			System.out.println("USER MOBILE NO IS :" + bean.getMobileNo());
			System.out.println("...............................................");
		}

	}// end of seeAllUsers() method

	@Override
	public void deleteProduct() {
		ProductBean productBean = null;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("ENTER PRODUCT ID TO BE DELETED");
			int productId = Integer.parseInt(scanner.nextLine());

			for (ProductBean pb : DaoImpl.list1) {

				if (productId == pb.getProductId()) {
					productBean = pb;

				}
			}
			if (productBean != null) {
				DaoImpl.list1.remove(productBean);
				System.out.println("PRODUCT DELETED");
			} else {
				System.err.println("THE PRODUCT ID IS NOT PRESENT IN THE LIST");

			}

		} catch (NumberFormatException e) {
			System.out.println("ENTER NUMBER ONLY");
		}
		scanner.close();
	}// end of deleteProduct() method

	@Override
	public void updateProduct() {

		ProductBean bean = null;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("ENTER THE PRODUCT ID TO BE UPDATED");
				int id = Integer.parseInt(scanner.nextLine());
				for (ProductBean productBean : DaoImpl.list1) {
					if (id == productBean.getProductId()) {
						bean = productBean;

					}

				}
				if (bean != null) {
					System.out.println("ENTER PRODUCT CATEGORY");
					String category = scanner.nextLine();
					bean.setProductCategory(category);
					System.out.println("ENTER PRODUCT NAME");
					String name = scanner.nextLine();
					bean.setProductName(name);
					System.out.println("ENTER PRODUCT PRICE");
					double price = Double.parseDouble(scanner.nextLine());
					bean.setProductPrice(price);
					System.out.println("ENTER PRODUCT QUANTITY");
					int quantity = Integer.parseInt(scanner.nextLine());
					bean.setProductQuantity(quantity);
					System.out.println("PRODUCT UPDATED");
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("ENTER NUMBER ONLY");
			}
		}
		scanner.close();
	}// end of updateProduct() method

	@Override
	public void seeMessage() {
		for (RequestBean requestBean : UserDaoImpl.request) {
			System.out.println("MESSAGE ID IS  :" + requestBean.getRequestId());
			System.out.println("USER ID IS  :" + requestBean.getUserId());
			System.out.println("USER EMAILID IS  :" + requestBean.getEmailId());
			System.out.println("MESSAGE IS  :" + requestBean.getMessage());
			System.out.println("...............................................");
		}
	}// end of seeMessage() method

	@Override
	public void sendMessage() {
		Scanner scanner = new Scanner(System.in);
		String emailId = null;
		try {
			System.out.println("ENTER MESSAGE ID");
			int id = Integer.parseInt(scanner.nextLine());

			System.out.println("ENTER THE USER ID OF USER TO SENT THE MESSAGE");
			int uId = Integer.parseInt(scanner.nextLine());
			for (UserBean bean : UserDaoImpl.user) {
				if (uId == bean.getUserId()) {
					emailId = bean.getEmailId();
				}
			}

			System.out.println("ENTER THE MESSAGE TO SENT THE MESSAGE");
			String msg = scanner.nextLine();
			ReplyBean bean = null;
			for (ReplyBean replyBean : reply) {
				bean = replyBean;
			}
			if (bean != null) {
				ReplyBean bean1 = new ReplyBean(id, uId, emailId, msg);
				reply.add(bean1);
				System.out.println("REPLY FROM ADMIN SENT SUCCESSFULLY TO USER");
			}

		} catch (NumberFormatException e) {
			System.out.println("ENTER NUMBER ONLY");
		}
		scanner.close();
	}// end of sendMessage() method

	@Override
	public void seeReport() {
		System.out.println("..............................................");
		for (OrderBean orderBean : DaoImpl.order) {

			System.out.println("ORDER ID IS  :" + orderBean.getOrderId());
			System.out.println("USER ID IS  :" + orderBean.getUserId());
			System.out.println("EMAILID IS  :" + orderBean.getEmailId());
			System.out.println("PRODUCT ID IS  :" + orderBean.getProductId());
			System.out.println("PRODUCT NAME IS  :" + orderBean.getProductName());
			System.out.println("PRODUCT PRICE IS  :" + orderBean.getProductPrice());
			System.out.println("PRODUCT QUANTITY IS  :" + orderBean.getQuantity());
			System.out.println("...............................................");
		}

	}// end of seeReport() method
}// end of class
