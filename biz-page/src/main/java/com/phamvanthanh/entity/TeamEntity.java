package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class TeamEntity extends BaseEntity{
	
	private String name;
	@Column(name = "departmentname")
	private String departmentName;
	
	@ManyToMany(mappedBy = "linkedTeams")
	List<DepartmentEntity> departments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}
	
	
}
