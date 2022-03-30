package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldNew = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toNewEntity(newDTO, oldNew);
		} else {
			newEntity = newConverter.toNewEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategoryEntity(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toNewDTO(newEntity);
	}

	@Override
	public NewDTO update(NewDTO newDTO) {
		NewEntity oldNew = newRepository.findOne(newDTO.getId());
		NewEntity newEntity = newConverter.toNewEntity(newDTO, oldNew);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategoryEntity(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toNewDTO(newEntity);
	}
	
	
}
