package co.uniquindio.lenguaje.address.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.persistencia.Archivador;
import co.uniquindio.lenguaje.address.persistencia.Persistencia;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PreguntasOverviewController {
	@FXML Label nombreTemaLabel;
	@FXML TextArea areaDePreguntas;
	private Tema miTema;
	private Principal miPrincipal;
	private Stage miStage;
	
	public Tema getMiTema() {
		return miTema;
	}
	public void setMiTema(Tema miTema) {
		this.miTema = miTema;
		nombreTemaLabel.setText(miTema.getNombre());
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
	@FXML
	private void handleAgregarPreguntasButton()
	{
		if(isInputValid())
		{
			try
			{
				ArrayList<String> contenidoArchivo = Archivador.convertirStringEnArrayList(areaDePreguntas.getText());
				String ruta = "src/resources/ArchivoTema"+getMiTema().getNombre()+".txt";
				Archivador.guardarArchivo(contenidoArchivo, ruta);
				Persistencia.agregarPreguntasTema(miTema);
				this.miPrincipal.mostrarAlerta("Las preguntas han sido agregadas al tema: "+miTema.getNombre(), "", "Informacion", miStage, AlertType.INFORMATION);
				this.areaDePreguntas.setText("");
				this.miStage.hide();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				this.miPrincipal.mostrarAlerta(e.getMessage(), "", "ErRor", miStage, AlertType.ERROR);
			}
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
		if(areaDePreguntas.getText()==null||areaDePreguntas.getText().length()==0)
		{
			mensajeDeError+="Debe escribir preguntas con el formato: \n"+"<subtema>@<pregunta>@<tipoPregunta>@<opcionA>@<opcionB>@<opcionC>@<opcionD>@<respuesta>";
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Advertencia", miStage, AlertType.ERROR);
		}
		return centinela;
	}

}
