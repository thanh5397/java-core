package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.ClientEntity;
import com.phamvanthanh.repository.ClientRepository;
import com.phamvanthanh.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<ClientEntity> findAll() {
		return clientRepository.findAll();
	}

}
