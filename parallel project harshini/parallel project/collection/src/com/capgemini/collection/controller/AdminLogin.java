package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.dao.AdminDao;
import com.capgemini.collection.dao.AdminDaoImpl;
import com.capgemini.collection.dao.Dao;
import com.capgemini.collection.dao.UserDao;
import com.capgemini.collection.factory.Factory;

public class AdminLogin {
	public static void admin() {
		UserDao prod = Factory.getUserDAOImplInstance();
		Dao product1 = Factory.getDAOImplInstance();
		AdminDao product = Factory.getAdminDAOImplInstance();

		Scanner scan = new Scanner(System.in);
		int a = 0;
		System.out.println("ENTER THE EMAILID");
		String emailId = scan.nextLine();
		if (emailId.equals(AdminDaoImpl.admin.getEmailId())) {
			System.out.println("ENTER THE PASSWORD");
			String pass = scan.nextLine();
			if (pass.equals(AdminDaoImpl.admin.getPassword())) {
				a = AdminDaoImpl.admin.getAdminId();
				System.out.println("ADMIN LOGGED IN SUCCESSFULLY");
			} else {
				System.err.println("ENTER VALID EMAIL");
			}

		} else {
			System.err.println(" EMAILID  DOES NOT EXIST");
		}

		while (a != 0) {
			System.out.println("ENTER 1 TO VIEW THE PRODUCT ");
			System.out.println("ENTER 2 TO ADD THE PRODUCT ");
			System.out.println("ENTER 3 TO UPDATE THE PRODUCT ");
			System.out.println("ENTER 4 TO DELETE THE PRODUCT ");
			System.out.println("ENTER 5 TO VIEW ALL USERS");
			System.out.println("ENTER 6 TO DELETE THE USER");
			System.out.println("ENTER 7 TO VIEW MESSAGE FROM USERS");
			System.out.println("ENTER 8 TO SENT MESSAGE TO USER");
			System.out.println("ENTER 9 TO VIEW THE REPORT OF SALE OF PRODUCTS");
			System.out.println("ENTER 10 TO LOGOUT");
			String button = scan.nextLine();

			switch (button) {
			case "1":
				System.out.println("HERE ARE THE PRODUCTS");
				System.out.println("...............................................");
				product1.viewproducts();
				System.out.println("...............................................");
				break;
			case "2":
				System.out.println("ADD PRODUCTS HERE");
				System.out.println("...............................................");
				product.addProducts();
				System.out.println("...............................................");
				break;
			case "3":
				System.out.println("....................................");
				product.updateProduct();
				System.out.println("........................................");
				break;
			case "4":
				System.out.println("...............................................");
				product.deleteProduct();
				System.out.println("...............................................");
				break;
			case "5":
				product.seeAllUsers();
				break;
			case "6":
				System.out.println("...............................................");
				product.deleteUser();
				System.out.println("...............................................");
				break;
			case "7":
				System.out.println("...............................................");
				product.seeMessage();
				System.out.println("...............................................");
				break;
			case "8":
				System.out.println("...............................................");
				product.sendMessage();
				System.out.println("...............................................");
				prod.seeReply(a);
				System.out.println("...............................................");
				System.out.println("REPLY SENT SUCCESSFULLY");
				System.out.println("...............................................");
				break;
			case "9":
				System.out.println("HERE IS THE REPORT OF SALE OF PRODUCT");
				System.out.println("...............................................");
				product.seeReport();
				System.out.println("...............................................");
				break;
			case "10":
				System.out.println("...............................................");
				System.out.println("YOU ARE LOGGED OUT");
				System.out.println("...............................................");
				System.exit(0);
			default:
				System.out.println("...............................................");
				System.out.println("ENTER BUTTON BETWEEN 1 TO 10 ONLY");
				System.out.println("...............................................");
			}
		}
	}// end of admin() method
}// end of class
