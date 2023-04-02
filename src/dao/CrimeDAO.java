package dao;

import java.time.LocalDate;
import java.util.List;

import dto.CrimeDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public interface CrimeDAO {

	public void addCrimeAsAdmin(CrimeDTO crime) throws SomethingWentWrongException;

	public void updateCrime(CrimeDTO crime) throws SomethingWentWrongException;

	public void deleteCrime(String crime_id) throws SomethingWentWrongException, NoDataFoundException;

	public List<String> displayTotalCrimeFromEachPoliceStationForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException;

	public List<String> displayTotalCrimeFromEachCrimeTypeForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException;

	public List<String> searchCrimeByDescription(String desc) throws SomethingWentWrongException, NoDataFoundException;

	public List<String> displayCrimeList() throws SomethingWentWrongException, NoDataFoundException;

}
