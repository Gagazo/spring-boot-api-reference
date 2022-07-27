package com.example.spring.api.example.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.spring.api.example.model.CourseModel;
import com.example.spring.api.example.model.TopicModel;
import com.example.spring.api.example.repository.CourseRepository;

public class TopicForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;
	
	@NotNull @NotEmpty
	private String course;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public TopicModel convert(CourseRepository rep) {
		CourseModel courseModel = rep.findByName(course);
		return new TopicModel(title, message, courseModel);
	}
}
