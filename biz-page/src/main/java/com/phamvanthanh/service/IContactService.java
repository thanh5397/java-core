package com.phamvanthanh.service;

import java.util.List;

import com.phamvanthanh.entity.ContactEntity;

public interface IContactService {
	List<ContactEntity> findAll();
}
