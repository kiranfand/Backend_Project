package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.PatientReqDto;
import com.app.dtos.PatientRespDto;
import com.app.dtos.PatientUpdDto;
import com.app.entities.Hospital;
import com.app.entities.Patient;
import com.app.repository.HospitalRepo;
import com.app.repository.PatientRepo;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	private HospitalRepo prepo;
	
	@Autowired
	private PatientRepo patrepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public Patient addPatient(PatientReqDto pdto) {
	    
		Hospital h=prepo.findByHospitalName(pdto.getHospitalName());
		System.out.println(h);
		//System.out.println(h.addPatient(mapper.map(pdto, Patient.class)));
		Patient p=mapper.map(pdto, Patient.class);
		h.addPatient(p);
		System.out.println(p);
		return patrepo.save(p);
	}
	@Override
	public List<PatientRespDto> getAllPatients() {
		List<PatientRespDto> dto=new ArrayList<PatientRespDto>();
		List<Patient> list=patrepo.findAll();
		//Patient p=list.get(0);
		list.forEach((p)->{
		PatientRespDto pdto=mapper.map(p, PatientRespDto.class);
				pdto.setHospitalAdress(p.getAllocatedHospital().getHospitalAdress());
				pdto.setHospitalName(p.getAllocatedHospital().getHospitalName());
				pdto.setHospitalId(p.getAllocatedHospital().getId());
				pdto.setPatientId(p.getId());
				dto.add(pdto);
		});
//		list.forEach((p)->dto.add(mapper.map(p, PatientRespDto.class)));
	//	return dto;
				System.out.println(dto);
		return dto;
	}
	@Override
	public String upadtePatDet(PatientUpdDto uDto) {
		
		Patient p=patrepo.findById(uDto.getId()).orElseThrow();
		
		p.setMobNumber(uDto.getMobNumber());
		p.setPatientName(uDto.getPatientName());
		
		patrepo.save(p);
			
		return "Successfully updated";
	}
	@Override
	public String deletePat(Long id) {
		System.out.println("Id is:"+id);
		Patient p=patrepo.findById(id).orElseThrow();
		Hospital h=prepo.findById(p.getAllocatedHospital().getId()).orElseThrow();
		h.delPatient(p);
		patrepo.deleteById(id);
		return "Successfully deleted";
	}

}
