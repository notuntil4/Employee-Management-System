package com.collabera.odetocode.ems.department;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Department implements Serializable{

	private static final long serialVersionUID = 300060108581086165L;
	private int departmentID;
	private String departmentName;
	private double departmentBudget;
	private static int nextID = 1000;
	
	public Department() {
		this.departmentID = nextID++;
		this.departmentName = "N/A";
		this.departmentBudget = 0;
	}

	public Department(String departmentName, double departmentBudget) {
		this.departmentID = nextID++;
		this.departmentName = departmentName;
		this.departmentBudget = departmentBudget;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public double getDepartmentBudget() {
		return departmentBudget;
	}

	public void setDepartmentBudget(double departmentBudget) {
		this.departmentBudget = departmentBudget;
	}
	
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
		return "Department Name: " + departmentName + "\nBudget: $" 
        	+ decimalFormat.format(departmentBudget) + "\nID: " + departmentID;
	}
}
