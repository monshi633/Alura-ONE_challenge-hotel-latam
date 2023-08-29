package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.DBCredentials;

public class ConnectionFactory {

	DBCredentials dbc = new DBCredentials();
	public Connection createConnection() throws SQLException {
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC", dbc.getUsername(), dbc.getPassword());
	return connection;
	}
	
}