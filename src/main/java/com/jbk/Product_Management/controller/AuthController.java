package com.jbk.Product_Management.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.Product_Management.entity.User;
import com.jbk.Product_Management.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/login")
	public ModelAndView loginProcess(@ModelAttribute User user,HttpSession session) {
		
		User usr = service.loginProcess(user);
		//List<String> usernames = new ArrayList<>();

		if(usr!=null) {
			String username = usr.getUsername();
			String role = usr.getRole();
			//usernames.add(username);
			//String uname = "username"+usernames.size();
			//session.setAttribute("userList", usernames);
			session.setAttribute("username", username);
			session.setAttribute("role", role);
			return new ModelAndView("/home");
		} else {
			return new ModelAndView("/login","msg","Invalid Credentials");
		}
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(@ModelAttribute User user,HttpSession session) {
		
		session.invalidate();
		
		return new ModelAndView ("/login","msg","Logged Out Successfully");	
	}
}
