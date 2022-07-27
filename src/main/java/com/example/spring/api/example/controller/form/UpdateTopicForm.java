package com.example.spring.api.example.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.spring.api.example.model.TopicModel;
import com.example.spring.api.example.repository.TopicRepository;

public class UpdateTopicForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;

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

	public TopicModel update(Long id, TopicRepository topicRepository) {
		TopicModel topic = topicRepository.getReferenceById(id);
		topic.setTitle(this.getTitle());
		topic.setMessage(this.message);
		
		return topic;
	}
	
	
}
