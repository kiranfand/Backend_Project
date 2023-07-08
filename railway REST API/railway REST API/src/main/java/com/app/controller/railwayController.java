package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.entity.railway;
import com.app.service.railwayServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/railways")
public class railwayController {
	@Autowired
private railwayServiceImpl railwayService;
	@GetMapping
	public List<railway> getAllrailway(){
		return railwayService.getAllrailways();
	}
//	@PostMapping
//	public railway addrailway( @RequestBody railway m) {
//		return railwayService.addrailDetails(m);
//	}
	
	@PostMapping
	 public ResponseEntity<railway>  saverailwayDetails(@org.springframework.web.bind.annotation.RequestBody railway m){
		 System.out.println("In add emp details controller....");
		 return new ResponseEntity<>(railwayService.addrailDetails(m),HttpStatus.CREATED);
	 }

	@DeleteMapping
	public String deleterailway(@PathVariable Long railwayNo) {
		String msg="deleted";
		railwayService.deleterailDetails(railwayNo);
		return msg;
	}
	@GetMapping("/{railwayno}")
	public railway getrailwayByid(@PathVariable Long railwayno) {
		return railwayService.getrailDetails(railwayno);
		
	}
	@PutMapping("/{railwayNo}")
	public railway updaterailway(@org.springframework.web.bind.annotation.RequestBody railway m) {
		return   railwayService.updaterailDetails(m);
		
	}
}
