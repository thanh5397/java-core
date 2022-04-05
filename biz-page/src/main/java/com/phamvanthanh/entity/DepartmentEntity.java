package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
	
	@Column(name = "departmentname")
	private String departmentName;
	
	@ManyToMany
	@JoinTable(
	  name = "team_department", 
	  joinColumns = @JoinColumn(name = "department_id"), 
	  inverseJoinColumns = @JoinColumn(name = "team_id"))
	List<TeamEntity> linkedTeams;
	
	@ManyToMany
	@JoinTable(
	  name = "testimonial_department", 
	  joinColumns = @JoinColumn(name = "department_id"), 
	  inverseJoinColumns = @JoinColumn(name = "testimonialid"))
	List<TeamEntity> linkedTestimonial;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<TeamEntity> getLinkedTeams() {
		return linkedTeams;
	}

	public void setLinkedTeams(List<TeamEntity> linkedTeams) {
		this.linkedTeams = linkedTeams;
	}

	public List<TeamEntity> getLinkedTestimonial() {
		return linkedTestimonial;
	}

	public void setLinkedTestimonial(List<TeamEntity> linkedTestimonial) {
		this.linkedTestimonial = linkedTestimonial;
	}
}
