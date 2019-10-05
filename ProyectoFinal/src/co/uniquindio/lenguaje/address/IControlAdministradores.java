package co.uniquindio.lenguaje.address;

import co.uniquindio.lenguaje.address.exceptions.PersonaNoEncontradaException;
import co.uniquindio.lenguaje.address.exceptions.PersonaRepetidaException;
import co.uniquindio.lenguaje.address.model.Administrador;

public interface IControlAdministradores 
{
	public abstract int obtenerPosAdministrador(String codigo);
	public abstract Administrador obtenerAdministrador(String codigo)throws PersonaNoEncontradaException;
	public abstract void agregarAdministrador(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono)throws PersonaRepetidaException;
	public abstract void eliminarAdministrador(String codigo)throws PersonaNoEncontradaException;
	public int obtenerPosAdministradorSegunUsuario(String usuario);
	public Administrador obtenerAdministradorSegunUsuario(String usuario)throws PersonaNoEncontradaException;
}
