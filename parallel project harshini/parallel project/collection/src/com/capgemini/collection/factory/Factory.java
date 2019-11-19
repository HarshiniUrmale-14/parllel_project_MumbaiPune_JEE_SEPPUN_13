package com.capgemini.collection.factory;

import com.capgemini.collection.dao.AdminDao;
import com.capgemini.collection.dao.AdminDaoImpl;
import com.capgemini.collection.dao.Dao;
import com.capgemini.collection.dao.DaoImpl;
import com.capgemini.collection.dao.UserDao;
import com.capgemini.collection.dao.UserDaoImpl;
import com.capgemini.collection.validation.ValidationDao;
import com.capgemini.collection.validation.ValidationDaoImpl;

public class Factory {
	private Factory() {
	}
	
	public static Dao getDAOImplInstance() {
	Dao dao = new DaoImpl();
		return dao;
	}
	public static AdminDao getAdminDAOImplInstance() {
		AdminDao dao1 = new AdminDaoImpl();
			return dao1;
		}
	public static UserDao getUserDAOImplInstance() {
		UserDao dao2 = new UserDaoImpl();
			return dao2;
		}
	public static ValidationDao getValImplInstance() {
		ValidationDao dao1 = new ValidationDaoImpl();
		return dao1;
	}

}//end of class
