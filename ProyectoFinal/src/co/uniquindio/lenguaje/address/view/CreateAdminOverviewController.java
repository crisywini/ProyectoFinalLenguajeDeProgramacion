package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.PersonaRepetidaException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class CreateAdminOverviewController 
{
	@FXML TextField nombreField;
	@FXML TextField apellidoField;
	@FXML TextField codigoField;
	@FXML TextField usuarioField;
	@FXML PasswordField contraseniaField;
	@FXML PasswordField contraseniaRepeatField;
	@FXML TextField telefonoField;
	private Principal miPrincipal;
	private Stage thisStage;
	
	public Stage getThisStage() {
		return thisStage;
	}
	public void setThisStage(Stage thisStage) {
		this.thisStage = thisStage;
	}
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) {
		this.miPrincipal = miPrincipal;
	}
	@FXML
	private void handleAgregarButton()
	{
		if(isInputRight())
		{
			try 
			{
				getMiPrincipal().agregarAdministrador(nombreField.getText(), apellidoField.getText(), codigoField.getText(), usuarioField.getText(), contraseniaField.getText(), telefonoField.getText());
				getMiPrincipal().mostrarAlerta("El administrador: " + codigoField.getText() +" ha sido agregado a la Universidad", "Información", "Agregado con exito", thisStage, AlertType.INFORMATION);
				codigoField.setText("");
				nombreField.setText("");
				apellidoField.setText("");
				usuarioField.setText("");
				contraseniaField.setText("");
				contraseniaRepeatField.setText("");
				telefonoField.setText("");
			}
			catch (PersonaRepetidaException e) 
			{
				getMiPrincipal().mostrarAlerta(e.getMessage(), "Error", "Error", this.thisStage, AlertType.ERROR);
			}
		}
	}
	
	@FXML
	private void handleCancelarButton()
	{
		this.thisStage.close();
	}
	public boolean isInputRight()
	{
		String mensajeDeError = "";
		boolean salida = false;
		if(nombreField.getText() == null||nombreField.getText().length()==0)
		{
			mensajeDeError += "Nombre no permitido\n";
		}
		if(apellidoField.getText() == null|| apellidoField.getText().length()==0)
		{
			mensajeDeError += "Apellido no permitido\n";
		}
		if(codigoField.getText() == null|| codigoField.getText().length()==0)
		{
			mensajeDeError += "Codigo no permitido\n";
		}
		try 
		{
			Integer.parseInt(codigoField.getText());
		} 
		catch (Exception e) 
		{
			mensajeDeError += "Codigo no permitido, debe ser un numero\n";
		}
		if(contraseniaField.getText() == null|| contraseniaField.getText().length()==0)
		{
			mensajeDeError += "Contraseña no permitida\n";
		}
		if(contraseniaRepeatField.getText()==null|| contraseniaRepeatField.getText().length()==0)
		{
			mensajeDeError += "Campo de contraseña repetida no permitido\n";
		}
		if(!isContraseniaRight())
		{
			mensajeDeError += "Las contraseñas deben ser iguales";
		}
		if(telefonoField.getText() == null|| telefonoField.getText().length()==0)
		{
			mensajeDeError += "Telefono no permitido\n";
		}
		try 
		{
			Integer.parseInt(telefonoField.getText());
		} 
		catch (Exception e) 
		{
			mensajeDeError += "El telefono debe ser un número";
		}
		if(mensajeDeError.length()==0)
		{
			salida = true;
		}
		else
		{
			getMiPrincipal().mostrarAlerta(mensajeDeError, "Cuidado", "Error", this.thisStage, AlertType.WARNING);
		}
		return salida;
	}
	public boolean isContraseniaRight()
	{
		char[] contrasenia = contraseniaField.getText().toCharArray();
		char[] contraseniaRepeat = contraseniaRepeatField.getText().toCharArray();
		boolean centinela = true;
		for (int i = 0; i < contraseniaRepeat.length&&centinela; i++) 
		{
			if(contrasenia[i]!=contraseniaRepeat[i])
			{
				centinela = false;
			}
		}
		return centinela;
	}
}