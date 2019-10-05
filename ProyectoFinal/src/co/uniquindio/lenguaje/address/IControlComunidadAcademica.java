package co.uniquindio.lenguaje.address;

import co.uniquindio.lenguaje.address.exceptions.PersonaNoEncontradaException;
import co.uniquindio.lenguaje.address.exceptions.PersonaRepetidaException;
import co.uniquindio.lenguaje.address.model.ComunidadAcademica;

public interface IControlComunidadAcademica 
{
	public abstract int obtenerPosMiComunidadAcademica(String codigo);
	public abstract ComunidadAcademica obtenerComunidadAcademica(String codigo) throws PersonaNoEncontradaException;
	public abstract void agregarComunidadAcademica(ComunidadAcademica miComunidadAcademica)throws PersonaRepetidaException;
	public abstract void eliminarComunidadAcademica(String codigo)throws PersonaNoEncontradaException;





}
