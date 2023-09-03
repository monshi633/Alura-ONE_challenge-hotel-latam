package com.alura.hotelalura.controller;

import java.util.List;
import java.util.Vector;

import com.alura.hotelalura.dao.GuestDAO;
import com.alura.hotelalura.factory.ConnectionFactory;
import com.alura.hotelalura.model.Guest;

public class GuestController {

	private GuestDAO guestDao;

	public GuestController() {
		this.guestDao = new GuestDAO(new ConnectionFactory().getConnection());
	}

	public void createGuest(Guest guest) {
		guestDao.createGuest(guest);
	}

	public List<Vector<String>> readGuestLastName(String lastName) {
		return guestDao.readGuestLastName(lastName);
	}

	public Vector<String> readGuestId(Integer id) {
		return guestDao.readGuestId(id);
	}

	public Vector<String> readGuestFullName(String name, String lastName) {
		return guestDao.readGuestFullName(name, lastName);
	}

	public void updateGuest(Integer id, String name, String lastName, String birthDate, String nationality,
			String phone) {
		guestDao.updateGuest(id, name, lastName, birthDate, nationality, phone);
	}

	public void deleteGuest(Integer id) {
		guestDao.deleteGuest(id);
	}

}