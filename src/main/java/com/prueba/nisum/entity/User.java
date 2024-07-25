package com.prueba.nisum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "modifiedDate")
	private Date modifiedDate;
	
	@Column(name = "lastLogin")
	private Date lastLogin;
	
	@Column(name = "isactive")
	private Boolean isactive;
	
	@Column(name = "token")
	private String token;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Phone> Phones;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public List<Phone> getPhones() {
		return Phones;
	}

	public void setPhones(List<Phone> phones) {
		Phones = phones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
 
	
	
}
