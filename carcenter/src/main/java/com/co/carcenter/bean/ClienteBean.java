package com.co.carcenter.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import com.co.carcenter.pojo.Cliente;
import com.co.carcenter.service.ClaseConexion;

/**
 * 
 * @author Juan Carlos Pedraza
 *
 */

@ManagedBean
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1126777011722826080L;

	private Cliente cliente;
	private ClaseConexion conexion;

	@PostConstruct
	public void init() {
		conexion = new ClaseConexion();
		cliente = new Cliente();
	}

	private boolean validarCampos() {
		boolean validador = true;
		if (StringUtils.isBlank(cliente.getIdentificacion())) {
			mensajes("La identificacion es obligatoria");
			validador = false;
		}
		if (StringUtils.isBlank(cliente.getNombres())) {
			mensajes("El nombre es obligatorio");
			validador = false;
		}
		if (StringUtils.isBlank(cliente.getPrimerApellido())) {
			mensajes("El primer apellido es obligatorio");
			validador = false;
		}
		return validador;
	}

	public void guardarCliente() {
		try {
			if (!validarCampos()) {
				return;
			}
			if (cliente.insertar(conexion)) {
				mensajes("Se ha guardado el registro");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String mensajes(String mensaje) {
		FacesMessage confirmar = new FacesMessage(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, confirmar);
		return "guardado";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
