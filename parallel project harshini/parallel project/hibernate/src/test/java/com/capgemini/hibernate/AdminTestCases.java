package com.capgemini.hibernate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.hibernate.dao.AdminDaoImpl;

import junit.framework.Assert;

public class AdminTestCases {
	private AdminDaoImpl adminDaoImpl;

	@BeforeEach
	public void createObject() {
		adminDaoImpl = new AdminDaoImpl();

	}

	@Test
	public void testAdminAuthentication() {
		Assert.assertEquals(1, adminDaoImpl.adminLogin("harshini@gmail.com", "abc123"));
	}

	@Test
	public void testAdminAuthenticationForNull() {
		Assert.assertEquals(0, adminDaoImpl.adminLogin(null, null));
	}

	@Test
	public void testProductInsertion() {
		Assert.assertEquals(true, adminDaoImpl.insertProduct("eyecare", "tycodine", 78.9, 89));
	}

	@Test
	public void testProductDelete() {
		Assert.assertEquals(true, adminDaoImpl.deleteProduct(99));
	}
	
	@Test
	public void testGetUser() {
		Assert.assertEquals(true, adminDaoImpl.getUser());
	}


}
