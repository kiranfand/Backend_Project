
package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entity.railway;
import com.app.repository.railwayRepository;
@Service
@Transactional


public class railwayServiceImpl implements railwayService{
	
	@Autowired // by type : Field Level DI
	private railwayRepository railRepo;

	@Override
	public List<railway> getAllrailways() {
		// TODO Auto-generated method stub
		return railRepo.findAll();
	}

	@Override
	public railway addrailDetails(railway transientrail) {
		// TODO Auto-generated method stub
		return railRepo.save(transientrail);
	}

	@Override
	public String deleterailDetails(Long railwayno) {
		String msg="railway deleted Sucessfully";
		if(railRepo.existsById(railwayno)) {
			railRepo.deleteById(railwayno);
		}
		return msg;
	}

	@Override
	public railway getrailDetails(Long railwayno) {
		// TODO Auto-generated method stub
		return railRepo.findById(railwayno).orElseThrow(()-> new ResourceNotFoundException("Invalid railwayid"));
	}

	@Override
	public railway updaterailDetails(railway detachedrail) {
		// TODO Auto-generated method stub
		return railRepo.save(detachedrail);
	}

	

	
	}
	
	
	
	
	



