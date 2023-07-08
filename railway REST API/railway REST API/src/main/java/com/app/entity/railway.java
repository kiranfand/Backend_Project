package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



	@Entity
	@Table(name = "railway") // to specify table name
	//lombok annotations
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@JsonIgnoreType	

public class railway extends BaseEntity{
	
	
	
	@Column(name = "railwayname", length = 20)
	private String railwayName;
	
	
	@Column(name = "", length = 20)
	private Category category;
	
	
	@Column(name="releaseDate",length = 20)
	private LocalDate releaseDate;
	
	
	@Column(length = 20)
	private double cost;
	
	
	@Column(name = "locopilot", length = 20)
	private String locopilot;


	public String getrailwayName() {
		return railwayName;
	}


	public void setrailwayName(String railwayName) {
		this.railwayName = railwayName;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	public double getBudget() {
		return cost;
	}


	public void setBudget(double budget) {
		this.cost = budget;
	}


	public String getlocopilt() {
		return locopilot;
	}


	public void setlocopilot(String director) {
		this.locopilot = locopilot;
	}


	public railway(String railwayName, Category category, LocalDate releaseDate, double budget, String director) {
		super();
		this.railwayName = railwayName;
		this.category = category;
		this.releaseDate = releaseDate;
		this.cost = budget;
		this.locopilot = director;
	}


	public railway() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "railway [railwayName=" + railwayName + ", category=" + category + ", releaseDate=" + releaseDate + ", budget="
				+ cost + ", director=" + locopilot + "]";
	}
	
	
	
	
	
	
	
	
	

//====================================================================================
//
//	public railway() {
//		System.out.println("in default ctr of railway");
//	}
//
//
//
//
//	public railway(String railwayName, Cat category, LocalDate releaseDate, double budget, String director) {
//		super();
//		this.railwayName = railwayName;
//		this.category = category;
//		this.releaseDate = releaseDate;
//		this.budget = budget;
//		this.director = director;
//	}
//
//
//
//
//	public String getrailwayName() {
//		return railwayName;
//	}
//
//
//
//
//	public void setrailwayName(String railwayName) {
//		this.railwayName = railwayName;
//	}
//
//
//
//
//	public Cat getCategory() {
//		return category;
//	}
//
//
//
//
//	public void setCategory(Cat category) {
//		this.category = category;
//	}
//
//
//
//
//	public LocalDate getReleaseDate() {
//		return releaseDate;
//	}
//
//
//
//
//	public void setReleaseDate(LocalDate releaseDate) {
//		this.releaseDate = releaseDate;
//	}
//
//
//
//
//	public double getBudget() {
//		return budget;
//	}
//
//
//
//
//	public void setBudget(double budget) {
//		this.budget = budget;
//	}
//
//
//
//
//	public String getDirector() {
//		return director;
//	}
//
//
//
//
//	public void setDirector(String director) {
//		this.director = director;
//	}
//
//
//
//
//	@Override
//	public String toString() {
//		return "railway [railwayName=" + railwayName + ", category=" + category + ", releaseDate=" + releaseDate + ", budget="
//				+ budget + ", director=" + director + "]";
//	}
//	
//	
	
	
}
