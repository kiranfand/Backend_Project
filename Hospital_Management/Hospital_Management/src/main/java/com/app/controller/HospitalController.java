package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.HospitalReqDto;
import com.app.service.HospitalService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/hospital")
@Validated
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	//insert hospital
	@PostMapping
	public ResponseEntity<?> addHospital(@RequestBody @Valid HospitalReqDto reDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hospitalService.insertHospital(reDto));
	}
}
