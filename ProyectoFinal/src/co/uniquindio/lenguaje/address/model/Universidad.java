package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.uniquindio.lenguaje.address.exceptions.DocenteNullException;
import co.uniquindio.lenguaje.address.exceptions.DocenteRepeatException;
import co.uniquindio.lenguaje.address.exceptions.EstudianteNullException;
import co.uniquindio.lenguaje.address.exceptions.EstudianteRepeatException;
import co.uniquindio.lenguaje.address.exceptions.PersonaNoEncontradaException;
import co.uniquindio.lenguaje.address.exceptions.PersonaRepetidaException;
import co.uniquindio.lenguaje.address.exceptions.ProgramaAcademicoNullException;
import co.uniquindio.lenguaje.address.exceptions.ProgramaAcademicoRepeatException;

public class Universidad implements Serializable 
{
	/**
	 * @author Cristian Giovanny Sanchez Pineda
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ComunidadAcademica> miComunidadAcademica;
	private ArrayList<Docente> misDocentes;
	private ArrayList<Estudiante> misEstudiantes;
	private ArrayList<ProgramaAcademico> misProgramasAcademicos;
	private ArrayList<Administrador> misAdministradores;
	/**
	 *Metodo constructor de la clase principal de la logica
	 */
	public Universidad() 
	{
		this.miComunidadAcademica = new ArrayList<ComunidadAcademica>();
		this.misDocentes = new ArrayList<Docente>();
		this.misEstudiantes = new ArrayList<Estudiante>();
		this.misProgramasAcademicos = new ArrayList<ProgramaAcademico>();
		this.misAdministradores = new ArrayList<Administrador>();
	}
	/**
	 * Metodo accesor a la lista de administradores de la Universidad 
	 * @return la lista de Administradores
	 */
	public ArrayList<Administrador> getMisAdministradores() {
		return misAdministradores;
	}
	/**
	 * Metodo modificador de la lista de Administradores de la Universidad
	 * @param misAdministradores
	 */
	public void setMisAdministradores(ArrayList<Administrador> misAdministradores) {
		this.misAdministradores = misAdministradores;
	}
	/**
	 * Metodo accesor a la lista de personas pertenecientes a laUniversidad
	 * @return la lista de personas pertenecientes a la Universidad
	 */
	public ArrayList<ComunidadAcademica> getMiComunidadAcademica() {
		return miComunidadAcademica;
	}
	/**
	 * Metodo modificador de la lista de personas pertenecientes a la Universidad
	 * @param miComunidadAcademica
	 */
	public void setMiComunidadAcademica(ArrayList<ComunidadAcademica> miComunidadAcademica) {
		this.miComunidadAcademica = miComunidadAcademica;
	}
	/**
	 * Metodo accesor a la lista de Docentes de la Universidad
	 * @return la lista de Docentes de la Universidad
	 */
	public ArrayList<Docente> getMisDocentes() {
		return misDocentes;
	}
	/**
	 * Metodo modificador de la lista de Docentes de la Universidad
	 * @param misDocentes
	 */
	public void setMisDocentes(ArrayList<Docente> misDocentes) {
		this.misDocentes = misDocentes;
	}
	/**
	 * Metodo accesor a la lista de Estudiantes de la Universidad
	 * @return la lista de Estudiantes de la Universidad
	 */
	public ArrayList<Estudiante> getMisEstudiantes() {
		return misEstudiantes;
	}
	/**
	 * Metodo modificador de la lista de Estudiantes de la Universidad
	 * @param misEstudiantes
	 */
	public void setMisEstudiantes(ArrayList<Estudiante> misEstudiantes) {
		this.misEstudiantes = misEstudiantes;
	}
	/**
	 * Metodo accesor a la lista de Programas Academicos de la Universidad
	 * @return la lista de Programas Academicos de la Universidad
	 */
	public ArrayList<ProgramaAcademico> getMisProgramasAcademicos() {
		return misProgramasAcademicos;
	}
	/**
	 * Metodo modificador de la lista de Programas Academicos de la Universidad
	 * @param misProgramasAcademicos
	 */
	public void setMisProgramasAcademicos(ArrayList<ProgramaAcademico> misProgramasAcademicos) {
		this.misProgramasAcademicos = misProgramasAcademicos;
	}
	/**
	 * Metodo que obtiene el indice de la lista de personas pertenecientes a la Universidad
	 * @param codigo
	 * @return el indice de la lista de personas
	 */
	public int obtenerPosMiComunidadAcademica(String codigo)
	{
		int pos = -1;
		ComunidadAcademica miComunidadAux = null;
		String codigoAux = "";
		boolean centinela = false;
		for (int i = 0; i < miComunidadAcademica.size()&&!centinela; i++) 
		{
			miComunidadAux = miComunidadAcademica.get(i);
			codigoAux = miComunidadAux.getCodigo();
			if(codigoAux.equals(codigo))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener a una persona perteneciente a la Universidad
	 * @param codigo
	 * @return la Persona perteneciente a la Universidad
	 * @throws PersonaNoEncontradaException si esta persona no existe
	 */
	public ComunidadAcademica obtenerComunidadAcademica(String codigo) throws PersonaNoEncontradaException
	{
		ComunidadAcademica salida = null;
		int pos = obtenerPosMiComunidadAcademica(codigo);
		if(pos==-1)
		{
			throw new PersonaNoEncontradaException("La persona: "+codigo+" no ha sido encontrada en la Comunidad Universitaria");
		}
		else
		{
			salida = getMiComunidadAcademica().get(obtenerPosMiComunidadAcademica(codigo));
		}
		return salida;
	}
	/**
	 * Metodo que permite agrgar una persona a la lista de personas pertenecientes a la Universidad
	 * @param miComunidadAcademica
	 * @throws PersonaRepetidaException si esta persona ya existe
	 */
	public void agregarComunidadAcademica(ComunidadAcademica miComunidadAcademica)throws PersonaRepetidaException
	{
		int pos = obtenerPosMiComunidadAcademica(miComunidadAcademica.getCodigo());
		if(pos != -1)
		{
			throw new PersonaRepetidaException("La persona "+getMiComunidadAcademica().get(pos).getCodigo()+" ya se encuentra en la comunidad universitaria");
		}
		else
		{
			getMiComunidadAcademica().add(miComunidadAcademica);
		}
	}
	/**
	 * Metodo que permite eliminar una persona de la lista de personas pertenecientes a la Universidad
	 * @param codigo
	 * @throws PersonaNoEncontradaException si la persona no existe en la Universidad
	 */
	public void eliminarComunidadAcademica(String codigo)throws PersonaNoEncontradaException
	{
		int pos = obtenerPosMiComunidadAcademica(codigo);
		if(pos != -1)
		{
			ComunidadAcademica miAcademica = getMiComunidadAcademica().get(pos);
			getMiComunidadAcademica().remove(miAcademica);
		}
		else
		{
			throw new PersonaNoEncontradaException("La persona "+codigo+" no se encuentra en la Comunidad Universitaria");
		}
	}
	/**
	 * Metodo que permite obtener el indice del Docente en la lista de Docentes de la Universidad
	 * @param codigo
	 * @return el indice del Docente en la lista de Docentes de la Universidad
	 */
	public int obtenerPosDocente(String codigo)
	{
		int pos = -1;
		String codigoAux = "";
		Docente miDocenteAux = null;
		boolean centinela = false;
		for (int i = 0; i < getMisDocentes().size()&&!centinela; i++) 
		{
			miDocenteAux = getMisDocentes().get(i);
			codigoAux = miDocenteAux.getCodigo();
			if(codigoAux.equals(codigo))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener un Docente de la lista de Docentes de la Universidad
	 * @param codigo
	 * @return un Docente segun el codigo
	 * @throws DocenteNullException si este Docente no existe
	 */
	public Docente obtenerDocente(String codigo)throws DocenteNullException
	{
		int pos = obtenerPosDocente(codigo);
		Docente miDocente = null;
		if(pos!=-1)
		{
			miDocente = getMisDocentes().get(pos);
		}
		else
		{
			throw new DocenteNullException("El docente "+codigo+" no se encuentra en la Comunidad Universitaria");
		}
		return miDocente;
	}
	/**
	 * Metodo que permite agregar un Docente a la lista de Docentes de la Universidad
	 * @param nombre del Docente
	 * @param apellido del Docente
	 * @param codigo del Docente
	 * @param usuario del Docente
	 * @param contrasenia del Docente
	 * @param telefono del Docente
	 * @param profesion del Docente
	 * @throws DocenteRepeatException si el Docente ya existe
	 */
	public void agregarDocente(String nombre, String apellido, String codigo, String usuario, String contrasenia, String telefono, String profesion)throws DocenteRepeatException
	{
		int pos = obtenerPosDocente(codigo);
		if(pos==-1)
		{
			getMisDocentes().add(new Docente(nombre, apellido, codigo, usuario, contrasenia, telefono, this,profesion));
		}
		else
		{
			throw new DocenteRepeatException("El docente "+codigo+" ya se encuentra en la Comunidad Universitaria");
		}
	}
	/**
	 * Metodo que permite eliminar un Docente de la lista de Docentes de la Universidad
	 * @param codigo
	 * @throws DocenteNullException si el Docente no existe
	 */
	public void eliminarDocente(String codigo)throws DocenteNullException
	{
		int pos = obtenerPosDocente(codigo);
		if(pos == -1)
		{
			throw new DocenteNullException("El docente: " +codigo+ " no se encuentra en la Comunidad Universitaria");
		}
		else
		{
			Docente miDocente = getMisDocentes().get(pos);
			getMisDocentes().remove(miDocente);
		}
	}
	/**
	 * Metodo que permite obtener el indice de un estudiante en la lista de estudiantes de la Universidad
	 * @param codigo
	 * @return el indice del estudiante en la lista de estudiantes de la Universidad
	 */
	public int obtenerPosEstudiante(String codigo)
	{
		int pos = -1;
		Estudiante miEstudiante = null;
		String codigoAux = "";
		boolean centinela = false;
		for (int i = 0; i < getMisEstudiantes().size()&&!centinela; i++) 
		{
			miEstudiante = getMisEstudiantes().get(i);
			codigoAux = miEstudiante.getCodigo();
			if(codigoAux.equals(codigo))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener un estudiante de la lista de estudiantes de la Universidad
	 * @param codigo
	 * @return un Estudiante
	 * @throws EstudianteNullException si el estudiante no existe
	 */
	public Estudiante obtenerEstudiante(String codigo)throws EstudianteNullException
	{
		Estudiante miEstudiante = null;
		int pos = obtenerPosEstudiante(codigo);
		if(pos!=-1)
		{
			miEstudiante = getMisEstudiantes().get(pos);
		}
		else
		{
			throw new EstudianteNullException("El estudiante: "+ codigo+" no se encuentra en la Comunidad Universitaria");
		}
		return miEstudiante;
	}
	/**
	 * Metodo que permite agregar un estudiante a la lista de Estudiantes de la Universidad
	 * @param nombre del Estudiante
	 * @param apellido del Estudiante
	 * @param codigo del Estudiante
	 * @param usuario del Estudiante
	 * @param contrasenia del Estudiante
	 * @param telefono del Estudiante
	 * @param miProgramaAcademico del Estudiante
	 * @throws EstudianteRepeatException si el Estudiante ya esta agregado
	 */
	public void agregarEstudiante(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, ProgramaAcademico miProgramaAcademico)throws EstudianteRepeatException
	{
		int pos = obtenerPosEstudiante(codigo);
		if(pos!=-1)
		{
			throw new EstudianteRepeatException("El estudiante: "+ codigo + " ya se encuentra en la Comunidad Universitaria");
		}
		else
		{
			Estudiante miEstudiante = new Estudiante(nombre, apellido, codigo, usuario, contrasenia, telefono, this, miProgramaAcademico);
			getMisEstudiantes().add(miEstudiante);
		}
	}
	/**
	 * Metodo que permite eliminar a un estudiante de la lista de Estudiantes de la Universidad
	 * @param codigo
	 * @throws EstudianteNullException si el Estudiante no existe
	 */
	public void eliminarEstudiante(String codigo)throws EstudianteNullException
	{
		int pos = obtenerPosEstudiante(codigo);
		if(pos == -1)
		{
			throw new EstudianteNullException("El estudiante: "+ codigo+ " no se encuentra en la Comunidad Universitaria");
		}
		else 
		{
			Estudiante miEstudiante = getMisEstudiantes().get(pos);
			getMisEstudiantes().remove(miEstudiante);
		}
	}
	/**
	 * Metodo que permite obtener el indice de un programa Academico de la Universidad
	 * @param codigoSNIES
	 * @return el indice de un Programa Academico en la lista de Programas de la Universidad
	 */
	public int obtenerPosProgramaAcademico(String codigoSNIES)
	{
		int pos = -1;
		boolean centinela = false;
		ProgramaAcademico miProgramaAcademico = null;
		String codigoSNIESAux = "";
		for (int i = 0; i <getMisProgramasAcademicos().size()&&!centinela; i++) 
		{
			miProgramaAcademico = getMisProgramasAcademicos().get(i);
			codigoSNIESAux = miProgramaAcademico.getCodigoSNIES();
			if(codigoSNIESAux.equals(codigoSNIES))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener un Programa Academico de la Universidad
	 * @param codigoSNIES
	 * @return un Programa Academico de la Universidad
	 * @throws ProgramaAcademicoNullException si el Programa no existe
	 */
	public ProgramaAcademico obtenerProgramaAcademico(String codigoSNIES)throws ProgramaAcademicoNullException
	{
		ProgramaAcademico miProgramaAcademico = null;
		int pos = obtenerPosProgramaAcademico(codigoSNIES);
		if(pos == -1)
		{
			throw new ProgramaAcademicoNullException("El programa academico: "+ codigoSNIES+" no se encuentra en la Universidad");
		}
		else
		{
			miProgramaAcademico = getMisProgramasAcademicos().get(pos);
		}
		return miProgramaAcademico;
	}
	/**
	 * Metodo que permite agregar un Programa Academico a la lista de Programas de de la Universidad
	 * @param nombre del Programa Academico
	 * @param codigoSNIES del Programa Academico
	 * @param numeroCreditos del Programa Academico
	 * @param lugarDeDesarrollo del Programa Academico
	 * @param miMetodologia del Programa Academico
	 * @param miJordana del Programa Academico
	 * @throws ProgramaAcademicoRepeatException si El Programa Academico ya existe 
	 */
	public void agregarProgramaAcademico(String nombre, String codigoSNIES, int numeroCreditos, String lugarDeDesarrollo,
			Metodologia miMetodologia, Jornada miJordana)throws ProgramaAcademicoRepeatException
	{
		int pos = obtenerPosProgramaAcademico(codigoSNIES);
		if(pos != -1)
		{
			throw new ProgramaAcademicoRepeatException("El programa academico: "+codigoSNIES+" ya existe en la Universidad");
		}
		else
		{
			getMisProgramasAcademicos().add(new ProgramaAcademico(nombre, codigoSNIES, numeroCreditos, lugarDeDesarrollo, miMetodologia, miJordana));
		}
	}
	/**
	 * Metodo que permite eliminar un Programa Academico de la Universidad
	 * @param codigoSNIES
	 * @throws ProgramaAcademicoNullException si el Programa no existe
	 */
	public void eliminarProgramaAcademico(String codigoSNIES)throws ProgramaAcademicoNullException
	{
		int pos = obtenerPosProgramaAcademico(codigoSNIES);
		if(pos == -1)
		{
			throw new ProgramaAcademicoNullException("El programa academico: "+ codigoSNIES+ " no se encuentra en la Universidad");
		}
		else
		{
			ProgramaAcademico miProgramaAcademico = getMisProgramasAcademicos().get(pos);
			getMisProgramasAcademicos().remove(miProgramaAcademico);
		}
	}
	/**
	 * Metodo que permite obtener el indice de un Administrador de la Universidad
	 * @param codigo
	 * @return el indice de un administrador en la lista de Administradores de la Universidad
	 */
	public int obtenerPosAdministrador(String codigo)
	{
		int pos = -1;
		Administrador miAdministrador = null;
		String codigoAux = "";
		boolean centinela = false;
		for (int i = 0; i < misAdministradores.size()&&!centinela; i++) 
		{
			miAdministrador = misAdministradores.get(i);
			codigoAux = miAdministrador.getCodigo();
			if(codigoAux.equals(codigo))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener un Administrador de la lista de Administradores de la Universidad
	 * @param codigo 
	 * @return el Administrador en la lista de Administradores
	 * @throws PersonaNoEncontradaException si El Administrador no existe en la lista de Administradores de la Universidad
	 */
	public Administrador obtenerAdministrador(String codigo)throws PersonaNoEncontradaException
	{
		Administrador salida = null;
		int pos = obtenerPosAdministrador(codigo);
		if(pos==-1)
		{
			throw new PersonaNoEncontradaException("El administrador: "+ codigo+" no se encuentra en la Universidad");
		}
		else
		{
			salida = getMisAdministradores().get(pos);
		}
		return salida;
	}
	/**
	 * Metodo que permite agregar un Administrador a la lista de Administradores de la Universidad
	 * @param nombre del Administrador
	 * @param apellido del Administrador
	 * @param codigo del Administrador
	 * @param usuario del Administrador
	 * @param contrasenia del Administrador
	 * @param telefono del Administrador
	 * @throws PersonaRepetidaException si el Administrador ya se encuentra en la lista de Administradores 
	 */
	public void agregarAdministrador(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono)throws PersonaRepetidaException
	{
		int pos = obtenerPosAdministrador(codigo);
		if(pos==-1)
		{
			Administrador miAdministrador = new Administrador(nombre, apellido, codigo, usuario, contrasenia, telefono, this);
			getMisAdministradores().add(miAdministrador);
		}
		else
		{
			throw new PersonaRepetidaException("El administrador: "+ codigo+" ya se encuentra en la Universidad");
		}
	}
	/**
	 * Metodo que permite eliminar un Administrador de la lista de Administradores de la Universidad
	 * @param codigo
	 * @throws PersonaNoEncontradaException si el Administrador no existe en la lista de Administradores de la Universidad
	 */
	public void eliminarAdministrador(String codigo)throws PersonaNoEncontradaException
	{
		int pos = obtenerPosAdministrador(codigo);
		if(pos == -1)
		{
			throw new PersonaNoEncontradaException("El administrador: "+codigo+ " no se encuentra en la Universidad");
		}
		else
		{
			Administrador miAdministrador = obtenerAdministrador(codigo);
			getMisAdministradores().remove(miAdministrador);
		}
	}
	/**
	 * Metodo que permite obtener el indice del Administrador en la lista de Administradores de la Universidad
	 * @param usuario
	 * @return el indice del Administrador en la lista de Administradores de la Universidad
	 */
	public int obtenerPosAdministradorSegunUsuario(String usuario)
	{
		int pos = -1;
		Administrador miAdministrador = null;
		String user = "";
		boolean centinela = false;
		for (int i = 0; i < misAdministradores.size()&&!centinela; i++) 
		{
			miAdministrador = misAdministradores.get(i);
			user = miAdministrador.getUsuario();
			if(user.equals(usuario))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener un Administrador de la lista de Administradores de la Universidad
	 * @param usuario
	 * @return un Administrador
	 * @throws PersonaNoEncontradaException si el Administrador no esta registrado en la lista de Administradores de la Universidad
	 */
	public Administrador obtenerAdministradorSegunUsuario(String usuario)throws PersonaNoEncontradaException
	{
		int pos = obtenerPosAdministradorSegunUsuario(usuario);
		Administrador miAdministrador = null;
		if(pos == -1)
		{
			throw new PersonaNoEncontradaException("El administrador segun el usuario: "+ usuario+" no se encuentra en la Universidad");
		}
		else
		{
			miAdministrador = getMisAdministradores().get(pos);
		}
		return miAdministrador;
	}
}