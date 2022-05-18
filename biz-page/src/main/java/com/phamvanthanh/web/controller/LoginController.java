package com.phamvanthanh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@PostMapping(value = "/loginProcess",produces=MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody UserDTO userDTO) {
		 UserDTO user = userService.findOneByUserName(userDTO.getUserName());
		 if(user != null) {
			 return "redirect:/home";
		 } else {
			 return "login";
		 }
	}
}
