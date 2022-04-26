package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.CategoryEntity;
import com.phamvanthanh.repository.CategoryRepository;
import com.phamvanthanh.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
