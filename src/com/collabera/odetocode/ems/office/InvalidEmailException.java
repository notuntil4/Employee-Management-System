package com.collabera.odetocode.ems.office;

public class InvalidEmailException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException() {
		super("Invalid email format");
	}
}
