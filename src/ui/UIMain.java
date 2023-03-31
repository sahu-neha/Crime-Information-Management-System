package ui;

import java.time.LocalDate;
import java.util.Scanner;

import dao.CrimeDAO;
import dao.CrimeImplDAO;
import dao.CriminalDAO;
import dao.CriminalImplDAO;
import dao.LoginDAO;
import dao.LoginImplDAO;
import dto.CrimeDTO;
import dto.CrimeImplDTO;
import dto.CriminalDTO;
import dto.CriminalImplDTO;
import dto.LoginDTO;
import dto.LoginImplDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class UIMain {

	// ---------------------------------------------------------//

	// --------------------- A D M I N ---------------------//

	// ---------------------------------------------------------//

	// --------------------- A D D - C R I M E ---------------------//

	public static void addCrimeAsAdmin(Scanner sc) {

		System.out.println("Please Enter Crime ID of 4 characters");
		String getCrime_id = sc.next();

		System.out.println("Please Enter Crime Type : ");
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

		System.out.println("Please Enter the Police Station Area");
		String getPs_area = sc.next();

		System.out.println("Please Enter the Date of Crime");
		LocalDate getCrime_date = LocalDate.parse(sc.next());

		LocalDate getComplaint_date = LocalDate.now();

		System.out.println("Please Enter Victim's Name");
		String getVictim_name = sc.next();

		CrimeDTO crimeDTO = new CrimeImplDTO(getCrime_id, getCrime_type, getCrime_desc, getPs_area, getCrime_date,
				getComplaint_date, getVictim_name);

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.addCrimeAsAdmin(crimeDTO);
			System.out.println("Crime Registered Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- U P D A T E - C R I M E ---------------------//

	public static void updateCrime(Scanner sc) {

		System.out.println("Please Enter Crime ID of 4 characters");
		String getCrime_id = sc.next();

		System.out.println("Please Enter Crime Type : ");
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
		String getCrime_desc = sc.next();

		System.out.println("Please Enter the Police Station Area");
		String getPs_area = sc.next();

		System.out.println("Please Enter the Date of Crime");
		LocalDate getCrime_date = LocalDate.parse(sc.next());

		LocalDate getComplaint_date = LocalDate.now();

		System.out.println("Please Enter Victim's Name");
		String getVictim_name = sc.next();

		CrimeDTO crimeDTO = new CrimeImplDTO(getCrime_id, getCrime_type, getCrime_desc, getPs_area, getCrime_date,
				getComplaint_date, getVictim_name);

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.updateCrime(crimeDTO);
			System.out.println("Crime Registered Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- A D D - C R I M I N A L ---------------------//

	public static void addCriminalAsAdmin(Scanner sc) {

		System.out.println("Please Enter Criminal ID of 4 characters");
		String getCriminal_id = sc.next();

		System.out.println("Please Enter First Name of Criminal");
		String getFirst_name = sc.next();

		System.out.println("Please Enter Last Name of Criminal");
		String getLast_name = sc.next();

		System.out.println("Please Enter Date of Birth of Criminal");
		LocalDate getDob = LocalDate.parse(sc.next());

		System.out.println("Please Select Gender of Criminal (M/F)");
		String getGender = sc.next();

		System.out.println("Please Enter Identifyning marks of Criminal");
		String getIdentifying_mark = sc.next();

		System.out.println("Please Enter First Arrest Date of Criminal");
		LocalDate getFirst_arrest_date = LocalDate.parse(sc.next());

		System.out.println("Please Enter The Police Station Area Where Criminal Was Arrested");
		String getArrested_from_ps_area = sc.next();

		CriminalDTO criminalDTO = new CriminalImplDTO(getCriminal_id, getFirst_name, getLast_name, getDob, getGender,
				getIdentifying_mark, getFirst_arrest_date, getArrested_from_ps_area);

		CriminalDAO criminalDAO = new CriminalImplDAO();

		try {
			criminalDAO.addCriminalAsAdmin(criminalDTO);
			System.out.println("Criminal Record Saved Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- U P D A T E - C R I M I N A L ---------------------//

	public static void updateCriminal(Scanner sc) {

		System.out.println("Please Enter Criminal ID of 4 characters");
		String getCriminal_id = sc.next();

		System.out.println("Please Enter First Name of Criminal");
		String getFirst_name = sc.next();

		System.out.println("Please Enter Last Name of Criminal");
		String getLast_name = sc.next();

		System.out.println("Please Enter Date of Birth of Criminal");
		LocalDate getDob = LocalDate.parse(sc.next());

		System.out.println("Please Select Gender of Criminal (M/F)");
		String getGender = sc.next();

		System.out.println("Please Enter Identifyning marks of Criminal");
		String getIdentifying_mark = sc.next();

		System.out.println("Please Enter First Arrest Date of Criminal");
		LocalDate getFirst_arrest_date = LocalDate.parse(sc.next());

		System.out.println("Please Enter The Police Station Area Where Criminal Was Arrested");
		String getArrested_from_ps_area = sc.next();

		CriminalDTO criminalDTO = new CriminalImplDTO(getCriminal_id, getFirst_name, getLast_name, getDob, getGender,
				getIdentifying_mark, getFirst_arrest_date, getArrested_from_ps_area);

		CriminalDAO criminalDAO = new CriminalImplDAO();

		try {
			criminalDAO.updateCriminal(criminalDTO);
			System.out.println("Criminal Record Saved Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- A S S I G N - C R I M E ---------------------//

	public static void assignCriminalToCrime(Scanner sc) {
	}

	// --------------------- R E M O V E - C R I M E ---------------------//

	public static void removeCriminalFromCrime(Scanner sc) {
	}

	// --------------------- D E L E T E - C R I M E ---------------------//

	public static void deleteCrime(Scanner sc) {

		System.out.println("Please Enter Crime ID of 4 characters");
		String getCrime_id = sc.next();

		CrimeDAO crimeDAO = new CrimeImplDAO();

		try {
			crimeDAO.deleteCrime(getCrime_id);
			System.out.println("Crime Deleted Successfully");
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// --------------------- D E L E T E - C R I M I N A L ---------------------//

	public static void deleteCriminal(Scanner sc) {

		System.out.println("Please Enter Criminal ID of 4 characters");
		String getCriminal_id = sc.next();

		CriminalDAO criminalDAO = new CriminalImplDAO();

		try {
			criminalDAO.deleteCriminal(getCriminal_id);
			System.out.println("Crime Deleted Successfully");
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// ---------------------------------------------------------//

	// --------------------- P U B L I C ---------------------//

	// ---------------------------------------------------------//

	// --------------------- S I G N - U P ---------------------//

	public static void userSignUp(Scanner sc) {

		System.out.println("Please Enter Your Name");
		String name = sc.next();

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
			System.out.println("User Account Created Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	// --------------------- L O G - I N ---------------------//

	public static void userLogin(Scanner sc) {

		System.out.println("Please Enter Your Email");
		String mail = sc.next();

		System.out.println("Please Enter Your Password");
		String pw = sc.next();

		LoginDAO loginDAO = new LoginImplDAO();

		try {
			String username = loginDAO.userLogin(mail, pw);
			System.out.println("Welcome " + username + ", Login Successful.");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	// ---------------- DISPLAY CRIME FOR POLICE STATION ----------------//

	public static void displayTotalCrimeFromEachPoliceStationForADateRange(Scanner sc) {
	}
	// ---------------- DISPLAY CRIME FOR CRIME TYPE ----------------//

	public static void displayTotalCrimeFromEachCrimeTypeForADateRange(Scanner sc) {
	}

	// --------------- S E A R C H - C R I M I N A L ---------------//

	public static void searchCriminalByName(Scanner sc) {
	}

	// ---------------- S E A R C H - C R I M E ----------------//

	public static void searchCrimeByDescription(Scanner sc) {
	}

	// --------------------- C O M P L A I N T ---------------------//

	public static void fileNewComplaint(Scanner sc) {
	}

	// --------------------- L O G - O U T ---------------------//

	public static void userLogOut(Scanner sc) {
	}

	// --------------------- M A I N ---------------------//

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {
			System.out.println("--------------------------------");
			System.out.println("**Please select a valid option**");
			System.out.println("--------------------------------");
			System.out.println("-> Administration Only");
			System.out.println("--------------------------------");
			System.out.println("Select 1 to Login and Register a Crime");
			System.out.println("select 2 to Update an Already Registered Crime");
			System.out.println("select 3 to Add a Criminal Record");
			System.out.println("select 4 to Update a Criminal Record");
			System.out.println("select 5 to Assign a Criminal To a Crime");
			System.out.println("select 6 to Remove a Criminal From a Crime");
			System.out.println("select 7 to Delete a Registered Crime");
			System.out.println("select 8 to Remove an Existing Criminal Record");
			System.out.println("--------------------------------");
			System.out.println("-> Available to Public");
			System.out.println("---------------------------");
			System.out.println("select 9 to Sign Up");
			System.out.println("select 10 to Log In");
			System.out.println("select 11 to Display Total Crime From Each Police Station For a Date Range");
			System.out.println("select 12 to Display Total Crime From Each Crime Type For a Date Range");
			System.out.println("select 13 to Search a Criminal By Name");
			System.out.println("select 14 to Search Crime By Description");
			System.out.println("select 15 to File a New Complaint");
			System.out.println("select 16 to Log Out");
			System.out.println("---------------------------");

			choice = sc.nextInt();

			switch (choice) {

			// admin - functions//

			case 1:
				System.out.println("Please Enter Admin Username");
				String un = sc.next().toLowerCase();

				System.out.println("Please Enter Admin password");
				String pw = sc.next().toLowerCase();

				if (un.equals("admin") && pw.equals("admin")) {
					System.out.println("Welcome, Admin !");
					addCrimeAsAdmin(sc);
				} else {
					System.out.println("Incorrect Admin Credentials, Please Try Again");
				}
				break;

			case 2:
				updateCrime(sc);
				break;

			case 3:
				addCriminalAsAdmin(sc);
				break;

			case 4:
				updateCriminal(sc);
				break;

			case 5:
				assignCriminalToCrime(sc);
				break;

			case 6:
				removeCriminalFromCrime(sc);
				break;

			case 7:
				deleteCrime(sc);
				break;

			case 8:
				deleteCriminal(sc);
				break;

			// public - functions//

			case 9:
				userSignUp(sc);
				break;

			case 10:
				userLogin(sc);
				break;

			case 11:
				displayTotalCrimeFromEachPoliceStationForADateRange(sc);
				break;

			case 12:
				displayTotalCrimeFromEachCrimeTypeForADateRange(sc);
				break;

			case 13:
				searchCriminalByName(sc);
				break;

			case 14:
				searchCrimeByDescription(sc);
				break;

			case 15:
				fileNewComplaint(sc);
				break;

			case 16:
				userLogOut(sc);
				break;

			case 0:
				System.out.println("Thank you for using our service ~ Team Crime Net");
				break;

			default:
				System.out.println("Invalid selection, Please select a valid option");
			}

		} while (choice != 0);

		sc.close();

	}

}
