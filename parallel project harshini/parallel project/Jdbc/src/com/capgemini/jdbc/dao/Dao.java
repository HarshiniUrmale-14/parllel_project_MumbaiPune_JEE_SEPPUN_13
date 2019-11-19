package com.capgemini.jdbc.dao;

import java.util.List;

import com.capgemini.jdbc.bean.ProductBean;
import com.capgemini.jdbc.bean.ReplyBean;
import com.capgemini.jdbc.bean.RequestBean;

public interface Dao {
	public List<ProductBean> getProducts();

	
	}
