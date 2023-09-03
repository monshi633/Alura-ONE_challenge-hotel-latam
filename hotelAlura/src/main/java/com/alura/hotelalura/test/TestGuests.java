package com.alura.hotelalura.test;

import java.sql.SQLException;
import java.util.Vector;

import com.alura.hotelalura.controller.GuestController;
import com.alura.hotelalura.model.Guest;

@SuppressWarnings("unused")
public class TestGuests {

	public static void main(String[] args) throws SQLException {

		GuestController gc = new GuestController();
		Guest antonio = new Guest("Ganso", "Manso", "1990-06-12", "Argentino", "123");
//		gc.createGuest(antonio);
//		System.out.println(gc.readGuest("Manso"));
//		gc.updateGuest(39, "Peppermint", "Buttler", "1111-01-01", "Unknown", "000");
//		gc.deleteGuest(2);
		for (Vector<String> element : gc.readGuestLastName("top")) {
			System.out.println(element);
		}
		System.out.println(gc.readGuestLastName("top"));
	}

}
