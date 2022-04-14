package com.phamvanthanh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class SkillEntity extends BaseEntity  {
	private String language;
	private int level;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
