package com.capgemini.jdbc.controller;

import java.util.List;

import com.capgemini.jdbc.bean.ProductBean;
import com.capgemini.jdbc.dao.Dao;
import com.capgemini.jdbc.factory.Factory;

public class ProductTest {
	public static void product() {
		Dao product = Factory.getDAOImplInstance();
		List<ProductBean> list = product.getProducts();
		if (list != null) {
			for (ProductBean user : list) {
				System.out.println("PRODUCT ID IS :" + user.getProductId());
				System.out.println("PRODUCT CATEGORY IS :" + user.getProductCategory());
				System.out.println("PRODUCT NAME IS :" + user.getProductName());
				System.out.println("PRODUCT PRICE IS :" + user.getProductPrice());
				System.out.println("NO OF PRODUCT QUANTITY PRESENT IS :" + user.getProductQuantity());
				System.out.println("----------------------------------------------------------------");
			}
		} else {
			System.out.println("Something Went Wrong...");
		}
	}
}
