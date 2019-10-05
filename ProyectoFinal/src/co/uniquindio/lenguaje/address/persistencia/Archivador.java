package co.uniquindio.lenguaje.address.persistencia;

import java.util.*;

import co.uniquindio.lenguaje.address.model.TipoPregunta;

import java.io.*;

public class Archivador {
	/**
	 * Metodo estatico que guarda archivos
	 * 
	 * @param contenidoArchivo ArrayList con el contenido del archivo
	 * @param ruta             ruta del archivo
	 * @throws IOException exception
	 */
	public static void guardarArchivo(ArrayList<String> contenidoArchivo, String ruta) throws IOException {
		FileWriter archivoEscritor = new FileWriter(ruta, false);
		BufferedWriter direccionadorArchivo = new BufferedWriter(archivoEscritor);
		for (String string : contenidoArchivo) {
			direccionadorArchivo.write(string);
		}
		direccionadorArchivo.flush();
		direccionadorArchivo.close();
		archivoEscritor.close();
	}

	/**
	 * Metodo estatico que lee archivos
	 * 
	 * @param ruta ruta en donde se encuentra el archivo
	 * @return un ArrayList con la informacion del archivo
	 * @throws FileNotFoundException si no encuentra el archivo
	 * @throws IOException           exception
	 */
	public static ArrayList<String> leerArchivo(String ruta) throws FileNotFoundException, IOException {
		ArrayList<String> contenidoArchivo = new ArrayList<String>();
		FileReader archivoLector = new FileReader(ruta);
		BufferedReader direccionadorArchivo = new BufferedReader(archivoLector);
		String informacion = "";
		while ((informacion = direccionadorArchivo.readLine()) != null) {
			contenidoArchivo.add(informacion + "\n");
		}
		direccionadorArchivo.close();
		archivoLector.close();
		return contenidoArchivo;
	}

	public static String[] particionarString(String linea) {
		StringTokenizer tokens = new StringTokenizer(linea, "<@*>", false);
		String[] salida = new String[tokens.countTokens()];
		int cont = 0;
		while (tokens.hasMoreElements()) {
			salida[cont] = tokens.nextToken();
			cont++;
		}
		return salida;
	}
 
//	public static void main(String[] args) {
//		String prueba="<subtema>@<pregunta>@<tipoPregunta>@<opcionA>@<opcionB>@<opcionC>@<opcionD>@<respuesta>* hola * hola hola* hola hola hola";
//		String[] arreglo = particionarStringExclusive(prueba);
//		String[] arreglo2 = particionarString(prueba);
//		System.out.println(mostrarArreglo(arreglo, 0));
//		System.out.println(mostrarArreglo(arreglo2, 0));
//	}
	/**
	 * Metodo recursivo que muestra un arreglpo
	 * @param arreglo
	 * @param pos
	 * @return
	 */
	public static String mostrarArreglo(String[] arreglo, int pos) {
		if (pos == arreglo.length - 1) {
			return arreglo[pos];
		} else {
			return arreglo[pos] + "," + mostrarArreglo(arreglo, pos + 1);
		}
	}
	/**
	 * Metodo que dado un String retorna un tipo de pregunta
	 * 
	 * @param miTipo String
	 * @return un tipo
	 */
	public static TipoPregunta obtenerTipoPregunta(String miTipo) {
		TipoPregunta miTipoPregunta = null;
		if (miTipo.equalsIgnoreCase(TipoPregunta.MULTIPLE.toString())) {
			miTipoPregunta = TipoPregunta.MULTIPLE;
		} else {
			miTipoPregunta = TipoPregunta.SIMPLE;
		}
		return miTipoPregunta;
	}
	/**
	 * Metodo que verifica si existe un arhivo
	 * @param ruta
	 * @return un boolean con la verificacion del archivo
	 */
	public static boolean existFile(String ruta)
	{
		File archivo = new File(ruta);
		boolean centinela = false;
		
		if(archivo.exists())
		{
			centinela = true;
		}
		return centinela;
	}
	/**
	 * Metodo que crea un archivo segun una ruta
	 * @param ruta
	 * @throws IOException
	 */
	public static void crearArchivo(String ruta) throws IOException
	{
		File archivoNuevo = new File(ruta);
		archivoNuevo.createNewFile();
	}
	/**
	 * Metodo que particiona un String con una diferencia, ya que usa el caracter * para definir una linea 
	 * @param linea
	 * @return
	 */
	public static String[] particionarStringExclusive(String linea)
	{
		StringTokenizer tokens = new StringTokenizer(linea, "*", false);
		String[] salida = new String[tokens.countTokens()];
		int cont = 0;
		while (tokens.hasMoreElements()) {
			salida[cont] = tokens.nextToken();
			cont++;
		}
		return salida;
	}

	/**
	 * Método que convierte un String en un arraylist
	 * @param contenidoDelTexto
	 * @return un ArrayList con la informacion del String
	 */
	public static ArrayList<String> convertirStringEnArrayList(String contenidoDelTexto)
	{
		ArrayList<String> contenidoArchivo = new ArrayList<>();
		String[] informacionArchivo = particionarStringExclusive(contenidoDelTexto);
		for (int i = 0; i < informacionArchivo.length; i++) 
		{
			contenidoArchivo.add(informacionArchivo[i]);
		}
		return contenidoArchivo;
	}
}
