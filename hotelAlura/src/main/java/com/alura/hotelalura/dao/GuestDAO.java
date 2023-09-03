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

import com.alura.hotelalura.model.Guest;

public class GuestDAO{

	Connection con;

	public GuestDAO(Connection con) {
		this.con = con;
	}
	
	public void createGuest(Guest guest){
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO huespedes (nombre, apellido, fechaNacimiento, nacionalidad, telefono) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, guest.getName());
			statement.setString(2, guest.getLastName());
			statement.setDate(3, Date.valueOf(guest.getBirthDate()));
			statement.setString(4, guest.getNationality());
			statement.setString(5, guest.getPhone());
			statement.executeUpdate();
			
			ResultSet rst = statement.getGeneratedKeys();
			
			while(rst.next()) {
				guest.setId(rst.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Vector<String>> readGuestLastName(String lastName){
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE apellido = ?");
			
			statement.setString(1, lastName);
			statement.execute();
			
			List<Vector<String>> vectorList = new ArrayList<>();
			
			ResultSet rst = statement.executeQuery();
			
			while(rst.next()) {
				Vector<String> vector = new Vector<>();
				vector.add(rst.getString("id"));
				vector.add(rst.getString("nombre"));
				vector.add(lastName);
				vector.add(rst.getString("fechaNacimiento"));
				vector.add(rst.getString("nacionalidad"));
				vector.add(rst.getString("telefono"));
				vectorList.add(vector);
			}
			
			return vectorList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Vector<String> readGuestId(Integer id) {
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE id = ?");
			
			statement.setInt(1, id);
			statement.execute();
			
			Vector<String> vector = new Vector<>();
			
			ResultSet rst = statement.executeQuery();
			
			while(rst.next()) {
				vector.add(id.toString());
				vector.add(rst.getString("nombre"));
				vector.add(rst.getString("apellido"));
				vector.add(rst.getString("fechaNacimiento"));
				vector.add(rst.getString("nacionalidad"));
				vector.add(rst.getString("telefono"));
			}
			return vector;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Vector<String> readGuestFullName(String name, String lastName) {
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE nombre = ? AND apellido = ?");
			
			statement.setString(1, name);
			statement.setString(2, lastName);
			statement.execute();
			
			Vector<String> vector = new Vector<>();
			
			ResultSet rst = statement.executeQuery();
			
			while(rst.next()) {
				vector.add(rst.getString("id"));
				vector.add(name);
				vector.add(lastName);
				vector.add(rst.getString("fechaNacimiento"));
				vector.add(rst.getString("nacionalidad"));
				vector.add(rst.getString("telefono"));
			}
			return vector;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateGuest(Integer id, String name, String lastName, String birthDate, String nationality, String phone){
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fechaNacimiento = ?, nacionalidad = ?, telefono = ? WHERE id = ?");
			
			statement.setString(1, name);
			statement.setString(2, lastName);
			statement.setDate(3, Date.valueOf(birthDate));
			statement.setString(4, nationality);
			statement.setString(5, phone);
			statement.setInt(6, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteGuest(Integer id){
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			
			statement.setInt(1, id);
			statement.executeUpdate();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}