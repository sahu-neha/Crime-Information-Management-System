package ui;

import java.util.Scanner;

public class UIMain {

	// -----------------------------------//

	public static void login(Scanner sc) {

		System.out.println("Enter your email");
		String mail = sc.next();

		System.out.println("Enter pw");
		String pw = sc.next();

//		EmployeeDAO deptDao = new EmployeeImplDAO();
//
//		try {
//			System.out.println("Welcome " + deptDao.login(mail, pw));
//		} catch (SomethingWentWrongException e) {
//			System.out.println(e.getMessage());
//		}
	}

	// -----------------------------------//

	public static void addCrimeAsAdmin(Scanner sc) {

		
		
	}

	// -----------------------------------//

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {
			System.out.println("---------------------------");
			System.out.println("Please select a valid option");
			System.out.println("---------------------------");

			System.out.println("Select 1 to login and register a crime as an administrator");
			System.out.println("select 2 to update an already registered crime");
			System.out.println("select 3 to add a criminal details");

			System.out.println("select 3 to add an existing employee to a department");
			System.out.println("select 4 to login an employee display his profile with a Welcome message");
			System.out.println("select 5 to get the all department details");
			System.out.println("select 6 to Update the Department location");
			System.out.println("select 7 to Update the existing employee password");
			System.out.println("select 8 to delete a Department by dept ID");
			System.out.println("select 0 to exit");

			System.out.println("---------------------------");

			choice = sc.nextInt();

			switch (choice) {
			// ----------------//
			case 1:
				System.out.println("Please enter your username");
				String un = sc.next().toLowerCase();

				System.out.println("Please enter your password");
				String pw = sc.next().toLowerCase();

				if (un.equals("admin") && pw.equals("admin")) {
					System.out.println("Welcome, Admin !");
					addCrimeAsAdmin(sc);
				}

				break;
			// ----------------//
			case 2:
				break;
			// ----------------//
			case 3:
				break;
			// ----------------//
			case 4:
				break;
			// ----------------//
			case 5:
				break;
			// ----------------//
			case 6:
				break;
			// ----------------//
			case 7:
				break;
			// ----------------//
			case 8:
				break;
			// ----------------//
			case 0:
				System.out.println("Thank you for using our service ~ Team Crime Studio / Criminology / Crime Net");
				break;
			// ----------------//
			default:
				System.out.println("Please select a valid option");
			}

		} while (choice != 0);

		sc.close();

	}

}
