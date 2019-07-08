package com.collabera.odetocode.ems.filemanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.collabera.odetocode.ems.department.Department;
import com.collabera.odetocode.ems.employee.Employee;
import com.collabera.odetocode.ems.office.Office;

public class WriteToFile {
	
	File file;
	FileOutputStream outStream;
	ObjectOutputStream objOutStream;
	
	public void setFileStream(String filePath) throws FileNotFoundException, IOException {		
		file = new File(filePath);
		outStream = new FileOutputStream(file);
		objOutStream = new ObjectOutputStream(outStream);
	}
	
	public void writeEmployeesToFile(ArrayList<Employee> employeeList) throws IOException {
		objOutStream.writeObject(employeeList);
		close();
	}
	
	public void writeOfficesToFile(ArrayList<Office> officeList) throws IOException {
		objOutStream.writeObject(officeList);
		close();
	}
	
	public void writeDeptToFile(ArrayList<Department> departmentList) throws IOException {
		objOutStream.writeObject(departmentList);
		close();
	}
	
	private void close() throws IOException {
		outStream.close();
		objOutStream.close();
	}
	
	

}
