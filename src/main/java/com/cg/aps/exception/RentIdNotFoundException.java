package com.cg.aps.exception;

public class RentIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rent;

	public RentIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public RentIdNotFoundException(String rent) {
		super(rent);
	}

	public Object getFlatRentEntity() {
		// TODO Auto-generated method stub
		return getFlatRentEntity();
	}
}
