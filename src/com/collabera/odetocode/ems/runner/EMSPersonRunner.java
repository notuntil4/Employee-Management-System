package com.collabera.odetocode.ems.runner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.collabera.odetocode.ems.address.Address;
import com.collabera.odetocode.ems.person.Person;

public class EMSPersonRunner {
	private static ArrayList<Person> p = new ArrayList<Person>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int input = 0;
		do {
			try {
				System.out.println(
						"1.Add Person\n2.Delete Person" + "\n3.Edit Person\n4.Display Person\n5.Display All\n6.Exit");
				input = Integer.parseInt(scanner.nextLine());
				if (input == 1) {
					addPerson();
				} else if (input == 2) {
					deletePerson();
				} else if (input == 3) {
					editPerson();
				} else if (input == 4) {
					displayPerson();
				} else if (input == 5) {
					displayAll();
				}
			} catch (NumberFormatException e) {
				System.out.println("Please select 1-6");
			}
		} while (input != 6);
		scanner.close();
		System.out.println("Have a nice day!");
	}

	private static void addPerson() {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		int age, aptNum, zipcode, ssn;
		long phone;
		while (true) {
			try {
				System.out.print("Age: ");
				age = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be an number");
			}
		}

		System.out.print("---Address---\nHouse/Apartment Number: ");
		while (true) {
			try {
				aptNum = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be an number");
				System.out.print("Apartment Number: ");
			}
		}
		System.out.print("Street: ");
		String street = scanner.nextLine();
		System.out.print("City: ");
		String city = scanner.nextLine();
		System.out.print("State: ");
		String state = scanner.nextLine();
		while (true) {
			try {
				System.out.print("Zipcode: ");
				zipcode = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be an number");
			}
		}
		System.out.print("Country: ");
		String country = scanner.nextLine();
		Address address = new Address(street, city, state, country, aptNum, zipcode);

		while (true) {
			try {
				System.out.print("SSN: ");
				ssn = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be an number");
			}
		}
		while (true) {
			try {
				System.out.print("Phone #: ");
				phone = Long.parseLong(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be an number");
			}
		}
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		String email;
		while (true) {
			System.out.print("Email: ");
			email = scanner.nextLine();
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				break;
			} else {
				System.out.println("Must be a valid email");
			}
		}
		p.add(new Person(name, email, age, ssn, phone, address));
	}

	private static void deletePerson() {
		System.out.print("Delete person by name: ");
		String name = scanner.nextLine();
		int i = 0;
		for (i = 0; i < p.size(); i++) {
			if (p.get(i).getName().equals(name)) {
				break;
			}
		}
		p.remove(i);
	}

	private static void editPerson() {
		System.out.print("Edit person by name: ");
		String name = scanner.nextLine();
		int i = -1;
		for (int j = 0; j < p.size(); j++) {
			if (p.get(j).getName().equals(name)) {
				i = j;
			}
		}
		if (i == -1) {
			System.out.println("Could not find " + name);
			return;
		}
		int input = 0;
		do {
			try {
				System.out.println("What would you like to edit?");
				System.out.println("1.Name\n2.Age\n3.Address\n4.SSN\n5.Phone\n6.Email\n7.Quit");
				input = Integer.parseInt(scanner.nextLine());
				if (input == 1) {
					System.out.print("Name: ");
					p.get(i).setName(scanner.nextLine());
				} else if (input == 2) {
					while (true) {
						try {
							System.out.print("Age: ");
							p.get(i).setAge(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Must be an number");
						}
					}
				} else if (input == 3) {
					editAddress(i);
				} else if (input == 4) {
					while (true) {
						try {
							System.out.print("SSN: ");
							p.get(i).setSsn(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Must be an number");
						}
					}
				} else if (input == 5) {
					while (true) {
						try {
							System.out.print("Phone #: ");
							p.get(i).setPhone(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Must be an number");
						}
					}
				} else if (input == 6) {
					String regex = "^(.+)@(.+)$";
					Pattern pattern = Pattern.compile(regex);
					String email;
					while (true) {
						System.out.print("Email: ");
						email = scanner.nextLine();
						Matcher matcher = pattern.matcher(email);
						if (matcher.matches()) {
							break;
						} else {
							System.out.println("Must be a valid email");
						}
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Please select 1-7");
			}
		} while (input != 7);
	}

	private static void editAddress(int i) {
		int input = 0;
		do {
			try {
				System.out.println("What would you like to edit?");
				System.out.println(
						"1.House/Apartment Number\n2.Street\n3.City\n4.State" + "\n5.Zipcode\n6.Country\n7.Quit");
				input = Integer.parseInt(scanner.nextLine());
				if (input == 1) {
					while (true) {
						try {
							System.out.print("Apartment Number: ");
							p.get(i).getAddress().setAptNum(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Must be an number");
						}
					}
				} else if (input == 2) {
					System.out.print("Street: ");
					p.get(i).getAddress().setStreet(scanner.nextLine());
				} else if (input == 3) {
					System.out.print("City: ");
					p.get(i).getAddress().setCity(scanner.nextLine());
				} else if (input == 4) {
					System.out.print("State: ");
					p.get(i).getAddress().setState(scanner.nextLine());
				} else if (input == 5) {
					while (true) {
						try {
							System.out.print("Zipcode: ");
							p.get(i).getAddress().setZipcode(Integer.parseInt(scanner.nextLine()));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Must be an number");
						}
					}
				} else if (input == 6) {
					System.out.print("State: ");
					p.get(i).getAddress().setCountry(scanner.nextLine());
				}
			} catch (NumberFormatException e) {
				System.out.println("Please select 1-7");
			}
		} while (input != 7);
	}

	
	
	private static void displayPerson() {
		System.out.print("Display person by name: ");
		String name = scanner.nextLine();
		int i = 0;
		for (i = 0; i < p.size(); i++) {
			if (p.get(i).getName().equals(name)) {
				System.out.println(p.get(i));
				break;
			}
		}
	}

	private static void displayAll() {
		for (int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i));
		}
	}
}