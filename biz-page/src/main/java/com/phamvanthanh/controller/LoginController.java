package com.phamvanthanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phamvanthanh.dto.UserDTO;
import com.phamvanthanh.service.IUserService;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value= "/login")
	public String showLogin() {
		return "index";
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String userName,@RequestParam("password") String password) {
		 UserDTO user = userService.findOneByUserName(userName);
//		 if(user != null) {
//			 return "redirect:/home";
//		 } else {
//			 return "index";
//		 }
		 return "redirect:/home";
	}
}
