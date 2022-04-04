package com.phamvanthanh.converter;

import org.springframework.stereotype.Component;

import com.phamvanthanh.dto.UserDTO;
import com.phamvanthanh.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toUserDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setPassword(userEntity.getPassword());
		return userDTO;
	}
	
	public UserEntity toUserEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassword());
		return userEntity;
	}
}
