package com.prueba.nisum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.nisum.model.UserJwt;
import com.prueba.nisum.security.JWTAuthtenticationConfig;

@RestController
public class LoginController {

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;


	@PostMapping(value = "/login")
	public UserJwt login(@RequestParam("user") String username,	@RequestParam("password") String pass) {

		UserJwt user = new UserJwt();

		if (username.equals("admin") && pass.equals("admin")) {
			String token = jwtAuthtenticationConfig.getJWTToken(username);
			user.setUser(username);
			user.setPass(pass);
			user.setToken(token);
		}

		return user;
		
	}

	@GetMapping("/key")
	public String getKey(){
		return jwtAuthtenticationConfig.JwkGenerator();
	}


}
