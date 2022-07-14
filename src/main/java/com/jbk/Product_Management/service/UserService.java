package com.jbk.Product_Management.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.jbk.Product_Management.entity.User;

public interface UserService {

	public User loginProcess(User user);
	public boolean addUser(User user);
	public List<User> listOfUser();
	public boolean deleteUser(String username);
	public User profile(String username);
	public boolean updateUser(User user);
	public int[] uploadUserSheet(CommonsMultipartFile file,HttpSession session);
}
