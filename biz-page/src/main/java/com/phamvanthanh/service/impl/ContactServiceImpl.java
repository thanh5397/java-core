package com.phamvanthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.phamvanthanh.entity.ContactEntity;
import com.phamvanthanh.repository.ContactRepository;
import com.phamvanthanh.service.IContactService;

public class ContactServiceImpl implements IContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public ContactEntity findFirst() {
		return contactRepository.findFirst();
	}

}
