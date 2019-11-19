package com.capgemini.hibernate.dao;

import java.util.List;

import com.capgemini.hibernate.beans.ProductBean;

public interface Dao {
	public List<ProductBean> getProducts();

}
