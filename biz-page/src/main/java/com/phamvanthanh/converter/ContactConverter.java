package com.phamvanthanh.converter;

import org.springframework.stereotype.Component;

import com.phamvanthanh.dto.ContactDTO;
import com.phamvanthanh.entity.ContactEntity;

@Component
public class ContactConverter {
	public ContactDTO toDTO(ContactEntity contactEntity) {
		ContactDTO contactDTO = new ContactDTO();
		if(contactEntity.getId() != null) {
			contactDTO.setId(contactEntity.getId());
		}
		contactDTO.setAddress(contactEntity.getAddress());
		contactDTO.setEmail(contactEntity.getEmail());
		contactDTO.setPhoneNumber(contactEntity.getPhoneNumber());
		return contactDTO;
	}
	
	public ContactEntity toEntity(ContactDTO contactDTO) {
		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setAddress(contactDTO.getAddress());
		contactEntity.setEmail(contactDTO.getEmail());
		contactEntity.setPhoneNumber(contactDTO.getPhoneNumber());
		return contactEntity;
	}
	public ContactEntity toEntity(ContactDTO contactDTO,ContactEntity contactEntity) {
		contactEntity.setAddress(contactDTO.getAddress());
		contactEntity.setEmail(contactDTO.getEmail());
		contactEntity.setPhoneNumber(contactDTO.getPhoneNumber());
		return contactEntity;
	}
}
