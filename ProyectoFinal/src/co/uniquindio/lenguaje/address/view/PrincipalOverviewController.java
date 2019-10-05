package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class PrincipalOverviewController 
{
	@FXML Button ingresarComoDocenteButton;
	@FXML Button ingresarComoEstudianteButton;
	@FXML Button ingresarComoAdminButton;
	private Principal miPrincipal;
	private Stage miStage;
	public Principal getMiPrincipal() 
	{
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) 
	{
		this.miPrincipal = miPrincipal;
	}
	public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}
	@FXML
	private void handleDocenteButton()
	{
		this.miPrincipal.showLoginDocentesOverview();
	}
	@FXML
	private void handleEstudianteButton()
	{
		this.miPrincipal.cargarPrincipalEstudiantesOverview();
	}
	@FXML
	private void handleAdminButton()
	{
		AdminOverviewController controlador = new AdminOverviewController();
		controlador.showAdminOverview(this.miPrincipal);
	}
	@FXML
	private void handleGurdarInformacion()
	{
		try 
		{
			getMiPrincipal().mostrarAlerta("La informacion de la Universidad ha sido guardada", "Datos guardados con exito","Informacion" , getMiPrincipal().getEscenarioPrincipal(), AlertType.INFORMATION);
			getMiPrincipal().guardarUniversidad();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}

}
