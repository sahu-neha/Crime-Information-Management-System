package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.CrimeDTO;
import dto.CrimeImplDTO;
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

			PreparedStatement ps = c.prepareStatement("delete from criminal where criminal_id = ?");

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
	public List<CriminalDTO> displayTotalCrimeFromEachCrimeTypeForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException {

		List<CriminalDTO> list = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select crime_id, crime_type, crime_desc, ps_area, crime_date, complaint_date, victim_name from crime where crime_date between ? and ? group by ps_area");

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			while (rs.next()) {
				list.add(new CriminalImplDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDate(4).toLocalDate(), rs.getDate(4).toLocalDate(), rs.getString(7)));
			}
			return list;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Somerthing went wrong !");
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
