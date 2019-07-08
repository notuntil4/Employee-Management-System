package com.collabera.odetocode.ems.office;

public class NoOfficeFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoOfficeFoundException() {
		super("No office with that ID found.");
	}
}
