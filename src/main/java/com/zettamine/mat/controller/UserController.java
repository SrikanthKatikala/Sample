package com.zettamine.mat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zettamine.mat.entity.User;
import com.zettamine.mat.service.UserServiceImpl;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	private UserServiceImpl userService;
	
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping(path="/home")
	public String showHomePage() {
		return "home";
	}

}
