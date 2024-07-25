package com.prueba.nisum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserJwt {
	@JsonIgnore
	private String user;

	@JsonIgnore
	private String pass;

	private String token;

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
