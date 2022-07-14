package com.jbk.Product_Management.dao;

import java.util.List;

import com.jbk.Product_Management.entity.Product;

public interface ProductDao {

	public boolean addProduct(Product product);
	public List<Product> listOfProduct();
	public Product editProduct(String productId);
	public boolean upadateProduct(Product product);
	public boolean deleteProduct(String productId);
}
