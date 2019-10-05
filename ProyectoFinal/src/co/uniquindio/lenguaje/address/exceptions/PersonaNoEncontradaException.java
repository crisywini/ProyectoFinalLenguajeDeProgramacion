package co.uniquindio.lenguaje.address.exceptions;

public class PersonaNoEncontradaException extends NullPointerException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PersonaNoEncontradaException(String mensajeError) 
	{
		super(mensajeError);
	}

}