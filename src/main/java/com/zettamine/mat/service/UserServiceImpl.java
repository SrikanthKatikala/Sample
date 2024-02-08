package com.zettamine.mat.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.User;
import com.zettamine.mat.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	
	private String uname;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isPresent()) {
			User user = optUser.get();
			return user;
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepo.findAllByActive("active");
		return allUsers;
	}

	@Override
	public boolean saveUser(User user) {
		User save = userRepo.save(user);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean chechUserExists(Integer id) {
		Optional<User> optUser = userRepo.findByUserIdAndActive(id, "active");
		if (optUser.isPresent()) {
			User user = optUser.get();
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		Optional<User> optUser = userRepo.findByUserName(username);
		if (optUser.isPresent()) {
			User user = optUser.get();
			return user;
		}
		return null;
	}

	@Override
	public User getUserByUsernameAndActive(String username) {
		
		Optional<User> optUser = userRepo.findByUserNameAndActive(username, "active");
		if (optUser.isPresent()) {
			uname=username;
			User user = optUser.get();
			return user;
		}
		return null;
	}
	
	public User getUser() {
		User user = getUserByUsernameAndActive(uname);
		return user;
	}
}
