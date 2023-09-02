package com.alura.hotelalura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.alura.hotelalura.utils.DBCredentials;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SuppressWarnings("unused")
public class ConnectionFactory {

	private DataSource datasource;
	
	DBCredentials dbc = new DBCredentials();
	
//	Connection pool
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC");
		pooledDataSource.setUser(dbc.getUsername());
		pooledDataSource.setPassword(dbc.getPassword());
		pooledDataSource.setMaxPoolSize(10);
		
		this.datasource = pooledDataSource;
	}
	
	public Connection getConnection(){
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	Single connection
//	public Connection createConnection() throws SQLException {
//	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC", dbc.getUsername(), dbc.getPassword());
//	return connection;
//	}
	
}