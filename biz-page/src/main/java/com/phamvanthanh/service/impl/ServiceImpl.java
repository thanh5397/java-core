package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.ServiceEntity;
import com.phamvanthanh.repository.ServiceRepository;
import com.phamvanthanh.service.IService;

@Service
public class ServiceImpl implements IService  {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public List<ServiceEntity> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

}
