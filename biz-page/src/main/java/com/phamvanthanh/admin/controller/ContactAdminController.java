package com.phamvanthanh.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/admin")
@Controller
public class ContactAdminController {
	@GetMapping(value= "/contact")
	public String showContact(Model model) {
		return "/admin/contact";
	}
}
