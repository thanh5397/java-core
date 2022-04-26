package com.phamvanthanh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class SkillEntity extends BaseEntity  {
	private String language;
	private int level;
	@Column(name = "progressbarcolor")
	private String progressBarColor;
	
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
	public String getProgressBarColor() {
		return progressBarColor;
	}
	public void setProgressBarColor(String progressBarColor) {
		this.progressBarColor = progressBarColor;
	}	
}
