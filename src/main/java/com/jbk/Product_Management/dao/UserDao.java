package com.jbk.Product_Management.dao;

import java.util.List;

import com.jbk.Product_Management.entity.User;

public interface UserDao {

	public User loginProcess(User user);
	public boolean addUser(User user);
	public List<User> listOfUser();
	public boolean deleteUser(String username);
	public User profile(String username);
	public boolean updateUser(User user);
	public int[] insertUsers(List<User> list);
}
