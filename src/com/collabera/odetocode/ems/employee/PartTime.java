//package com.collabera.odetocode.ems.employee;
//
//import java.util.Date;
//
//import com.collabera.odetocode.ems.address.Address;
//
//public class PartTime extends Employee implements EmployeeType {
//
//	public PartTime() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public PartTime(String name, String email, int age, int ssn, long phone, Address address, String position,
//			int departmentID, int officeID, double hourlyWage, int weeklyHours, Date startDate,
//			EmployeeTypeEnum employeeType) {
//		super(name, email, age, ssn, phone, address, position, departmentID, officeID, hourlyWage, weeklyHours,
//				startDate, employeeType);
//		// TODO Auto-generated constructor stub
//	}
//
//	public PartTime(Employee employee) {
//		// TODO Auto-generated constructor stub
//		super(employee);
//	}
//
//	@Override
//	public String getType() {
//		return "Part Time Employee";
//	}
//
//	@Override
//	public String toString() {
//		return super.toString() + "\nEmployee Type: " + this.getType();
//	}
//
//}
