package com.example.spring.api.example.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.spring.api.example.model.TopicModel;
import com.example.spring.api.example.model.TopicStatus;

public class TopicDetailDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime createDate;
	private String authorName;
	private TopicStatus status;
	private List<AnswerDto> answers;
	
	public TopicDetailDto(TopicModel topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.createDate = topic.getCreateDate();
		this.authorName = topic.getAuthor().getName();
		this.status = topic.getStatus();
		this.answers = new ArrayList<>();
		this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
	}
	
	public String getAuthorName() {
		return authorName;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public static List<TopicDetailDto> convert(List<TopicModel> topics) {
		return topics.stream().map(TopicDetailDto::new).collect(Collectors.toList());
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