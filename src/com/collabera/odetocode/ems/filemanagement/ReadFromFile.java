package com.collabera.odetocode.ems.filemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import com.collabera.odetocode.ems.department.Department;
import com.collabera.odetocode.ems.employee.Employee;
import com.collabera.odetocode.ems.office.Office;

public class ReadFromFile {
	
	File file;
	FileInputStream inStream;
	ObjectInputStream objInStream;
	
	public void setFileStream(String filePath) throws FileNotFoundException, IOException {
		file = new File(filePath);
		inStream = new FileInputStream(file);
		objInStream = new ObjectInputStream(inStream);
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public ArrayList<Employee> readEmployeeFile() throws ClassNotFoundException, IOException, NullPointerException 
	{		
		ArrayList<Employee> employeeArrList = new ArrayList<Employee>();
		employeeArrList.addAll((ArrayList<Employee> )objInStream.readObject());
		close();
		
		return employeeArrList;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public ArrayList<Office> readOfficeFile() throws ClassNotFoundException, IOException, NullPointerException
	{
		
		ArrayList<Office> officeArrList = new ArrayList<Office>();
		officeArrList.addAll( (ArrayList<Office>) objInStream.readObject());
		close();
		
		return officeArrList;

	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public ArrayList<Department> readDeptFile() throws ClassNotFoundException, IOException, NullPointerException 
	{		
		ArrayList<Department> deptArrList = new ArrayList<Department>();
		deptArrList.addAll((ArrayList<Department>) objInStream.readObject());
		close();
		
		return deptArrList;
	}
		
	private void close() throws IOException {
		inStream.close();
		objInStream.close();
	}
	
}
