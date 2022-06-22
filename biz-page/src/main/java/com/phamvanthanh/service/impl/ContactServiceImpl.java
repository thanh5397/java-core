package com.phamvanthanh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.converter.ContactConverter;
import com.phamvanthanh.dto.ContactDTO;
import com.phamvanthanh.entity.ContactEntity;
import com.phamvanthanh.repository.ContactRepository;
import com.phamvanthanh.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	ContactConverter contactConverter;

	@Override
	public List<ContactDTO> findAll() {
		ContactDTO contactDTO = new ContactDTO();
		List<ContactDTO> listContactDTO = new ArrayList<ContactDTO>();
		List<ContactEntity> listContactEntity = new ArrayList<ContactEntity>();
		listContactEntity = contactRepository.findAll();
		for (ContactEntity contactEntity : listContactEntity) {
			contactDTO = contactConverter.toDTO(contactEntity);
			listContactDTO.add(contactDTO);
		}
		return listContactDTO;
	}

	@Override
	public ContactDTO save(ContactDTO contactDTO) {
		ContactEntity oldContactEntity = contactRepository.findOneById(contactDTO.getId());
		ContactEntity contactEntity = new ContactEntity();
		contactEntity = contactConverter.toEntity(contactDTO,oldContactEntity);
		contactEntity = contactRepository.save(contactEntity);
		return contactConverter.toDTO(contactEntity);
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		int deletedRow;
		boolean deleteConfirm = false;
		try {
			deletedRow = contactRepository.deleteById(id);
			if(deletedRow > 0) {
				deleteConfirm = true;
			}
		} catch (Exception e) {
			deleteConfirm = false;
			throw e;
		}
		return deleteConfirm;
	}
}
