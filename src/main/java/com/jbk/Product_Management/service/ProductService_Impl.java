package com.jbk.Product_Management.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Product_Management.dao.ProductDao;
import com.jbk.Product_Management.entity.Product;

@Service
public class ProductService_Impl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public boolean addProduct(Product product) {
		String productId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		product.setProductId(productId);
		boolean value = dao.addProduct(product);
		return value;
	}

	@Override
	public List<Product> listOfProduct() {
		List<Product> products= dao.listOfProduct();
		return products;
	}

	@Override
	public Product editProduct(String productId) {
		Product product = dao.editProduct(productId);
		return product;
	}

	@Override
	public boolean upadateProduct(Product product) {
		boolean value=dao.upadateProduct(product);
		return value;
	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean value = dao.deleteProduct(productId);
		return value;
	}

}
