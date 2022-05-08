package com.phamvanthanh.dto;

import java.sql.Timestamp;

public class PortfolioDetailDTO extends AbstractDTO<PortfolioDetailDTO> {
	private String image;
	private String title;
	private String category;
	private String client;
	private Timestamp projectDate;
	private String projectURL;
	private String shortDescription;
	private String content;
	
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
}
