package co.uniquindio.lenguaje.address.persistencia;

import java.beans.XMLDecoder;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

import co.uniquindio.lenguaje.address.model.*;

public class Persistencia
{
	public static final String RUTA_UNIVERSIDAD = "src/resources/Universidad.xml";
	public static final String RUTA_ADMINISTRADORES = "src/resources/Administradores.txt";
	public static final String RUTA_COMUNIDAD_ACADEMICA = "src/resources/ComunidadAcademica.txt";
	public static final String RUTA_DOCENTE = "src/resources/Docentes.txt";
	public static final String RUTA_ESTUDIANTE = "src/resources/Estudiantes.txt";
	public static final String RUTA_PROGRAMAS = "src/resources/Programas.txt";
	/**
	 * Metodo que serializa un objeto en un archivo XML
	 * @param nombreArchivo ruta en la cual se desea guardar el objeto
	 * @param objeto objeto a ser serializado
	 * @throws FileNotFoundException si no encuentra el archivo
	 */
	public static void serializarObjetoXML(String nombreArchivo, Object objeto)throws FileNotFoundException
	{
		FileOutputStream salida = new FileOutputStream(nombreArchivo);
		XMLEncoder codificador = new XMLEncoder(salida);
		codificador.writeObject(objeto);
		codificador.close();
	}
	/**
	 * Metodo estatico que lee la informacion de un objeto serializado en un archivo XML
	 * @param nombreArchivo ruta del archivo del objeto serializado en XML
	 * @return un  objeto leido de un archivo XML
	 * @throws FileNotFoundException si no encuentra el archivo
	 */
	public static Object deserializaObjetoXML(String nombreArchivo)throws FileNotFoundException
	{
		FileInputStream entrada = new FileInputStream(nombreArchivo);
		XMLDecoder decodificador = new XMLDecoder(entrada);
		Object objeto = decodificador.readObject();
		decodificador.close();
		return objeto;
	}
	/**
	 * metodo estatico que guarda la comunidad academica en un archivo
	 * @param miComunidadAcademica arrayList de comunidad academica
	 * @throws IOException Exception
	 */
	public static void guardarComunidadAcademicaEnArchivo(ArrayList<ComunidadAcademica> miComunidadAcademica)throws IOException
	{
		ArrayList<String> informacionArchivo = new ArrayList<String>();
		String informacion = "";
		ComunidadAcademica miAcademica = null;
		for (int i = 0;i<miComunidadAcademica.size(); i++) 
		{
			miAcademica = miComunidadAcademica.get(i);
			informacion += miAcademica.getCodigo()+","+miAcademica.getNombre()+","+miAcademica.getApellido()+","+miAcademica.getTelefono()
			               + ","+miAcademica.getUsuario()+","+miAcademica.getContrasenia()+"\n";
			informacionArchivo.add(informacion);
		}
		Archivador.guardarArchivo(informacionArchivo, RUTA_COMUNIDAD_ACADEMICA);		
	}
	/**
	 * Metodo estatico el cual guarda un estudiante en un archivo
	 * @param misEstudiantes arrayList de estudiantes
	 * @throws IOException 
	 */
	public static void guardarEstudiantesEnArchivo(ArrayList<Estudiante> misEstudiantes)throws IOException
	{
		ArrayList<String> informacionArchivo = new ArrayList<String>();
		String informacion = "";
		Estudiante miEstudiante = null;
		for (int i = 0; i < misEstudiantes.size(); i++) 
		{
			miEstudiante = misEstudiantes.get(i);
			informacion += miEstudiante.getCodigo()+","+miEstudiante.getNombre()+","+miEstudiante.getApellido()+","+miEstudiante.getTelefono()
			               +","+miEstudiante.getUsuario()+","+miEstudiante.getContrasenia()+","+miEstudiante.getMiProgramaAcademico().getCodigoSNIES()+"\n";
			informacionArchivo.add(informacion);
		}
		Archivador.guardarArchivo(informacionArchivo, RUTA_ESTUDIANTE);
	}
	
	/**
	 * Metodo estatico el cual permite guardar administradores en un archivo de texto
	 * @param misAdmins arrayList de administradores los cuales seran guardados en un archivo de texto
	 * @throws IOException 
	 */
	public static void guardarAdministradoresEnArchivo(ArrayList<Administrador> misAdmins)throws IOException
	{
		ArrayList<String> contenidoArchivoAdmin = new ArrayList<String>();
		String linea = "";
		for (Administrador miAdmin: misAdmins) 
		{
			linea = miAdmin.getCodigo()+","+miAdmin.getNombre()+","+miAdmin.getApellido()+","+miAdmin.getUsuario()+","+
		            miAdmin.getContrasenia()+","+miAdmin.getTelefono();
			contenidoArchivoAdmin.add(linea);
		}
		Archivador.guardarArchivo(contenidoArchivoAdmin, RUTA_ADMINISTRADORES);
	}
	
	
	/**
	 * Metodo que agrega las preguntas que se guardaron en un archivo a un tema
	 * @param miTema tema a ser completado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void agregarPreguntasTema(Tema miTema) throws FileNotFoundException, IOException
	{
		String ruta = "src/resources/ArchivoTema"+miTema.getNombre()+".txt";
		File archivo = new File(ruta);
		if(archivo.exists())
		{
			ArrayList<String> contenidoArchivo = Archivador.leerArchivo(ruta);
			ArrayList<Tema> misSubtemas = new ArrayList<>();//se setean al tema
			ArrayList<Pregunta> misPreguntas = new ArrayList<>();//se setean al tema
			ArrayList<String> respuestas = new ArrayList<>();//Se setean a cada pregunta
			ArrayList<String> opciones = new ArrayList<>();//se setean a cada pregunta
			String[] informacionArchivo = null;
			for (int i = 0; i < contenidoArchivo.size(); i++) 
			{
				informacionArchivo = Archivador.particionarString(contenidoArchivo.get(i));
				Tema miSubtema = new Tema(informacionArchivo[0]);
				Pregunta miPregunta = new Pregunta(informacionArchivo[1], Archivador.obtenerTipoPregunta(informacionArchivo[2]));
				String opcionA = informacionArchivo[3];
				String opcionB = informacionArchivo[4];
				String opcionC = informacionArchivo[5];
				String opcionD = informacionArchivo[6];
				String respuesta = informacionArchivo[7];
				opciones.add(opcionA);
				opciones.add(opcionB);
				opciones.add(opcionC);
				opciones.add(opcionD);
				respuestas.add(respuesta);
				miPregunta.setMiTemaAsociado(miTema);
				miPregunta.setOpciones(opciones);
				miPregunta.setRespuestas(respuestas);
				misPreguntas.add(miPregunta);
				misSubtemas.add(miSubtema);
			}
			miTema.setMisSubTemas(misSubtemas);
			miTema.setMisPreguntas(misPreguntas);
		}
		else
		{
			throw new FileNotFoundException();
		}
	}

}