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
import exception.NoDataFoundException;
import exception.SomethingWentWrongException;

public class CrimeImplDAO implements CrimeDAO {

	@Override
	public void addCrimeAsAdmin(CrimeDTO crime) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"insert into crime(crime_id, crime_type, crime_desc, ps_area, crime_date, complaint_date, victim_name) values(?,?,?,?,?,?,?)");

			ps.setString(1, crime.getCrime_id());
			ps.setInt(2, crime.getCrime_type());
			ps.setString(3, crime.getCrime_desc());
			ps.setString(4, crime.getPs_area());
			ps.setDate(5, Date.valueOf(crime.getCrime_date()));
			ps.setDate(6, Date.valueOf(crime.getComplaint_date()));
			ps.setString(7, crime.getVictim_name());

			if (ps.executeUpdate() == 0) {
				throw new SomethingWentWrongException("Crime Already Registered");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register the crime record.");
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
	public void updateCrime(CrimeDTO crime) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"update crime set crime_type=?, crime_desc=?, ps_area=?, crime_date=?, complaint_date=?, victim_name=? where crime_id=?");

			ps.setInt(1, crime.getCrime_type());
			ps.setString(2, crime.getCrime_desc());
			ps.setString(3, crime.getPs_area());
			ps.setDate(4, Date.valueOf(crime.getCrime_date()));
			ps.setDate(5, Date.valueOf(crime.getComplaint_date()));
			ps.setString(6, crime.getVictim_name());
			ps.setString(7, crime.getCrime_id());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to update the crime record.");
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
	public void deleteCrime(String crime_id) throws SomethingWentWrongException, NoDataFoundException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement("delete from crime where crime_id = ?");

			ps.setString(1, crime_id);

			if (ps.executeUpdate() <= 0) {
				throw new NoDataFoundException("No Data Found");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Invalid Crime ID, Please Try Again");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong, Unable to Delete the crime record.");
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<CrimeDTO> displayTotalCrimeFromEachPoliceStationForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException {

		List<CrimeDTO> list = new ArrayList<>();

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
				list.add(new CrimeImplDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
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

}
