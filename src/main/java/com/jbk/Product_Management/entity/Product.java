package com.jbk.Product_Management.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date productExpiryDate;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, String productPrice, Date productExpiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpiryDate = productExpiryDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(Date productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productExpiryDate=" + productExpiryDate + "]";
	}

}
