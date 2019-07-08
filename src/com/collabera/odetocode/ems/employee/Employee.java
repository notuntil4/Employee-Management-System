package com.collabera.odetocode.ems.employee;

import java.io.Serializable;
import java.time.LocalDate;

import com.collabera.odetocode.ems.address.Address;
import com.collabera.odetocode.ems.person.Person;

public class Employee extends Person implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2483260525681120559L;
	private static int currentID = 1000;
	private int ID;
	private String position;
	private int departmentID;
	private int officeID;
	private double hourlyWage;
	private int weeklyHours;
	private LocalDate startDate;
	private EmployeeTypeEnum employeeType;


	public Employee() {
		this("N/A","N/A",0,0,0,new Address(),"N/A",-1,-1,0,0,null,EmployeeTypeEnum.FULLTIME);
	}
	
	public Employee(String name, String email, int age, int ssn, long phone, Address address, String position, int departmentID, int officeID, double hourlyWage, int weeklyHours,
			LocalDate startDate, EmployeeTypeEnum employeeType) {
		
		super(name, email, age, ssn, phone, address);
		this.ID = currentID++;
		this.position = position;
		this.departmentID = departmentID;
		this.officeID = officeID;
		this.hourlyWage = hourlyWage;
		this.weeklyHours = weeklyHours;
		this.startDate = startDate;
		this.employeeType = employeeType;
	}
	
	public Employee(Employee employee) {
		super(employee.getName(), employee.getEmail(), employee.getAge(), employee.getSsn(), employee.getPhone(), employee.getAddress());
		this.ID = employee.getID();
		this.position = employee.getPosition();
		this.departmentID = employee.getDepartmentID();
		this.officeID = employee.getOfficeID();
		this.hourlyWage = employee.getHourlyWage();
		this.weeklyHours = employee.getWeeklyHours();
		this.startDate = employee.getStartDate();
		this.employeeType = employee.getEmployeeType();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getOfficeID() {
		return officeID;
	}
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public int getWeeklyHours() {
		return weeklyHours;
	}
	public void setWeeklyHours(int weeklyHours) {
		this.weeklyHours = weeklyHours;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	
	public EmployeeTypeEnum getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeTypeEnum employeeType) {
		this.employeeType = employeeType;
	}


	
	public double calcWage() {
		
		return this.hourlyWage;
	}

	public static void setCurrentID(int currentID) {
		Employee.currentID = currentID;
	}

	@Override
	public String toString() {

		
		return super.toString() + "\nID: " + ID + "\nPosition: " + position + "\nDepartment ID: " + departmentID + "\nOffice ID: "
				+ officeID + "\nHourly Wage: " + hourlyWage + "\nWeekly Hours: " + weeklyHours + "\nStart Date: " + startDate;
				
	}
	

	
	
	
}
