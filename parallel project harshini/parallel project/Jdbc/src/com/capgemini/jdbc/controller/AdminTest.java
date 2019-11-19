package com.capgemini.jdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.jdbc.bean.ProductBean;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.AdminDao;
import com.capgemini.jdbc.dao.Dao;
import com.capgemini.jdbc.factory.Factory;
import com.capgemini.jdbc.validation.CustomValidationDao;

public class AdminTest {
	public static void admin() {
		com.capgemini.jdbc.validation.ValidationDao vali = Factory.getValImplInstance();
		Dao dao1 = Factory.getDAOImplInstance();
		AdminDao dao = Factory.getAdminDAOImplInstance();
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		Scanner scan = new Scanner(System.in);
		int adminId = 0;
		System.out.println("ENTER THE EMAIL");
		String emailId = scan.nextLine();
		if (customVali.checkAdminEmail(emailId)) {
			System.out.println("ENTER THE PASSWORD");
			String password = scan.nextLine();
			adminId = dao.adminLogin(emailId, password);
			if (adminId != 0) {

				System.out.println("LOGGED IN SUCCESSFULLY");
			} else {
				System.err.println("PASSWORD IS WRONG");
			}

		} else {
			System.err.println("THIS EMAIL ID DOES NOT EXIST");
		}
		while (adminId != 0) {
			System.out.println("ENTER 1 TO VIEW THE PRODUCT ");
			System.out.println("ENTER 2 TO ADD THE PRODUCT ");
			System.out.println("ENTER 3 TO UPDATE THE PRODUCT ");
			System.out.println("ENTER 4 TO DELETE THE PRODUCT ");
			System.out.println("ENTER 5 TO VIEW THE USER LIST");
			System.out.println("ENTER 6 TO DELETE THE USER");
			System.out.println("ENTER 7 TO VIEW THE MESSAGE FROM USER");
			System.out.println("ENTER 8 TO GIVE REPLY TO USER");
			System.out.println("ENTER 9 TO LOGOUT");
			String button = scan.nextLine();
			switch (button) {
			case "1":
				System.out.println("HERE ARE THE PRODUCTS");
				List<ProductBean> list = dao1.getProducts();
				if (list != null) {
					for (ProductBean user : list) {
						System.out.println("PRODUCT ID IS :" + user.getProductId());
						System.out.println("PRODUCT CATEGORY IS :" + user.getProductCategory());
						System.out.println("PRODUCT NAME IS :" + user.getProductName());
						System.out.println("PRODUCT PRICE IS :" + user.getProductPrice());
						System.out.println("NO OF PRODUCT QUANTITY PRESENT IS :" + user.getProductQuantity());
						System.out.println("----------------------------------------------------------------");
					}
				} else {
					System.err.println("SOMETHING WENT WRONG");

				}
				break;
			case "2":
				boolean check = true;
				while (check) {
					System.out.println(" ENTER THE PRODUCT CATEGORY");
					String category = scan.nextLine();
					if (vali.validationProductCategory(category)) {
						System.out.println("ENTER THE PRODUCT NAME ");
						String name = scan.nextLine();
						if (!customVali.checkProductName(name)) {
							if (vali.validationProductName(name)) {
								double price = 0;
								try {
									System.out.println("ENTER THE PRODUCT PRICE ");
									price = Double.parseDouble(scan.nextLine());

									System.out.println("ENTER THE PRODUCT QUANTITY AVAILABLE");
									int quantity = Integer.parseInt(scan.nextLine());

									int m = dao.insertProduct(category, name, price, quantity);
									if (m != 0) {
										System.out.println("DATA INSERTED");
										check = false;
									}
								} catch (NumberFormatException e) {
									System.err.println("ENTER NUMBER ONLY");
								}

							} else {
								System.err.println("ENTER CHARACTERS AND ASLO NUMBER IF REQUIRED");

							}
						} else {
							System.err.println("PRODUCT NAME ALREADY EXIST");
						}

					} else {
						System.out.println("ENTER ONLY CHARACTERS");
					}

				}

				break;

			case "3":
				try {
					System.out.println("ENTER THE ID OF PRODUCT TO BE UPDATED");
					int productId = Integer.parseInt(scan.nextLine());
					if (customVali.checkProductId(productId)) {

						dao.updateProduct(productId);
					} else {
						System.err.println("PRODUCT ID DOES NOT EXIST");
					}

				} catch (NumberFormatException e) {
					System.err.println("ENTER ONLY NUMBER");
				}
				break;
			case "4":
				try {
					System.out.println("ENTER THE PRODUCT ID ");
					int productId = Integer.parseInt(scan.nextLine());
					if (customVali.checkProductId(productId)) {
						int d = dao.deleteProduct(productId);
						if (d != 0) {
							System.out.println("DATA DELETED");
						}
					} else {
						System.err.println("PRODUCT ID DOES NOT EXIST");
					}
				} catch (NumberFormatException e) {
					System.err.println("ENTER NUMBER ONLY");
				}

				break;
			case "5":
				List<UserBean> user = dao.getUsers();

				if (user != null) {
					for (UserBean user1 : user) {
						System.out.println("USER ID IS" + user1.getUserId());
						System.out.println("USER EMAIL ID IS" + user1.getEmailId());
						System.out.println("USER MOBILE NO IS" + user1.getMobileNo());

						System.out.println("----------------------------------------------------------------");
					}
				} else {
					System.err.println("SOMETHING WENT WRONG");
				}
			case "6":
				System.out.println("ENTER THE ID OF USER TO BE DELETED");
				try {
					int userId = Integer.parseInt(scan.nextLine());
					if (customVali.checkUserId(userId)) {
						System.out.println("................................");
						int r = dao.deleteUser(userId);

						if (r != 0) {
							System.out.println("USER DELETED");
						}
					} else {
						System.err.println("USER ID IS NOT PRESENT");
					}
				} catch (NumberFormatException e) {
					System.err.println("ENTER ONLY NUMBER");
				}

				break;
			case "7":
				dao.seeRequest();
				break;
			case "8":
				dao.sendReply();
				break;
			case "9":
				System.out.println("YOU ARE LOGGED OUT");
				System.exit(0);
				break;
			default:
				System.out.println("...............................................");
				System.err.println("ENTER BUTTON BETWEEN 1 TO 9");
				System.out.println("...............................................");
			}

		}
	}
}
