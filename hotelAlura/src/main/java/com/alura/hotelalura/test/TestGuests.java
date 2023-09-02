package com.alura.hotelalura.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotelalura.controller.GuestController;
import com.alura.hotelalura.dao.GuestDAO;
import com.alura.hotelalura.factory.ConnectionFactory;
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
		for (int i = 0; i < gc.readGuestLastName("top").size(); i++) {
			System.out.println(gc.readGuestLastName("top").get(i));
		}
		System.out.println(gc.readGuestLastName("top"));
	}

}
