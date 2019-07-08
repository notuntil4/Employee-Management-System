package com.collabera.odetocode.ems.runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.collabera.odetocode.ems.address.Address;
import com.collabera.odetocode.ems.department.Department;
import com.collabera.odetocode.ems.employee.Employee;
import com.collabera.odetocode.ems.employee.EmployeeType;
import com.collabera.odetocode.ems.employee.EmployeeTypeEnum;
import com.collabera.odetocode.ems.filemanagement.ReadFromFile;
import com.collabera.odetocode.ems.filemanagement.WriteToFile;
import com.collabera.odetocode.ems.office.InvalidEmailException;
import com.collabera.odetocode.ems.office.NoOfficeFoundException;
import com.collabera.odetocode.ems.office.Office;
import com.collabera.odetocode.ems.text.Text;

public class EMSRunner {
	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static ArrayList<Office> officeList = new ArrayList<Office>();
	private static ArrayList<Department> departmentList = new ArrayList<Department>();
	private static Scanner scanner = new Scanner(System.in);
	private static Text text;
	public static void main(String[] args) throws ParseException {
		/*officeList.add(new Office(Long.parseLong("9992034765"), "Office1@gmail.com", 
				new Address("Wall Street", "New York", "NY", "USA", 11, 10118)));
		officeList.add(new Office(Long.parseLong("9912003947"), "Office2@gmail.com", 
				new Address("B Baker St", "London", "England", "England", 221, 10023)));
		officeList.add(new Office(Long.parseLong("123456789"), "Office3@yahoo.com", 
				new Address("Mt Lee Dr.", "Hollywood", "CA", "USA", 4059 , 90068)));
		departmentList.add(new Department("HR",20000.50));
		departmentList.add(new Department("Marketing",250000));
		departmentList.add(new Department("R/D",1000000));
		employeeList.add(new EmployeeType.FullTime("Darth Vader", "darkSid3@deathstar.com", 45, 12345678, Long.parseLong("12332112343"), 
				new Address("Death Star", "Space", "More Space", "All the Space", 1 , 00000), 
				"Sith Lord", 1000, 1000,
				1000000000, 40, null, EmployeeTypeEnum.FULLTIME));
		employeeList.add(new EmployeeType.FullTime("Sherlock Homes", "puzzlez@solved.com", 35, 345434545, 1121221211, 
				new Address("B Baker St", "London", "England", "England", 221, 10023), 
				"Detective", 1000, 1001,
				11, 40, null, EmployeeTypeEnum.FULLTIME));
		employeeList.add(new EmployeeType.FullTime("Tony Stark", "arc@stark.com", 52, 10101010, 1111111111, 
				new Address("Malibu Point", "Los Angeles County", "California", "USA", 10880, 90265),
				"Iron Man", 1002, 1000,
				1000000, 40, null, EmployeeTypeEnum.FULLTIME));
				*/
		load();
		text = new Text();
		int input = 0;
		do {
			try {
				text.writeToScreen("1.Employee Menu\n2.Office Menu"
						+ "\n3.Department Menu\n4.Option\n5.Exit");
				input = Integer.parseInt(scanner.nextLine());
				text.writeToScreen();
				if(input == 1) {
					employeeMenu();
				} else if(input == 2) {
					officeMenu();
				} else if(input == 3) {
					departmentMenu();
				} else if(input == 4) {
					optionsMenu();
				}
			} catch(NumberFormatException e) {
				text.writeToScreen("Please select 1-5");
			}
		}while(input != 5);
		scanner.close();
		save();
		text.writeToScreen("Have a nice day!");
	}
	private static void employeeMenu() throws ParseException {
		if(officeList.isEmpty()) {
			text.writeToScreen("Must create an Office first");
			text.writeToScreen();
			return;
		}
		if(departmentList.isEmpty()) {
			text.writeToScreen("Must create a Department first");
			text.writeToScreen();
			return;
		}
		int input = 0;
		do {
			try {
				text.writeToScreen("What would you like to do?");
				text.writeToScreen("1.Add Employee\n2.Delete Employee"
					+ "\n3.Edit Employee\n4.Display Employee\n5.Display All\n6.Display by Department\n7.Display by Office\n8.Back");
				input = Integer.parseInt(scanner.nextLine());
				text.writeToScreen();
				if (input == 1) {
					addEmployee();
				} else if (input == 2) {
					deleteEmployee();
				} else if (input == 3) {
					editEmployee();
				} else if (input == 4) {
					displayEmployee();
				} else if (input == 5) {
					displayAllEmployees();
				} else if (input == 6) {
					displayByDepartment();
				} else if (input == 7) {
					displayByOffice();
				} 
			}catch(NumberFormatException e) {
				text.writeToScreen("Please select 1-8");
			}
		} while (input != 8);
	}
	private static void officeMenu() {
		int choice = 0;
		while(choice != 6) {
			text.writeToScreen("Select Choice:\n1.Add Office\n2.Edit Office"
					+ "\n3.Delete Office\n4.Display Office\n5.Display All Offices\n6.Back");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
				text.writeToScreen();
				switch (choice) {
				case 1:	
					addOffice();
					break;
				case 2:
					editOffice();
					break;
				case 3:
					deleteOffice();
					break;
				case 4:
					displayOffice();
					break;
				case 5:
					displayAllOffices();
					break;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				text.writeToScreen("Enter a number for menu choice.");
			}
		}
	}
	private static void departmentMenu() {
		int input = 0;
		do {
			try {
				text.writeToScreen("1.Add Department\n2.Delete Department"
						+ "\n3.Edit Department\n4.Display Department\n5.Display All Departments\n6.Back");
				input = Integer.parseInt(scanner.nextLine());
				text.writeToScreen();
				if(input == 1) {
					addDepartment();
				} else if(input == 2) {
					deleteDepartment();
				} else if(input == 3) {
					editDepartment();
				} else if(input == 4) {
					displayDepartment();
				} else if(input == 5) {
					displayAllDepartments();
				} 
			} catch(NumberFormatException e) {
				text.writeToScreen("Please select 1-6");
			}
		}while(input != 6);
	}
	private static void optionsMenu() {
		int input = 0;
		do {
			try {
				text.writeToScreen("1.Default Text\n2.Bubble Text"
						+ "\n3.Line Text\n4.Back");
				input = Integer.parseInt(scanner.nextLine());
				text.writeToScreen();
				if(input == 1) {
					text.setTextDefault();
				} else if(input == 2) {
					text.setTextBubble();
				} else if(input == 3) {
					text.setTextLine();
				}
			} catch(NumberFormatException e) {
				text.writeToScreen("Please select 1-4");
			}
		}while(input != 4);
	}
	private static void addEmployee() throws ParseException {
		String name = makeName();
        int age = makeAge();
        Address address = makeAddress();
        int ssn = makeSSN();
        long phone = makePhone();
		String email = makeEmail();
		EmployeeTypeEnum employeeType = null;
		while (employeeType == null) {
			text.writeToScreen("Enter employment type:");
			text.writeToScreen("1.Full Time\n2.Part Time" + "\n3.Contract\n4.Intern");
			switch (Integer.parseInt(scanner.nextLine())) {
			case 1:
				employeeType = EmployeeTypeEnum.FULLTIME;
				break;
			case 2:
				employeeType = EmployeeTypeEnum.PARTTIME;
				break;
			case 3:
				employeeType = EmployeeTypeEnum.CONTRACT;
				break;
			case 4:
				employeeType = EmployeeTypeEnum.INTERN;
				break;
			default:
				text.writeToScreen("Please enter a number between 1 and 4");
			}
		}
		
		String position = makePosition();
	    int depID = makeDepID();
	    int officeID = makeOfficeID();
	    double hourlyWage = makeHourlyWage();
	    int weeklyHours = makeWeeklyHours();
		LocalDate date = makeDate();
	    
		//TODO
		if (employeeType.equals(EmployeeTypeEnum.FULLTIME)) {
			employeeList.add(new EmployeeType.FullTime(name, email, age, ssn, phone, address, position, depID, officeID,
					hourlyWage, weeklyHours, date, employeeType));
		} else if (employeeType.equals(EmployeeTypeEnum.PARTTIME)) {
			employeeList.add(new EmployeeType.PartTime(name, email, age, ssn, phone, address, position, depID, officeID,
					hourlyWage, weeklyHours, date, employeeType));
		} else if (employeeType.equals(EmployeeTypeEnum.CONTRACT)) {
			employeeList.add(new EmployeeType.Contract(name, email, age, ssn, phone, address, position, depID, officeID,
					hourlyWage, weeklyHours, date, employeeType));
		} else if (employeeType.equals(EmployeeTypeEnum.INTERN)) {
			employeeList.add(new EmployeeType.Intern(name, email, age, ssn, phone, address, position, depID, officeID,
					hourlyWage, weeklyHours, date, employeeType));
		}
		text.writeToScreen("\nEmployee created with ID: " 
				+ employeeList.get(employeeList.size() - 1).getID() + "\n");
	}
	private static void deleteEmployee() {
		if(employeeList.isEmpty()) {
			text.writeToScreen("There are no employees\n");
			return;
		}
		int idToDelete = -1;
		while (true) {
			try {
				for (Employee e : employeeList) {
					text.writeToScreen("Name: " + e.getName() + "\nID: " + e.getID());
				}
				text.writeToScreen("Choose an employee to delete (Select ID): ");
				idToDelete = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				text.writeToScreen("Must be an ID");
			}
		}
		boolean removed = false;
		for (Employee e : employeeList) {
			if (e.getID() == idToDelete) {
				employeeList.remove(e);
				removed = true;
				text.writeToScreen(e.getName() + " successfully removed\n");
				break;
			}
		}
		if (removed == false) {
			text.writeToScreen("ID not found");
		}
	}
	private static void editEmployee() throws ParseException {
		if(employeeList.isEmpty()) {
			text.writeToScreen("There are no employees\n");
			return;
		}
		int idToEdit = -1;
		while (true) {
			try {
				for (Employee e : employeeList) {
					text.writeToScreen("Name: " + e.getName() + "\nID: " + e.getID());
				}
				text.writeToScreen("Choose an employee to edit (Select ID): ");
                idToEdit = Integer.parseInt(scanner.nextLine());
                text.writeToScreen();
				break;
			} catch (NumberFormatException e) {
				text.writeToScreen("Must be an ID");
			}
		}
		boolean edited = false;
		Employee editEmployee = new Employee();
		for (Employee e : employeeList) {
			if (e.getID() == idToEdit) {
				text.writeToScreen(e.toString());
				edited = true;
				editEmployee = e;
				break;
			}
		}
		if (edited == false) {
			text.writeToScreen("ID not found");
		}
		int input = 0;
		if (edited == true) {
			do {
				try {
					text.writeToScreen("What would you like to edit?");
					text.writeToScreen(
							"1.Edit Name\n2.Edit Age\n3.Edit Address\n4.Edit SSN\n5.Edit Phone"
									+ "\n6.Edit Email\n7.Edit Position\n8.Edit Department"
									+ "\n9.Edit Office\n10.Edit Hourly Wage"
									+ "\n11.Hours Worked\n12.Edit Employment Type\n13.Edit Start Date\n14.Back");
					input = Integer.parseInt(scanner.nextLine());
					text.writeToScreen();
					if (input == 1) {
                        editEmployee.setName(makeName());
                    } else if (input == 2) {
                        editEmployee.setAge(makeAge());
                    } else if (input == 3) {
                        editAddress(editEmployee.getAddress());
                    } else if (input == 4) {
                        editEmployee.setSsn(makeSSN());
                    } else if (input == 5) {
                        editEmployee.setPhone(makePhone());
                    } else if (input == 6) {
                        editEmployee.setEmail(makeEmail());
                    } else if (input == 7) {
                        editEmployee.setPosition(makePosition());
                    } else if (input == 8) {
                        editEmployee.setDepartmentID(makeDepID());
                    } else if (input == 9) {
                        editEmployee.setOfficeID(makeOfficeID());
                    } else if (input == 10) {
                        editEmployee.setHourlyWage(makeHourlyWage());
                    } else if (input == 11) {
                        editEmployee.setWeeklyHours(makeWeeklyHours());
					} else if (input == 12) {
						EmployeeTypeEnum employeeType = null;
						while (employeeType == null) {
							text.writeToScreen("Enter employment type:");
							text.writeToScreen("1.Full Time\n2.Part Time" + "\n3.Contract\n4.Intern");
							switch (Integer.parseInt(scanner.nextLine())) {
							case 1:
								employeeList.remove(editEmployee);
								employeeType = EmployeeTypeEnum.FULLTIME;
								editEmployee.setEmployeeType(employeeType);
								employeeList.add(new EmployeeType.FullTime(editEmployee));
								break;
							case 2:
								employeeList.remove(editEmployee);
								employeeType = EmployeeTypeEnum.PARTTIME;
								editEmployee.setEmployeeType(employeeType);
								employeeList.add(new EmployeeType.PartTime(editEmployee));
								break;
							case 3:
								employeeList.remove(editEmployee);
								employeeType = EmployeeTypeEnum.CONTRACT;
								editEmployee.setEmployeeType(employeeType);
								employeeList.add(new EmployeeType.Contract(editEmployee));
								break;
							case 4:
								employeeList.remove(editEmployee);
								employeeType = EmployeeTypeEnum.INTERN;
								editEmployee.setEmployeeType(employeeType);
								employeeList.add(new EmployeeType.Intern(editEmployee));
								break;
							default:
								text.writeToScreen("Please enter a number between 1 and 4");
							}
						}
					} else if(input == 13) {
						editEmployee.setStartDate(makeDate());
					}
				} catch (NumberFormatException e) {
					text.writeToScreen("Please select 1-14");
				}
			} while (input != 14);
			text.writeToScreen("Successfully updated "+ editEmployee.getName() + "\n");
		}
	}
	private static void displayEmployee() {
		int idToDisplay = -1;
		while (true) {
			try {
				text.writeToScreen("Choose an employee to display their info (Select ID): ");
				for (Employee e : employeeList) {
					text.writeToScreen("Name: " + e.getName() + " ID: " + e.getID());
				}
				idToDisplay = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				text.writeToScreen("Must be an ID");
			}
		}
		boolean displayed = false;
		for (Employee e : employeeList) {
			if (e.getID() == idToDisplay) {
				text.writeToScreen(e.toString());
				displayed = true;
				break;
			}
		}
		if (displayed == false) {
			text.writeToScreen("ID not found");
		}
		text.writeToScreen();
	}
	private static void displayAllEmployees() {
		if(employeeList.isEmpty()) {
			text.writeToScreen("There are no employees\n");
			return;
		}
		for (Employee e : employeeList) {
			text.writeToScreen("\n----------\n" + e.toString() + "\n----------");
		}
		text.writeToScreen();
	}
	private static void displayByDepartment() {
		int depID = -1;
		while (depID == -1) {
			try {
				text.writeToScreen("Choose a department by ID: ");
				for (Department d : departmentList) {
					text.writeToScreen(d.getDepartmentID() + " - " + d.getDepartmentName());
				}
				int depIDin = Integer.parseInt(scanner.nextLine());
				for (Department d : departmentList) {
					if (d.getDepartmentID() == depIDin) {
						depID = d.getDepartmentID();
						for(Employee e : employeeList) {
							if(e.getDepartmentID() == depID) {
								text.writeToScreen("\n----------\n" + e.toString() + "\n----------");
							}
						}
						break;
					}
				}
				if (depID == -1) {
					text.writeToScreen("That department does not exist.\n");
				}
			} catch(NumberFormatException e) {
				text.writeToScreen("Please enter a number");
			}
		}
		
	}
	private static void displayByOffice() {
		int offID = -1;
		while (offID == -1) {
			try {
				text.writeToScreen("Choose an office by ID: ");
				for (Office o : officeList) {
					text.writeToScreen(o.getOfficeID() + " - " + o.getName());
				}
				int offIDin = Integer.parseInt(scanner.nextLine());
				for (Office o : officeList) {
					if (o.getOfficeID() == offIDin) {
						offID = o.getOfficeID();
						for(Employee e : employeeList) {
							if(e.getOfficeID() == offID) {
								text.writeToScreen("\n----------\n" + e.toString() + "\n----------");
							}
						}
						break;
					}
				}
				if (offID == -1) {
					text.writeToScreen("That office does not exist.\n");
				}
			} catch(NumberFormatException e) {
				text.writeToScreen("Please enter a number");
			}
		}
	}
	private static void addOffice() {
		String email = makeEmail();
		long phoneNum = makePhone();
		Address address = makeAddress();	
		officeList.add(new Office(phoneNum, email, address));
		text.writeToScreen("\nOffice created with ID " 
				+ officeList.get(officeList.size() - 1).getOfficeID() + "\n");
	}
	private static void deleteOffice() {
		if(officeList.isEmpty()) {
			text.writeToScreen("There are no Offices\n");
			return;
		}
		while(true) {
			try {
				for(int i = 0; i < officeList.size(); i++) {
					text.writeToScreen(officeList.get(i).getName() + "\nID: " + officeList.get(i).getOfficeID());
				}
				text.writeToScreen();
				text.writeToScreen("Type office ID for office you want to delete: ");
				int toDelete = scanner.nextInt();
				scanner.nextLine();
				boolean deleted = false;
				for(int i = 0; i < officeList.size() && !deleted; i++) {
					if (officeList.get(i).getOfficeID() == toDelete) {
						text.writeToScreen("Deleted " + officeList.get(i).getName());
						officeList.remove(i);
						deleted = true;
					}
				}
				if(!deleted)
					throw new NoOfficeFoundException();
				break;
			} catch (NumberFormatException e) {
				text.writeToScreen("Invalid id for office.");
			} catch (NoOfficeFoundException e) {
				text.writeToScreen("No office to delete with that id.");
			}
		}
		text.writeToScreen();
		//TODO change emps with off to N/A
	}
	private static void editOffice() {
		if(officeList.isEmpty()) {
			text.writeToScreen("There are no Offices\n");
			return;
		}
		Office editOffice = null;
		boolean validChoice = false;
		while (!validChoice) {
			text.writeToScreen("Enter ID of office you want to edit");
			for(int i = 0; i < officeList.size(); i++) {
				text.writeToScreen(officeList.get(i).getName() + "\nID: " + officeList.get(i).getOfficeID());
			}
			try {
				int id = scanner.nextInt();
				scanner.nextLine();
				boolean found = false;
				for (int i = 0; i < officeList.size() && !found; i++) {
					if (officeList.get(i).getOfficeID() == id) {
						editOffice = officeList.get(i);
						found = true;
					}
				}
				if (!found)
					throw new NoOfficeFoundException();
				validChoice = true;
			} catch (NumberFormatException e) {
				text.writeToScreen("Enter a number for ID.");
			} catch (NoOfficeFoundException e) {
				text.writeToScreen("Invalid office ID.");
			}
		}
		int choice;
		boolean madeChoice = false;
		while (!madeChoice) {
			try {
				text.writeToScreen("Edit: \n1.Phone# \n2.Email \n3.Address");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					editOffice.setPhoneNumber(makePhone());
					madeChoice = true;
					break;
				case 2:
					editOffice.setEmail(makeEmail());
					break;
				case 3:
					editAddress(editOffice.getAddress());
					madeChoice = true;
					break;
				default:
					text.writeToScreen("Select from the choices listed.");
					break;
				}
			} catch (NumberFormatException e) {
				text.writeToScreen("Select from the choices listed.");
			}
		}
		text.writeToScreen("Succesfully updated!");
	}
	private static void displayOffice() {
		if(officeList.isEmpty()) {
			text.writeToScreen("There are no Offices\n");
			return;
		}
		while(true)
		{
			text.writeToScreen("Enter ID of office to display: ");
			try {
				int toDisplay = scanner.nextInt();
				boolean found = false;	
				for (int i = 0; i < officeList.size() && !found; i++) {
					if (officeList.get(i).getOfficeID() == toDisplay) {
						text.writeToScreen(officeList.get(i).toString());
						found = true;				
					}
				}
				if(!found)
					throw new NoOfficeFoundException();
				break;
			} catch (NumberFormatException e) {
				text.writeToScreen("Enter proper ID for office.");
			} catch (NoOfficeFoundException e) {
				text.writeToScreen("Office with that ID not found.");
			}	
		}
	}
	private static void displayAllOffices() {
		if(officeList.isEmpty()) {
			text.writeToScreen("There are no Offices\n");
			return;
		}
		for(int i = 0; i < officeList.size(); i++) {
			text.writeToScreen(officeList.get(i).toString());
		}
		text.writeToScreen();
	}
	private static void addDepartment() {
		String name = makeName();
	    double budget = makeBudget();
		departmentList.add(new Department(name, budget));
		text.writeToScreen("\nDepartment created with ID: "
				+ departmentList.get(departmentList.size() - 1).getDepartmentID() + "\n");
	}
	private static void deleteDepartment() {
		if(departmentList.isEmpty()) {
			text.writeToScreen("There are no departments\n");
			return;
		}
		for(Department d : departmentList) {
			text.writeToScreen(d.getDepartmentName());
		}
		text.writeToScreen("Delete Department by name: ");
		String name = scanner.nextLine();
		int i = 0;
		for(i = 0; i < departmentList.size(); i++) {
			if(departmentList.get(i).getDepartmentName().equals(name)) {
				break;
			}
		}
		text.writeToScreen("\nDeleted " + departmentList.get(i).getDepartmentName());
		departmentList.remove(i);
		text.writeToScreen();
		//TODO change emps with dep to N/A
	}
	private static void editDepartment() {
		if(departmentList.isEmpty()) {
			text.writeToScreen("There are no departments\n");
			return;
		}
		text.writeToScreen("Edit Department by name: ");
		String name = scanner.nextLine();
		int i = -1;
		for(int j = 0; j < departmentList.size(); j++) {
			if(departmentList.get(j).getDepartmentName().equals(name)) {
				i = j;
			}
		}
		if(i == -1) {
			text.writeToScreen("Could not find " + name);
			return;
		}
		int input = 0;
		do {
			try {
				text.writeToScreen("What would you like to edit?");
				text.writeToScreen("1.Department name\n2.Budget\n3.Back");
				input = Integer.parseInt(scanner.nextLine());
				if(input == 1) {			 
                    departmentList.get(i).setDepartmentName(makeName());
                } else if(input == 2) {
                    departmentList.get(i).setDepartmentBudget(makeBudget());
                } 
 
			} catch(NumberFormatException e) {
				text.writeToScreen("Please select 1-3");
			}
		}while(input != 3);
		text.writeToScreen("Succesfully updated!");
	}
	private static void displayDepartment() {
		text.writeToScreen("Display Department by name: ");
		String name = scanner.nextLine();
		int i = 0;
		for(i = 0; i < departmentList.size(); i++) {
			if(departmentList.get(i).getDepartmentName().equals(name)) {
				text.writeToScreen(departmentList.get(i).toString());
				break;
			}
		}
	}
	private static void displayAllDepartments() {
		if(departmentList.isEmpty()) {
			text.writeToScreen("There are no departments\n");
			return;
		}
		for(int i = 0; i < departmentList.size(); i++) {
			text.writeToScreen(departmentList.get(i).toString());
		}
		text.writeToScreen();
	}
	private static Address makeAddress() {
		int aptNum, zipcode;
		String regex = "^\\d{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
		text.writeToScreen("---Address---\nHouse/Apartment Number: ");
		while(true){
			try {
				aptNum = Integer.parseInt(scanner.nextLine());
				break;
			} catch(NumberFormatException e) {
				text.writeToScreen("Must be an number");
				text.writeToScreen("Apartment Number: ");
			}
		}
		String street = "";
		do {
			text.writeToScreen("Street: ");
			street = scanner.nextLine();
		}while(street.isEmpty());
		String city = "";
		do {
			text.writeToScreen("City: ");
			city = scanner.nextLine();
		}while(city.isEmpty());
		String state = "";
		do {
			text.writeToScreen("State: ");
			state = scanner.nextLine();
		}while(state.isEmpty());
		while(true){
		    text.writeToScreen("Zipcode: ");
            String zip = scanner.nextLine(); 
            matcher = pattern.matcher(zip); 
            if (matcher.matches()) {
                zipcode = Integer.parseInt(zip);
                break;
            } else {
                text.writeToScreen("Must be a valid Zipcode");
            }
		}
		String country = "";
		do {
			text.writeToScreen("Country: ");
			country = scanner.nextLine();
		}while(city.isEmpty());
		text.writeToScreen("-------------");
		return new Address(street, city, state, country, aptNum, zipcode);
	}
	private static void editAddress(Address address) {
		int input = 0;
		do {
			try {
				text.writeToScreen("What would you like to edit?");
				text.writeToScreen(
						"1.House/Apartment Number\n2.Street\n3.City\n4.State" + "\n5.Zipcode\n6.Country\n7.Back");
				input = Integer.parseInt(scanner.nextLine());
				if (input == 1) {
					while (true) {
						try {
							text.writeToScreen("Apartment Number: ");
							address.setAptNum(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							text.writeToScreen("Must be an number");
						}
					}
				} else if (input == 2) {
					text.writeToScreen("Street: ");
					address.setStreet(scanner.nextLine());
				} else if (input == 3) {
					text.writeToScreen("City: ");
					address.setCity(scanner.nextLine());
				} else if (input == 4) {
					text.writeToScreen("State: ");
					address.setState(scanner.nextLine());
				} else if (input == 5) {
					String regex = "^\\d{5}$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    while (true) {
 
                        text.writeToScreen("Zipcode: ");
                        String zip = scanner.nextLine(); 
                        matcher = pattern.matcher(zip); 
                        if (matcher.matches()) {
                            address.setZipcode(Integer.parseInt(zip));
                            break;
                        } else {
                            text.writeToScreen("Must be a valid Zipcode");
                        }
                    }
				} else if (input == 6) {
					text.writeToScreen("State: ");
					address.setCountry(scanner.nextLine());
				}
			} catch (NumberFormatException e) {
				text.writeToScreen("Please select 1-7");
			}
		} while (input != 7);
		text.writeToScreen("Succesfully updated!");
	}
	private static String makeName() {
		String name = "";
		do {
			text.writeToScreen("Name: ");
			name = scanner.nextLine();
		}while(name.isEmpty());
		return name;
	}
	private static long makePhone() {
		String regex = "^\\d{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		long phone;
		while (true) {
			text.writeToScreen("Phone #: ");
			String phoneStr = scanner.nextLine(); 
			matcher = pattern.matcher(phoneStr);	
			if (matcher.matches()) {
				phone = Long.parseLong(phoneStr);
				break;
			} else {
				text.writeToScreen("Must be a valid Phone Number");
			}
		}
		return phone;
	}
	private static String makeEmail() {
		while(true) {
			text.writeToScreen("Enter email address: ");
			try {
				String email = scanner.nextLine();
				String regex = "^(.+)@(.+)$";
				if (!email.matches(regex))
					throw new InvalidEmailException();
				return email;
			} catch (InvalidEmailException e) {
				text.writeToScreen("\nEmail not valid\n");
			}
		}
	}
	private static LocalDate makeDate() throws ParseException {
		
		while(true) {
			
			try {
				text.writeToScreen("Enter start date (MM/dd/YYYY): ");
				String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher;
			   String dateStr = scanner.nextLine();
				matcher = pattern.matcher(dateStr);
				if (matcher.matches()) {
					String year = dateStr.substring(dateStr.length()-4);
				    String month = dateStr.substring(0,2);
				    String day = dateStr.substring(3,5);
					LocalDate localDate = LocalDate.parse(year+"-"+month+"-"+day);
				    return localDate;
				} else {
					text.writeToScreen("Must be a valid Date (MM/dd/yyyy)");
				}
			} catch(DateTimeParseException e) {
				text.writeToScreen("Invalid date ");
			}
		  }
	}
	private static int makeSSN() {
        String regex = "^\\d{9}$";
 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String input;
        while(true) {
            text.writeToScreen("SSN: ");
            input = scanner.nextLine();
 
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                break;
 
 
            } else {
                text.writeToScreen("Must be a valid Social Security Number");
 
            }
        }
        return Integer.parseInt(input);
    }
    private static int makeAge() {
        int age;
        while (true) {
            try {
                text.writeToScreen("Age: ");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                text.writeToScreen("Must be an number");
            }
        }
        return age;
    }
    private static String makePosition() {
        String position = "";
        do {
        	text.writeToScreen("Enter position: ");
			position = scanner.nextLine();
		}while(position.isEmpty());
		return position;
    }
    private static int makeDepID() {
        int depID = -1;
        while (depID == -1) {
            try {
                text.writeToScreen("Choose a department by ID: ");
                for (Department d : departmentList) {
                    text.writeToScreen(d.getDepartmentID() + " - " + d.getDepartmentName());
                }
                int depIDin = Integer.parseInt(scanner.nextLine());
                for (Department d : departmentList) {
                    if (d.getDepartmentID() == depIDin) {
                        depID = d.getDepartmentID();
                        break;
                    }
                }
                if (depID == -1) {
                    text.writeToScreen("That department does not exist.\n");
                }
            } catch(NumberFormatException e) {
                text.writeToScreen("Please enter a number");
            }
        }
        return depID;
    }
    private static int makeOfficeID() {
        int officeID = -1;
        while (officeID == -1) {
            try {
                text.writeToScreen("Choose an office by ID: ");
                for (Office o : officeList) {
                    text.writeToScreen(o.getOfficeID() + " - " + o.getAddress().getCity());
                }
                int officeName = Integer.parseInt(scanner.nextLine());
                for (Office o : officeList) {
                    if (o.getOfficeID() == officeName) {
                        officeID = o.getOfficeID();
                        break;
                    }
                }
                if (officeID == -1) {
                    text.writeToScreen("That office does not exist.\n");
                }
            } catch(NumberFormatException e) {
                text.writeToScreen("Please enter a number");
            }
        }
        return officeID;
    }
    private static double makeHourlyWage() {
        double hourlyWage = 0;
        while (true) {
            try {
                text.writeToScreen("Enter hourly wage: ");
                hourlyWage = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                text.writeToScreen("Must be a number");
            }
        }
        return hourlyWage;
    }
    private static int makeWeeklyHours() {
        int weeklyHours = 0;
        while (true) {
            try {
                text.writeToScreen("Enter weekly hours: ");
                weeklyHours = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                text.writeToScreen("Must be a number");
            }
        }
        return weeklyHours;
    }
    private static double makeBudget() {
        double budget = 0;
        while(true) {
            try {
                text.writeToScreen("Budget: ");
                budget = Double.parseDouble(scanner.nextLine());
                break;
            } catch(NumberFormatException e) {
                text.writeToScreen("Must be an number");
            }
 
        }
        return budget;
    }
    private static void save() {
    	WriteToFile writeToFile = new WriteToFile();
    	try {
			writeToFile.setFileStream("./Resources/employee.data");
			writeToFile.writeEmployeesToFile(employeeList);
			writeToFile.setFileStream("./Resources/department.data");
			writeToFile.writeDeptToFile(departmentList);
			writeToFile.setFileStream("./Resources/office.data");
			writeToFile.writeOfficesToFile(officeList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private static void load() {
    	ReadFromFile readFromFile = new ReadFromFile();
    	try {
    		readFromFile.setFileStream("./Resources/employee.data");
    		employeeList = readFromFile.readEmployeeFile();
    		readFromFile.setFileStream("./Resources/department.data");
    		departmentList = readFromFile.readDeptFile();
    		readFromFile.setFileStream("./Resources/office.data");
    		officeList = readFromFile.readOfficeFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}