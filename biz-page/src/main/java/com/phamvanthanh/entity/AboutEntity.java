package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "about")
public class AboutEntity extends BaseEntity {
	private String name;
	private String description;
	private String image;
	private String icon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
