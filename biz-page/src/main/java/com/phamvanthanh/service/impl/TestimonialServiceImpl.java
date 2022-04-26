package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.TestimonialEntity;
import com.phamvanthanh.repository.TestimonialRepository;
import com.phamvanthanh.service.ITestimonialService;

@Service
public class TestimonialServiceImpl implements ITestimonialService{
	
	@Autowired
	private TestimonialRepository testimonialRepository;

	@Override
	public List<TestimonialEntity> findAll() {
		return testimonialRepository.findAll();
	}

}
