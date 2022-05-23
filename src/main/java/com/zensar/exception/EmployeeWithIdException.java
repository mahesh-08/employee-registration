package com.zensar.exception;

public class EmployeeWithIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	
	public EmployeeWithIdException() {
		super();
	}

	public EmployeeWithIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
