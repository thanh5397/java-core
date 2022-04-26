package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity extends BaseEntity  {
	private String avatar;
	private String name;
	
	@ManyToOne 
    @JoinColumn(name = "team_id")
	private TeamEntity team;
	@ManyToOne 
    @JoinColumn(name = "testimonial_id")
	private TestimonialEntity testimonial;
	
	@ManyToOne 
    @JoinColumn(name = "department_id")
	private DepartmentEntity department;
	
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
	public TeamEntity getTeam() {
		return team;
	}
	public void setTeam(TeamEntity team) {
		this.team = team;
	}
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
}
