package co.uniquindio.lenguaje.address;

import co.uniquindio.lenguaje.address.exceptions.DocenteNullException;
import co.uniquindio.lenguaje.address.exceptions.DocenteRepeatException;
import co.uniquindio.lenguaje.address.model.Docente;

public interface IControlDocente 
{
	public abstract int obtenerPosDocente(String codigo);
	public abstract Docente obtenerDocente(String codigo)throws DocenteNullException;
	public abstract void agregarDocente(String nombre, String apellido, String codigo, String usuario, String contrasenia, String telefono, String profesion)throws DocenteRepeatException;
	public abstract void eliminarDocente(String codigo)throws DocenteNullException;
}
