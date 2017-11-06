package jdbc1;

import org.apache.log4j.*;
import java.sql.*;

public class SimpleQuery {
	protected static Logger log = Logger.getLogger(SimpleQuery.class);

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try { // Test loading of the driver jdbc for MySQL
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath", e);
		}

		String connectionUrl = "jdbc:mysql://localhost:3306/sakila-db";
		String connectionUser = "root";
		String connectionPassword = "root";

		try {
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT last_name FROM actor ;");

			while (rs.next()) {
				String lastName = rs.getString("last_name");
				System.out.println("Last Name: " + lastName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
	}

}
