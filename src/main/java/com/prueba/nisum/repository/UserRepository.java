package com.prueba.nisum.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.nisum.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

	List<User> findByName(String name);
	List<User> findByEmail(String email);
}
