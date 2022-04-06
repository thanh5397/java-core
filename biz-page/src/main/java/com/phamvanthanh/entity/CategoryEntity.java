package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	@Column(name = "categoryname")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<PortfolioEntity> portfolios; 

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<PortfolioEntity> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<PortfolioEntity> portfolios) {
		this.portfolios = portfolios;
	}
}
