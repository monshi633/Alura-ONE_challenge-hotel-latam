package com.alura.hotelalura.test;

import java.sql.SQLException;

import com.alura.hotelalura.controller.GuestController;
import com.alura.hotelalura.controller.ReserveController;
import com.alura.hotelalura.model.Guest;
import com.alura.hotelalura.model.Reserve;

@SuppressWarnings("unused")
public class TestReserves {

	public static void main(String[] args) throws SQLException {

		Guest antonio = new Guest("Ganso", "Manso", "1990-06-12", "Argentino", "123");
		Reserve reserve = new Reserve(antonio.getId(), "2000-01-01", "2000-12-31", "$ 951", "Bitcoin");
		
		GuestController gc = new GuestController();
		gc.createGuest(antonio);
		ReserveController rc = new ReserveController();
//		rc.createReserve(reserve, antonio.getId());
//		System.out.println(rc.readReserve(19));
//		rc.updateReserve(6, 50, "2000-01-01", "2000-12-31", "$ 951", "Bitcoin");
//		rc.deleteReserveId(11);
//		rc.deleteReserveGuestId(50);
		for (int i = 0; i < rc.readReserveGuestId(53).size(); i++) {
			System.out.println(rc.readReserveGuestId(53).get(i));
		}
		System.out.println(rc.readReserveGuestId(53));
	}

}
