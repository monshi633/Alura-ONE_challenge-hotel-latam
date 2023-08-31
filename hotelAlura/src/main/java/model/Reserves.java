package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reserves {

	Connection con;
	Integer id;

	public Reserves(Connection con) {
		this.con = con;
	}

	public Integer createReserve(Integer huespedId, String fechaEntrada, String fechaSalida, String valor,	String formaPago) throws SQLException {
		// tengo que poner un try/catch por si el huespedId no existe
		String statement = "INSERT INTO reservas (huesped_id, fechaEntrada, fechaSalida, valor, formaPago) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stm = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);

		stm.setInt(1, huespedId);
		stm.setDate(2, Date.valueOf(fechaEntrada));
		stm.setDate(3, Date.valueOf(fechaSalida));
		stm.setString(4, valor);
		stm.setString(5, formaPago);
		stm.executeUpdate();

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			id = rst.getInt(1);
			System.out.println("New reserve inserted with id = " + id);
		}
		return id;
	}

	public void readReserve(Integer id) throws SQLException {
		// Agregar try/catch por si no existe el id
		String statement = "SELECT * FROM reservas WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);

		stm.setInt(1, id);
		stm.execute();

		ResultSet rst = stm.executeQuery();
		while (rst.next()) {
			String huespedId = rst.getString("huesped_id");
			String fechaEntrada = rst.getString("fechaEntrada");
			String fechaSalida = rst.getString("fechaSalida");
			String valor = rst.getString("valor");
			String formaPago = rst.getString("formaPago");
			System.out.println("Reserve id: " + id + "\n"
					+ "Reserve huesped id: " + huespedId + "\n"
					+ "Reserve fecha de entrada: " + fechaEntrada + "\n"
					+ "Reserve fecha de salida: " + fechaSalida + "\n"
					+ "Reserve valor: " + valor + "\n"
					+ "Reserve forma de pago: " + formaPago);
		}
	}

	public void updateReserve(Integer id, Integer huespedId, String fechaEntrada, String fechaSalida, String valor,	String formaPago) throws SQLException {
		String statement = "UPDATE reservas SET huesped_id = ?, fechaEntrada = ?, fechaSalida = ?, valor = ?, formaPago = ? WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);
		
		stm.setInt(1, huespedId);
		stm.setDate(2, Date.valueOf(fechaEntrada));
		stm.setDate(3, Date.valueOf(fechaSalida));
		stm.setString(4, valor);
		stm.setString(5, formaPago);
		stm.setInt(6, id);
		
		int rowsAffected = stm.executeUpdate();

	    if (rowsAffected > 0) {
	        System.out.println("Updated reserve with id: " + id);
	    } else {
	        System.out.println("No reserve found with id: " + id);
	    }
	}

	public void deleteReserve(Integer id) throws SQLException {
		System.out.println("Deleting reserve:");
		readReserve(id);
		
		String statement = "DELETE FROM reservas WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);
		
		stm.setInt(1, id);
		stm.executeUpdate();
	}
}
