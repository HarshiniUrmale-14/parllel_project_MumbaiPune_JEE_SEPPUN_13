package com.capgemini.hibernate.factory;

import com.capgemini.hibernate.dao.AdminDao;
import com.capgemini.hibernate.dao.AdminDaoImpl;
import com.capgemini.hibernate.dao.Dao;
import com.capgemini.hibernate.dao.DaoImpl;
import com.capgemini.hibernate.dao.UserDao;
import com.capgemini.hibernate.dao.UserDaoImpl;
import com.capgemini.hibernate.validation.CustomValidationDao;
import com.capgemini.hibernate.validation.CustomValidationDaoImpl;
import com.capgemini.hibernate.validation.ValidationDao;
import com.capgemini.hibernate.validation.ValidationDaoImpl;

public class Factory {
	private Factory() {

	}

	public static Dao getDAOImplInstance() {
		Dao dao = new DaoImpl();
		return dao;
	}

	public static AdminDao getAdminDAOImplInstance() {
		AdminDao adminDao = new AdminDaoImpl();
		return  adminDao;
	}

	public static UserDao getUserDAOImplInstance() {
		UserDao userDao = new UserDaoImpl();
		return userDao;
	}

	public static ValidationDao getValImplInstance() {
		ValidationDao dao1 = new ValidationDaoImpl();
		return dao1;
	}
	public static CustomValidationDao getCustomValImplInstance() {
		CustomValidationDao dao2 = new CustomValidationDaoImpl();
		return dao2;
	}

}
