package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.exceptions.PreguntaNullException;
import co.uniquindio.lenguaje.address.exceptions.PreguntaRepeatException;
import co.uniquindio.lenguaje.address.exceptions.TemaNullException;
import co.uniquindio.lenguaje.address.exceptions.TemaRepeatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tema implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Tema> misSubTemas;
	private ArrayList<Pregunta> misPreguntas;
	private Examen miExamen;
	/**
	 * Metodo constructor vacio de la clase Tema
	 */
	public Tema()
	{
		this("");
	}
	/**
	 * Metodo constructor de la clase Tema
	 * @param nombre
	 */
	public Tema(String nombre)
	{
		this.nombre = nombre;
		this.misSubTemas = new ArrayList<Tema>();
		this.misPreguntas = new ArrayList<Pregunta>();
	}
	/**
	 * Metodo accesor al nombre del tema
	 * @return el nombre del Tema
	 */
	public String getNombre() 
	{
		return nombre;
	}
	/**
	 * Metodo modificador del nombre del Tema
	 * @param nombre
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	/**
	 * Metodo accesor al nombre del Tema para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del nombre del Tema
	 */
	public StringProperty nombreProperty()
	{
		StringProperty nombreProperty = new SimpleStringProperty(this.nombre);
		return nombreProperty;
	}
	/**
	 * Metodo accesor a la lista de SubTemas del Tema
	 * @return la lista de subtemas del Tema
	 */
	public ArrayList<Tema> getMisSubTemas() {
		return misSubTemas;
	}
	/**
	 * Metodo modificador de la lista de Subtemas del Tema
	 * @param misSubTemas
	 */
	public void setMisSubTemas(ArrayList<Tema> misSubTemas) {
		this.misSubTemas = misSubTemas;
	}
	/**
	 * Metodo accesor a la lista de preguntas del Tema
	 * @return la lista de preguntas del Tema
	 */
	public ArrayList<Pregunta> getMisPreguntas() {
		return misPreguntas;
	}
	/**
	 * Metodo modificador de la lista de preguntas del Tema
	 * @param misPreguntas
	 */
	public void setMisPreguntas(ArrayList<Pregunta> misPreguntas) {
		this.misPreguntas = misPreguntas;
	}
	/**
	 * Metodo que obtiene el indice de un subtema del Tema
	 * @param nombre
	 * @return el indice de un Subtema en la lista de SubTemas del Tema
	 */
	public int obtenerPosSubtema(String nombre)
	{
		int pos = -1;
		Tema miTema = null;
		String nombreAux = "";
		boolean centinela = false;
		for (int i = 0; i < getMisSubTemas().size()&&!centinela; i++) 
		{
			miTema = getMisSubTemas().get(i);
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
	 * Metodo que permite obtener un SubTema dado un nombre 
	 * @param nombre
	 * @return el SubTema segun el nombre
	 * @throws TemaNullException si el Tema no existe
	 */
	public Tema obtenerSubTema(String nombre)throws TemaNullException
	{
		int pos = obtenerPosSubtema(nombre);
		Tema miTema = null;
		if(pos==-1)
		{
			throw new TemaNullException("El subtema: "+ nombre+ " no se encuentra en el tema: "+this.nombre);
		}
		else
		{
			miTema = getMisSubTemas().get(pos);
		}
		return miTema;
	}
	/**
	 * Metodo que permite agregar un SubTema
	 * @param nombre 
	 * @throws TemaRepeatException si El SubTema ya existe
	 */
	public void agregarSubtema(String nombre)throws TemaRepeatException
	{
		int pos = obtenerPosSubtema(nombre);
		if(pos != -1)
		{
			throw new TemaRepeatException("El Subtema: "+ nombre+" ya se encuentra en el tema: "+this.nombre);
		}
		else
		{
			getMisSubTemas().add(new Tema(nombre));
		}
	}
	/**
	 * Metodo que permite eliminar un SubTema de la lista de Subtemas del Tema
	 * @param nombre
	 * @throws TemaNullException si el Tema no existe
	 */
	public void eliminarSubTema(String nombre)throws TemaNullException
	{
		int pos = obtenerPosSubtema(nombre);
		Tema miTema = null;
		if(pos == -1)
		{
			throw new TemaNullException("El subtema: "+nombre +" no existe en el tema: "+this.nombre);
		}
		else
		{
			miTema = getMisSubTemas().get(pos);
			getMisSubTemas().remove(miTema);
		}
	}
	/**
	 * Metodo que permite obtener el indice de una pregunta en la lista de preguntas del Tema
	 * @param nombre
	 * @return el indice de la pregunta en la lista de preguntas del Tema
	 */
	public int obtenerPosPregunta(String nombre) 
	{
		int pos = -1;
		Pregunta miPregunta = null;
		boolean centinela = false;
		String nombreAux = "";
		for (int i = 0; i < getMisPreguntas().size()&&!centinela; i++) 
		{
			miPregunta = getMisPreguntas().get(i);
			nombreAux = miPregunta.getNombre();
			if(nombreAux.equals(nombre))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite obtener una pregunta dado el nombre de ella
	 * @param nombre 
	 * @return la pregunta segun el nombre
	 */
	public Pregunta obtenerPregunta(String nombre)
	{
		int pos = obtenerPosPregunta(nombre);
		Pregunta miPregunta = null;
		if(pos == -1)
		{
			throw new PreguntaNullException("La pregunta: "+nombre+ " no existe en el tema: "+this.nombre);
		}
		else
		{
			miPregunta = getMisPreguntas().get(pos);
		}
		return miPregunta;
	}
	/**
	 * Metodo que permite agregar una pregunta a la lista de preguntas del Tema
	 * @param nombre
	 * @param miTipo
	 * @throws PreguntaRepeatException si la Pregunta ya existe
	 */
	public void agregarPregunta(String nombre, TipoPregunta miTipo)throws PreguntaRepeatException
	{
		int pos = obtenerPosPregunta(nombre);
		if(pos == -1)
		{
			Pregunta miPregunta = new Pregunta(nombre, miTipo);
			miPregunta.setMiTemaAsociado(this);
			getMisPreguntas().add(miPregunta);
		}
		else
		{
			throw new PreguntaRepeatException("La pregunta: "+ nombre+ " ya se encuentra en el tema: "+this.nombre);
		}
	}
	/**
	 * Metodo que permite eliminar una pregunta del Tema
	 * @param nombre
	 * @throws PreguntaNullException si la Pregunta no Existe
	 */
	public void eliminarPregunta(String nombre)throws PreguntaNullException
	{
		int pos = obtenerPosPregunta(nombre);
		if(pos == -1)
		{
			throw new PreguntaNullException("La pregunta: "+ nombre+ " no se encuentra en el tema: "+this.nombre);
		}
		else
		{
			Pregunta miPregunta = obtenerPregunta(nombre);
			getMisPreguntas().remove(miPregunta);
		}
	}
	/**
	 * Metodo accesor al Examen asociado al Tema
	 * @return el Examen asociado del Tema
	 */
	public Examen getMiExamen() {
		return miExamen;
	}
	/**
	 * Metodo modificador del Examen asociado al Tema
	 * @param miExamen
	 */
	public void setMiExamen(Examen miExamen) {
		this.miExamen = miExamen;
	}
	/**
	 * Metodo toString de la clase Tema
	 */
	@Override
	public String toString() 
	{
		String informacion = "Nombre del tema: "+getNombre()+"\n"
				             +"Subtemas: "+mostrarArrayListSubTemas(0)+"\n"
		                     +"Preguntas: "+mostrarArrayListPreguntas(0)+"\n";
		return informacion;
	}
	/**
	 * Metodo recursivo que retorna un String con los nombres de los subtemas del tema
	 * @param pos indice que ayuda a moverse en el arraylist de subtemas
	 * @return un String con la informacion del arraylist de subtemas
	 */
	public String mostrarArrayListSubTemas(int pos)
	{
		if(pos == this.misSubTemas.size())
		{
			return "";
		}
		else
		{
			return getMisSubTemas().get(pos).getNombre()+","+mostrarArrayListSubTemas(pos+1);
		}
	}
	/**
	 *Metodo recursivo que retorna un String con los nombres de las preguntas que hay en el tema
	 * @param pos indice que ayuda a moverse en el arraylist de preguntas
	 * @return un String con la informacion del tema
	 */
	public String mostrarArrayListPreguntas(int pos)
	{
		if(pos == this.misPreguntas.size())
		{
			return "";
		}
		else
		{
			return getMisPreguntas().get(pos).getNombre()+","+mostrarArrayListSubTemas(pos+1);
		}
	}
}
