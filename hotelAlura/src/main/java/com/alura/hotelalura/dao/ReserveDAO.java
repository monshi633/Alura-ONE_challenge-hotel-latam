package com.alura.hotelalura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.alura.hotelalura.model.Reserve;

/*
 * CREATE TABLE reservas (
 * id int NOT NULL AUTO_INCREMENT,
 * huesped_id int NOT NULL,
 * fechaEntrada date NOT NULL,
 * fechaSalida date NOT NULL,
 * valor varchar(45) NOT NULL,
 * formaPago varchar(45) NOT NULL,
 * PRIMARY KEY (id),
 * KEY huesped_id (huesped_id),
 * CONSTRAINT huesped_id FOREIGN KEY (huesped_id) REFERENCES huespedes (id)
 * );
 */
public class ReserveDAO {

	Connection con;

	public ReserveDAO(Connection con) {
		this.con = con;
	}

	public void createReserve(Reserve reserve) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas (huesped_id, fechaEntrada, fechaSalida, valor, formaPago) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, reserve.getGuestId());
			statement.setDate(2, Date.valueOf(reserve.getDateIn()));
			statement.setDate(3, Date.valueOf(reserve.getDateOut()));
			statement.setString(4, reserve.getPrice());
			statement.setString(5, reserve.getPaymentMethod());
			statement.executeUpdate();

			ResultSet rst = statement.getGeneratedKeys();

			while (rst.next()) {
				reserve.setId(rst.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Vector<String> readReserveId(Integer id) {
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas WHERE id = ?");

			statement.setInt(1, id);
			statement.execute();

			Vector<String> vector = new Vector<>();

			ResultSet rst = statement.executeQuery();

			while (rst.next()) {
				vector.add(id.toString());
				vector.add(rst.getString("huesped_id"));
				vector.add(rst.getString("fechaEntrada"));
				vector.add(rst.getString("fechaSalida"));
				vector.add(rst.getString("valor"));
				vector.add(rst.getString("formaPago"));
			}
			return vector;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Vector<String>> readReserveGuestId(Integer guestId) {
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas WHERE huesped_id = ?");

			statement.setInt(1, guestId);
			statement.execute();

			List<Vector<String>> vectorList = new ArrayList<>();

			ResultSet rst = statement.executeQuery();

			while (rst.next()) {
				Vector<String> vector = new Vector<>();
				vector.add(rst.getString("id"));
				vector.add(guestId.toString());
				vector.add(rst.getString("fechaEntrada"));
				vector.add(rst.getString("fechaSalida"));
				vector.add(rst.getString("valor"));
				vector.add(rst.getString("formaPago"));
				vectorList.add(vector);
			}
			return vectorList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateReserve(Integer id, String dateIn, String dateOut, String price, String paymentMethod) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"UPDATE reservas SET fechaEntrada = ?, fechaSalida = ?, valor = ?, formaPago = ? WHERE id = ?");

			statement.setDate(1, Date.valueOf(dateIn));
			statement.setDate(2, Date.valueOf(dateOut));
			statement.setString(3, price);
			statement.setString(4, paymentMethod);
			statement.setInt(5, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Deletes a reserve only
	 */
	public void deleteReserveId(Integer id) {
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");

			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Deletes every reserve of given guest
	 */
	public void deleteReserveGuestId(Integer guestId) {
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE huesped_id = ?");

			statement.setInt(1, guestId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
