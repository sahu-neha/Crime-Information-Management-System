package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class LoginImplDAO implements LoginDAO {

	@Override
	public void userSignUp(LoginDTO login) throws SomethingWentWrongException {
		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c
					.prepareStatement("insert into login(username, password, email, contact_no) values(?,?,?,?)");

			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			ps.setString(3, login.getEmail());
			ps.setString(4, login.getContact_no());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to add user to record");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong");
			}
		}
	}

	// -------------------------------------------------------//

	@Override
	public String userLogin(String email, String pw) throws SomethingWentWrongException {
		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement("select username from login where email = ? && password = ?");

			ps.setString(1, email);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("Incorrect Credentials");
			}

			String un = "";

			while (rs.next()) {
				un = rs.getString(1);
			}
			return un;

		} catch (ClassNotFoundException | SQLException | NoDataFoundException e) {
			throw new SomethingWentWrongException("Incorrect Credentials");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong");
			}
		}
	}

	// -------------------------------------------------------//

	@Override
	public void updatePassword(String email, String opw, String npw) throws SomethingWentWrongException {
		Connection c = null;

		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement("update login set password=? where email = ? && password = ?");

			ps.setString(2, email);
			ps.setString(3, opw);
			ps.setString(1, npw);

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("went wrong");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// -------------------------------------------------------//

}
