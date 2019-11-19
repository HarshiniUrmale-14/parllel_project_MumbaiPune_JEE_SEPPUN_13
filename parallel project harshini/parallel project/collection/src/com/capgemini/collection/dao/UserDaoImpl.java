package com.capgemini.collection.dao;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.collection.bean.ReplyBean;
import com.capgemini.collection.bean.RequestBean;
import com.capgemini.collection.bean.UserBean;
import com.capgemini.collection.factory.Factory;
import com.capgemini.collection.validation.ValidationDao;

public class UserDaoImpl implements UserDao {
	public static Set<UserBean> user = null;
	public static List<RequestBean> request = null;

	static {
		user = new LinkedHashSet<UserBean>();
		UserBean user0 = new UserBean(1, "manish@gmail.com", "xyz123", "5666655557");
		UserBean user1 = new UserBean(2, "kanchan@gmail.com", "qw6780", "9589538976");
		UserBean user2 = new UserBean(3, "roshni@gmail.com", "qwe123", "7532467508");
		UserBean user3 = new UserBean(4, "kapil@gmail.com", "567ghhg", "9758634765");
		user.add(user0);
		user.add(user1);
		user.add(user2);
		user.add(user3);
		request = new LinkedList<RequestBean>();
		RequestBean request0 = new RequestBean(1, 1, "manish@gmail.com", "hello admin");
		RequestBean request1 = new RequestBean(2, 2, "kanchan@gmail.com", "any new products");
		request.add(request0);
		request.add(request1);
	}

	@Override
	public void updateProfile(int uId) {
		ValidationDao vali = Factory.getValImplInstance();
		Scanner scanner = new Scanner(System.in);
		UserBean bean = null;
		for (UserBean userBean : user) {
			if (uId == userBean.getUserId()) {
				bean = userBean;
			}
		}
		if (bean != null) {
			System.out.println("ENTER USER EMAIL ID");
			String emailId = scanner.nextLine();
			if (vali.validationEmail(emailId)) {
				bean.setEmailId(emailId);
				System.out.println("ENTER USER PASSWORD");
				String password = scanner.nextLine();
				if (vali.validationPassword(password)) {
					bean.setPassword(password);
					System.out.println("ENTER MOBILE NO");
					String mobileNo = scanner.nextLine();
					if (vali.validationMobileNo(mobileNo)) {
						bean.setMobileNo(mobileNo);
						System.out.println("PROFILE UPDATED");
					} else {
						System.out.println("ENTER VALID MOBILE NO");
					}
				} else {
					System.out.println("ENTER VALID PASSWORD");
				}
			} else {
				System.out.println("ENTER VALID EMAIL ID");
			}
		}
		scanner.close();
	}// end of updateProfile() method

	@Override
	public void seeUser(int uId) {
		UserBean bean = null;
		for (UserBean userBean : user) {
			if (uId == userBean.getUserId()) {
				bean = userBean;
			}
		}
		if (bean != null) {
			System.out.println("USER ID IS  :" + bean.getUserId());
			System.out.println("USER EMAILID  :" + bean.getEmailId());
			System.out.println("USER EMAILID :" + bean.getPassword());
			System.out.println("USER MOBILE NO IS :" + bean.getMobileNo());
			System.out.println("...............................................");
		}
	}// end of seeUser() method

	@Override
	public void registration(int uId, String emailId, String password, String mobileNo) {
		UserBean bean = new UserBean(uId, emailId, password, mobileNo);
		user.add(bean);
		System.out.println("REGISTRATION DONE SUCCESSFULLY");

	}// end of registration() method

	@Override
	public void sendMsg(int uId) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String emailId = null;
			try {
				System.out.println("ENTER THE MESSAGE ID");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.println("ENTER THE MSG TO BE SENT");
				String msg = scanner.nextLine();
				for (UserBean userBean : UserDaoImpl.user) {
					if (uId == userBean.getUserId()) {
						emailId = userBean.getEmailId();
					}
				}
				RequestBean bean = null;
				for (RequestBean requestBean : request) {
					bean = requestBean;
				}
				if (bean != null) {
					RequestBean bean1 = new RequestBean(id, uId, emailId, msg);
					request.add(bean1);
					System.out.println("MESSAGE SENT SUCCESSFULLY");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("ENTER NUMBER ONLY");
			}
		}
		scanner.close();
	}// end of sendMsg() method

	@Override
	public void seeReply(int uId) {
		for (ReplyBean replyBean : AdminDaoImpl.reply) {
			if (uId == replyBean.getUserId()) {
				System.out.println("MESSAGE ID IS :" + replyBean.getReplyId());
				System.out.println("USER ID IS :" + replyBean.getUserId());
				System.out.println("USER EMAILID IS :" + replyBean.getEmailId());
				System.out.println("MESSAGE IS :" + replyBean.getMessage());
				System.out.println("...............................................");
			}
		}
	}// end of seeReply() method

}// end of class
