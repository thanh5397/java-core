package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
	
	@Column(name = "departmentname")
	private String departmentName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<MemberEntity> members;
	

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(List<MemberEntity> members) {
		this.members = members;
	}
	
	
}
