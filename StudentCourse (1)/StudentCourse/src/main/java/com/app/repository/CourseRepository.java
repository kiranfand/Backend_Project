package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses,Long>{

}
