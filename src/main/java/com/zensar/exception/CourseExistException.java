package com.zensar.exception;

import lombok.Data;

public class CourseExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CourseExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
