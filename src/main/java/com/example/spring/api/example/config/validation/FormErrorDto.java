package com.example.spring.api.example.config.validation;

public class FormErrorDto {

	public FormErrorDto(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	private String field;
	private String message;
	
	public String getField() {
		return field;
	}
	
	public String getMessage() {
		return message;
	}
	
}
