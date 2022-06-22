package com.phamvanthanh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.phamvanthanh.dto.PortfolioDetailDTO;
import com.phamvanthanh.service.IPortfolioDetailService;

@Controller
@SessionAttributes("data")
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
	public String showDetailPortfolio(HttpServletRequest request,Model model,@RequestBody PortfolioDetailDTO portfolioDetailDTO) {
//		PortfolioDetailDTO portfolioDetailDTO = (PortfolioDetailDTO) request.getSession().getAttribute("data");
		model.addAttribute("detail", portfolioDetailDTO);
		return "portfolio-details";
	}
}
