package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="stud")
@NoArgsConstructor
public class Student extends BaseEntity{

	@Column(name="first_name",length=20)
	private String firstName;
	@Column(name="last_name",length=20)
	private String lastName;
	private LocalDate dob;
	@Column(name="course_name",length=20)
	private String courseName;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Courses course;
	public Student(String firstName, String lastName, LocalDate dob, String courseName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", courseName="
				+ courseName + "]";
	}
	
	
	
	
}
