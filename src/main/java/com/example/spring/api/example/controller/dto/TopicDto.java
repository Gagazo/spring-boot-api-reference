package com.example.spring.api.example.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.spring.api.example.model.TopicModel;

public class TopicDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime createDate;
	
	public TopicDto(TopicModel topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.createDate = topic.getCreateDate();
	}

	public static List<TopicDto> convert(List<TopicModel> topics) {
		return topics.stream().map(TopicDto::new).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
}