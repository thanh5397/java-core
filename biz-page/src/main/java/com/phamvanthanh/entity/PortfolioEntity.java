package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class PortfolioEntity extends BaseEntity {
	private String image;
	private String name;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@OneToOne(mappedBy = "portfolio")
    private PortfolioDetailEntity portfolioDetail;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public PortfolioDetailEntity getPortfolioDetail() {
		return portfolioDetail;
	}
	public void setPortfolioDetail(PortfolioDetailEntity portfolioDetail) {
		this.portfolioDetail = portfolioDetail;
	}
}
