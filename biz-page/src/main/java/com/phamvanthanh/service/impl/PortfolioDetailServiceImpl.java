package com.phamvanthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.converter.PortfolioDetailConverter;
import com.phamvanthanh.dto.PortfolioDetailDTO;
import com.phamvanthanh.entity.PortfolioDetailEntity;
import com.phamvanthanh.repository.PortfolioDetailRepository;
import com.phamvanthanh.service.IPortfolioDetailService;

@Service
public class PortfolioDetailServiceImpl implements IPortfolioDetailService {
	
	@Autowired
	private PortfolioDetailRepository portfolioDetailRepository;
	
	@Autowired
	private PortfolioDetailConverter portfolioDetailConverter;

	@Override
	public PortfolioDetailDTO findOne(Long id) {
		PortfolioDetailDTO portfolioDetailDTO = new PortfolioDetailDTO();
		PortfolioDetailEntity portfolioDetailEntity = new PortfolioDetailEntity();
		portfolioDetailEntity = portfolioDetailRepository.findOneById(id);
		portfolioDetailDTO = portfolioDetailConverter.toDTO(portfolioDetailEntity);
		return portfolioDetailDTO;
	}

}
