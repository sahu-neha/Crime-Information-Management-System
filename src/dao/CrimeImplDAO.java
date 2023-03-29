package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CrimeDTO;
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
			ps.setString(7, crime.getVictim_date());

			ps.executeUpdate();

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

	// -------------------------------------------------------//

}
