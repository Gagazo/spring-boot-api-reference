package com.example.spring.api.example.controller.dto;

import java.time.LocalDateTime;

import com.example.spring.api.example.model.AnswerModel;

public class AnswerDto {

	private Long id;
	private String message;
	private LocalDateTime createDate;
	private String authorName;
	
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public AnswerDto(AnswerModel answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.createDate = answer.getCreateDate();
		this.authorName = answer.getAuthor().getName();
	}
	
}
