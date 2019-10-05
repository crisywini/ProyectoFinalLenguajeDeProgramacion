package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProgramaAcademico implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String codigoSNIES;
	private int numeroCreditos;
	private String lugarDeDesarrollo;
	private Metodologia miMetodologia;
	private Jornada miJordana;
	private ArrayList<ComunidadAcademica> miComunidadAcademica;
	private ArrayList<Docente> misDocentes;
	private ArrayList<Estudiante> misEstudiantes;
	private Universidad miUniversidad;
	/**
	 * Metodo constructor vacio de la clase ProgramaAcademico
	 */
	public ProgramaAcademico()
	{
		this("", "", 0, "", null, null);
	}
	/**
	 * Metodo constructor de la clase Programa Academico
	 * @param nombre del Programa Academico
	 * @param codigoSNIES del Programa Academico
	 * @param numeroCreditos del Programa Academico
	 * @param lugarDeDesarrollo del Programa Academico
	 * @param miMetodologia del Programa Academico
	 * @param miJordana del Programa Academico
	 */
	public ProgramaAcademico(String nombre, String codigoSNIES, int numeroCreditos, String lugarDeDesarrollo,
			Metodologia miMetodologia, Jornada miJordana) 
	{	
		this.nombre = nombre;
		this.codigoSNIES = codigoSNIES;
		this.numeroCreditos = numeroCreditos;
		this.lugarDeDesarrollo = lugarDeDesarrollo;
		this.miMetodologia = miMetodologia;
		this.miJordana = miJordana;
		this.misDocentes = new ArrayList<Docente>();
		this.misEstudiantes = new ArrayList<Estudiante>();
	}
	/**
	 * Metodo accesor a la lista de Docentes asociados al Programa academico
	 * @return la lista de Docentes del Programa Academico
	 */
	public ArrayList<Docente> getMisDocentes() {
		return misDocentes;
	}
	/**
	 * Metodo modificador de la lista de Docentes asociados al Programa Academico
	 * @param misDocentes
	 */
	public void setMisDocentes(ArrayList<Docente> misDocentes) {
		this.misDocentes = misDocentes;
	}
	/**
	 * Metodo accesor a la lista de Estudiantes del Programa Academico
	 * @return la lista de estudiantes del Programa Academico
	 */
	public ArrayList<Estudiante> getMisEstudiantes() {
		return misEstudiantes;
	}
	/**
	 * Metodo modificador de la lista de estudiantes del Programa Academico
	 * @param misEstudiantes
	 */
	public void setMisEstudiantes(ArrayList<Estudiante> misEstudiantes) {
		this.misEstudiantes = misEstudiantes;
	}
	/**
	 * Metodo accesor a la lista de personas que pertenecen a la Universidad
	 * @return lista de personas que pertenecen a la Universidad
	 */
	public ArrayList<ComunidadAcademica> getMiComunidadAcademica() {
		return miComunidadAcademica;
	}
	/**
	 * Metodo modificador de la lista de personas que pertenecen a la Universidad
	 * @param miComunidadAcademica
	 */
	public void setMiComunidadAcademica(ArrayList<ComunidadAcademica> miComunidadAcademica) {
		this.miComunidadAcademica = miComunidadAcademica;
	}
	/**
	 * Metodo modificador del Nombre del Programa Academico
	 * @return el nombre del Programa Academico
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo modificador del nombre del Programa Academico
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo accesor al CodigoSNIES del Programa Academico
	 * @return el codigoSNIES del Programa Academico
	 */
	public String getCodigoSNIES() {
		return codigoSNIES;
	}
	/**
	 * Metodo modificador del codigoSNIES del Programa Academico
	 * @param codigoSNIES
	 */
	public void setCodigoSNIES(String codigoSNIES) {
		this.codigoSNIES = codigoSNIES;
	}
	/**
	 * Metodo accesor al numero de creditos del Programa Academico
	 * @return el numero de creditos del Programa Academico
	 */
	public int getNumeroCreditos() {
		return numeroCreditos;
	}
	/**
	 * Metodo modificador del numero de creditos del Programa Academico
	 * @param numeroCreditos
	 */
	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	/**
	 * Metodo accesor al lugar de desarrollo del Programa Academico
	 * @return el lugar de desarrollo del Programa Academico
	 */
	public String getLugarDeDesarrollo() {
		return lugarDeDesarrollo;
	}
	/**
	 * Metodo modificador del lugar del desarrollo del Programa Academico
	 * @param lugarDeDesarrollo
	 */
	public void setLugarDeDesarrollo(String lugarDeDesarrollo) {
		this.lugarDeDesarrollo = lugarDeDesarrollo;
	}
	/**
	 * Metodo accesor a la metodologia del Programa Academico
	 * @return la metodologia del Programa Academico
	 */
	public Metodologia getMiMetodologia() {
		return miMetodologia;
	}
	/**
	 * metodo modificador de la Metodologia del Programa Academico
	 * @param miMetodologia
	 */
	public void setMiMetodologia(Metodologia miMetodologia) {
		this.miMetodologia = miMetodologia;
	}
	/**
	 * Metodo accesor a la Jornada del Programa Academico
	 * @return la Jornada del Programa Academico
	 */
	public Jornada getMiJordana() {
		return miJordana;
	}
	/**
	 * Metodo modificador de la Jornada del Programa Academico
	 * @param miJordana
	 */
	public void setMiJordana(Jornada miJordana) {
		this.miJordana = miJordana;
	}
	/**
	 * Metodo accesor al nombre del Programa Academico para poder mostrarlo en la interfaz
	 * @return el nombre del Programa Academico en un StringProperty
	 */
	public StringProperty nombreProperty()
	{
		StringProperty nombreProperty = new SimpleStringProperty(this.nombre);
		return nombreProperty;
	}
	/**
	 * Metodo accesor al CodigoSNIES del Programa Academico para poder mostrarlo en la interfaz
	 * @return 
	 */
	public StringProperty codigoSNIESProperty()
	{
		StringProperty codigoSNIESProperty = new SimpleStringProperty(this.codigoSNIES);
		return codigoSNIESProperty;
	}
	/**
	 * Metodo accesor al numero de creditos del Programa Academico para porder mostrarlo en la interfaz
	 * @return
	 */
	public StringProperty numeroCreditosProperty()
	{
		StringProperty numeroCreditosProperty = new SimpleStringProperty(this.numeroCreditos+"");
		return numeroCreditosProperty;
	}
	/**
	 * Metodo accesor al lugar de desarrollo del Programa Academico para poder mostrarlo en la interfaz
	 * @return
	 */
	public StringProperty lugarDeDesarrolloProperty()
	{
		StringProperty lugarDeDesarrolloProperty = new SimpleStringProperty(this.lugarDeDesarrollo);
		return lugarDeDesarrolloProperty;
	}
	/**
	 * Metodo accesor a la metodologia del Programa Academico para poder mostrarlo en la interfaz
	 * @return
	 */
	public StringProperty miMetodologiaProperty()
	{
		StringProperty miMetodologiaProperty = new SimpleStringProperty(this.miMetodologia+"");
		return miMetodologiaProperty;
	}
	/**
	 * Metodo accesor a la jornada del Programa Academico para poder mostrarlo en la interfaz
	 * @return
	 */
	public StringProperty miJornadaProperty()
	{
		StringProperty miJornadaProperty = new SimpleStringProperty(this.miJordana+"");
		return miJornadaProperty;
	}
	/**
	 * Metodo accesor a la Universidad asociada al Programa Academico
	 * @return la Universidad Asociada al Programa Academico
	 */
	public Universidad getMiUniversidad() {
		return miUniversidad;
	}
	/**
	 * Metodo modificador de la Universidad Asociada al Programa Academico
	 * @param miUniversidad
	 */
	public void setMiUniversidad(Universidad miUniversidad) {
		this.miUniversidad = miUniversidad;
	}
	/**
	 * Metodo que obtiene el indice de un docente en la lista de Docentes asociados al programa academico
	 * @param codigo
	 * @return el indice del docente en la lista
	 */
	public int obtenerPosDocente(String codigo)
	{
		int pos = -1;
		Docente miDocente = null;
		String auxiliar = "";
		boolean control = false;
		for (int i = 0; i < getMisDocentes().size()&&!control; i++) 
		{
			miDocente = misDocentes.get(i);
			auxiliar = miDocente.getCodigo();
			if(auxiliar.equals(codigo))
			{
				control = true;
				pos = i;
			}
		}
		return pos;	
	}
}