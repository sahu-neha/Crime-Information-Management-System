package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	public static Connection getConnectionToDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("db");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("un"), rb.getString("pw"));

	}

	// ---------------------------------------//

	public static void closeConnection(Connection c) throws SQLException {
		if (c != null) {
			c.close();
		}
	}

	// ---------------------------------------//

	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		}
		return false;
	}

}
