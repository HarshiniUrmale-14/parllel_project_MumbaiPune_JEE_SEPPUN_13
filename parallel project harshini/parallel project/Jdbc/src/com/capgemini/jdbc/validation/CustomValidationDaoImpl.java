package com.capgemini.jdbc.validation;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class CustomValidationDaoImpl implements CustomValidationDao {
	FileReader reader;

	Properties prop;
	Scanner scan = new Scanner(System.in);

	public CustomValidationDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean checkUserEmail(String emailId) {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); Statement stmt = conn.createStatement()) {
			try (ResultSet res = stmt.executeQuery(prop.getProperty("query26"))) {
				while (res.next()) {
					if (emailId.equals(res.getString(1))) {
						check = true;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkAdminEmail(String emailId) {

		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); Statement stmt = conn.createStatement()) {
			try (ResultSet res = stmt.executeQuery(prop.getProperty("query27"))) {
				while (res.next()) {
					if (emailId.equals(res.getString(1))) {
						check = true;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkProductName(String productName) {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); Statement stmt = conn.createStatement()) {
			try (ResultSet res = stmt.executeQuery(prop.getProperty("query28"))) {
				while (res.next()) {
					if (productName.equals(res.getString(1))) {
						check = true;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkProductId(int productId) {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); Statement stmt = conn.createStatement()) {
			try (ResultSet res = stmt.executeQuery(prop.getProperty("query29"))) {
				while (res.next()) {
					if (productId == res.getInt(1)) {
						check = true;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;

	}

	@Override
	public boolean checkUserId(int userId) {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); Statement stmt = conn.createStatement()) {
			try (ResultSet res = stmt.executeQuery(prop.getProperty("query30"))) {
				while (res.next()) {

					if (userId == res.getInt(1)) {

						check = true;

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;

	}

	@Override
	public boolean checkProductQuantity(String productName, int productQuantity) {
		boolean check = false;

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query31"))) {

			pstmt.setString(1, productName);
			

			try (ResultSet res = pstmt.executeQuery()) {
				if (res.next()) {
					if (productQuantity <= res.getInt(1)) {

						check = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public boolean checkProductFromCart(String productName,int userId) {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query33"))) {

			pstmt.setInt(1, userId);
			

			try (ResultSet res = pstmt.executeQuery()) {
				if (res.next()) {
					if (productName.equals(res.getString(1))) {

						check = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}



}
