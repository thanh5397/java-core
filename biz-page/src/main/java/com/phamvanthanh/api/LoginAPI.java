package com.phamvanthanh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phamvanthanh.dto.UserDTO;
import com.phamvanthanh.service.IUserService;

@RestController
@RequestMapping(value= "/api")
public class LoginAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/login")
	public String login(@RequestBody UserDTO userDTO) {
		 UserDTO user = userService.findOneByUserName(userDTO.getUserName());
		 if(user != null) {
			 return "redirect:/home";
		 } else {
			 return "index";
		 }
	}
}
