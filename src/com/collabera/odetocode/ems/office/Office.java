package com.collabera.odetocode.ems.office;

import java.io.Serializable;

import com.collabera.odetocode.ems.address.Address;

public class Office implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2050101970943643850L;
	private static int officeIDCounter = 1000;
	private int officeID;
	private long phoneNumber;
	private String email;
	private Address address;

	public Office() {
		this(-1, "N/A", null);
	}

	public Office(long phoneNumber, String email, Address address) {
		super();
		this.officeID = officeIDCounter++;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public int getOfficeID() {
		return officeID;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return this.address.getCity() + " Office";
	}

	public String toString() {
		return getName() + ": ID:" + getOfficeID() + " Phone#: " + getPhoneNumber() + 
				" Email: " + getEmail() + " Address: " + getAddress().toStringOneLine();
	}

}
