package com.phamvanthanh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phamvanthanh.dto.UserDTO;
import com.phamvanthanh.service.IUserService;

@RestController
public class LoginAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/api/login")
	public UserDTO login(@RequestBody UserDTO userDTO) {
		 UserDTO user = userService.findOne(userDTO);
		 return user;
	}
}
