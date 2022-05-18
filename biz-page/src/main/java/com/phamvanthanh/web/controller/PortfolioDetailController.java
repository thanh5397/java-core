package com.phamvanthanh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phamvanthanh.service.IPortfolioDetailService;

@Controller
public class PortfolioDetailController {
	@Autowired
	private IPortfolioDetailService portfolioDetailService;
	
	@GetMapping(value= "/detail/{id}")
	public String getDetailPortfolio(@PathVariable(value="id",required = false) Long id,Model model) {
		try {
			model.addAttribute("detail", portfolioDetailService.findOne(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "portfolio-details";
	}
	
	@GetMapping(value= "/detail")
	public String showDetailPortfolio() {
		return "portfolio-details";
	}
}
