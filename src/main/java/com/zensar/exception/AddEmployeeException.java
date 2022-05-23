package com.zensar.exception;

public class AddEmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AddEmployeeException(String message) {
		super();
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}

}
