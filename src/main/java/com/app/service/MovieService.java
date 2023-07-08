package com.app.service;

import java.util.List;

import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Movie;

public interface MovieService {
//add a method to get all emps
	List<Movie> getAllMovies();

	Movie addEmpDetails(Movie transientEmp);

	String deleteEmpDetails(Long empId);

	Movie getEmpDetails(Long empId);

	Movie updateEmpDetails(Movie detachedEmp);

	AuthRespDTO authenticateEmp(AuthRequestDTO request);
}
