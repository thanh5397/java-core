package com.phamvanthanh.service;

import java.util.List;

import com.phamvanthanh.entity.ServiceEntity;

public interface IService {
	List<ServiceEntity> findAll();
}
