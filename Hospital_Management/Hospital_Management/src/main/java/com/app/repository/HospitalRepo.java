package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Long>{

	Hospital findByHospitalName(String name);
}
