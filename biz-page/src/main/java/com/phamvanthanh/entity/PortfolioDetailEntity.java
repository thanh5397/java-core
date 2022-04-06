package com.phamvanthanh.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "portfoliodetail")
public class PortfolioDetailEntity extends BaseEntity {
	private String image;
	private String title;
	private String category;
	private String client;
	private Timestamp projectDate;
	private String projectURL;
	private String shortDescription;
	private String content;
	
}
