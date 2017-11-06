package simplequery;

import org.apache.log4j.*;
import java.sql.*;

public class Query {
	protected static Logger log = Logger.getLogger(Query.class);

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String connectionUrl = "jdbc:mysql://localhost:3306/sakila-db";
			String connectionUser = "root";
			String connectionPassword = "root";

			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT last_name FROM actor ;");

			while (rs.next()) {
				String lastName = rs.getString("last_name");
				System.out.println("Last Name: " + lastName);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
	}
}
