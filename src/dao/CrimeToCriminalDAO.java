package dao;

import dto.CrimeToCriminalDTO;
import exception.SomethingWentWrongException;

public interface CrimeToCriminalDAO {

	public void assignCriminalToCrime(CrimeToCriminalDTO cc) throws SomethingWentWrongException;

	public void removeCriminalFromCrime(CrimeToCriminalDTO cc) throws SomethingWentWrongException;

}
