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

import com.capgemini.jdbc.bean.CartBean;
import com.capgemini.jdbc.bean.ProductBean;
import com.capgemini.jdbc.factory.Factory;
import com.capgemini.jdbc.validation.CustomValidationDao;
import com.capgemini.jdbc.validation.ValidationDao;

public class UserDaoImpl implements UserDao {
	FileReader reader;
	Properties properties;
	Scanner scanner = new Scanner(System.in);

	public UserDaoImpl() {
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
	public int userLogin(String emailId, String password) {
		int uid = 0;
		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("query2"))) {

			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);

			try (ResultSet res = preparedStatement.executeQuery()) {
				if (res.next()) {

					System.out.println("id =" + res.getInt(1));
					uid = res.getInt(1);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return uid;
	}

	@Override
	public void userRegistration(String emailId, String password, String mobileNo) {

		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("query10"))) {

			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, mobileNo);

			int count = preparedStatement.executeUpdate();
			if (count != 0) {
				System.out.println("REGISTRATION DONE SUCCESSFULLY");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(int userId) {
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		ValidationDao vali = Factory.getValImplInstance();

		System.out.println("ENTER 1 TO CHANGE THE EMAIL");
		System.out.println("ENTER 2 TO CHANGE THE PASSWORD");
		System.out.println("ENTER 3 TO CHANGE THE PHONENO");
		String button = scanner.nextLine();
		switch (button) {
		case "1":
			while (true) {
				System.out.println("ENTER EMAILID");
				String emailId = scanner.nextLine();
				if (vali.validationEmail(emailId)) {
					if (!customVali.checkUserEmail(emailId)) {
						try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
								properties.getProperty("user"), properties.getProperty("password"));
								PreparedStatement pstmt = connection
										.prepareStatement(properties.getProperty("query11"))) {

							pstmt.setString(1, emailId);
							pstmt.setInt(2, userId);

							int count = pstmt.executeUpdate();
							if (count > 0) {
								System.out.println("USER PROFILE UPDATED");
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						System.err.println("EMAILID ALREADY EXIST");
					}
				} else {
					System.err.println("EMAIL ID IS NOT VALID");
				}

			}
			break;

		case "2":
			while (true) {
				System.out.println("ENTER PASSWORD");
				String password = scanner.nextLine();
				if (vali.validationPassword(password)) {
					try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
							properties.getProperty("user"), properties.getProperty("password"));
							PreparedStatement pstmt = connection.prepareStatement(properties.getProperty("query12"))) {

						pstmt.setString(1, password);
						pstmt.setInt(2, userId);

						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("USER PROFILE UPDATED");
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.err.println("ENTER VALID PASSWORD");
				}

			}

		case "3":
			while (true) {
				System.out.println("ENTER THE PHONE NO");
				String mobileNo = scanner.nextLine();
				if (vali.validationMobileNo(mobileNo)) {
					try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"),
							properties.getProperty("user"), properties.getProperty("password"));
							PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query24"))) {

						pstmt.setString(1, mobileNo);
						pstmt.setInt(2, userId);

						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("USER PROFILE UPDATED");
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.err.println("ENTER 10 DIGITS ONLY ");

				}

			}
			break;

		default:
			System.out.println("ENTER NUMBER BETWEEN 1 TO 3");

		}
	}

	@Override
	public void addToCart(int userId) {
		CustomValidationDao customVali = Factory.getCustomValImplInstance();
		String emailId = null;
		String pName = null;
		String pCategory = null;

		int pId = 0;
		double pPrice = 0;
		int count = 0;
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query14"))) {

			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				System.out.println("emailid" + res.getString(1));
				System.out.println("uid" + userId);
				emailId = res.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao dao1 = Factory.getDAOImplInstance();

		while (true) {
			System.out.println("ENTER THE PRODUCT NAME TO BE ADDED TO THE CART");
			pName = scanner.nextLine();
			if (customVali.checkProductName(pName)) {
				try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
						properties.getProperty("user"), properties.getProperty("password"));
						PreparedStatement pstmt = connection.prepareStatement(properties.getProperty("query15"))) {

					pstmt.setString(1, pName);
					try (ResultSet res1 = pstmt.executeQuery()) {
						if (res1.next()) {
							System.out.println("pcategory" + res1.getString(1));
							System.out.println("pid" + res1.getInt(2));
							System.out.println("pprice" + res1.getDouble(3));
							System.out.println("pQuantity" + res1.getInt(4));
							pCategory = res1.getString(1);
							pId = res1.getInt(2);
							pPrice = res1.getDouble(3);
							System.out.println("ENTER THE NO QUANTITY OF THE SELECTED PRODUCT");
							int quantity = Integer.parseInt(scanner.nextLine());
							if (customVali.checkProductQuantity(pName, quantity)) {
								try (Connection conn1 = DriverManager.getConnection(properties.getProperty("dbUrl"),
										properties.getProperty("user"), properties.getProperty("password"));
										PreparedStatement pstmt1 = conn1
												.prepareStatement(properties.getProperty("query16"))) {

									pstmt1.setInt(1, userId);
									pstmt1.setInt(2, pId);
									pstmt1.setString(3, emailId);
									pstmt1.setString(4, pCategory);
									pstmt1.setString(5, pName);
									pstmt1.setDouble(6, pPrice);
									pstmt1.setInt(7, quantity);
									count = pstmt1.executeUpdate();
									if (count != 0) {
										System.out.println("PRODUCT IS ADDED TO THE CART");
										break;
									}

								} catch (Exception e) {
									e.printStackTrace();
								}

							} else {
								System.err.println("PRODUCT IS OUT OF STOCK");
							}

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				System.err.println("ENTERED PRODUCT DOES NOT EXIST");
			}

		}

	}

	@Override
	public void payment(int userId) {
		int count = 0;

		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("query18"))) {

			preparedStatement.setInt(1, userId);
			try (ResultSet ressultList = preparedStatement.executeQuery()) {
				if (ressultList.next()) {
					System.out.println("total price is" + ressultList.getDouble(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int deleteFromCart(String productName, int userId) {
		int count = 0;

		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("query17"))) {
			preparedStatement.setString(1, productName);
			preparedStatement.setInt(2, userId);

			count = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	@Override
	public void sendRequest(int userId) {
		String getEmailId = null;
		String msg = null;
		int count = 0;
		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement perparedStement = connection.prepareStatement(properties.getProperty("query19"))) {

			perparedStement.setInt(1, userId);

			try (ResultSet res = perparedStement.executeQuery()) {
				if (res.next()) {
					System.out.println("EMAILID IS" + res.getString(1));
					System.out.println("USER ID IS" + userId);
					getEmailId = res.getString(1);

				}
				System.out.println("ENTER THE MESSAGE TO BE SENT");
				msg = scanner.nextLine();
				try (Connection connection1 = DriverManager.getConnection(properties.getProperty("dbUrl"),
						properties.getProperty("user"), properties.getProperty("password"));
						PreparedStatement preparedStatement = connection1
								.prepareStatement(properties.getProperty("query20"))) {
					preparedStatement.setInt(1, userId);
					preparedStatement.setString(2, getEmailId);
					preparedStatement.setString(3, msg);

					count = preparedStatement.executeUpdate();
					if (count > 0) {
						System.out.println("DATA IS INSERTED");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void seeReply(int userId) {
		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				PreparedStatement preparedStatement = connection.prepareStatement(properties.getProperty("query21"))) {
			preparedStatement.setInt(1, userId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					System.out.println("MESSAGE IS" + resultSet.getString(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CartBean> seeCart(int userId) {
		List<CartBean> cartList = new ArrayList<CartBean>();
		try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
				properties.getProperty("user"), properties.getProperty("password"));
				Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(properties.getProperty("query32"))) {
				while (resultSet.next()) {
					CartBean cartBean = new CartBean();
					cartBean.setCartId(resultSet.getInt(1));
					cartBean.setUserId(resultSet.getInt(2));
					cartBean.setProductId(resultSet.getInt(3));
					cartBean.setEmailId(resultSet.getString(4));
					cartBean.setProductCategory(resultSet.getString(5));
					cartBean.setProductName(resultSet.getString(6));
					cartBean.setProductPrice(resultSet.getDouble(7));
					cartBean.setQuantity(resultSet.getInt(8));
					cartList.add(cartBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

}
