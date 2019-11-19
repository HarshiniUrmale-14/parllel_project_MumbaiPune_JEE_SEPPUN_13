package com.capgemini.jdbc.factory;


import com.capgemini.jdbc.dao.AdminDao;
import com.capgemini.jdbc.dao.AdminDaoImpl;
import com.capgemini.jdbc.dao.Dao;
import com.capgemini.jdbc.dao.DaoImpl;
import com.capgemini.jdbc.dao.UserDao;
import com.capgemini.jdbc.dao.UserDaoImpl;
import com.capgemini.jdbc.validation.CustomValidationDao;
import com.capgemini.jdbc.validation.CustomValidationDaoImpl;
import com.capgemini.jdbc.validation.ValidationDao;
import com.capgemini.jdbc.validation.ValidationDaoImpl;

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
		CustomValidationDao customDao = new CustomValidationDaoImpl();
		return customDao;
	}

}
