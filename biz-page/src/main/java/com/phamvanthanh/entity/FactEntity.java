package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fact")
public class FactEntity extends BaseEntity {

	private int quantity;
	private String category;
	private String image;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
