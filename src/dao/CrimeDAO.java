package dao;

import dto.CrimeDTO;
import exception.SomethingWentWrongException;

public interface CrimeDAO {

	public void addCrimeAsAdmin(CrimeDTO mob) throws SomethingWentWrongException;
	
}
