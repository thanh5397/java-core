package com.phamvanthanh.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phamvanthanh.service.IContactService;

@RequestMapping(value="/admin")
@Controller
public class ContactAdminController {
	
	@Autowired
	private IContactService contactService;
	
	@GetMapping(value= "/contact")
	public String showContact(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "/admin/contact";
	}
	
}
