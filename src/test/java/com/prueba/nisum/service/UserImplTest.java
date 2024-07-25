package com.prueba.nisum.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.nisum.model.UserDto;
import com.prueba.nisum.model.UserResponseDto;
import com.prueba.nisum.service.impl.UserImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserImplTest {
	
	@Autowired
	private UserImpl UserService;
	private UserDto userDto = new UserDto();
	private UserResponseDto responseDto = new UserResponseDto();
	
	@Before
	public void setUp() {		
		userDto.setEmail("aaaaaaa@dominio.cl)");
		userDto.setName("Juan Rodriguez");
		userDto.setPassword("hunter2");
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createUserTest() {


	}
}
