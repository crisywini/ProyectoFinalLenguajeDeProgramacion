package co.uniquindio.lenguaje.address.model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class ComunidadAcademica implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String codigo;
	private String usuario;
	private String contrasenia;
	private String telefono;
	private Universidad miUniversidad;
	
	/**
	 * Metodo constructor vacio de la clase Comunidad academica
	 */
	public ComunidadAcademica() 
	{
		this("", "", "", "", "", "", null);
	}
	
	/**
	 * Metodo constructor de la clase Comunidad Academica
	 * @param nombre de una persona de la comunidad academica
	 * @param apellido de una persona de la comunidad academica
	 * @param codigo de una persona de la comunidad academica
	 * @param usuario de una persona de la comunidad academica
	 * @param contrasenia de una persona de la comunidad academica
	 * @param telefono de una persona de la comunidad academica
	 * @param miUniversidad asociada a una persona de la comunidad academica
	 */
	public ComunidadAcademica(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, Universidad miUniversidad)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.miUniversidad = miUniversidad;
	}

	/**
	 * Metodo accesor del nombre para poder mostrarlo en la interfaz
	 * @return
	 */
	public StringProperty nombreProperty() 
	{
		StringProperty nombreProperty = new SimpleStringProperty(this.nombre);
		return nombreProperty;
	}
	/**
	 * Metodo accesor del nombre de la persona perteneciente a la comunidad academica
	 * @return el nombre de la persona que pertenece a la comunidad academica
	 */
	public  String getNombre() 
	{
		return this.nombre;
	}
	/**
	 * Metodo modificador del nombre de la persona que pertenece a la comunidad academica
	 * @param nombre de la persona que pertenece a la comunidad academica
	 */
	public  void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	/**
	 * Metodo accesor del apellido de la persona que pertenece a la comunidad academica para poder mostrarlo en la interfaz
	 * @return 
	 */
	public StringProperty apellidoProperty() 
	{
		StringProperty apellidoProperty = new SimpleStringProperty(this.apellido);
		return apellidoProperty;
	}
	/**
	 * Metodo accesor del apellido de la persona que pertenece a la comunidad academica
	 * @return el apellido de la persona que pertenece a la comunidad academica
	 */
	public  String getApellido() 
	{
		return this.apellido;
	}
	/**
	 * Metodo modificador del apellido de la persona que pertenece a la comunidad academica
	 * @param apellido
	 */
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	/**
	 * Metodo accesor del codigo de la persona que pertenece a la comunidad academica para poder mostrarlo en la interfaz
	 * @return 
	 */
	public StringProperty codigoProperty() 
	{
		StringProperty codigoProperty = new SimpleStringProperty(this.codigo);
		return codigoProperty;
	}
	/**
	 * Metodo accesor del codigo de la persona que pertenece a la comunidad academica
	 * @return el codigo de la persona que pertenece a la comunidad academica
	 */
	public String getCodigo() 
	{
		return this.codigo;
	}
	/**
	 * Metodo modificador del codigo  de la persona que pertenece a la comunidad academica
	 * @param codigo 
	 */
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	/**
	 * Metodo accesor del usuario de la persona que pertenece a la comunidad academica para poder mostrarlo en la interfaz
	 * @return 
	 */
	public StringProperty usuarioProperty() 
	{
		StringProperty usuarioProperty = new SimpleStringProperty(this.usuario);
		return usuarioProperty;
	}
	/**
	 * Metodo accesor del usuario de la persona que pertenece a la comunidad academica
	 * @return el usuario de la persona que pertenece a la comunidad academica
	 */
	public String getUsuario() 
	{
		return this.usuario;
	}
	/**
	 * Metodo modificador del usuario de la persona que pertenece a la comunidad academica
	 * @param usuario
	 */
	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}
	/**
	 * Metodo accesor de la contrasenia de la persona que pertenece a la comunidad academica para poder mostrarla en la interfaz
	 * @return
	 */
	public StringProperty contraseniaProperty() 
	{
		StringProperty contraseniaProperty = new SimpleStringProperty(this.contrasenia);
		return contraseniaProperty;
	}
	/**
	 * Metodo accesor de la contrasenia de la persona que pertenece a la comunidad academica
	 * @return la contrasenia de la persona que pertenece a la comunidad academica
	 */
	public String getContrasenia() 
	{
		return this.contrasenia;
	}
	/**
	 * Metodo modificador de la contrasenia de la persona que pertenece a la comunidad academica
	 * @param contrasenia
	 */
	public void setContrasenia(String contrasenia) 
	{
		this.contrasenia = contrasenia;
	}
	/**
	 * Metodo accesor al telefono de la persona que pertenece a la comunidad academica para poder mostrarlo en la interfaz
	 * @return 
	 */
	public StringProperty telefonoProperty() 
	{
		StringProperty telefonoProperty = new SimpleStringProperty(this.telefono);
		return telefonoProperty;
	}
	/**
	 * Metodo accesor del telefono de la persona que pertenece a la comunidad academica
	 * @return el telefono de la persona que pertenece a la comunidad academica
	 */
	public String getTelefono() 
	{
		return this.telefono;
	}
	/**
	 * Metodo modificador del telefono de la persona que pertenece a la comunidad academica
	 * @param telefono
	 */
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	/**
	 * Metodo equals de la persona que pertenece a la comunidad academica
	 */
	@Override
	public boolean equals(Object obj) 
	{
		boolean centinela = false;
		ComunidadAcademica auxiliar = null;
		if(obj instanceof ComunidadAcademica)
		{
			auxiliar = (ComunidadAcademica) obj;
			if(auxiliar.getCodigo().equals(this.codigo)||auxiliar.getUsuario().equals(this.usuario))
			{
				centinela = true;
			}
		}
		else
		{
			centinela = false;
		}
		return centinela;
	}
	/**
	 * Metodo toString de la persona que pertenece a la comunidad academica
	 */
	@Override
	public String toString() 
	{
		String informacion = getCodigo()+","+getNombre()+","+getApellido()+","+getUsuario()+","+getTelefono()+","+getContrasenia();
		return informacion;
	}


	/**
	 * Metodo accesor a la Universidad de la persona que pertenece a la comunidad academica
	 * @return la Universidad de la persona que pertenece a la comunidad academica
	 */
	public Universidad getMiUniversidad() {
		return miUniversidad;
	}


	/**
	 * Metodo modificador de la Universidad de la persona que pertenece a la comunidad academica
	 * @param miUniversidad
	 */
	public void setMiUniversidad(Universidad miUniversidad) {
		this.miUniversidad = miUniversidad;
	}
}