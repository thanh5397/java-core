package com.phamvanthanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phamvanthanh.service.IContactService;

@Controller
public class HomeController {
	
	@Autowired
	private IContactService contactService;
	
	@GetMapping(value= "/home")
	public String showHome(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "home";
	}
}
