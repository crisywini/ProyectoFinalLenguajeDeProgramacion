package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;

public class Administrador extends ComunidadAcademica implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Metodo constructor vacio de la clase Administrador
	 */
	public Administrador() 
	{
		this("", "", "", "", "", "", null);
	}
	/**
	 * Metodo constructor de la clase Administrador 
	 * @param nombre del administrador
	 * @param apellido del administrador
	 * @param codigo del administrador 
	 * @param usuario del administrador
	 * @param contrasenia del administrador
	 * @param telefono del administrador
	 * @param miUniversidad asociada al administrador
	 */
	public Administrador(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, Universidad miUniversidad) 
	{
		super(nombre, apellido, codigo, usuario, contrasenia, telefono, miUniversidad);
	}
}
