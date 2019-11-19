package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.jdbc.bean.ProductBean;
import com.capgemini.jdbc.bean.ReplyBean;
import com.capgemini.jdbc.bean.RequestBean;

public class DaoImpl implements Dao {

	FileReader reader;

	Properties properties;
	Scanner scanner = new Scanner(System.in);

	public DaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db.properties");
			properties = new Properties();
			properties.load(reader);
		} catch (Exception e) {
			System.err.println("DRIVER IS NOT LOADED PROPERLY");
		}
	}

	@Override
	public List<ProductBean> getProducts() {
		List<ProductBean> productlist = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("user"),
				properties.getProperty("password")); Statement stmt = conn.createStatement()) {

			try (ResultSet res = stmt.executeQuery(properties.getProperty("query1"))) {
				while (res.next()) {
					ProductBean product = new ProductBean();
					product.setProductCategory(res.getString(1));
					product.setProductId(res.getInt(2));
					product.setProductName(res.getString(3));
					product.setProductPrice(res.getInt(4));
					product.setProductQuantity(res.getInt(5));
					productlist.add(product);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productlist;
	}



}
