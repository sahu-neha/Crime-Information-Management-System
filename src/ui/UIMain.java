package ui;

import java.util.Scanner;

public class UIMain {

	// --------------------- M A I N - S T A R T ---------------------//

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {
			System.out.println();
			System.out.println("+-------------------------------------------------------------------+");
			System.out.println("|==== Welcome to Crime Net, Crime Information Management System ====|");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("|   Select 1 For Admin Log In                                       |");
			System.out.println("|   Select 2 For Public Portal                                      |");
			System.out.println("|   Select 0 to Close The Application                               |");
			System.out.println("+-------------------------------------------------------------------+");
			System.out.println();
			
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println();
				System.out.println("Wrong Input Selected");
				System.out.println();
				main(null);
			}

			switch (choice) {

			case 1:
				System.out.println("Please Enter Admin Username ");
				String un = sc.next().toLowerCase();

				System.out.println("Please Enter Admin password ");
				String pw = sc.next().toLowerCase();

				if (un.equals("admin") && pw.equals("admin")) {
					UIMainAdmin.adminUI(sc);
					;
				} else {
					System.out.println();
					System.out.println("Incorrect Admin Credentials, Please Try Again");
					System.out.println();
				}
				break;

			case 2:
				UIMainPublic.publicUI(sc);
				break;

			case 0:
				System.out.println();
				System.out.println("+----------------------------------------------------------+");
				System.out.println("|==== Thank you for using our service ~ Team Crime Net ====|");
				System.out.println("+----------------------------------------------------------+");
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println("Invalid selection, Please select a valid option");
				System.out.println();
				break;
			}

		} while (choice != 0);

		sc.close();

	}

	// --------------------- M A I N - E N D ---------------------//
}
