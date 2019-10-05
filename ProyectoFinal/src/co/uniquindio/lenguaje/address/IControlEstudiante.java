package co.uniquindio.lenguaje.address;



import co.uniquindio.lenguaje.address.exceptions.EstudianteNullException;

import co.uniquindio.lenguaje.address.exceptions.EstudianteRepeatException;
import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.ProgramaAcademico;

public interface IControlEstudiante 
{
	public abstract int obtenerPosEstudiante(String codigo);
	public abstract Estudiante obtenerEstudiante(String codigo)throws EstudianteNullException;
	public abstract void agregarEstudiante(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, ProgramaAcademico miProgramaAcademico)throws EstudianteRepeatException;
	public abstract void eliminarEstudiante(String codigo)throws EstudianteNullException;



}
