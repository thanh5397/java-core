package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factdetail")
public class FactDetailEntity extends BaseEntity  {
	
	private int quantity;
	private String category;
	
	@ManyToOne 
    @JoinColumn(name = "fact_id")
	private FactEntity fact;
	
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
	public FactEntity getFact() {
		return fact;
	}
	public void setFact(FactEntity fact) {
		this.fact = fact;
	}
}
