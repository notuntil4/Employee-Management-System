//package com.collabera.odetocode.ems.runner;
//
//import java.util.Date;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import com.collabera.odetocode.ems.address.Address;
//import com.collabera.odetocode.ems.department.Department;
//import com.collabera.odetocode.ems.employee.Contract;
//import com.collabera.odetocode.ems.employee.Employee;
//import com.collabera.odetocode.ems.employee.EmployeeTypeEnum;
//import com.collabera.odetocode.ems.employee.FullTime;
//import com.collabera.odetocode.ems.employee.Intern;
//import com.collabera.odetocode.ems.employee.PartTime;
//import com.collabera.odetocode.ems.office.Office;
//import com.collabera.odetocode.ems.person.Person;
//
//public class EMSEmployeeRunner {
//
//	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
//	private static ArrayList<Department> departmentList = new ArrayList<Department>();
//	private static ArrayList<Office> officeList = new ArrayList<Office>();
//
//	private static Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		int input = 0;
//
//		
//		//test values, feel free to delete #odetocode
//		Department d1 = new Department();
//		d1.setDepartmentID(1);
//		Department d2 = new Department();
//		d2.setDepartmentID(2);
//		Office o1 = new Office();
//		o1.setOfficeID(5);
//
//		d1.setDepartmentName("Foop");
//
//		departmentList.add(d1);
//
//		departmentList.add(d2);
//
//		officeList.add(o1);
//
//		Intern emp = new Intern();
//		emp.setID(0);
//		employeeList.add(emp);
//		
//		do {
//			System.out.println("What would you like to do?");
//			System.out.println("1.Add Employee\n2.Delete Employee"
//					+ "\n3.Edit Employee\n4.Display Employee\n5.Display All\n6.Exit");
//			input = Integer.parseInt(scanner.nextLine());
//			if (input == 1) {
//				addEmployee();
//			} else if (input == 2) {
//				deleteEmployee();
//			} else if (input == 3) {
//				editEmployee();
//			} else if (input == 4) {
//				displayEmployee();
//			} else if (input == 5) {
//				displayAllEmployees();
//			}
//		} while (input != 6);
//		scanner.close();
//		System.out.println("Have a nice day!");
//
//	}
//
//	private static void addEmployee() {
//		// TODO Auto-generated method stub
//		// generate ID
//		int id = Employee.getCurrentID();
//		Employee.incrementID();
//
//		System.out.print("Name: ");
//		String name = scanner.nextLine();
//		int age, aptNum, zipcode, ssn;
//		long phone;
//		while (true) {
//			try {
//				System.out.print("Age: ");
//				age = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an number");
//			}
//		}
//
//		System.out.print("---Address---\nHouse/Apartment Number: ");
//		while (true) {
//			try {
//				aptNum = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an number");
//				System.out.print("Apartment Number: ");
//			}
//		}
//		System.out.print("Street: ");
//		String street = scanner.nextLine();
//		System.out.print("City: ");
//		String city = scanner.nextLine();
//		System.out.print("State: ");
//		String state = scanner.nextLine();
//		while (true) {
//			try {
//				System.out.print("Zipcode: ");
//				zipcode = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an number");
//			}
//		}
//		System.out.print("Country: ");
//		String country = scanner.nextLine();
//		Address address = new Address(street, city, state, country, aptNum, zipcode);
//
//		while (true) {
//			try {
//				System.out.print("SSN: ");
//				ssn = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an number");
//			}
//		}
//		while (true) {
//			try {
//				System.out.print("Phone #: ");
//				phone = Long.parseLong(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an number");
//			}
//		}
//		String regex = "^(.+)@(.+)$";
//		Pattern pattern = Pattern.compile(regex);
//		String email;
//		while (true) {
//			System.out.print("Email: ");
//			email = scanner.nextLine();
//			Matcher matcher = pattern.matcher(email);
//			if (matcher.matches()) {
//				break;
//			} else {
//				System.out.println("Must be a valid email");
//			}
//		}
//		
//
//		EmployeeTypeEnum employeeType = null;
//		while (employeeType == null) {
//			System.out.println("Enter employment type:");
//			System.out.println("1.Full Time\n2.Part Time" + "\n3.Contract\n4.Intern");
//			switch (Integer.parseInt(scanner.nextLine())) {
//			case 1:
//				employeeType = EmployeeTypeEnum.FULLTIME;
//				break;
//			case 2:
//				employeeType = EmployeeTypeEnum.PARTTIME;
//				break;
//			case 3:
//				employeeType = EmployeeTypeEnum.CONTRACT;
//				break;
//			case 4:
//				employeeType = EmployeeTypeEnum.INTERN;
//				break;
//			default:
//				System.out.println("Please enter a number between 1 and 4");
//			}
//		}
//
//		System.out.println("Enter position: ");
//		String position = scanner.nextLine();
//
//		int departmentID = -1;
//		while (departmentID == -1) {
//			System.out.println("Choose a department: ");
//			for (Department d : departmentList) {
//				System.out.println(d.getDepartmentName());
//			}
//
//			String departmentName = scanner.nextLine();
//
//			for (Department d : departmentList) {
//				if (d.getDepartmentName().equalsIgnoreCase(departmentName.trim())) {
//					departmentID = d.getDepartmentID();
//					break;
//				}
//
//			}
//			if (departmentID == -1) {
//				System.out.println("That department does not exist.\n");
//			}
//		}
//
//		int officeID = -1;
//		while (officeID == -1) {
//			System.out.println("Choose an office: ");
//			for (Office o : officeList) {
//				System.out.println(o.getOfficeName());
//			}
//
//			String officeName = scanner.nextLine();
//
//			for (Office o : officeList) {
//				if (o.getOfficeName().equalsIgnoreCase(officeName.trim())) {
//					officeID = o.getOfficeID();
//					break;
//				}
//			}
//			if (officeID == -1) {
//				System.out.println("That office does not exist.\n");
//			}
//		}
//
//		double hourlyWage = 0;
//		while (true) {
//			try {
//				System.out.println("Enter hourly wage: ");
//				hourlyWage = Double.parseDouble(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be a number");
//			}
//		}
//
//		int weeklyHours = 0;
//		while (true) {
//			try {
//				System.out.println("Enter weekly hours: ");
//				weeklyHours = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be a number");
//			}
//		}
//
//		Date date = new Date();
//
//		if (employeeType.equals(EmployeeTypeEnum.FULLTIME)) {
//			employeeList.add(new FullTime(name, email, age, ssn, phone, address, id, position, departmentID, officeID,
//					hourlyWage, weeklyHours, date, employeeType));
//			
//		} else if (employeeType.equals(EmployeeTypeEnum.PARTTIME)) {
//			employeeList.add(new PartTime(name, email, age, ssn, phone, address, id, position, departmentID, officeID,
//					hourlyWage, weeklyHours, date, employeeType));
//		
//		} else if (employeeType.equals(EmployeeTypeEnum.CONTRACT)) {
//			employeeList.add(new Contract(name, email, age, ssn, phone, address, id, position, departmentID, officeID,
//					hourlyWage, weeklyHours, date, employeeType));
//			
//		} else if (employeeType.equals(EmployeeTypeEnum.INTERN)) {
//			employeeList.add(new Intern(name, email, age, ssn, phone, address, id, position, departmentID, officeID,
//					hourlyWage, weeklyHours, date, employeeType));
//	
//		}
//
//	}
//
//	private static void deleteEmployee() {
//		// TODO Auto-generated method stub
//
//		int idToDelete = -1;
//
//		while (true) {
//			try {
//				System.out.println("Choose an employee to delete (Select ID): ");
//
//				for (Employee e : employeeList) {
//					System.out.println("Name: " + e.getName() + " ID: " + e.getID());
//				}
//
//				idToDelete = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an ID");
//			}
//		}
//
//		boolean removed = false;
//		for (Employee e : employeeList) {
//			if (e.getID() == idToDelete) {
//				employeeList.remove(e);
//				removed = true;
//				System.out.println(e.getName() + " successfully removed\n");
//				break;
//			}
//		}
//
//		if (removed == false) {
//			System.out.println("ID not found");
//		}
//
//	}
//
//	private static void editEmployee() {
//		// TODO Auto-generated method stub
//
//		int idToEdit = -1;
//
//		while (true) {
//			try {
//				System.out.println("Choose an employee edit (Select ID): ");
//
//				for (Employee e : employeeList) {
//					System.out.println("Name: " + e.getName() + " ID: " + e.getID());
//				}
//
//				idToEdit = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an ID");
//			}
//		}
//
//		boolean edited = false;
//
//		Employee editEmployee = new Employee();
//		for (Employee e : employeeList) {
//			if (e.getID() == idToEdit) {
//				System.out.println(e.toString());
//				edited = true;
//				editEmployee = e;
//
//				break;
//			}
//		}
//
//		if (edited == false) {
//			System.out.println("ID not found");
//		}
//		int input = 0;
//		if (edited == true) {
//			do {
//				try {
//					System.out.println("What would you like to edit?");
//
//					System.out.println(
//							"1.Edit Name\n2.Edit Age\n3.Edit Address\n4.Edit SSN\n5.Edit Phone\n6.Edit Email\n7.Edit Position\n8.Edit Department"
//									+ "\n9.Edit Office\n10.Edit Hourly Wage"
//									+ "\n11.Hours Worked\n12.Edit Employment Type\n13. Exit");
//					input = Integer.parseInt(scanner.nextLine());
//					if (input == 1) {
//						System.out.print("Name: ");
//						editEmployee.setName(scanner.nextLine());
//					} else if (input == 2) {
//						while (true) {
//							try {
//								System.out.print("Age: ");
//								editEmployee.setAge(Integer.parseInt(scanner.nextLine()));
//								break;
//							} catch (NumberFormatException e) {
//								System.out.println("Must be an number");
//							}
//						}
//					} else if (input == 3) {
//						editAddress(editEmployee);
//					} else if (input == 4) {
//						while (true) {
//							try {
//								System.out.print("SSN: ");
//								editEmployee.setSsn(Integer.parseInt(scanner.nextLine()));
//								break;
//							} catch (NumberFormatException e) {
//								System.out.println("Must be an number");
//							}
//						}
//					} else if (input == 5) {
//						while (true) {
//							try {
//								System.out.print("Phone #: ");
//								editEmployee.setPhone(Integer.parseInt(scanner.nextLine()));
//								break;
//							} catch (NumberFormatException e) {
//								System.out.println("Must be an number");
//							}
//						}
//					} else if (input == 6) {
//						String regex = "^(.+)@(.+)$";
//						Pattern pattern = Pattern.compile(regex);
//						String email = "";
//						while (true) {
//							System.out.print("Email: ");
//							email = scanner.nextLine();
//							Matcher matcher = pattern.matcher(email);
//							if (matcher.matches()) {
//								break;
//							} else {
//								System.out.println("Must be a valid email");
//							}
//						}
//						editEmployee.setEmail(email);
//					} else if (input == 7) {
//						System.out.println("Enter position: ");
//						String position = scanner.nextLine();
//						editEmployee.setPosition(position);
//					} else if (input == 8) {
//						int departmentID = -1;
//						while (departmentID == -1) {
//							System.out.println("Choose a department: ");
//							for (Department d : departmentList) {
//								System.out.println(d.getDepartmentName());
//							}
//
//							String departmentName = scanner.nextLine();
//
//							for (Department d : departmentList) {
//								if (d.getDepartmentName().equalsIgnoreCase(departmentName.trim())) {
//									departmentID = d.getDepartmentID();
//									break;
//								}
//
//							}
//							if (departmentID == -1) {
//								System.out.println("That department does not exist.\n");
//							}
//						}
//						editEmployee.setDepartmentID(departmentID);
//
//					} else if (input == 9) {
//						int officeID = -1;
//						while (officeID == -1) {
//							System.out.println("Choose an office: ");
//							for (Office o : officeList) {
//								System.out.println(o.getOfficeName());
//							}
//
//							String officeName = scanner.nextLine();
//
//							for (Office o : officeList) {
//								if (o.getOfficeName().equalsIgnoreCase(officeName.trim())) {
//									officeID = o.getOfficeID();
//									break;
//								}
//							}
//							if (officeID == -1) {
//								System.out.println("That office does not exist.\n");
//							}
//						}
//						editEmployee.setOfficeID(officeID);
//					} else if (input == 10) {
//						double hourlyWage = 0;
//						while (true) {
//							try {
//								System.out.println("Enter hourly wage: ");
//								hourlyWage = Double.parseDouble(scanner.nextLine());
//								break;
//							} catch (NumberFormatException e) {
//								System.out.println("Must be a number");
//							}
//						}
//						editEmployee.setHourlyWage(hourlyWage);
//					} else if (input == 11) {
//						int weeklyHours = 0;
//						while (true) {
//							try {
//								System.out.println("Enter weekly hours: ");
//								weeklyHours = Integer.parseInt(scanner.nextLine());
//								break;
//							} catch (NumberFormatException e) {
//								System.out.println("Must be a number");
//							}
//						}
//						editEmployee.setWeeklyHours(weeklyHours);
//					} else if (input == 12) {
//						EmployeeTypeEnum employeeType = null;
//						while (employeeType == null) {
//							System.out.println("Enter employment type:");
//							System.out.println("1.Full Time\n2.Part Time" + "\n3.Contract\n4.Intern");
//							switch (Integer.parseInt(scanner.nextLine())) {
//							case 1:
//								employeeList.remove(editEmployee);
//								employeeType = EmployeeTypeEnum.FULLTIME;
//								editEmployee.setEmployeeType(employeeType);
//								employeeList.add(new FullTime(editEmployee));
//								break;
//							case 2:
//								employeeList.remove(editEmployee);
//								employeeType = EmployeeTypeEnum.PARTTIME;
//								editEmployee.setEmployeeType(employeeType);
//								employeeList.add(new PartTime(editEmployee));
//								break;
//							case 3:
//								employeeList.remove(editEmployee);
//								employeeType = EmployeeTypeEnum.CONTRACT;
//								editEmployee.setEmployeeType(employeeType);
//								employeeList.add(new Contract(editEmployee));
//								break;
//							case 4:
//								employeeList.remove(editEmployee);
//								employeeType = EmployeeTypeEnum.INTERN;
//								editEmployee.setEmployeeType(employeeType);
//								employeeList.add(new Intern(editEmployee));
//								break;
//							default:
//								System.out.println("Please enter a number between 1 and 4");
//							}
//						}
//					}
//
//				} catch (NumberFormatException e) {
//					System.out.println("Please select 1-13");
//				}
//			} while (input != 13);
//
//			System.out.println("TEST\n"+ editEmployee.toString());
//		}
//	}
//
//	private static void displayEmployee() {
//		// TODO Auto-generated method stub
//
//		int idToDisplay = -1;
//
//		while (true) {
//			try {
//				System.out.println("Choose an employee to display their info (Select ID): ");
//
//				for (Employee e : employeeList) {
//					System.out.println("Name: " + e.getName() + " ID: " + e.getID());
//				}
//
//				idToDisplay = Integer.parseInt(scanner.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("Must be an ID");
//			}
//		}
//
//		boolean displayed = false;
//		for (Employee e : employeeList) {
//			if (e.getID() == idToDisplay) {
//				System.out.println(e.toString());
//				displayed = true;
//				break;
//			}
//		}
//
//		if (displayed == false) {
//			System.out.println("ID not found");
//		}
//
//	}
//
//	private static void displayAllEmployees() {
//		// TODO Auto-generated method stub
//		for (Employee e : employeeList) {
//			System.out.println("\n----------\n" + e.toString() + "\n----------");
//		}
//	}
//
//	private static void editAddress(Person person) {
//		int input = 0;
//		do {
//			try {
//				System.out.println("What would you like to edit?");
//				System.out.println(
//						"1.House/Apartment Number\n2.Street\n3.City\n4.State" + "\n5.Zipcode\n6.Country\n7.Quit");
//				input = Integer.parseInt(scanner.nextLine());
//				if (input == 1) {
//					while (true) {
//						try {
//							System.out.print("Apartment Number: ");
//							person.getAddress().setAptNum(Integer.parseInt(scanner.nextLine()));
//							break;
//						} catch (NumberFormatException e) {
//							System.out.println("Must be an number");
//						}
//					}
//				} else if (input == 2) {
//					System.out.print("Street: ");
//					person.getAddress().setStreet(scanner.nextLine());
//				} else if (input == 3) {
//					System.out.print("City: ");
//					person.getAddress().setCity(scanner.nextLine());
//				} else if (input == 4) {
//					System.out.print("State: ");
//					person.getAddress().setState(scanner.nextLine());
//				} else if (input == 5) {
//					while (true) {
//						try {
//							System.out.print("Zipcode: ");
//							person.getAddress().setZipcode(Integer.parseInt(scanner.nextLine()));
//							break;
//						} catch (NumberFormatException e) {
//							System.out.println("Must be an number");
//						}
//					}
//				} else if (input == 6) {
//					System.out.print("State: ");
//					person.getAddress().setCountry(scanner.nextLine());
//				}
//			} catch (NumberFormatException e) {
//				System.out.println("Please select 1-7");
//			}
//		} while (input != 7);
//	}
//
//}
