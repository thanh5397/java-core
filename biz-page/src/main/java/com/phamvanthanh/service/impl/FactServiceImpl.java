package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.FactEntity;
import com.phamvanthanh.repository.FactRepository;
import com.phamvanthanh.service.IFactService;

@Service
public class FactServiceImpl implements IFactService {

	@Autowired
	private FactRepository factRepository;
	
	@Override
	public List<FactEntity> findAll() {
		// TODO Auto-generated method stub
		return factRepository.findAll();
	}
	
}
