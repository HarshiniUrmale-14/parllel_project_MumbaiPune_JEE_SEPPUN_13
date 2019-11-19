package com.capgemini.collection.dao;

public interface Dao {
	public void viewproducts();

	public void seeCart(int userId);

	public void addToCart(int userId);

	public void deleteFormCart();

	public void placeOrder(int userId);

	public void viewOrder(int userId);

}// end of interface
