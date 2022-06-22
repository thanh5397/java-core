package com.phamvanthanh.service;

import java.util.List;

import com.phamvanthanh.dto.ContactDTO;

public interface IContactService {
	List<ContactDTO> findAll();
	ContactDTO save(ContactDTO contactDTO);
}
