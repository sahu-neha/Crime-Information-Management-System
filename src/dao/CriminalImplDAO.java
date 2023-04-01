package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CriminalDTO;
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class CriminalImplDAO implements CriminalDAO {

	@Override
	public void addCriminalAsAdmin(CriminalDTO criminal) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"insert into criminal(criminal_id, fname, lname, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area) values(?,?,?,?,?,?,?,?)");

			ps.setString(1, criminal.getCriminal_id());
			ps.setString(2, criminal.getFirst_name());
			ps.setString(3, criminal.getLast_name());
			ps.setDate(4, Date.valueOf(criminal.getDob()));
			ps.setString(5, criminal.getGender());
			ps.setString(6, criminal.getIdentifying_mark());
			ps.setDate(7, Date.valueOf(criminal.getFirst_arrest_date()));
			ps.setString(8, criminal.getArrested_from_ps_area());

			if (ps.executeUpdate() == 0) {
				throw new SomethingWentWrongException("Criminal Already Registered");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register the criminal record.");
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
	public void updateCriminal(CriminalDTO criminal) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"update criminal set fname=?, lname=?, dob=?, gender=?, identifying_mark=?, first_arrest_date=?, arrested_from_ps_area=? where criminal_id=?");

			ps.setString(8, criminal.getCriminal_id());
			ps.setString(1, criminal.getFirst_name());
			ps.setString(2, criminal.getLast_name());
			ps.setDate(3, Date.valueOf(criminal.getDob()));
			ps.setString(4, criminal.getGender());
			ps.setString(5, criminal.getIdentifying_mark());
			ps.setDate(6, Date.valueOf(criminal.getFirst_arrest_date()));
			ps.setString(7, criminal.getArrested_from_ps_area());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to update the criminal record.");
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
	public void deleteCriminal(String criminal_id) throws SomethingWentWrongException, NoDataFoundException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"update criminal set is_deleted = true where criminal_id = ? && is_deleted = false");

			ps.setString(1, criminal_id);

			if (ps.executeUpdate() <= 0) {
				throw new NoDataFoundException("No Data Found");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Invalid Criminal ID, Please Try Again");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong, Unable to delete the criminal record.");
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<String> searchCriminalByName(String fname, String lname)
			throws SomethingWentWrongException, NoDataFoundException {

		List<String> criminals = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select fname, lname, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area from criminal where fname=?, lname=?");

			ps.setString(1, fname);
			ps.setString(2, lname);

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			String un = "";

			while (rs.next()) {
				un = "First Name : " + rs.getString(1) + ", Last Name : " + rs.getString(2) + ", Date of Birth : "
						+ rs.getDate(3).toLocalDate() + ", Gender : " + rs.getString(4) + ", Identifying Mark : "
						+ rs.getString(5) + ", First Arrest Date : " + rs.getDate(6).toLocalDate()
						+ ", Arrested From Police Station Area : " + rs.getString(7);
				criminals.add(un);
			}
			return criminals;

		} catch (ClassNotFoundException | SQLException | NoDataFoundException e) {
			throw new SomethingWentWrongException("Something went wrong");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong");
			}
		}

	}

	// -------------------------------------------------------//

}
