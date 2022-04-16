package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.ContactEntity;
import com.phamvanthanh.repository.ContactRepository;
import com.phamvanthanh.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<ContactEntity> findAll() {
		return contactRepository.findAll();
	}

	

}
