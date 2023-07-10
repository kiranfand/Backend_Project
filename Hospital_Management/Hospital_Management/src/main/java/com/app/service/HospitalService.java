package com.app.service;

import com.app.dtos.HospitalReqDto;
import com.app.dtos.HospitalSignUpDto;
import com.app.entities.Hospital;

public interface HospitalService {

	Hospital insertHospital(HospitalReqDto hospital);
}
