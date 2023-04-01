package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.PublicComplaintDTO;
import exception.SomethingWentWrongException;

public class PublicComplaintImplDAO implements PublicComplaintDAO {

	@Override
	public void fileNewComplaint(PublicComplaintDTO cp) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"insert into public_complaint(email, crime_desc, crime_date, complaint_date, victim_name, suspect, crime_type) values(?,?,?,?,?,?,?)");

			ps.setString(1, cp.getEmail());
			ps.setString(2, cp.getCrime_desc());
			ps.setDate(3, Date.valueOf(cp.getCrime_date()));
			ps.setDate(4, Date.valueOf(cp.getComplaint_date()));
			ps.setString(5, cp.getVictim_name());
			ps.setString(6, cp.getSuspect());
			ps.setInt(7, cp.getCrime_type());

			if (ps.executeUpdate() == 0) {
				throw new SomethingWentWrongException("Complaint Already Registered");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Sorry, unable to register the complaint. Please try again.");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing went wrong");
			}
		}

	}

}
