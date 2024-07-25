package com.prueba.nisum.service;

import com.prueba.nisum.model.UserDto;
import com.prueba.nisum.model.UserResponseDto;

public interface IUser {

	public UserResponseDto createUser(UserDto user);
	
}
