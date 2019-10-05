package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.DocenteRepeatException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CRUDDocentesOverviewController 
{
	@FXML TextField nombreField;
	@FXML TextField apellidoField;
	@FXML TextField codigoField;
	@FXML TextField usuarioField;
	@FXML PasswordField contraseniaField;
	@FXML TextField telefonoField;
	@FXML TextField profesionField;
	private Stage miStage;
	private Principal miPrincipal;
	public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) 
	{
		this.miPrincipal = miPrincipal;
	}
	public void showThisOverview()
	{
		try 
		{
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(this.miPrincipal.getClass().getResource("view/CRUDDocentesOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			
			miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(getMiPrincipal().getEscenarioPrincipal());
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			miStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_ice_cold_winder_4527370.png"));
			cargador.setController(this);
			CRUDDocentesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(getMiPrincipal());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@FXML
	private void handleAgregarButton()
	{
		if(isInputValid())
		{
			try 
			{
				this.miPrincipal.agregarDocente(nombreField.getText(), apellidoField.getText(), codigoField.getText(), usuarioField.getText(), contraseniaField.getText(), telefonoField.getText(), profesionField.getText());
				this.miPrincipal.mostrarAlerta("El docente: "+ codigoField.getText()+" ha sido creado", "Informacion", "Informacion", miStage, AlertType.INFORMATION);
				nombreField.setText("");
				apellidoField.setText("");
				codigoField.setText("");
				usuarioField.setText("");
				contraseniaField.setText("");
				telefonoField.setText("");
				profesionField.setText("");
			} 
			catch (DocenteRepeatException e) 
			{
				this.miPrincipal.mostrarAlerta(e.getMessage(), "ERROR", "ErRor", miStage, AlertType.ERROR);
			}
		}
	}
	@FXML
	private void handleCancelarButton()
	{
		this.miStage.hide();
	}
	
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(nombreField.getText()==null||nombreField.getText().length()==0)
		{
			mensajeDeError += "Nombre no valido\n";
		}
		if(apellidoField.getText()==null||apellidoField.getText().length()==0)
		{
			mensajeDeError += "Apellido no valido\n";
		}
		if(codigoField.getText()==null||codigoField.getText().length()==0)
		{
			mensajeDeError += "Codigo no valido\n";
		}
		if(usuarioField.getText()==null||usuarioField.getText().length()==0)
		{
			mensajeDeError += "Usuario no valido\n";
		}
		if(contraseniaField.getText()==null||contraseniaField.getText().length()==0)
		{
			mensajeDeError += "Contraseña no valida\n";
		}
		if(telefonoField.getText()==null||telefonoField.getText().length()==0)
		{
			mensajeDeError += "Telefono no valido\n";
		}
		if(profesionField.getText()==null||profesionField.getText().length()==0)
		{
			mensajeDeError += "Profesion no valida\n";
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Error", miStage, AlertType.WARNING);
		}
		return centinela;
	}

}
