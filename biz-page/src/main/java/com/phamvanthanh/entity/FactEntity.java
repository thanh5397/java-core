package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fact")
public class FactEntity extends BaseEntity {

	private String comment;
	private String image;
	
	@OneToMany(mappedBy = "fact", cascade = CascadeType.ALL)
	private List<FactDetailEntity> factDetails;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<FactDetailEntity> getFactDetails() {
		return factDetails;
	}
	public void setFactDetails(List<FactDetailEntity> factDetails) {
		this.factDetails = factDetails;
	}
	
	
}
