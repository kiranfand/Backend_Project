package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dtos.AoiRespone;
import com.app.dtos.PatientReqDto;
import com.app.dtos.PatientUpdDto;
import com.app.service.PatientService;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {

	@Autowired
	private PatientService pService;
	
	
	public PatientController() {
		
	}

	@PostMapping
	public ResponseEntity<?> addPatient(@RequestBody PatientReqDto pdato)
	{
		return ResponseEntity.status(HttpStatus.OK).body(pService.addPatient(pdato));
	}
	
	@GetMapping
	public ResponseEntity<?> getPatients()
	{
		return ResponseEntity.status(HttpStatus.OK).body(pService.getAllPatients());
	}
	
	@PutMapping
	public ResponseEntity<?> updatePatient(@RequestBody PatientUpdDto uDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(new AoiRespone(pService.upadtePatDet(uDto)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delPatient(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(new AoiRespone(pService.deletePat(id)));
	}
}
