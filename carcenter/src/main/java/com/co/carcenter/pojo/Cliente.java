package com.co.carcenter.pojo;

import java.sql.CallableStatement;
import java.sql.SQLException;
import com.co.carcenter.service.ClaseConexion;

/**
 * @author Juan Carlos Pedraza
 *
 */
public class Cliente {

	private String identificacion;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private ClaseConexion connectionClass;
	
	public Cliente() {
		connectionClass = new ClaseConexion();
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public boolean insertar(ClaseConexion conexion) throws SQLException {
		CallableStatement sentencia = connectionClass.iniciarConexion().prepareCall("{call crud_cliente (?, ?, ?, ?, ?)}");
		sentencia.setString(1, this.identificacion);
		sentencia.setString(2, this.nombres);
		sentencia.setString(3, this.primerApellido);
		sentencia.setString(4, this.segundoApellido);
		sentencia.setString(5, "C");
		return sentencia.execute();
	}
	
	public boolean update(ClaseConexion conexion) throws SQLException {
		CallableStatement sentencia = connectionClass.iniciarConexion().prepareCall("{call crud_cliente (?, ?, ?, ?, ?)}");
		sentencia.setString(1, this.identificacion);
		sentencia.setString(2, this.nombres);
		sentencia.setString(3, this.primerApellido);
		sentencia.setString(4, this.segundoApellido);
		sentencia.setString(5, "U");
		return sentencia.execute();
	}
	
	public boolean delete(ClaseConexion conexion) throws SQLException {
		CallableStatement sentencia = connectionClass.iniciarConexion().prepareCall("{call crud_cliente (?, ?, ?, ?, ?)}");
		sentencia.setString(1, this.identificacion);
		sentencia.setString(2, this.nombres);
		sentencia.setString(3, this.primerApellido);
		sentencia.setString(4, this.segundoApellido);
		sentencia.setString(5, "D");
		return sentencia.execute();
	}

}
