package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.Factory;
import com.capgemini.jdbc.validation.CustomValidationDao;

public class AdminDaoImpl implements AdminDao {
	FileReader reader;
	Properties properties;
	Scanner scanner = new Scanner(System.in);

	public AdminDaoImpl() {
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
	public int adminLogin(String emailId, String password) {
		int id = 0;
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query3"))) {
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			try (ResultSet res = preparedStatement.executeQuery()) {
				if (res.next()) {
					System.out.println("id =" + res.getInt(1));
					id = res.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int insertProduct(String productCategory, String productName, Double productPrice, int productQuantity) {
		int count = 0;
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query4"))) {
			preparedStatement.setString(1, productCategory);
			preparedStatement.setString(2, productName);
			preparedStatement.setDouble(3, productPrice);
			preparedStatement.setInt(4, productQuantity);
			count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("DATA INSERTED");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteProduct(int productId) {
		int count = 0;
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query5"))) {
			preparedStatement.setInt(1, productId);
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void updateProduct(int productId) {
		System.out.println("ENTER 1 TO UPDATE THE CATEGORY");
		System.out.println("ENTER 2 TO UPDATE THE NAME");
		System.out.println("ENTER 3 TO UPDATE THE PRICE");
		System.out.println("enter 4 TO UPDATE THE QUANTITY ");
		String button = scanner.nextLine();
		switch (button) {
		case "1": {
			System.out.println("ENTER CATEGORY");
			String category = scanner.nextLine();
			try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
					properties.getProperty("user"), properties.getProperty("password"));
					PreparedStatement preparedStatement = connnection
							.prepareStatement(properties.getProperty("query6"))) {
				preparedStatement.setString(1, category);
				preparedStatement.setInt(2, productId);
				int count = preparedStatement.executeUpdate();
				if (count > 0) {
					System.out.println("PRODUCT CATEGORY UPDATED");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case "2": {
			System.out.println("ENTER NAME");
			String name = scanner.nextLine();
			try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
					properties.getProperty("user"), properties.getProperty("password"));
					PreparedStatement preparedStatement = connnection
							.prepareStatement(properties.getProperty("query7"))) {
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, productId);
				int count = preparedStatement.executeUpdate();
				if (count > 0) {
					System.out.println("PRODUCT NAME UPDATED");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			break;
		case "3": {
			try {
				System.out.println("ENTER PRICE");
				double price = Double.parseDouble(scanner.nextLine());
				try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
						properties.getProperty("user"), properties.getProperty("password"));
						PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query8"))) {
					preparedStatement.setDouble(1, price);
					preparedStatement.setInt(2, productId);
					int count = preparedStatement.executeUpdate();
					if (count > 0) {
						System.out.println("PRODUCT PRICE UPDATED");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException e) {
				System.out.println("ENTER ONLY NUMBER");
			}
		}
			break;
		case "4": {

			try {
				System.out.println("ENTER QUANTITY");
				String quantity = scanner.nextLine();
				try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
						properties.getProperty("user"), properties.getProperty("password"));
						PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query9"))) {
                    preparedStatement.setString(1, quantity);
					preparedStatement.setInt(2, productId);
					int count = preparedStatement.executeUpdate();
					if (count > 0) {
						System.out.println("PRODUCT QUANTITY UPDATED");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (NumberFormatException e) {
				System.out.println("ENTER ONLY NUMBER");
			}

		}
			break;
		default: {
			System.out.println("ENTER ONLY BUTTON BETWEEN 1 TO 4");
		}
		}
}

	@Override
	public List<UserBean> getUsers() {
		List<UserBean> userlist = new ArrayList<UserBean>();
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				Statement statement = connnection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(properties.getProperty("query25"))) {
				while (resultSet.next()) {
					UserBean user = new UserBean();
					user.setUserId(resultSet.getInt(1));
					user.setEmailId(resultSet.getString(2));
					user.setMobileNo(resultSet.getString(3));
					userlist.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}

	@Override
	public int deleteUser(int userId) {
		int count = 0;
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query13"))) {
			preparedStatement.setInt(1, userId);
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public void sendReply() {
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		String getEmailId = null;
		String message = null;
		int count = 0;
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connnection.prepareStatement(properties.getProperty("query19"))) {
			try {
				System.out.println("ENTER THE USER ID");
				int userId = Integer.parseInt(scanner.nextLine());

				if (customVali.checkUserId(userId)) {
					preparedStatement.setInt(1, userId);
					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						while (resultSet.next()) {
							System.out.println("EMAILID IS" + resultSet.getString(1));
							System.out.println("USER ID IS" + userId);
							getEmailId = resultSet.getString(1);
						}
						System.out.println("ENTER THE MESSAGE TO BE SENT");
						message = scanner.nextLine();
						try (Connection connection1 = DriverManager.getConnection(properties.getProperty("dbUrl"),
								properties.getProperty("user"), properties.getProperty("password"));
								PreparedStatement preparedStatement1 = connection1.prepareStatement(properties.getProperty("query23"))) {
							preparedStatement1.setInt(1, userId);
							preparedStatement1.setString(2, getEmailId);
							preparedStatement1.setString(3, message);
							count = preparedStatement1.executeUpdate();
							if (count > 0) {
								System.out.println("DATA IS INSERTED");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.err.println("USER ID DOES NOT EXIST");
				}
			} catch (NumberFormatException e) {
				System.err.println("ENTER NUMBER ONLY");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void seeRequest() {
		try (Connection connnection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				Statement statement = connnection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(properties.getProperty("query22"))) {
				while (resultSet.next()) {
					System.out.println("MESSAGE ID IS" + resultSet.getInt(1));
					System.out.println("USER ID IS" + resultSet.getInt(2));
					System.out.println("EMAILID IS" + resultSet.getString(3));
					System.out.println("MESSAGE  IS" + resultSet.getString(4));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
