package com.app.service;

import java.util.List;

import com.app.entity.railway;

public interface railwayService {
	
	List<railway> getAllrailways();

	railway addrailDetails(railway transientrail);

	String deleterailDetails(Long railwayno);

	railway getrailDetails(Long railwayno);

	
	railway updaterailDetails(railway detachedrail);

	


}
