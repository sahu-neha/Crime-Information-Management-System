package dao;

import java.util.List;

import dto.CriminalDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public interface CriminalDAO {

	public void addCriminalAsAdmin(CriminalDTO criminal) throws SomethingWentWrongException;

	public void updateCriminal(CriminalDTO criminal) throws SomethingWentWrongException;

	public void deleteCriminal(String criminal_id) throws SomethingWentWrongException, NoDataFoundException;

	public List<String> searchCriminalByName(String fname) throws SomethingWentWrongException, NoDataFoundException;

	public List<String> displayCriminalList() throws SomethingWentWrongException, NoDataFoundException;

}
