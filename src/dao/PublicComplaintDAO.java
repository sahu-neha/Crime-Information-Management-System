package dao;

import dto.PublicComplaintDTO;
import exception.SomethingWentWrongException;

public interface PublicComplaintDAO {

	public void fileNewComplaint(PublicComplaintDTO cp) throws SomethingWentWrongException;

}
