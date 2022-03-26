package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewEntity extends BaseEntity {

	@Column
	private String title;
	@Column
	private String thumbnail;
	@Column
	private String shortDescription;
	@Column
	private String content;
}
