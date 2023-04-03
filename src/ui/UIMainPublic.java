package ui;

import java.time.LocalDate;
import java.util.Scanner;

import dao.CrimeDAO;
import dao.CrimeImplDAO;
import dao.CriminalDAO;
import dao.CriminalImplDAO;
import dao.LoginDAO;
import dao.LoginImplDAO;
import dao.PublicComplaintDAO;
import dao.PublicComplaintImplDAO;
import dto.LoginDTO;
import dto.LoginImplDTO;
import dto.PublicComplaintDTO;
import dto.PublicComplaintImplDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class UIMainPublic {

	static String email;

	// --------------------- S I G N - U P ---------------------//

	public static void userSignUp(Scanner sc) {

		System.out.println("Please Enter Your Name");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Please Enter Your Password");
		String pw = sc.next();

		System.out.println("Please Enter Your Email");
		String mail = sc.next();

		System.out.println("Please Enter Your Contact No.");
		String phone = sc.next();

		LoginDTO loginDTO = new LoginImplDTO(name, pw, mail, phone);

		LoginDAO loginDAO = new LoginImplDAO();

		try {
			loginDAO.userSignUp(loginDTO);
			email = mail;
			System.out.println();
			System.out.println("User Account Created Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	// --------------------- L O G - I N ---------------------//

	public static String userLogin(Scanner sc) {

		System.out.println("Please Enter Your Email");
		String mail = sc.next();

		System.out.println("Please Enter Your Password");
		String pw = sc.next();

		LoginDAO loginDAO = new LoginImplDAO();

		String un = "";
		try {
			String username = loginDAO.userLogin(mail, pw);
			un = username;
			email = mail;
			return un;
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		return un;
	}

	// --------------------- L O G - I N ---------------------//

	public static void updatePassword(Scanner sc) {

		System.out.println("Enter your email");
		String mail = sc.next();

		System.out.println("Enter current password");
		String opw = sc.next();

		System.out.println("Enter new password");
		String npw = sc.next();

		LoginDAO loginDAO = new LoginImplDAO();

		try {
			loginDAO.updatePassword(mail, opw, npw);
			System.out.println("Password Changed Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	// ---------------- DISPLAY TOTAL CRIME FOR POLICE STATION ----------------//

	public static void displayTotalCrimeFromEachPoliceStationForADateRange(Scanner sc) {

		System.out.println("Please Enter Start Date (YYYY-MM-DD)");
		LocalDate start_date = LocalDate.parse(sc.next());

		System.out.println("Please Enter End Date (YYYY-MM-DD)");
		LocalDate end_date = LocalDate.parse(sc.next());

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.displayTotalCrimeFromEachPoliceStationForADateRange(start_date, end_date)
					.forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// ---------------- DISPLAY TOTAL CRIME FOR CRIME TYPE ----------------//

	public static void displayTotalCrimeFromEachCrimeTypeForADateRange(Scanner sc) {

		System.out.println("Please Enter Start Date (YYYY-MM-DD)");
		LocalDate start_date = LocalDate.parse(sc.next());

		System.out.println("Please Enter End Date (YYYY-MM-DD)");
		LocalDate end_date = LocalDate.parse(sc.next());

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.displayTotalCrimeFromEachCrimeTypeForADateRange(start_date, end_date)
					.forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------- S E A R C H - C R I M I N A L ---------------//

	public static void searchCriminalByName(Scanner sc) {

		System.out.println("Please Enter First Name of Criminal");
		String fname = sc.next();

		CriminalDAO criminalDao = new CriminalImplDAO();

		try {
			criminalDao.searchCriminalByName(fname).forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// ---------------- S E A R C H - C R I M E ----------------//

	public static void searchCrimeByDescription(Scanner sc) {

		System.out.println("Please Enter Keyword Related To Crime Description");
		sc.nextLine();
		String desc = sc.nextLine();

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.searchCrimeByDescription(desc).forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- C O M P L A I N T ---------------------//

	public static void fileNewComplaint(Scanner sc) {

		String getCrime_id = email;

		System.out.println("Please Enter Crime Type : ");
		System.out.println("--------------------------");
		System.out.println("Select 1 for Robbery");
		System.out.println("Select 2 for Theft");
		System.out.println("Select 3 for Homicide");
		System.out.println("Select 4 for Kidnapping/Abduction");
		System.out.println("Select 5 for Bribery");
		System.out.println("Select 6 for Burglary");
		System.out.println("Select 7 for Terrorism");
		System.out.println("Select 8 for Fraud");
		System.out.println("Select 9 for Religious Violence");
		System.out.println("Select 10 for Human Trafficking");
		System.out.println("Select 11 for Money Laundering");
		System.out.println("Select 12 for Domestic Violence");
		System.out.println("Select 13 for Stalking");
		System.out.println("Select 14 for Sexual Harassment");
		System.out.println("Select 15 for Drug trafficking");
		int getCrime_type = sc.nextInt();

		System.out.println("Please Describe the Crime");
		sc.nextLine();
		String getCrime_desc = sc.nextLine();

		System.out.println("Please Enter the Date of Crime (YYYY-MM-DD)");
		LocalDate getCrime_date = LocalDate.parse(sc.next());

		LocalDate getComplaint_date = LocalDate.now();

		System.out.println("Please Enter Victim's Name");
		sc.nextLine();
		String getVictim_name = sc.nextLine();

		System.out.println("Please Enter Suspect Name");
		String getSuspect = sc.nextLine();

		PublicComplaintDTO pcDTO = new PublicComplaintImplDTO(getCrime_id, getCrime_desc, getCrime_date,
				getComplaint_date, getVictim_name, getSuspect, getCrime_type);

		PublicComplaintDAO pcDAO = new PublicComplaintImplDAO();

		try {
			System.out.println(pcDTO);
			System.out.println("Press 1 to confirm or Press 2 to cancel");
			int res = sc.nextInt();

			if (res == 1) {
				pcDAO.fileNewComplaint(pcDTO);
				System.out.println("Complaint Registered Successfully");
			} else {
				System.out.println("Complaint Registration Canceled");
				return;
			}

		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- L O G - O U T ---------------------//

	public static void userLogOut(Scanner sc) {
	}

	// ---------------------------------------------------------//

	public static void publicUIMethods(Scanner sc) {

		int choice = 0;

		do {
			System.out.println();
			System.out.println("+-----------------------------------------------------------------------------+");
			System.out.println("|========================= Welcome to Public Portal ==========================|");
			System.out.println("|-----------------------------------------------------------------------------|");
			System.out.println("|  Select 1 to Display Total Crime From Each Police Station For a Date Range  |");
			System.out.println("|  Select 2 to Display Total Crime From Each Crime Type For a Date Range      |");
			System.out.println("|  Select 3 to Search a Criminal By Name                                      |");
			System.out.println("|  Select 4 to Search Crime By Description                                    |");
			System.out.println("|  Select 5 to File a New Complaint                                           |");
			System.out.println("|  Select 6 to Change Your Password                                           |");
			System.out.println("|  Select 0 to Log Out                                                        |");
			System.out.println("+-----------------------------------------------------------------------------+");
			System.out.println();

			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println();
				System.out.println("Wrong Input Selected");
				System.out.println();
				publicUIMethods(null);
			}
			switch (choice) {

			case 1:
				displayTotalCrimeFromEachPoliceStationForADateRange(sc);
				break;

			case 2:
				displayTotalCrimeFromEachCrimeTypeForADateRange(sc);
				break;

			case 3:
				searchCriminalByName(sc);
				break;

			case 4:
				searchCrimeByDescription(sc);
				break;

			case 5:
				fileNewComplaint(sc);
				break;

			case 6:
				updatePassword(sc);
				break;

			case 0:
				return;

			default:
				System.out.println();
				System.out.println("Invalid selection, Please select a valid option");
				System.out.println();
				break;
			}

		} while (choice != 0);

		sc.close();

	}

	// ---------------------------------------------------------//

	public static void publicUI(Scanner sc) {

		int choice = 0;

		do {
			System.out.println();
			System.out.println("+-------------------------------------+");
			System.out.println("|========= Log In / Sign Up ==========|");
			System.out.println("|-------------------------------------|");
			System.out.println("|  Select 1 to Sign Up                |");
			System.out.println("|  Select 2 to Log In                 |");
			System.out.println("|  Select 0 to Go to Previous Menu    |");
			System.out.println("+-------------------------------------+");
			System.out.println();

			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println();
				System.out.println("Wrong Input Selected");
				System.out.println();
				publicUI(null);
			}

			switch (choice) {

			case 1:
				userSignUp(sc);
				publicUIMethods(sc);
				break;

			case 2:
				String un = "";
				un = userLogin(sc);
				if (un != "") {
					System.out.println("Welcome " + un + ", Login Successful.");
					publicUIMethods(sc);
				}

				break;

			case 0:
				return;

			default:
				System.out.println();
				System.out.println("Invalid selection, Please select a valid option");
				System.out.println();
				break;
			}

		} while (choice != 0);

		sc.close();
	}

}
