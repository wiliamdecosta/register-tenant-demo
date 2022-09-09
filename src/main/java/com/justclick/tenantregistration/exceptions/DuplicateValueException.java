package com.justclick.tenantregistration.exceptions;

import lombok.Getter;

public class DuplicateValueException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Getter
	private String fieldName;
	
	public DuplicateValueException(String fieldName, String message) {
		super(message);
		this.fieldName = fieldName;
	}
}
