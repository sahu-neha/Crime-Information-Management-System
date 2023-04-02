package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CrimeToCriminalDTO;
import exception.SomethingWentWrongException;

public class CrimeToCriminalImplDAO implements CrimeToCriminalDAO {

	@Override
	public void assignCriminalToCrime(CrimeToCriminalDTO cc) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement("insert into crime_to_criminal values (?,?,?)");

			ps.setString(1, cc.getCrime_id());
			ps.setString(2, cc.getCriminal_id());
			ps.setInt(3, 0);

			if (ps.executeUpdate() <= 0) {
				throw new SomethingWentWrongException("Unable to assign crime to criminal");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something Went Wrong, Please Try Again Later");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Something Went Wrong.");
			}
		}

	}

	// ------------------------------------------------------//

	@Override
	public void removeCriminalFromCrime(CrimeToCriminalDTO cc) throws SomethingWentWrongException {

		Connection c = null;
		try {
			c = DBUtils.getConnectionToDB();

			PreparedStatement ps = c.prepareStatement(
					"update crime_to_criminal set is_deleted = 1 where crime_id = ? && criminal_id = ? && is_deleted = 0");

			ps.setString(1, cc.getCrime_id());
			ps.setString(2, cc.getCriminal_id());

			if (ps.executeUpdate() <= 0) {
				throw new SomethingWentWrongException("Unable To Remove Crime From Criminal");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something Went Wrong, Please Try Again Later");
		} finally {
			try {
				DBUtils.closeConnection(c);
			} catch (SQLException e) {
				throw new SomethingWentWrongException("Somerthing Went Wrong.");
			}
		}

	}

}
