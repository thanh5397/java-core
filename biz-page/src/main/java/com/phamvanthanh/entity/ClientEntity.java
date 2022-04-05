package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity{
	private String name;
	private String image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
