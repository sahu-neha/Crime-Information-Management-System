package dao;

import dto.LoginDTO;
import exception.SomethingWentWrongException;

public interface LoginDAO {

	public void userSignUp(LoginDTO login) throws SomethingWentWrongException;

	public String userLogin(String email, String pw) throws SomethingWentWrongException;

	public void updatePassword(String email, String opw, String npw) throws SomethingWentWrongException;

}
