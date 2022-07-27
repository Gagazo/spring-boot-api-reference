package com.example.spring.api.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.api.example.model.TopicModel;

public interface TopicRepository extends JpaRepository<TopicModel, Long>{

	List<TopicModel> findByCourseName(String courseName);
	
}