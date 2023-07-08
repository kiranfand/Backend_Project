package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.railway;

public interface railwayRepository 
extends JpaRepository<railway, Long> {
	// add a method for auth
	List<railway> findByrailwayNameContainingIgnoreCase(String railwayName);

}
