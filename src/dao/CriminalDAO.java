package dao;

import java.time.LocalDate;
import java.util.List;

import dto.CriminalDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public interface CriminalDAO {

	public void addCriminalAsAdmin(CriminalDTO criminal) throws SomethingWentWrongException;

	public void updateCriminal(CriminalDTO criminal) throws SomethingWentWrongException;

	public void deleteCriminal(String criminal_id) throws SomethingWentWrongException, NoDataFoundException;

	public List<CriminalDTO> displayTotalCrimeFromEachCrimeTypeForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException;

	
}
