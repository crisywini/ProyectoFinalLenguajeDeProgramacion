package co.uniquindio.lenguaje.address.view;



import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.Examen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalEstudiantesOverviewController 
{
	@FXML
	BorderPane panelPrincipal;
	VentanaLoginEstudiantesController controladorLogin;
	VentanaEstudiantesController controladorEstudiantes;
	VentanaExamenController controladorExamenInicio;
	VentanaPreguntaNormalController controladorPreguntaNormal;
	VentanaPreguntaMultipleController controladorPreguntaMultiple;
	HBox panelEstudiantes;
	AnchorPane panelLogin;
	VBox panelInicioExamen;
	VBox panelPreguntaNormal;
	AnchorPane panelPreguntaMultiple;
	private Principal miPrincipal;
	private Stage miStage;
	@FXML
    void initialize()
    {
		cargarLogin();
    }
	
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
	public void salir()
	{
		this.miStage.hide();
	}
	public void devolver()
	{
		panelPrincipal.setCenter(panelLogin);
	}
	public void devolverAPrincipal()
	{
		panelPrincipal.setCenter(panelEstudiantes);
	}
	public void mostrarMensaje(String mensaje, String cabecera, String titulo, AlertType tipo)
	{
		this.miPrincipal.mostrarAlerta(mensaje, cabecera, titulo, miStage, tipo);
	}
	public void cargarLogin()
	{
		if(panelLogin == null)
		{
			try 
			{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/VentanaLoginEstudiantes.fxml"));
				panelLogin = (AnchorPane)cargador.load();
				controladorLogin = cargador.getController();
				controladorLogin.setVentanaPrincipal(this);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		panelPrincipal.setCenter(panelLogin);
	}
	public void cargarVentanaEstudiantes(Estudiante miEstudiante)
	{
		if(panelEstudiantes == null)
		{
			try 
			{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/VentanaEstudiantes.fxml"));
				panelEstudiantes = (HBox)cargador.load();
				controladorEstudiantes = cargador.getController();
				controladorEstudiantes.setVentanaPrincipal(this);
				controladorEstudiantes.setMiEstudiante(miEstudiante);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		panelPrincipal.setCenter(panelEstudiantes);
	}
	public void cargarVentanaExamen(Examen miExamen)
	{
		if(panelInicioExamen == null)
		{
			try 
			{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/VentanaExamen.fxml"));
				panelInicioExamen = (VBox)cargador.load();
				controladorExamenInicio = cargador.getController();
				controladorExamenInicio.setMiExamen(miExamen);
				controladorExamenInicio.setVentanaPrincipal(this);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		panelPrincipal.setCenter(panelInicioExamen);
	}
	public void cargarVentanaPreguntaNormal(Examen miExamen, int indiceTema, int indicePregunta)//Falta setear el examen
	{
		if(panelPreguntaNormal==null)
		{
			try 
			{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/VentanaPreguntaNormal.fxml"));
				panelPreguntaNormal = (VBox)cargador.load();
				controladorPreguntaNormal = cargador.getController();
				controladorPreguntaNormal.setVentanaPrincipal(this);
				controladorPreguntaNormal.setMiExamen(miExamen);
				controladorPreguntaNormal.setMisTemas(miExamen.getMisTemas());
				controladorPreguntaNormal.setIndiceTema(indiceTema);
				controladorPreguntaNormal.setIndicePregunta(indicePregunta);

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		panelPrincipal.setCenter(panelPreguntaNormal);
	}
	public void cargarVentanaPreguntaMultiple(Examen miExamen, int indiceTema, int indicePregunta)//Falta setear el examen
	{
		if(panelPreguntaMultiple == null)
		{
			try 
			{
				FXMLLoader cargador = new FXMLLoader();
				cargador.setLocation(Principal.class.getResource("view/VentanaPreguntaMultiple.fxml"));
				panelPreguntaMultiple = (AnchorPane)cargador.load();
				controladorPreguntaMultiple = cargador.getController();
				controladorPreguntaMultiple.setVentanaPrincipal(this);
				controladorPreguntaMultiple.setMiExamen(miExamen);
				controladorPreguntaMultiple.setMisTemas(miExamen.getMisTemas());
				controladorPreguntaMultiple.setIndiceTema(indiceTema);
				controladorPreguntaMultiple.setIndicePregunta(indicePregunta);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		panelPrincipal.setCenter(panelPreguntaMultiple);
	}
}