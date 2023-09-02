package com.alura.hotelalura.controller;

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
	
	public Vector<String> readGuest(String lastName){
		return guestDao.readGuest(lastName);
	}
	
	public void updateGuest(Integer id, String name, String lastName, String birthDate, String nationality, String phone){
		guestDao.updateGuest(id, name, lastName, birthDate, nationality, phone);
	}
	
	public void deleteGuest(Integer id){
		guestDao.deleteGuest(id);
	}
	
}