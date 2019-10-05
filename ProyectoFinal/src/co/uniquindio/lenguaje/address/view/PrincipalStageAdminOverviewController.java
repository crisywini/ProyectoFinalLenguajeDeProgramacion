package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PrincipalStageAdminOverviewController 
{
	private Principal miPrincipal;
	private Stage miStage;
	private boolean isExitCliked = false;
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
	private void handleProgramasButton()
	{
		getMiPrincipal().showProgramaAcademicoOverview();
	}
	
	@FXML
	private void handleEstudiantesButton()
	{
		getMiPrincipal().showCRUDEstudiantesOverview();
	}
	@FXML
	private void handleProfesoresButton()
	{
//		CRUDDocentesOverviewController controlador = new CRUDDocentesOverviewController();
//		controlador.showThisOverview();
		getMiPrincipal().showCRUDDocentesOverview();
	}
	@FXML
	private void handleExitButton()
	{
		AdminOverviewController controlador = new AdminOverviewController();
		this.miStage.close();	
		controlador.showAdminOverview(getMiPrincipal());
	}
	public boolean isExitCliked() {
		return isExitCliked;
	}
	public void setExitCliked(boolean isExitCliked) {
		this.isExitCliked = isExitCliked;
	}


}
