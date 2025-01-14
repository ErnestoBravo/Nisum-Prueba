package com.prueba.nisum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.nisum.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
