package com.phamvanthanh.service;

import java.util.List;

import com.phamvanthanh.entity.ClientEntity;

public interface IClientService {
	List<ClientEntity> findAll();
}
