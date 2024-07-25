package com.prueba.nisum.model;

import java.util.List;

public class UserDto {

	private String name;
	private String email;
	private String password;
	private String token;
	
	private List<PhoneDto> phones;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhoneDto> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
