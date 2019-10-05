package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.uniquindio.lenguaje.address.exceptions.EstudianteNullException;
import co.uniquindio.lenguaje.address.exceptions.EstudianteRepeatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Examen implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String titulo;
	private double porcentajeExito;
	private double tiempoLimite;
	private ArrayList<Tema> misTemas;
	private TipoExamen miTipoExamen;
	private Docente miDocente;
	private ArrayList<Estudiante> misEstudiantes;
	private ArrayList<String> opcionesElejidas;
	private double notaTotal;
	/**
	 * Metodo constructor vacio del Examen
	 */
	public Examen()
	{
		this("", "", 0.0, 0.0, null, null, null);
	}
	/**
	 * Metodo constructor del Examen
	 * @param descripcion del Examen
	 * @param titulo del Examen
	 * @param porcentajeExito del Examen
	 * @param tiempoLimite del Examen
	 * @param misTemas del Examen
	 * @param miTipoExamen del Examen
	 * @param misEstudiantes asociados al Examen
	 */
	public Examen(String descripcion, String titulo, double porcentajeExito, double tiempoLimite,
			ArrayList<Tema> misTemas, TipoExamen miTipoExamen, ArrayList<Estudiante> misEstudiantes)
	{
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.porcentajeExito = porcentajeExito;
		this.tiempoLimite = tiempoLimite;
		this.misTemas = misTemas;
		this.miTipoExamen = miTipoExamen;
		this.misEstudiantes = misEstudiantes;
		this.opcionesElejidas = new ArrayList<>();
	}
	/**
	 * Metoto acceso al tipo del Examen
	 * @return el tipo del Examen
	 */
	public TipoExamen getMiTipoExamen() 
	{
		return miTipoExamen;
	}
	/**
	 * Metodo modificador del Tipo del Examen 
	 * @param miTipoExamen
	 */
	public void setMiTipoExamen(TipoExamen miTipoExamen) {
		this.miTipoExamen = miTipoExamen;
	}
	/**
	 * Metodo accesor al tipo del Examen para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del tipo del Examen
	 */
	public StringProperty miTipoExamenProperty()
	{
		StringProperty miTipoExamenProperty = new SimpleStringProperty(this.miTipoExamen+"");
		return miTipoExamenProperty;
	}
	/**
	 * Metodo accesor a la descripcion del Examen
	 * @return la descripcion del Examen
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Metodo modificador de la descripcion del Examen
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Metodo accesor a la descripcion del Examen para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion de la descripcion del Examen
	 */
	public StringProperty descripcionProperty()
	{
		StringProperty descripcionProperty = new SimpleStringProperty(this.descripcion);
		return descripcionProperty;
	}
	/**
	 * Metodo accesor al titulo del Examen
	 * @return el Titulo del Examen
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Metodo modificador al titulo del Examen
	 * @param titulo
	 */
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	/**
	 * Metodo accesor al titulo del Examen para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del Examen
	 */
	public StringProperty tituloProperty()
	{
		StringProperty tituloProperty = new SimpleStringProperty(this.titulo);
		return tituloProperty;
	}
	/**
	 * Metodo accesor al porcentaje de exito del examen
	 * @return el porcentaje de exito del Examen
	 */
	public double getPorcentajeExito() {
		return porcentajeExito;
	}
	/**
	 * Metodo modificador del Porcentaje de exito del Examen
	 * @param porcentajeExito
	 */
	public void setPorcentajeExito(double porcentajeExito) {
		this.porcentajeExito = porcentajeExito;
	}
	/**
	 * Metodo accesor al Porcentaje de exito para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del porcentaje de exito del Examen
	 */
	public StringProperty porcentajeExitoProperty()
	{
		StringProperty porcentajeExitoProperty = new SimpleStringProperty(this.porcentajeExito+"");
		return porcentajeExitoProperty;
	}
	/**
	 * Metodo accesor al tiempo limite del Examen
	 * @return el tiempo limite del Examen
	 */
	public double getTiempoLimite() {
		return tiempoLimite;
	}
	/**
	 * Metodo modificador del Tiempo limite del Examen
	 * @param tiempoLimite
	 */
	public void setTiempoLimite(double tiempoLimite) {
		this.tiempoLimite = tiempoLimite;
	}
	/**
	 * Metodo accesor al tiempo limite del Examen para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion del TiempoLimite del Examen
	 */
	public StringProperty tiempoLimiteProperty()
	{
		StringProperty tiempoLimiteProperty = new SimpleStringProperty(this.tiempoLimite+"");
		return tiempoLimiteProperty;
	}
	/**
	 * Metodo accesor a la lista de temas del Examen
	 * @return la lista de temas del Examen
	 */
	public ArrayList<Tema> getMisTemas() {
		return misTemas;
	}
	/**
	 * Metodo modificador de la lista de temas de un Examen
	 * @param misTemas
	 */
	public void setMisTemas(ArrayList<Tema> misTemas) {
		this.misTemas = misTemas;
	}
	/**
	 * Metodo Accesor al Docente asociado al Examen
	 * @return el Docente asociado al Examen
	 */
	public Docente getMiDocente() {
		return miDocente;
	}
	/**
	 * Metodo modificador del Docente asociado al Examen
	 * @param miDocente
	 */
	public void setMiDocente(Docente miDocente) {
		this.miDocente = miDocente;
	}
	/**
	 * Metodo accesor a la lista de Estudiantes asociados al Examen
	 * @return la lista de estudiantes asociados al examen
	 */
	public ArrayList<Estudiante> getMisEstudiantes() {
		return misEstudiantes;
	}
	/**
	 * Metodo modificador de la lista de Estudiantes
	 * @param misEstudiante
	 */
	public void setMisEstudiantes(ArrayList<Estudiante> misEstudiante) {
		this.misEstudiantes = misEstudiante;
	}
	/**
	 * Metodo accesor a la lista de opciones elejidas por el estudiante en el Examen
	 * @return la lista de Opciones elejidas
	 */
	public ArrayList<String> getOpcionesElejidas() {
		return opcionesElejidas;
	}
	/**
	 * Metodo modificador de la lista de opciones elejidas por el estudiante en el Examen
	 * @param opcionesElejidas
	 */
	public void setOpcionesElejidas(ArrayList<String> opcionesElejidas) {
		this.opcionesElejidas = opcionesElejidas;
	}
	/**
	 * Metodo equals del examen
	 */
	@Override
	public boolean equals(Object obj) 
	{
		boolean centinela = false;
		Examen esteExamen = null;
		if(obj instanceof Examen)
		{
			esteExamen = (Examen)obj;
			if(esteExamen.getTitulo().equals(getTitulo())&&esteExamen.getDescripcion().equals(getDescripcion()))
			{
				centinela = true;
			}
		}
		return centinela;
	}
	/**
	 * Metodo accesor a la nota Final del Examen
	 * @return
	 */
	public double getNotaTotal() {
		return notaTotal;
	}
	/**
	 * Metodo modificador de la nota del Examen
	 * @param notaTotal
	 */
	public void setNotaTotal(double notaTotal) {
		this.notaTotal = notaTotal;
	}
	/**
	 * Metodo accesor a la nota final del Examen para poder mostrarlo en la interfaz
	 * @return un StringProperty con la informacion de la nota final del Examen
	 */
	public StringProperty notaTotalProperty()
	{
		StringProperty notaProperty = new SimpleStringProperty(notaTotal+"");
		return notaProperty;
	}
	/**
	 * Metodo que permite obtener un indice de la lista de estudiantes asociados al Examen
	 * @param estudiante
	 * @return un indice de la lista de estudiantes asociados al Examen
	 */
	public int obtenerPosEstudiante(String estudiante)
	{
		int pos = -1;
		Estudiante miEstudiante = null;
		String codigoAux = "";
		boolean centinela = false;
		for (int i = 0; i < getMisEstudiantes().size()&&!centinela; i++) 
		{
			miEstudiante = getMisEstudiantes().get(i);
			codigoAux = miEstudiante.getCodigo();
			if(codigoAux.equals(estudiante))
			{
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}
	/**
	 * Metodo que permite agregar un estudiante a la lista de estudiantes asociados al examen
	 * @param codigo
	 * @throws EstudianteNullException si el Estudiante no existe
	 * @throws EstudianteRepeatException si el estudiante ya pertenece
	 */
	public void agregarEstudiante(String codigo)throws EstudianteNullException, EstudianteRepeatException
	{
		Universidad miU = miDocente.getMiUniversidad();
		int pos = miU.obtenerPosEstudiante(codigo);
		if(pos == -1)
		{
			throw new EstudianteNullException("El estudiante: "+codigo+ " no se encuentra en la Universidad, no puede presentar el examen");
		}
		else
		{
			if(obtenerPosEstudiante(codigo)==-1)
			{
				Estudiante miEstudiante = miU.obtenerEstudiante(codigo);
				getMisEstudiantes().add(miEstudiante);
			}
			else
			{
				throw new EstudianteRepeatException("El estudiante"+codigo +"ya se encuentra en la lista de examinados");
			}
		}
	}
	/**
	 * Metodo que permite eliminar un estudiante de la lista de examinados
	 * @param codigo
	 * @throws EstudianteNullException si el estudiante no existe
	 */
	public void eliminarEstudiante(String codigo)throws EstudianteNullException
	{
		Universidad miUniversidad = miDocente.getMiUniversidad();
		int pos = miUniversidad.obtenerPosEstudiante(codigo);
		if(pos==-1)
		{
			throw new EstudianteNullException("El estudiante: "+codigo+" no se encuentra en la Universidad");
		}
		else
		{
			if(obtenerPosEstudiante(codigo)==-1)
			{
				throw new EstudianteNullException("El estudiante: "+ codigo+ " no se encuentra en la lista de examinados");
			}
			else
			{
				Estudiante miAux = getMisEstudiantes().get(obtenerPosEstudiante(codigo));
				getMisEstudiantes().remove(miAux);
			}
		}
	}
	/**
	 * Metodo que permite obtener una lista con los estudiantes que ganaron el examen
	 * @return una lista con los ganadores
	 */
	public ArrayList<Estudiante> obtenerEstudiantesGanadores()
	{
		ArrayList<Estudiante> misEstudiantes = new ArrayList<>();
		for (Estudiante estudiante : getMisEstudiantes()) 
		{
			if(estudiante.obtenerExamenSegunTitulo(getTitulo()).getNotaTotal()>=3)
			{
				misEstudiantes.add(estudiante);
			}
		}
		return misEstudiantes;
	}
	/**
	 * Metodo que permite obtener una lista con los estudiantes que no ganaron el Examen
	 * @return la lista con los estudiantes que no ganaron el Examen
	 */
	public ArrayList<Estudiante> obtenerEstudiantesNoGanadores()
	{
		ArrayList<Estudiante> misEstudiantes = new ArrayList<>();
		for (Estudiante estudiante : getMisEstudiantes()) 
		{
			if(estudiante.obtenerExamenSegunTitulo(getTitulo()).getNotaTotal()<3)
				misEstudiantes.add(estudiante);
		}
		return misEstudiantes;
	}
	/**
	 * Metodo que obtiene la nota total del examen
	 * @return nota total del examen
	 */
	public double obtenerPorcentajeExamen()
	{
		double salida = 0.0;
		Tema miTema = null;
		for (int i = 0; i < getMisTemas().size(); i++) 
		{
			miTema = getMisTemas().get(i);
			salida += obtenerCalificacionPregunta(miTema);
		}
		setNotaTotal(salida);//ojo con esto
		return salida;
	}
	/**
	 * Metodo que obtiene la calificacion de cada pregunta dado un tema
	 * @param miTema tema 
	 * @return calificacion de cada pregunta
	 */
	public double obtenerCalificacionPregunta(Tema miTema)
	{
		double salida = 0.0;
		Pregunta miPregunta = null;
		for (int i = 0; i < miTema.getMisPreguntas().size(); i++) 
		{
			miPregunta = miTema.getMisPreguntas().get(i);
			if(miPregunta.getMiTipo()==TipoPregunta.SIMPLE)
			{
				if(obtenerOpcionesCorrectas(miPregunta, i)>0)
				{
					salida += 1;
				}
			}
			else
			{
				if(obtenerOpcionesCorrectas(miPregunta, i)>0)
				{
					salida += 1;
				}
			}
		}
		if(salida == miTema.getMisPreguntas().size())
		{
			salida = 5.0;
		}
		return salida;
	}
	/**
	 * Metodo que obtiene el numero de opciones correctas
	 * @param miPregunta pregunta con la cual va a verificar si estan o no correctas
	 * @return el numero de opciones correctas, dada una pregunta
	 */
	public int obtenerOpcionesCorrectas(Pregunta miPregunta, int i)
	{
		int salida = 0;
		String opcionAux = getOpcionesElejidas().get(i);
		if(miPregunta.isOpcionCorrecta(opcionAux))
		{
			salida ++;
		}
		return salida;
	}
	/**
	 *Metodo que setea a todos los estudiantes a este examen
	 */
	public void setEstudiantes()
	{
		Estudiante miEstudiante = null;
		ArrayList<Examen> misExamenes = null;
		for (int i = 0; i < misEstudiantes.size(); i++) 
		{
			miEstudiante = misEstudiantes.get(i);
			misExamenes = miEstudiante.getMisExamenesAsociados();
			misExamenes.add(this);
		}
	}
}