package com.phamvanthanh.converter;

import org.springframework.stereotype.Component;

import com.phamvanthanh.dto.FactDTO;
import com.phamvanthanh.entity.FactEntity;

@Component
public class FactConverter {
	public FactDTO toDTO(FactEntity factEntity) {
		FactDTO factDTO = new FactDTO();
		factDTO.setComment(factEntity.getComment());
		return factDTO;
	}
	
	public FactEntity toEntity(FactDTO factDTO) {
		FactEntity factEntity = new FactEntity();
		factEntity.setComment(factDTO.getComment());
		return factEntity;
	}
}
