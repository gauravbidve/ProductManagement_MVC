package com.jbk.Product_Management.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.Product_Management.entity.Product;
import com.jbk.Product_Management.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(
	        dateFormat, false));
	}
	
	@PostMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		
		boolean value = service.addProduct(product);
		
		if(value) {
			return new ModelAndView("/addProduct","msg","Product Added Successfully");
		} else {
			return new ModelAndView("/addProduct","msg","Product Not Added, Something went wrong!!!");
		}	
	}
	
	@GetMapping("/listOfProduct")
	public ModelAndView listOfProduct() {
		
		List<Product> products = service.listOfProduct();
		
		if(!products.isEmpty()) {
			return new ModelAndView("/listOfProduct","products",products);
		} else {
			return new ModelAndView("/listOfProduct","msg","No Products are available");
		}
		
	}
	
	@GetMapping("/editProduct")
	public ModelAndView editProduct(@RequestParam String productId) {
		
		Product product = service.editProduct(productId);
		
		if(product!=null) {
			return new ModelAndView("/updateProduct","product",product);
		} else {
			return new ModelAndView("/listOfProduct","msg","Something went wrong!!!");
		}	
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute Product product,Model model) {
		
		boolean value = service.upadateProduct(product);
		
		if(value) {
			model.addAttribute("product", product);
			return new ModelAndView("/updateProduct","msg","Product Updated Sucessfully");
		} else {
			model.addAttribute("product", product);
			return new ModelAndView("/updateProduct","msg","Product Not updated, Possibely Product name already exists!!!");
		}
		
	}
	
	@GetMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam String productId, Model model) {
		
		boolean value = service.deleteProduct(productId);
		List<Product> products = service.listOfProduct();
		
		if(value) {
			model.addAttribute("products",products);
			return new ModelAndView("/listOfProduct","msg","Product Deleted Sucessfully");
		} else {
			model.addAttribute("products",products);
			return new ModelAndView("/listOfProduct","msg","Product Not deleted, Something went wrong!!!");
		}
	}
}
