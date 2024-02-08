package com.zettamine.mat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zettamine.mat.entity.User;
import com.zettamine.mat.service.UserServiceImpl;

@Controller
@RequestMapping(path="/app")
public class LoginController {

	private UserServiceImpl userService;
	
	    public LoginController(UserServiceImpl userService) {
		this.userService = userService;
	    }

	    
	    @GetMapping(path="/login")
	    public String showForm(Model model) {
	        model.addAttribute("user", new User());
	        return "login"; 
	    }

	    @PostMapping(path="loginToApp")
	    public String processForm(User user, Model model) {
	    	
	    	User exsistUser = userService.getUserByUsernameAndActive(user.getUserName());
	        if (exsistUser!=null) {
				if (exsistUser.getUserPassword().equals(user.getUserPassword())) {
					model.addAttribute("loginUser",exsistUser);
					return "redirect:/user/home";
				}
				model.addAttribute("msg", " Invalid password ");
				return "redirect:/login"; 
			}
	        model.addAttribute("msg", "No user found with this user name");
	        return "redirect:/login"; 
	    }
		
}
