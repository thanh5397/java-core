package com.phamvanthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.PortfolioDetailEntity;
import com.phamvanthanh.repository.PortfolioDetailRepository;
import com.phamvanthanh.service.IPortfolioDetailService;

@Service
public class PortfolioDetailServiceImpl implements IPortfolioDetailService {
	
	@Autowired
	private PortfolioDetailRepository portfolioDetailRepository;

	@Override
	public PortfolioDetailEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return portfolioDetailRepository.findOne(id);
	}

}
