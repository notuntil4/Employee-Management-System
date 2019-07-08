package com.collabera.odetocode.ems.person;

import java.io.Serializable;

import com.collabera.odetocode.ems.address.Address;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 931835622712297973L;
	private String name, email;
	private int age, ssn;
	private long phone;
	private Address address;
	
	public Person() {
		this.name = "N/A";
		this.email = "N/A";
		this.age = 0;
		this.ssn = 0;
		this.phone = 0;
		this.address = new Address();
	}
	public Person(String name, String email, int age, int ssn, long phone, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.ssn = ssn;
		this.phone = phone;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private String formatSsn() {
		String temp = String.format("%09d", ssn);
		return temp.substring(0, 3) + "-" + temp.substring(3,5) + "-" + temp.substring(5);
	}
	private String formatPhone() {
		String temp = String.format("%010d", phone);
		return "(" + temp.substring(0, 3) + ")-" + temp.substring(3,6) + "-" + temp.substring(6);
	}
	public String toString() {
		return name + "\n" + email + "\nAge: " + age + "\nSSN: " 
				+ formatSsn() + "\nPhone #: " + formatPhone() + "\n" + address.toString();
	}
}