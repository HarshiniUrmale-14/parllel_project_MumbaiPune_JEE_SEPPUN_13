package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.dao.Dao;
import com.capgemini.collection.factory.Factory;

public class Mainclass {

	public static void main(String[] args) {

		Dao product = Factory.getDAOImplInstance();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("ENTER 0 TO VIEW ALL THE PRODUCTS");
			System.out.println("ENTER 1 TO LOGIN AS ADMINISTRATOR");
			System.out.println("ENTER 2 TO LOGIN AS USER");
			System.out.println("ENTER 3 TO DO REGISTRATION AS USER");
			System.out.println("ENTER 4 TO GO OUT OF THE APPLICATION");
			String button = scan.nextLine();

			switch (button) {
			case "0":
				System.out.println("YOU CAN VIEW THE PRODUCTS HERE");
				System.out.println("...............................................");
				product.viewproducts();
				break;

			case "1":
				System.out.println("...............................................");
				System.out.println("WELCOME TO ADMINISTRATOR PAGE");
				AdminLogin.admin();
				System.out.println("...............................................");
				break;
			case "2":
				System.out.println("...............................................");
				System.out.println("WELCOME TO USER PAGE");
				UserLogin.user();
				System.out.println("...............................................");
				break;
			case "3":
				System.out.println("...............................................");
				System.out.println("REGISTER THE USERS HERE");
				RegisterUser.register();
				System.out.println("...............................................");
				break;
			case "4":
				System.out.println("...............................................");
				System.out.println("THANK YOU FOR VISITING OUR APPLICATION");
				System.exit(0);
				System.out.println("...............................................");
			default:
				System.out.println("...............................................");
				System.err.println("ENTER DIGITS BETWEEN 0 TO 4  ONLY");
				System.out.println("...............................................");
			}
		}
	}// end of main method
}// end of class
