package com.collabera.odetocode.ems.employee;

import java.time.LocalDate;
import java.util.Date;

import com.collabera.odetocode.ems.address.Address;

public interface EmployeeType {
	
	
	public String getType();
	
	public class PartTime extends Employee implements EmployeeType {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8576498074564490093L;

		public PartTime() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PartTime(String name, String email, int age, int ssn, long phone, Address address, String position,
				int departmentID, int officeID, double hourlyWage, int weeklyHours, LocalDate startDate,
				EmployeeTypeEnum employeeType) {
			super(name, email, age, ssn, phone, address, position, departmentID, officeID, hourlyWage, weeklyHours,
					startDate, employeeType);
			// TODO Auto-generated constructor stub
		}

		public PartTime(Employee employee) {
			// TODO Auto-generated constructor stub
			super(employee);
		}

		@Override
		public String getType() {
			return "Part Time Employee";
		}

		@Override
		public String toString() {
			return super.toString() + "\nEmployee Type: " + this.getType();
		}

	}
	
	public class Intern extends Employee implements EmployeeType {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2874181915026771258L;

		public Intern() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Intern(String name, String email, int age, int ssn, long phone, Address address, String position,
				int departmentID, int officeID, double hourlyWage, int weeklyHours, LocalDate startDate,
				EmployeeTypeEnum employeeType) {
			super(name, email, age, ssn, phone, address, position, departmentID, officeID, hourlyWage, weeklyHours,
					startDate, employeeType);
			// TODO Auto-generated constructor stub
		}

		public Intern(Employee employee) {
			// TODO Auto-generated constructor stub
			super(employee);
		}

		@Override
		public String getType() {
			return "Intern";
		}

		@Override
		public String toString() {
			return super.toString() + "\nEmployee Type: " + this.getType();
		}

	}


	public class FullTime extends Employee implements EmployeeType {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2618737853768287627L;

		public FullTime(Employee employee) {
			super(employee);
			// TODO Auto-generated constructor stub
		}

		public FullTime(String name, String email, int age, int ssn, long phone, Address address, String position,
				int departmentID, int officeID, double hourlyWage, int weeklyHours, LocalDate startDate,
				EmployeeTypeEnum employeeType) {
			super(name, email, age, ssn, phone, address, position, departmentID, officeID, hourlyWage, weeklyHours,
					startDate, employeeType);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getType() {

			return "Full Time Employee";
		}

		@Override
		public String toString() {
			return super.toString() + "\nEmployee Type: " + this.getType();
		}

	}

	public class Contract extends Employee implements EmployeeType {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4745379201894423699L;

		public Contract(String name, String email, int age, int ssn, long phone, Address address, String position,
				int departmentID, int officeID, double hourlyWage, int weeklyHours, LocalDate startDate,
				EmployeeTypeEnum employeeType) {
			super(name, email, age, ssn, phone, address, position, departmentID, officeID, hourlyWage, weeklyHours,
					startDate, employeeType);
			// TODO Auto-generated constructor stub
		}

		Date contractEnd;

		public Contract() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Contract(Employee employee) {
			// TODO Auto-generated constructor stub
			super(employee);
		}

		@Override
		public String getType() {
			return "Contract Employee";
		}

		public Date getContractEnd() {
			return contractEnd;
		}

		public void setContractEnd(Date contractEnd) {
			this.contractEnd = contractEnd;
		}

		@Override
		public String toString() {
			return super.toString() + "\nEmployee Type: " + this.getType();
		}

	}


}
