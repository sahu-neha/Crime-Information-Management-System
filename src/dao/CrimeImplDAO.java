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
				throw new SomethingWentWrongException("Something went wrong");
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
				throw new SomethingWentWrongException("Something went wrong");
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public void deleteCrime(String crime_id) throws SomethingWentWrongException, NoDataFoundException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c
					.prepareStatement("update crime set is_deleted = true where crime_id = ? && is_deleted = false");

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
				throw new SomethingWentWrongException("Something went wrong, Unable to Delete the crime record.");
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<String> displayTotalCrimeFromEachPoliceStationForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException {

		List<String> list = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select count(*) Total_Crime, ps_area Police_Station_Area from crime where is_deleted = false && crime_date between ? and ? group by ps_area");

			ps.setDate(1, Date.valueOf(startDate));
			ps.setDate(2, Date.valueOf(enddate));

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			while (rs.next()) {
				String str = "Total Crime : " + rs.getInt(1) + "  |  Police Station Area : " + rs.getString(2);
				list.add(str);
			}
			return list;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong !");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<String> displayTotalCrimeFromEachCrimeTypeForADateRange(LocalDate startDate, LocalDate enddate)
			throws SomethingWentWrongException, NoDataFoundException {

		List<String> list = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select count(*) Total_Crime, crime_type_name from crime c join crime_type ct on c.crime_type = ct.crime_type_id where is_deleted = false && crime_date between ? and ? group by crime_type");

			ps.setDate(1, Date.valueOf(startDate));
			ps.setDate(2, Date.valueOf(enddate));

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			while (rs.next()) {
				String str = "Total Crime : " + rs.getInt(1) + "  |  Crime Type : " + rs.getString(2);
				list.add(str);
			}
			return list;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong !");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<String> searchCrimeByDescription(String desc) throws SomethingWentWrongException, NoDataFoundException {

		List<String> crime = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select crime_desc, ps_area, crime_date, complaint_date, victim_name from crime where crime_desc like ? ");

			String str = "%";
			ps.setString(1, str + desc + str);

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			String un = "";

			while (rs.next()) {
				un = "Crime Description : " + rs.getString(1) + "\n" + "Police Station Area : " + rs.getString(2) + "\n"
						+ "Crime Date : " + rs.getDate(3).toLocalDate() + "\n" + "Complaint Date : "
						+ rs.getDate(4).toLocalDate() + "\n" + "Victim Name : " + rs.getString(5) + "\n";
				crime.add(un);
			}
			return crime;

		} catch (ClassNotFoundException | SQLException | NoDataFoundException e) {
			throw new NoDataFoundException("No Record Found");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong");
			}
		}

	}

	// -------------------------------------------------------//

	@Override
	public List<String> displayCrimeList() throws SomethingWentWrongException, NoDataFoundException {

		List<String> crime = new ArrayList<>();

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"select crime_id, crime_type, crime_desc, ps_area, crime_date, complaint_date, victim_name from crime");

			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoDataFoundException("No Record Found");
			}

			String un = "";

			while (rs.next()) {
				un = "Crime ID : " + rs.getString(1) + "\n" + "Crime Type : " + rs.getString(2) + "\n"
						+ "Crime Description : " + rs.getString(3) + "\n" + "Police Station Area : " + rs.getString(4)
						+ "\n" + "Crime Date : " + rs.getDate(5).toLocalDate() + "\n" + "Complaint Date : "
						+ rs.getDate(6).toLocalDate() + "\n" + "Victim Name : " + rs.getString(7) + "\n";
				crime.add(un);
			}
			return crime;

		} catch (ClassNotFoundException | SQLException | NoDataFoundException e) {
			throw new NoDataFoundException("No Record Found");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something went wrong");
			}
		}

	}

	// -------------------------------------------------------//
}
