package com.prueba.nisum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.nisum.model.UserDto;
import com.prueba.nisum.model.UserResponseDto;
import com.prueba.nisum.service.IUser;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUser userService;

	@PostMapping(value = "/create")
	public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDto user, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws Exception {
		UserResponseDto resp = new UserResponseDto();
		user.setToken(token);
		try {
			resp = userService.createUser(user);
		} catch (Exception e) {
			System.out.print("Error: " + e.getMessage());
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
