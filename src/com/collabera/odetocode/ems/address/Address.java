package com.collabera.odetocode.ems.address;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5808789752745120937L;
	private String street, city, state, country;
	private int aptNum, zipcode;

	public Address() {
		this.street = "N/A";
		this.city = "N/A";
		this.state = "N/A";
		this.country = "N/A";
		this.aptNum = 0;
		this.zipcode = 0;
	}
	public Address(String street, String city, String state, String country, int aptNum, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.aptNum = aptNum;
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAptNum() {
		return aptNum;
	}
	public void setAptNum(int aptNum) {
		this.aptNum = aptNum;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String toStringOneLine() {
		return aptNum + " " + street + " " + city + ", " + state + " " + zipcode + " " + country;
	}
	public String toString() {
		return aptNum + " " + street + "\n" + city + ", " + state + " " + zipcode + "\n" + country;
	}
}