package com.phamvanthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.converter.UserConverter;
import com.phamvanthanh.dto.UserDTO;
import com.phamvanthanh.entity.UserEntity;
import com.phamvanthanh.repository.UserRepository;
import com.phamvanthanh.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	public UserDTO findOne(UserDTO userDTO) {
		UserEntity userEntity = userRepository.findOneByUserNameAndPassword(userDTO.getUserName(),userDTO.getPassword());
		UserDTO user = userConverter.toUserDTO(userEntity);
		return user;
	}

}
