package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.User;

public interface UserService {
	
	User getUserById(Integer id);
	User getUserByUsername(String username);
	List<User> getAllUsers();
	boolean saveUser(User user);
	boolean updateUser(User user, Integer id);
	boolean deleteUserById(Integer id);
	boolean chechUserExists(Integer id);
	
	User getUserByUsernameAndActive(String username);
}
