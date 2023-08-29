package test;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Guests;

public class TestGuests {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.createConnection();

		Guests guests = new Guests(con);
		guests.createGuest("Alice", "Berth", "1999-12-31", "argdfsdfsdfdnio", "123");
		guests.readGuest(37);
		guests.updateGuest(41, "Z", "Z", "2000-12-31", "argentino", "456");
		guests.deleteGuest(44);

	}

}
