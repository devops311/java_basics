package employeeregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import employeeregistration.exception.DatabaseConnectivityException;

public class ConnectionUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root@123";

	private ConnectionUtil() {

	}

	private static Connection connection = null;

	public static Connection getConnection() throws DatabaseConnectivityException {
		if (ConnectionUtil.connection == null) {
			try {
				ConnectionUtil.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			} catch (SQLException e) {
				throw new DatabaseConnectivityException("Unable to connect to database", e);
			}
		}
		return ConnectionUtil.connection;
	}
}
