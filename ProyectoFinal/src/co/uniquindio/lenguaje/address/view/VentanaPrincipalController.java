package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Examen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaPrincipalController 
{
	@FXML BorderPane panelPrincipal;
	MenuEstadisticosOverviewController controladorMenu;
	StatEstudiantesOverviewController controladorStatEstudiantes;
	StatGanadoresOverviewController controladorStatGanadores;
	StatAciertoPreguntasOverviewController controladorStatAciertoPreguntas;
	AnchorPane panelControlMenu;
	AnchorPane panelStatEstudiantes1;
	AnchorPane panelStatGanadores;
	AnchorPane panelStatAciertos;
	private Principal miPrincipal;
	private Stage miStage;
	private Examen miExamen;

	public Examen getMiExamen() {
		return miExamen;
	}

	public void setMiExamen(Examen miExamen) {
		this.miExamen = miExamen;
	}
    public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}
	@FXML
    void initialize() 
    {
    	cargarVentanaMenu();
    }
    public void cargarVentanaMenu()
    {
    	if(panelControlMenu==null)
    	{
    		try 
    		{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/MenuEstadisticosOverview.fxml"));
				panelControlMenu = (AnchorPane)cargador.load();
				controladorMenu = cargador.getController();
				controladorMenu.setMiPrincipal(this);
			} 
    		catch (Exception e) 
    		{
				e.printStackTrace();
			}
    	}
    	panelPrincipal.setCenter(panelControlMenu);

    }
    public void cargarStatEstudiantesOverview()
    {
       	if(panelStatEstudiantes1 == null)
    	{
    		try 
    		{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/StatEstudiantesOverview.fxml"));
				panelStatEstudiantes1 = (AnchorPane)cargador.load();
				controladorStatEstudiantes = cargador.getController();
				controladorStatEstudiantes.setVentanaPrincipal(this);
				controladorStatEstudiantes.setMiExamen(miExamen);
			} 
    		catch (Exception e)
    		{
				e.printStackTrace();
			}
    	}
		panelPrincipal.setCenter(panelStatEstudiantes1);
    }
    public void cargarStatGanadoresOverview()
    {
    	if(panelStatGanadores==null)
    	{
    		try 
    		{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/StatsGanadoresOverview.fxml"));
				panelStatGanadores = (AnchorPane)cargador.load();
				controladorStatGanadores = cargador.getController();
				controladorStatGanadores.setVentanaPrincipal(this);
				controladorStatGanadores.setMiExamen(miExamen);
			} 
    		catch (Exception e) 
    		{
				e.printStackTrace();
			}
    	}
    	panelPrincipal.setCenter(panelStatGanadores);
    }
    public void cargarStatAciertoPreguntaOverview()
    {
    	if(panelStatAciertos==null)
    	{
    		try 
    		{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/StatAciertoPreguntasOverview.fxml"));
				panelStatAciertos = (AnchorPane) cargador.load();
				controladorStatAciertoPreguntas = cargador.getController();
				controladorStatAciertoPreguntas.setVentanaPrincipal(this);
				controladorStatAciertoPreguntas.setMiExamen(miExamen);
			} 
    		catch (Exception e) 
    		{
    			e.printStackTrace();
			}
    	}
    	panelPrincipal.setCenter(panelStatAciertos);
    }
    public void salirDeLaVentana()
    {
    	this.miStage.hide();
    }
    public void cerrarVentana()
    {
    	panelPrincipal.setCenter(panelControlMenu);
    }
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) {
		this.miPrincipal = miPrincipal;
	}

}
