package com.phamvanthanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phamvanthanh.entity.PortfolioDetailEntity;

public interface PortfolioDetailRepository extends JpaRepository<PortfolioDetailEntity, Long>  {
	PortfolioDetailEntity findOneById(Long id);
}
