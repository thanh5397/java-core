package com.phamvanthanh.converter;

import org.springframework.stereotype.Component;

import com.phamvanthanh.dto.PortfolioDetailDTO;
import com.phamvanthanh.entity.PortfolioDetailEntity;

@Component
public class PortfolioDetailConverter {
	public PortfolioDetailDTO toDTO(PortfolioDetailEntity portfolioDetailEntity) {
		PortfolioDetailDTO portfolioDetailDTO = new PortfolioDetailDTO();
		portfolioDetailDTO.setClient(portfolioDetailEntity.getClient());
		return portfolioDetailDTO;
	}
	
	public PortfolioDetailEntity toUserEntity(PortfolioDetailDTO portfolioDetailDTO) {
		PortfolioDetailEntity portfolioDetailEntity = new PortfolioDetailEntity();
		portfolioDetailEntity.setClient(portfolioDetailDTO.getClient());
		return portfolioDetailEntity;
	}
}
