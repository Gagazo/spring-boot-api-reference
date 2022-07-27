package com.example.spring.api.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.api.example.model.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel, Long>{

	CourseModel findByName(String name);

}
