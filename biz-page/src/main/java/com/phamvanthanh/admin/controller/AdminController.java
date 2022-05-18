package com.phamvanthanh.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/admin")
@Controller
public class AdminController {
	@GetMapping(value= "/home")
	public String showHome(Model model) {
		return "/admin/admin";
	}
}
