package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Courses{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;
	private String courseName;
	private double fees;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",orphanRemoval = true)
	private List<Student> sList = new ArrayList<>();
	
	public Courses(String courseName, double fees) {
		super();
		this.courseName = courseName;
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", fees=" + fees + "]";
	}
	
}


