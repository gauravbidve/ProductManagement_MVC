package com.jbk.Product_Management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.Product_Management.entity.User;
import com.jbk.Product_Management.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		
		boolean value = service.addUser(user);
		
		if(value) {
			return new ModelAndView("/addUser","msg","Added Succefully");
		} else {
			return new ModelAndView("/addUser","msg","Not Added, Try with Other Username");
		}
	}
	
	@GetMapping("/listOfUser")
	public ModelAndView listOfUser() {
		
		List<User> users = service.listOfUser();
		
		if(users.isEmpty()) {
			return new ModelAndView("/listOfUser","msg","No User Found");
		} else {
			return new ModelAndView("/listOfUser","userList",users);
		}
		
	}
	
	@GetMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam String username, Model model) {
		
		boolean value = service.deleteUser(username);
		List<User> users = service.listOfUser();
		
		if(value) {
			model.addAttribute("userList", users);
			return new ModelAndView("/listOfUser","msg","User Deleted!!!");
		} else {
			model.addAttribute("userList", users);
			return new ModelAndView("/listOfUser","msg","Not Deleted!!!");
		}
		
	}
	
	@GetMapping("/profile")
	public ModelAndView editUser(@RequestParam String username) {
	
		User user = service.profile(username);
		System.out.println(user);
		if(user!=null) {
			return new ModelAndView("/profile","user",user);
		} else {
			return new ModelAndView("/listOfUser","msg","Profile not found");
		}
		
	}
	
	@PostMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute User user) {
		
		boolean value = service.updateUser(user);
		
		if(value) {
			return new ModelAndView("/profile","msg","User Updated Successfully");
		} else {
			return new ModelAndView("/profile","msg","User not Updated");
		}
		
	}
	
	@PostMapping("/uploadUserSheet")
	public ModelAndView uploadUserSheet(@RequestParam CommonsMultipartFile file, HttpSession session) {
		int[] countArray = service.uploadUserSheet(file, session);
		String msg = "Added Users are " + countArray[0] + " & Count of Users which aren't added is " + countArray[1];
		return new ModelAndView("/importUser","msg",msg);
	}
}
