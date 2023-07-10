package com.app.service;

import java.util.List;

import com.app.dtos.PatientReqDto;
import com.app.dtos.PatientRespDto;
import com.app.dtos.PatientUpdDto;
import com.app.entities.Patient;

public interface PatientService {

	Patient addPatient(PatientReqDto pdto);

	List<PatientRespDto> getAllPatients();

	String upadtePatDet(PatientUpdDto uDto);

	String deletePat(Long id);
	

}
