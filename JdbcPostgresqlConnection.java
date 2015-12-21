package net.codejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class JdbcPostgresqlConnection {

	public static void main(String[] args) {
		// create three connections to three different databases on localhost
		Connection conn1 = null;
		Connection conn2 = null;
		Connection conn3 = null;

		try {
			// Connect method #1
			String dbURL1 = "jdbc:postgresql:ProductDB1?user=root&password=secret";
			conn1 = DriverManager.getConnection(dbURL1);
			if (conn1 != null) {
				System.out.println("Connected to database #1");
			}

			// Connect method #2
			String dbURL2 = "jdbc:postgresql://localhost/ProductDB2";
			String user = "root";
			String pass = "secret";

			conn2 = DriverManager.getConnection(dbURL2, user, pass);
			if (conn2 != null) {
				System.out.println("Connected to database #2");
			}

			// Connect method #3
			String dbURL3 = "jdbc:postgresql://localhost:5432/ProductDB3";
			Properties parameters = new Properties();
			parameters.put("user", "root");
			parameters.put("password", "secret");

			conn3 = DriverManager.getConnection(dbURL3, parameters);
			if (conn3 != null) {
				System.out.println("Connected to database #3");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn1 != null && !conn1.isClosed()) {
					conn1.close();
				}
				if (conn2 != null && !conn2.isClosed()) {
					conn2.close();
				}
				if (conn3 != null && !conn3.isClosed()) {
					conn3.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}