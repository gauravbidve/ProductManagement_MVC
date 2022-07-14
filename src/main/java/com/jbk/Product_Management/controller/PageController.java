package com.jbk.Product_Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String indexPage() {
		System.out.println(111);
		return "/login";
	}
	
	@GetMapping("/homePage")
	public String homePage() {
		return "/home";
	}
	
	@GetMapping("/addUserPage")
	public String addUserPage() {
		
		return "/addUser";
	}
	
	@GetMapping("/addProductPage")
	public String addProductPage() {
		return "/addProduct";
	}
	
	@GetMapping("/importUserPage")
	public String inportUserPage() {
		return "/importUser";
	}
	
}
