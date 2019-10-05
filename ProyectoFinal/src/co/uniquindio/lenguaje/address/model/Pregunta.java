package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pregunta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Tema miTemaAsociado;
	private ArrayList<String> respuestas;
	private ArrayList<String> opciones;
	private TipoPregunta miTipo;
	/**
	 * Metodo constructor vacio de la clase Pregunta
	 */
	public Pregunta()
	{
		this("", null);
	}
	/**
	 * Metodo constructor de la clase Pregunta
	 * @param nombre
	 * @param miTipo
	 */
	public Pregunta(String nombre, TipoPregunta miTipo)
	{
		this.nombre = nombre;
		this.miTipo = miTipo;
		this.respuestas = new ArrayList<String>();
	}
	/**
	 * Metodo accesor al Tema asociado a la pregunta
	 * @return el Tema asociado a la pregunta
	 */
	public Tema getMiTemaAsociado() {
		return miTemaAsociado;
	}
	/**
	 * Metodo modificador del Tema asociado a la pregunta
	 * @param miTemaAsociado
	 */
	public void setMiTemaAsociado(Tema miTemaAsociado) {
		this.miTemaAsociado = miTemaAsociado;
	}
	/**
	 * Metodo accesor a la lista de respuestas de la Pregunta
	 * @return la lista de respuestas de la pregunta
	 */
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	/**
	 * Metodo modificador de la lista de respuestas de la Pregunta
	 * @param respuestas
	 */
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
	/**
	 * Metodo accesor al nombre de la Pregunta
	 * @return el nombre de la pregunta
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo accesor al nombre de la pregunta para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del nombre de la pregunta
	 */
	public StringProperty nombreProperty()
	{
		StringProperty nombreProperty = new SimpleStringProperty(this.nombre);
		return nombreProperty;
	}
	/**
	 * Metodo modificador del nombre de la pregunta
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo accesor al tipo de la pregunta
	 * @return el tipo de la pregunta
	 */
	public TipoPregunta getMiTipo() {
		return miTipo;
	}
	/**
	 * Metodo modificador del tipo de la pregunta
	 * @param miTipo
	 */
	public void setMiTipo(TipoPregunta miTipo) {
		this.miTipo = miTipo;
	}
	/**
	 * Metodo accesor al tipo de la pregunta para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del tipo de pregunta
	 */
	public StringProperty miTipoProperty()
	{
		StringProperty miTipoProperty = new SimpleStringProperty(this.miTipo+"");
		return miTipoProperty;
	}
	/**
	 * Metodo que permite agregar respuestas a la lista de respuestas de la pregunta
	 * @param respuesta
	 */
	public void agregarRespuesta(String respuesta)
	{
		getRespuestas().add(respuesta);
	}
	/**
	 * Metodo que permite eliminar una respuesta de la lista de respuestas de la pregunta
	 * @param respuesta
	 */
	public void eliminarRespuesta(String respuesta)
	{
		getRespuestas().remove(respuesta);
	}
	/**
	 * Metodo accesor a la lista de opciones posibles de la pregunta
	 * @return la lista de opciones de la pregunta
	 */
	public ArrayList<String> getOpciones() {
		return opciones;
	}
	/**
	 * Metodo modificador de la lista de opciones de la pregunta
	 * @param opciones
	 */
	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}
	/**
	 * Metodo toString de la clase Pregunta
	 */
	@Override
	public String toString()
	{
		return nombre+"";
	}
	/**
	 * Metodo que verifica si la opcion elejida es correcta
	 * @param opcion
	 * @return un booleano verificando si la opcion ingresada es correcta
	 */
	public boolean isOpcionCorrecta(String opcion)
	{
		boolean centinela = false;
		
			if(getMiTipo()==TipoPregunta.SIMPLE)
			{
				if(opcion.equalsIgnoreCase(getRespuestas().get(0)))
					centinela = true;
			}
			else
			{
				if(opcion.contains(getRespuestas().get(0)))
					centinela = true;
			}
		
		return centinela;
	}
}