package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Docente;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginDocentesOverviewController 
{
	@FXML TextField usuarioField;
	@FXML PasswordField contraseniaField;
	private Principal miPrincipal;
	private Stage miStage;
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) {
		this.miPrincipal = miPrincipal;
	}
	public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}


	@FXML
	private void handleIngresarButton()
	{
		if(isInputValid())
		{
			Docente miDocente = this.miPrincipal.obtenerDocente(usuarioField.getText());
			usuarioField.setText("");
			contraseniaField.setText("");
			this.miPrincipal.showDocentesOverview(miDocente);
		}
	}
	@FXML
	private void handleSalirButton()
	{
		this.miStage.hide();
	}
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(usuarioField.getText()==null||usuarioField.getText().length()==0)
		{
			mensajeDeError += "Ususario no permitido\n";
		}
		if(contraseniaField.getText()==null||contraseniaField.getText().length()==0)
		{
			mensajeDeError += "Contraseña no permitida\n";
		}
		int pos = this.miPrincipal.obtenerPosDocente(usuarioField.getText());
		if(pos!=-1)
		{
			if(!verificarContrasenia())
			{
				mensajeDeError += "Las contraseñas no coinciden\n";
			}
		}
		else
		{
			mensajeDeError += "El Docente ingresado no existe en la Universidad\n";
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Advertencia", miStage, AlertType.WARNING);
		}
		return centinela;
	}
	public boolean verificarContrasenia()
	{
		boolean centinela = true;
		Docente miDocente = this.miPrincipal.obtenerDocente(usuarioField.getText());
			char[] contraseniaChar = miDocente.getContrasenia().toCharArray();
			char[] contraseniaIngresadaChar = contraseniaField.getText().toCharArray();
			if(contraseniaChar.length!=contraseniaIngresadaChar.length)
			{
				centinela = false;
			}
			for (int i = 0; i < contraseniaChar.length&&centinela; i++) 
			{
				if(contraseniaChar[i]!=contraseniaIngresadaChar[i])
				{
					centinela = false;
				}
			}
		return centinela;
	}
}
