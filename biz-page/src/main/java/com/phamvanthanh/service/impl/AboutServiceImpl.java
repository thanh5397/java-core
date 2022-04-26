package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.AboutEntity;
import com.phamvanthanh.repository.AboutRepository;
import com.phamvanthanh.service.IAboutService;

@Service
public class AboutServiceImpl implements IAboutService{
	
	@Autowired
	private AboutRepository aboutRepository;

	@Override
	public List<AboutEntity> findAll() {
		// TODO Auto-generated method stub
		return aboutRepository.findAll();
	}
	
}
