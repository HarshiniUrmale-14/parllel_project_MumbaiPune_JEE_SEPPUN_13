package com.capgemini.hibernate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.hibernate.beans.UserBean;
import com.capgemini.hibernate.dao.UserDaoImpl;

import junit.framework.Assert;

public class UserTestCases {
	private UserDaoImpl userDaoImpl;

	@BeforeEach
	public void createObject() {
		userDaoImpl = new UserDaoImpl();

	}
	@Test
	public void testUserAuthentication() {
		Assert.assertEquals(3, userDaoImpl.userLogin("manish@gmail.com","xyz123"));
	}
	@Test
	public void testUserAuthenticationForNull() {
		Assert.assertEquals(0, userDaoImpl.userLogin(null,null));
	}
	@Test
	public void testUserRegistration() {
	Assert.assertEquals(true, userDaoImpl.registration("kanchan@gmail.com","456asd", "1234567890"));
	}
	@Test
	public void testUserDeleteFromCartTest() {
	Assert.assertEquals(true, userDaoImpl.deleteFromCart("lotion"));
	}

}
