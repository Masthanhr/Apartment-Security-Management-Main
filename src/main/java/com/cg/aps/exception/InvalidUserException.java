package com.cg.aps.exception;

public class InvalidUserException extends RuntimeException {
	
	public InvalidUserException(){
	
	}

	public InvalidUserException(String message) {
		super(message);	
	}

}
