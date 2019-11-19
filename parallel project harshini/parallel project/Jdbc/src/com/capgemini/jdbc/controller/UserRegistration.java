package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.Dao;
import com.capgemini.jdbc.dao.UserDao;
import com.capgemini.jdbc.factory.Factory;
import com.capgemini.jdbc.validation.CustomValidationDao;
import com.capgemini.jdbc.validation.ValidationDao;

public class UserRegistration {
	public static void registration() {

		Dao dao1 = Factory.getDAOImplInstance();
		UserDao dao = Factory.getUserDAOImplInstance();
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		Scanner scan = new Scanner(System.in);
		ValidationDao vali = Factory.getValImplInstance();
		UserBean userBean = new UserBean();
		boolean value = true;
		while (value) {
			System.out.println("ENTER THE EMAILID");
			String emailId = scan.nextLine();
			if (vali.validationEmail(emailId)) {
				boolean check = customVali.checkUserEmail(emailId);
				if (!check) {
					userBean.setEmailId(emailId);
					while (value) {
						System.out.println("ENTER THE PASSWORD");
						String password = scan.nextLine();
						if (vali.validationPassword(password)) {
							userBean.setPassword(password);
							while (value) {
								System.out.println("ENTER THE MOBILE NUMBER");
								String mobileNo = scan.nextLine();
								if (vali.validationMobileNo(mobileNo)) {
									userBean.setMobileNo(mobileNo);
									dao.userRegistration(emailId, password, mobileNo);
									value = false;
								} else {
									System.err.println("ENTER VALID MOBILENO");
									System.err.println("ENTER ONLY 10 DIGITS");
								}
							}
						} else {
							System.err.println("ENTER VALID PASSWORD");
							System.err.println("ENTER PASSWORD BETWEEN 6 TO 8");
							}
					}
				} else {
					System.err.println("EMAIL ID ALREADY EXIST");
				}
			} else {
				System.err.println("ENTER VALID EMAILID");
				System.err.println("THE MAIL ID SHOULD BE OF TYPE abc@xyz.com");
			}
		}
	}
}
