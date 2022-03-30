package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toNewEntity(NewDTO newDTO) {
		NewEntity entity = new NewEntity();
		entity.setTitle(newDTO.getTitle());
		entity.setContent(newDTO.getContent());
		entity.setShortDescription(newDTO.getShortDescription());
		entity.setThumbnail(newDTO.getThumbnail());
		return entity;
	}
	
	public NewDTO toNewDTO(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		if(newEntity.getId() != null) {
			newDTO.setId(newEntity.getId());
		}
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setContent(newEntity.getContent());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setCreatedDate(newEntity.getCreatedDate());
		newDTO.setCreatedBy(newEntity.getCreatedBy());
		newDTO.setModifiedDate(newEntity.getModifiedDate());
		newDTO.setModifiedBy(newEntity.getModifiedBy());
		return newDTO;
	}
	
	public NewEntity toNewEntity(NewDTO newDTO,NewEntity newEntity) {
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setContent(newDTO.getContent());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setThumbnail(newDTO.getThumbnail());
		return newEntity;
	}
}
