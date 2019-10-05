package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.uniquindio.lenguaje.address.exceptions.ExamenNullException;
import co.uniquindio.lenguaje.address.exceptions.ExamenRepeatException;
import co.uniquindio.lenguaje.address.exceptions.TemaNullException;
import co.uniquindio.lenguaje.address.exceptions.TemaRepeatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Docente extends ComunidadAcademica implements Serializable
{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String profesion;
	private ArrayList<Tema> misTemas;
	private ArrayList<Examen> misExamenes;
	/**
	 * Metodo constructor vacio de la clase Docente
	 */
	public Docente()
	{
		this("", "", "", "", "", "", null,"");
	}
	/**
	 * Metodo constructor de la clase Docente 
	 * @param nombre del Docente
	 * @param apellido del Docente
	 * @param codigo del Docente
	 * @param usuario del Docente
	 * @param contrasenia del Docente
	 * @param telefono del Docente
	 * @param miUniversidad asociada al Docente
	 * @param profesion del Docente
	 */
	public Docente(String nombre, String apellido, String codigo, String usuario, String contrasenia, String telefono, Universidad miUniversidad,String profesion) 
	{
		super(nombre, apellido, codigo, usuario, contrasenia, telefono, miUniversidad);
		this.profesion = profesion;
		this.misTemas = new ArrayList<Tema>();
		this.misExamenes = new ArrayList<Examen>();
	}
	/**
	 * Metodo accesor al la lista de temas propuestos por el Docente
	 * @return los temas propuestos por el Docente
	 */
	public ArrayList<Tema> getMisTemas() {
		return misTemas;
	}
	/**
	 * Metodo modificador de los temas propuestos por el Docente
	 * @param misTemas
	 */
	public void setMisTemas(ArrayList<Tema> misTemas) {
		this.misTemas = misTemas;
	}
	/**
	 * Metodo accesor de los Examenes propuestos por el Docente
	 * @return los  examenes propuestos por el Docente
	 */
	public ArrayList<Examen> getMisExamenes() {
		return misExamenes;
	}
	/**
	 * Metodo modificador de los examenes propuestos por el Docente
	 * @param misExamenes
	 */
	public void setMisExamenes(ArrayList<Examen> misExamenes) {
		this.misExamenes = misExamenes;
	}
	/**
	 * Metodo accesor de la profesion del Docente
	 * @return la Profesion del Docente
	 */
	public String getProfesion()
	{
		return profesion;
	}
	/**
	 * Metodo modificador de la profesion del Docente
	 * @param profesion
	 */
	public void setProfesion(String profesion) 
	{
		this.profesion = profesion;
	}
	/**
	 * Metodo accesor a la profesion del Docente para poder mostrarla en la interfaz
	 * @return
	 */
	public StringProperty profesionProperty()
	{
		StringProperty profesionProperty = new SimpleStringProperty(this.profesion);
		return profesionProperty;
	}
	/**
	 * Metodo que obtiene el indice de un Tema propuesto por el Docente
	 * @param nombre
	 * @return el indice del tema en la lista de temas del Docente
	 */
	public int obtenerPosTema(String nombre)
	{
		int pos = -1;
		Tema miTema = null;
		String nombreAux = "";
		boolean centinela = false;
		for (int i = 0; i < getMisTemas().size()&&!centinela; i++) 
		{
			miTema = getMisTemas().get(i);
			nombreAux = miTema.getNombre();
			if(nombreAux.equals(nombre))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que obtiene un tema dado un nombre
	 * @param nombre 
	 * @return el tema si este existe
	 * @throws TemaNullException si no existe el tema
	 */
	public Tema obtenerTema(String nombre)throws TemaNullException
	{
		Tema miTema = null;
		int pos = obtenerPosTema(nombre);
		if(pos != -1)
		{
			miTema = getMisTemas().get(pos);
		}
		else
		{
			throw new TemaNullException("El tema: "+nombre+" no esta en la lista de temas creados por el docente: "+ this.getNombre());
		}
		return miTema;
	}
	/**
	 * Metodo que permite agregar temas a la lista de Temas del Docente
	 * @param nombre
	 * @throws TemaRepeatException si el tema ya existe
	 */
	public void agregarTema(String nombre)throws TemaRepeatException
	{
		int pos = obtenerPosTema(nombre);
		if(pos == -1)
		{
			getMisTemas().add(new Tema(nombre));
		}
		else
		{
			throw new TemaRepeatException("El tema: "+ nombre+ " ya se encuentra en la lista de temas creados por el docente: "+this.getNombre());
		}
	}
	/**
	 * Metodo que permite eliminar un tema segun el nombre
	 * @param nombre
	 * @throws TemaNullException si el tema no existe
	 */
	public void eliminarTema(String nombre)throws TemaNullException
	{
		int pos = obtenerPosTema(nombre); 
		if(pos == -1)
		{
			throw new TemaNullException("El tema: "+nombre+ " no se encuentra en la lista de temas creados por el docente: "+ this.getNombre());
		}
		else
		{
			Tema miTema = obtenerTema(nombre);
			getMisTemas().remove(miTema);
		}
	}
	/**
	 * Metodo que obtiene el indice de un Examen propuesto por el Docente
	 * @param descripcion
	 * @param titulo
	 * @return el indice del examen
	 */
	public int obtenerPosExamen(String descripcion, String titulo)
	{
		int pos = -1;
		boolean centinela = false;
		Examen miExamenAux = null;
		String descripcionAux = "";
		String tituloAux = "";
		for (int i = 0; i <getMisExamenes().size()&&!centinela; i++) 
		{
			miExamenAux = getMisExamenes().get(i);
			descripcionAux = miExamenAux.getDescripcion();
			tituloAux = miExamenAux.getTitulo();
			if(descripcionAux.equals(descripcion)&&tituloAux.equals(titulo))
			{
				centinela = true;
				pos = i;
			}
		}
		return pos;
	}
	/**
	 * Metodo que obtiene un Examen ingresando la descripcion y el titulo
	 * @param descripcion
	 * @param titulo
	 * @return el Examen
	 * @throws ExamenNullException si no existe el Examen
	 */
	public Examen obtenerExamenSegunDescripcionTitulo(String descripcion, String titulo)throws ExamenNullException
	{
		Examen salida = null;
		int pos = obtenerPosExamen(descripcion, titulo);
		if(pos ==-1)
		{
			throw new ExamenNullException("El Examen:"+ titulo +"no se encuentra en la base de datos del Docente: "+getNombre());
		}
		else
		{
			salida = getMisExamenes().get(pos);
		}
		return salida;
	}
	/**
	 * Metodo que agrega un Examen a la lista de Examenes propuestos por el Docente
	 * @param descripcion del Examen
	 * @param titulo del Examen
	 * @param porcentajeExito del Examen
	 * @param tiempoLimite del Examen
	 * @param misTemas del Examen
	 * @param miTipoExamen del Examen
	 * @param misEstudiantes del Examen
	 * @throws ExamenRepeatException si el Examen ya existe 
	 */
	public void agregarExamen(String descripcion, String titulo, double porcentajeExito, double tiempoLimite,
			ArrayList<Tema> misTemas, TipoExamen miTipoExamen, ArrayList<Estudiante> misEstudiantes) throws ExamenRepeatException
	{
		int pos = obtenerPosExamen(descripcion, titulo);
		if(pos !=-1)
		{
			throw new ExamenRepeatException("El examen: "+titulo+" ya se encuentra en la base de datos del docente: " +getNombre());
		}
		else
		{
			getMisExamenes().add(new Examen(descripcion, titulo, porcentajeExito, tiempoLimite, misTemas, miTipoExamen, misEstudiantes));
		}
	}
	/**
	 * Metodo que permite eliminar un Examen ingresando la descripcion y el titulo de este
	 * @param descripcion del Examen
	 * @param titulo del Examen
	 * @throws ExamenNullException si este no existe
	 */
	public void eliminarExamen(String descripcion, String titulo)throws ExamenNullException
	{
		int pos = obtenerPosExamen(descripcion, titulo);
		if(pos ==-1)
		{
			throw new ExamenNullException("El examen: "+ titulo+" no se encuentra en la base de datos del docente: " +getNombre());
		}
		else
		{
			Examen miExamen = obtenerExamenSegunDescripcionTitulo(descripcion, titulo);
			getMisExamenes().remove(miExamen);
		}
	}
}