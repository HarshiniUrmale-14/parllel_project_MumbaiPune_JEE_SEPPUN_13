package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.dao.Dao;
import com.capgemini.jdbc.factory.Factory;

public class MedicineMain {

	public static void main(String[] args) {
		Dao product = Factory.getDAOImplInstance();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("PRESS 0 TO VIEW THE PRODUCTS");
			System.out.println("PRESS 1 TO LOGIN AS ADMINISTRATOR");
			System.out.println("PRESS 2 TO LOGIN AS USER");
			System.out.println("PRESS 3 TO FOR REGISTATION FOR USER ");
			System.out.println("PRESS 4 TO EXIT");
			String button = scan.nextLine();
			switch (button) {
			case "0":
				System.out.println("HERE ARE THE PRODUCTS");
				ProductTest.product();
				break;
			case "1":
				System.out.println("WELCOME TO LOGIN AS ADMINISTRATOR");
				AdminTest.admin();
				break;
			case "2":
				System.out.println("WELCOME TO LOGIN AS USER");
				UserTest.user();
				break;
			case "3":
				System.out.println("WELCOME TO REGISTRATION PAGE");
				UserRegistration.registration();
				break;
			case "4":
				System.exit(0);
			default:
				System.err.println("ENTER BUTTON BETWEEN 0 TO 4");
			}
		}
	}
}
