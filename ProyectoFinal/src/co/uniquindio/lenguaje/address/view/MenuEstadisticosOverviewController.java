package co.uniquindio.lenguaje.address.view;



import javafx.fxml.FXML;

import javafx.stage.Stage;

public class MenuEstadisticosOverviewController {
	private VentanaPrincipalController miPrincipal;
	private Stage miStage;



	public VentanaPrincipalController getMiPrincipal() {
		return miPrincipal;
	}

	public void setMiPrincipal(VentanaPrincipalController miPrincipal) {
		this.miPrincipal = miPrincipal;

	}



	public Stage getMiStage() {
		return miStage;
	}

	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}

	@FXML
	private void handleStudentsInExamenButton() {
		this.miPrincipal.cargarStatEstudiantesOverview();
	}

	@FXML
	private void handlePorcentajeGanadoresButton() 
	{
		this.miPrincipal.cargarStatGanadoresOverview();
	}

	@FXML
	private void handlePorcentajeAciertoButton() 
	{
		this.miPrincipal.cargarStatAciertoPreguntaOverview();
	}

	@FXML
	private void handleExit() 
	{
		this.miPrincipal.salirDeLaVentana();
	}

	@FXML
	private void initialize() 
	{
		
	}
}
