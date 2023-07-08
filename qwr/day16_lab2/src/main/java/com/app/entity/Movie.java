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
	@Table(name = "movie") // to specify table name
	//lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonIgnoreType	
public class Movie extends BaseEntity{
	
	
	
	@Column(name = "moviename", length = 20)
	private String movieName;
	
	
	@Column(name = "category", length = 20)
	private Cat category;
	
	
	@Column(name="releaseDate",length = 20)
	private LocalDate releaseDate;
	
	
	@Column(length = 20)
	private double budget;
	
	
	@Column(name = "director", length = 20)
	private String director;
	


//
//	public Movie() {
//		System.out.println("in default ctr of movie");
//	}
//
//
//
//
//	public Movie(String movieName, Cat category, LocalDate releaseDate, double budget, String director) {
//		super();
//		this.movieName = movieName;
//		this.category = category;
//		this.releaseDate = releaseDate;
//		this.budget = budget;
//		this.director = director;
//	}
//
//
//
//
//	public String getMovieName() {
//		return movieName;
//	}
//
//
//
//
//	public void setMovieName(String movieName) {
//		this.movieName = movieName;
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
//		return "Movie [movieName=" + movieName + ", category=" + category + ", releaseDate=" + releaseDate + ", budget="
//				+ budget + ", director=" + director + "]";
//	}
//	
//	
	
	
}
