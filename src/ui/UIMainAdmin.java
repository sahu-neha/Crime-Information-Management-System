package ui;

import java.time.LocalDate;
import java.util.Scanner;

import dao.CrimeDAO;
import dao.CrimeImplDAO;
import dao.CrimeToCriminalDAO;
import dao.CrimeToCriminalImplDAO;
import dao.CriminalDAO;
import dao.CriminalImplDAO;
import dto.CrimeDTO;
import dto.CrimeImplDTO;
import dto.CrimeToCriminalDTO;
import dto.CrimeToCriminalImplDTO;
import dto.CriminalDTO;
import dto.CriminalImplDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class UIMainAdmin {

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

		System.out.println("Please Enter the Date of Crime (YYYY-MM-DD)");
		LocalDate getCrime_date = LocalDate.parse(sc.next());

		LocalDate getComplaint_date = LocalDate.now();

		System.out.println("Please Enter Victim's Name");
		sc.nextLine();
		String getVictim_name = sc.nextLine();

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
		sc.nextLine();
		String getCrime_desc = sc.nextLine();

		System.out.println("Please Enter the Police Station Area");
		String getPs_area = sc.next();

		System.out.println("Please Enter the Date of Crime (YYYY-MM-DD)");
		LocalDate getCrime_date = LocalDate.parse(sc.next());

		LocalDate getComplaint_date = LocalDate.now();

		System.out.println("Please Enter Victim's Name");
		sc.nextLine();
		String getVictim_name = sc.nextLine();

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

		System.out.println("Please Enter Date of Birth of Criminal (YYYY-MM-DD)");
		LocalDate getDob = LocalDate.parse(sc.next());

		System.out.println("Please Select Gender of Criminal (M/F)");
		String getGender = sc.next();

		System.out.println("Please Enter Identifyning marks of Criminal");
		sc.nextLine();
		String getIdentifying_mark = sc.nextLine();

		System.out.println("Please Enter First Arrest Date of Criminal (YYYY-MM-DD)");
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

	public static void updateCriminalRecord(Scanner sc) {

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

	// --------------------- D I S P L A Y - C R I M E ---------------------//

	public static void displayCrimeList() {

		CrimeDAO crimeDao = new CrimeImplDAO();

		try {
			crimeDao.displayCrimeList().forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- D I S P L A Y - C R I M I N A L ---------------------//

	public static void displayCrimialList() {

		CriminalDAO criminalDAO = new CriminalImplDAO();

		try {
			criminalDAO.displayCriminalList().forEach(s -> System.out.println(s));
		} catch (SomethingWentWrongException | NoDataFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- A S S I G N - C R I M E ---------------------//

	public static void assignCriminalToCrime(Scanner sc) {

		System.out.println("Please Enter Crime ID of 4 characters");
		String getCrime_id = sc.next();

		System.out.println("Please Enter Criminal ID of 4 characters");
		String getCriminal_id = sc.next();

		CrimeToCriminalDTO ccDTO = new CrimeToCriminalImplDTO(getCrime_id, getCriminal_id);

		CrimeToCriminalDAO ccDAO = new CrimeToCriminalImplDAO();

		try {
			ccDAO.assignCriminalToCrime(ccDTO);
			System.out.println("Crime Assigned to Criminal Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}

	// --------------------- R E M O V E - C R I M E ---------------------//

	public static void removeCriminalFromCrime(Scanner sc) {

		System.out.println("Please Enter Crime ID of 4 characters");
		String getCrime_id = sc.next();

		System.out.println("Please Enter Criminal ID of 4 characters");
		String getCriminal_id = sc.next();

		CrimeToCriminalDTO ccDTO = new CrimeToCriminalImplDTO(getCrime_id, getCriminal_id);

		CrimeToCriminalDAO ccDAO = new CrimeToCriminalImplDAO();

		try {
			ccDAO.removeCriminalFromCrime(ccDTO);
			System.out.println("Crime Removed to Criminal Successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

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

	public static void adminUI(Scanner sc) {

		int choice = 0;

		do {

			System.out.println();
			System.out.println("+------------------------------------------------------+");
			System.out.println("|=============== Welcome to Admin Panel ===============|");
			System.out.println("|------------------------------------------------------|");
			System.out.println("|  Select 1 to Register a Crime                        |");
			System.out.println("|  Select 2 to Update an Already Registered Crime      |");
			System.out.println("|  Select 3 to Add a Criminal Record                   |");
			System.out.println("|  Select 4 to Update a Criminal Record                |");
			System.out.println("|  Select 5 to Display Crime Record                    |");
			System.out.println("|  Select 6 to Display Criminal Record                 |");
			System.out.println("|  Select 7 to Assign a Criminal To a Crime            |");
			System.out.println("|  Select 8 to Remove a Criminal From a Crime          |");
			System.out.println("|  Select 9 to Delete Registered Crime                 |");
			System.out.println("|  Select 10 to Delete an Existing Criminal Record     |");
			System.out.println("|  Select 0 to Log Out                                 |");
			System.out.println("+------------------------------------------------------+");
			System.out.println();

			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println();
				System.out.println("Wrong Input Selected, Please Try Again");
				System.out.println();
				adminUI(null);
			}

			switch (choice) {

			case 1:
				addCrimeAsAdmin(sc);
				break;

			case 2:
				updateCrime(sc);
				break;

			case 3:
				addCriminalAsAdmin(sc);
				break;

			case 4:
				updateCriminalRecord(sc);
				break;

			case 5:
				displayCrimeList();
				break;

			case 6:
				displayCrimialList();
				break;

			case 7:
				assignCriminalToCrime(sc);
				break;

			case 8:
				removeCriminalFromCrime(sc);
				break;

			case 9:
				deleteCrime(sc);
				break;

			case 10:
				deleteCriminal(sc);
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
