package com.phamvanthanh.service;

import com.phamvanthanh.dto.UserDTO;

public interface IUserService {
	UserDTO findOneByUserName(String userName);
}
