package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

//import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Patient extends BaseEntity {

	@Column(name="p_name",length=20)
	private String patientName;
	@Column(length=10)
	private Long mobNumber;
	
	@ManyToOne
	@JoinColumn(name="hosp_id")
	private Hospital allocatedHospital;
}
