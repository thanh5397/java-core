package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "testimonial")
public class TestimonialEntity extends BaseEntity {
	
	private String avatar;
	private String name;
	@ManyToMany(mappedBy = "linkedTestimonial")
	List<DepartmentEntity> departments;
	private String comment;
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DepartmentEntity> getDepartments() {
		return departments;
	}
	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
