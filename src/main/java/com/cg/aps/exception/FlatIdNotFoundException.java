package com.cg.aps.exception;

public class FlatIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public FlatIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public FlatIdNotFoundException(String flat) {
		super(flat);
	}

	
}
