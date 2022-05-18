package com.phamvanthanh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phamvanthanh.service.IAboutService;
import com.phamvanthanh.service.ICategoryService;
import com.phamvanthanh.service.IClientService;
import com.phamvanthanh.service.IContactService;
import com.phamvanthanh.service.IFactService;
import com.phamvanthanh.service.IService;
import com.phamvanthanh.service.ISkillService;
import com.phamvanthanh.service.ITeamService;
import com.phamvanthanh.service.ITestimonialService;

@Controller
public class HomeController {
	
	@Autowired
	private IContactService contactService;
	
	@Autowired
	private ITeamService teamService;
	
	@Autowired
	private ITestimonialService testimonialService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IFactService factService;
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private IService service;
	
	@Autowired
	private IAboutService aboutService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping(value= "/home")
	public String showHome(Model model) {
		try {
			model.addAttribute("contacts", contactService.findAll());
			model.addAttribute("teams",teamService.findAll());
			model.addAttribute("testimonials",testimonialService.findAll());
			model.addAttribute("clients",clientService.findAll());
			model.addAttribute("facts",factService.findAll());
			model.addAttribute("skills",skillService.findAll());
			model.addAttribute("services",service.findAll());
			model.addAttribute("abouts",aboutService.findAll());
			model.addAttribute("categories",categoryService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
}
