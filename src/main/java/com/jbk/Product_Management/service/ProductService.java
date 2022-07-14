package com.jbk.Product_Management.service;

import java.util.List;

import com.jbk.Product_Management.entity.Product;

public interface ProductService {

	public boolean addProduct(Product product);
	public List<Product> listOfProduct();
	public Product editProduct(String productId);
	public boolean upadateProduct(Product product);
	public boolean deleteProduct(String productId);
}
