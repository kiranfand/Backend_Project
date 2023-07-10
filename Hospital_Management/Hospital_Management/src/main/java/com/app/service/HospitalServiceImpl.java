package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.HospitalReqDto;
import com.app.entities.Hospital;
import com.app.repository.HospitalRepo;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepo hospRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Hospital insertHospital(HospitalReqDto hosp) 
	{
		Hospital h=mapper.map(hosp, Hospital.class);
		return hospRepo.save(h);
	}
}
