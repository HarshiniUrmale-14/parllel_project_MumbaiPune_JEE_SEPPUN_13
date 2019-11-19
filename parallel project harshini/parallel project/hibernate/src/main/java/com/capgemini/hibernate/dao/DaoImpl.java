package com.capgemini.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.beans.ProductBean;

public class DaoImpl implements Dao {
	

	@Override
	public List<ProductBean> getProducts() {
		EntityManagerFactory entityMangerFactory=Persistence.createEntityManagerFactory("medicine");

		EntityManager manager = entityMangerFactory.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);

		List<ProductBean> productList = null;
		try {
			productList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;

	}

}
