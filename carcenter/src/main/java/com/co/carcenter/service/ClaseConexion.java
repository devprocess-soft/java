package com.co.carcenter.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Juan Carlos Pedraza
 *
 */
public class ClaseConexion {

	public Connection iniciarConexion() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:orcl", "myuser", "xxxx");
		return conn;
	}

}
