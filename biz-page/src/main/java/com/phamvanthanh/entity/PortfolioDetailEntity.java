package com.phamvanthanh.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "portfoliodetail")
public class PortfolioDetailEntity extends BaseEntity {
	private String image;
	private String title;
	private String category;
	private String client;
	@Column(name = "projectdate")
	private Timestamp projectDate;
	private String projectURL;
	@Column(name = "shortdescription")
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String content;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id")
    private PortfolioEntity portfolio;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Timestamp getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(Timestamp projectDate) {
		this.projectDate = projectDate;
	}
	public String getProjectURL() {
		return projectURL;
	}
	public void setProjectURL(String projectURL) {
		this.projectURL = projectURL;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PortfolioEntity getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(PortfolioEntity portfolio) {
		this.portfolio = portfolio;
	}
}
