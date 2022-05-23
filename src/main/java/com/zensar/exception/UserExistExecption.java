package com.zensar.exception;

public class UserExistExecption extends RuntimeException{

	private String message;

	public UserExistExecption(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
