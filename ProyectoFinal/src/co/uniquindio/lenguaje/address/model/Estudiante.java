package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.uniquindio.lenguaje.address.exceptions.ExamenNullException;


public class Estudiante extends ComunidadAcademica implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgramaAcademico miProgramaAcademico;
	private ArrayList<Examen> misExamenesAsociados;
	/**
	 * Metodo constructor vacio de la clase Estudiante
	 */
	public Estudiante() 
	{
		super();
		this.miProgramaAcademico = null;
	}
	/**
	 * Metodo constructor de la Clase Estudiante
	 * @param nombre del Estudiante
	 * @param apellido del Estudiante
	 * @param codigo del Estudiante
	 * @param usuario del Estudiante
	 * @param contrasenia del Estudiante
	 * @param telefono del Estudiante
	 * @param miUniversidad asociada al Estudiante
	 * @param miProgramaAcademico asociado al Estudiante
	 */
	public Estudiante(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, Universidad miUniversidad,ProgramaAcademico miProgramaAcademico)
	{
		super(nombre, apellido, codigo, usuario, contrasenia, telefono, miUniversidad);
		this.miProgramaAcademico = miProgramaAcademico;
		this.misExamenesAsociados = new ArrayList<>();
	}
	/**
	 * Metodo accesor al programa academico asociado al Estudiante
	 * @return el programa academico asociado al estudiante
	 */
	public ProgramaAcademico getMiProgramaAcademico() 
	{
		return miProgramaAcademico;
	}
	/**
	 * Metodo modificador del Programa Academico asociado al estudiante
	 * @param miProgramaAcademico
	 */
	public void setMiProgramaAcademico(ProgramaAcademico miProgramaAcademico) 
	{
		this.miProgramaAcademico = miProgramaAcademico;
	}
	/**
	 * Metodo equals de la clase estudiante
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return super.equals(obj);
	}
	/**
	 * Metodo toString de la Clase Estudiante
	 */
	@Override
	public String toString() 
	{
		return super.toString();
	}
	/**
	 * Metodo accesor a los examenes del Estudiante
	 * @return los Examenes del estudiante
	 */
	public ArrayList<Examen> getMisExamenesAsociados() {
		return misExamenesAsociados;
	}
	/**
	 * Metodo modificador de los Examenes del Estudiante
	 * @param misExamenesAsociados
	 */
	public void setMisExamenesAsociados(ArrayList<Examen> misExamenesAsociados) {
		this.misExamenesAsociados = misExamenesAsociados;
	}
	/**
	 * Metodo que obtiene el indice del examen segun el titulo
	 * @param titulo
	 * @return el indice del examen en la lista de examenes
	 */
	public int obtenerPosExamen(String titulo)
	{
		int pos = -1;
		Examen salida = null;
		boolean centinela = false;
		for (int i = 0; i < getMisExamenesAsociados().size()&&centinela == false; i++) 
		{
			salida = getMisExamenesAsociados().get(i);
			if(salida.getTitulo().equals(titulo))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que obtiene un Examen dado un titulo
	 * @param titulo
	 * @return El Examen
	 */
	public Examen obtenerExamenSegunTitulo(String titulo)
	{
		Examen miExamen = null;
		int pos = obtenerPosExamen(titulo);
		if(pos == -1)
		{
			throw new ExamenNullException("El estudiante no ha presentado el examen: "+titulo);
		}
		else
		{
			miExamen = getMisExamenesAsociados().get(pos);
		}
		return miExamen;
	}
}