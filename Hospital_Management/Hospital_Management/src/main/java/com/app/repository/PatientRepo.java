package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Hospital;
import com.app.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	
}
