package com.alura.hotelalura.controller;

import java.util.List;
import java.util.Vector;

import com.alura.hotelalura.dao.ReserveDAO;
import com.alura.hotelalura.factory.ConnectionFactory;
import com.alura.hotelalura.model.Reserve;

public class ReserveController {

	private ReserveDAO reserveDao;

	public ReserveController() {
		this.reserveDao = new ReserveDAO(new ConnectionFactory().getConnection());
	}

	public void createReserve(Reserve reserve, Integer guestId) {
		reserve.setGuestId(guestId);
		reserveDao.createReserve(reserve);
	}

	public Vector<String> readReserveId(Integer id) {
		return reserveDao.readReserveId(id);
	}

	public List<Vector<String>> readReserveGuestId(Integer guestId) {
		return reserveDao.readReserveGuestId(guestId);
	}

	public void updateReserve(Integer id, Integer guestId, String dateIn, String dateOut, String price,
			String paymentMethod) {
		reserveDao.updateReserve(id, guestId, dateIn, dateOut, price, paymentMethod);
	}

	public void deleteReserveId(Integer id) {
		reserveDao.deleteReserveId(id);
	}

	public void deleteReserveGuestId(Integer guestId) {
		reserveDao.deleteReserveGuestId(guestId);
	}

}
