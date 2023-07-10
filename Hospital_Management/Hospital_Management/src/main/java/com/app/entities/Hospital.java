package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreType
public class Hospital extends BaseEntity{

	@Column(name="h_name",unique=true)
	private String hospitalName;
	
	private String hospitalAdress;
	
	@Column(name="email",nullable=false)
	private String email;
	private String password;
	
	@OneToMany(mappedBy="allocatedHospital",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	List<Patient> patients=new ArrayList<Patient>();
	
	public void addPatient(Patient p) 
	{
		patients.add(p);
		p.setAllocatedHospital(this);
		
	}
	
	public void delPatient(Patient p) 
	{
		patients.remove(patients.indexOf(p));
		p.setAllocatedHospital(null);
	}
}
