package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column
	private String userName;
	@Column
	private String fullName;
	@Column
	private String password;
	@Column
	private int status;
}
