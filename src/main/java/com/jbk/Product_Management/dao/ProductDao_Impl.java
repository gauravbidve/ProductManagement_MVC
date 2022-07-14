package com.jbk.Product_Management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Product_Management.entity.Product;

@Repository
public class ProductDao_Impl implements ProductDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addProduct(Product product) {

		Session session = null;
		boolean value = false;

		try {
			session = sf.openSession();
			Product prd = session.get(Product.class, product.getProductId());
			
			if (prd == null) {
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				value = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return value;
	}

	@Override
	public List<Product> listOfProduct() {

		Session session = null;
		List<Product> products = new ArrayList<>();

		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return products;
	}

	@Override
	public Product editProduct(String productId) {

		Session session = null;
		Product product = null;

		try {
			session = sf.openSession();
			product = session.get(Product.class, productId);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public boolean upadateProduct(Product product) {

		Session session = null;
		boolean value = false;

		try {
			    session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				session.update(product);
				transaction.commit();
				value = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return value;
	}

	@Override
	public boolean deleteProduct(String productId) {

		Session session = null;
		boolean value = false;

		try {
			session = sf.openSession();
			Product product = session.get(Product.class, productId);
			Transaction transaction = session.beginTransaction();
			session.delete(product);
			transaction.commit();
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return value;
	}

}
