package com.phamvanthanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping(value= "/login")
	public String showLogin() {
		return "index";
	}
}
