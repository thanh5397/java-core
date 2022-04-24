package com.phamvanthanh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class TeamEntity extends BaseEntity{
	
	private String name;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	List<MemberEntity> members;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(List<MemberEntity> members) {
		this.members = members;
	}
}
