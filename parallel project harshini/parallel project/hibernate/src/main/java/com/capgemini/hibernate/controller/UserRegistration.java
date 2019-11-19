package com.capgemini.hibernate.controller;

import java.util.Scanner;

import com.capgemini.hibernate.beans.UserBean;
import com.capgemini.hibernate.dao.UserDao;
import com.capgemini.hibernate.factory.Factory;
import com.capgemini.hibernate.validation.CustomValidationDao;
import com.capgemini.hibernate.validation.ValidationDao;

public class UserRegistration {
	public static void registration() {
		boolean value = true;
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		UserDao dao = Factory.getUserDAOImplInstance();
		Scanner scan = new Scanner(System.in);
		ValidationDao vali = Factory.getValImplInstance();
		UserBean userBean = new UserBean();
		while (value) {
			System.out.println("ENTER THE EMAIL ID");
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
									boolean check1 = dao.registration(emailId, password, mobileNo);
									if (check) {
										System.out.println("REGISTRAION DONE SUCCESSFULLY");
									}

									value = false;

								} else {
									System.err.println("ENTER VALID MOBILENO");
									System.err.println("ENTER ONLY 10 DIGITS");

								}
							}
						} else {
							System.err.println(" INVALID PASSWORD ");
							System.err.println("ENTER PASSWORD BETWEEN 6 TO 8");
						}
					}
				} else {
					System.err.println("EMAIL ID ALREADY EXIST");
				}
			} else {
				System.out.println("INVALID EMAIL ID");
				System.err.println("THE MAIL ID SHOULD BE OF TYPE abc@xyz.com");
			}

		}

	}
}
