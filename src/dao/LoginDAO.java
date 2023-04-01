package dao;

import dto.LoginDTO;
import exception.SomethingWentWrongException;

public interface LoginDAO {

	public void userSignUp(LoginDTO login) throws SomethingWentWrongException;

	public String userLogin(String un, String pw) throws SomethingWentWrongException;

}
