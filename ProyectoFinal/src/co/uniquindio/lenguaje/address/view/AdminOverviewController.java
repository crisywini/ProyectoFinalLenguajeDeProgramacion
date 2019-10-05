package co.uniquindio.lenguaje.address.view;


import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Administrador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminOverviewController 
{
	@FXML TextField userField;
	@FXML PasswordField passwordField;
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
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(userField.getText()==null||userField.getText().length()==0)
		{
			mensajeDeError += "El usuario no está permitido\n";
		}
		if(passwordField.getText()==null||passwordField.getText().length()==0)
		{
			mensajeDeError += "La contraseña no está permitida\n";
		}
		if(getMiPrincipal().obtenerPosAdministradorSegunUsuario(userField.getText())==-1)
		{
			mensajeDeError+="El administrador no se encuentra en la Universidad\n";
		}
		else
		{
			if(!verificarContrasenia())
			{
				mensajeDeError += "La contrasenia no coincide\n";
			}
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			getMiPrincipal().mostrarAlerta(mensajeDeError, "Error", "Error", this.thisStage, AlertType.WARNING);
		}
		return centinela;
	}
	
	public boolean verificarContrasenia()
	{
		boolean centinela = true;
			Administrador miAdministrador = getMiPrincipal().obtenerAdministradorSegunUsuario(userField.getText());
			char[] contraseniaChar = miAdministrador.getContrasenia().toCharArray();
			char[] contraseniaIngresadaChar = passwordField.getText().toCharArray();
			for (int i = 0; i < contraseniaChar.length&&centinela; i++) 
			{
				if(contraseniaChar[i]!=contraseniaIngresadaChar[i])
				{
					centinela = false;
				}
			}
		return centinela;
	}
	@FXML
	private void handleIngresarButton()
	{
		if(isInputValid())
		{
			userField.setText("");
			passwordField.setText("");
			getMiPrincipal().showPrincipalStageAdminOverview();
		}
	}
	@FXML
	private void handleSalirButton()
	{
		this.thisStage.hide();
	}
	@FXML
	private void handleCreateAdmin()
	{
		getMiPrincipal().showCreateAdminOverview();
	}
	public void showAdminOverview(Principal miPrincipal) {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/AdminOverview.fxml"));
			VBox layout = (VBox) cargador.load();

			Stage escenario = new Stage();
			escenario.setTitle("Admin");
			escenario.initModality(Modality.WINDOW_MODAL);
			escenario.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_character_avatar_ice_dragon_4527369.png"));
			Scene scene = new Scene(layout);
			escenario.setScene(scene);
			AdminOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(miPrincipal);
			controlador.setThisStage(escenario);
			escenario.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
