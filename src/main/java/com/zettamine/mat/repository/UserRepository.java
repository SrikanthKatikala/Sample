package com.zettamine.mat.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.mat.entity.User;


public interface UserRepository extends JpaRepository<User, Serializable> {

	List<User> findAllByActive(String active);
	
	Optional<User> findByUserName(String username);
	
	Optional<User> findByUserIdAndActive(Integer userId, String active);
	
	Optional<User> findByUserNameAndActive(String userName, String active);
	
	Optional<User> findByUserNameAndUserPasswordAndActive(String userName, String userPassword, String active);
}
