package co.uniquindio.lenguaje.address;



import co.uniquindio.lenguaje.address.exceptions.ProgramaAcademicoNullException;
import co.uniquindio.lenguaje.address.exceptions.ProgramaAcademicoRepeatException;

import co.uniquindio.lenguaje.address.model.Jornada;
import co.uniquindio.lenguaje.address.model.Metodologia;
import co.uniquindio.lenguaje.address.model.ProgramaAcademico;

public interface IControlProgramaAcademico 
{
	public abstract int obtenerPosProgramaAcademico(String codigoSNIES);
	public abstract ProgramaAcademico obtenerProgramaAcademico(String codigoSNIES)throws ProgramaAcademicoNullException;
	public abstract void agregarProgramaAcademico(String nombre, String codigoSNIES, int numeroCreditos, String lugarDeDesarrollo,
			Metodologia miMetodologia, Jornada miJordana)throws ProgramaAcademicoRepeatException;
	public abstract void eliminarProgramaAcademico(String codigoSNIES)throws ProgramaAcademicoNullException;

	

}
