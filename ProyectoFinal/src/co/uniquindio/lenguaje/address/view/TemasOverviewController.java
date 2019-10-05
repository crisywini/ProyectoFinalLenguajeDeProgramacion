package co.uniquindio.lenguaje.address.view;

import java.io.IOException;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.TemaRepeatException;
import co.uniquindio.lenguaje.address.model.Docente;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.persistencia.Archivador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TemasOverviewController {

	@FXML
	private TableColumn<Tema, String> nombreTemasColumn;

	@FXML
	private TableView<Tema> temasTableView;

	@FXML
	private TextField nombreTemaField;
	private Principal miPrincipal;
	private Docente miDocente;
	private Stage miStage;
	private ObservableList<Tema> misTemasTableData = FXCollections.observableArrayList();
	
	public Principal getMiPrincipal() {
		return miPrincipal;
	}

	public void setMiPrincipal(Principal miPrincipal) {
		this.miPrincipal = miPrincipal;
	}

	public Docente getMiDocente() {
		return miDocente;
	}

	public void setMiDocente(Docente miDocente) {
		this.miDocente = miDocente;
		misTemasTableData.setAll(miDocente.getMisTemas());
		temasTableView.setItems(misTemasTableData);
	
	}

	public Stage getMiStage() {
		return miStage;
	}

	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}

	@FXML
	private void handleAgregarButton() {
		if(isInputValid())
		{
			
			try {
				String ruta = "src/resources/ArchivoTema"+nombreTemaField.getText()+".txt";
				Archivador.crearArchivo(ruta);
				this.miDocente.agregarTema(nombreTemaField.getText());
				this.miPrincipal.mostrarAlerta("El tema: "+nombreTemaField.getText()+" ha sido agregado", "", "Informacion", miStage, AlertType.INFORMATION);
				this.misTemasTableData.add(new Tema(nombreTemaField.getText()));
				nombreTemaField.setText("");
			} catch (TemaRepeatException e) {
				this.miPrincipal.mostrarAlerta(e.getMessage(), "", "Error", miStage, AlertType.ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	private void handleAgregarPreguntas() 
	{
		if(isSelectedItem())
		{
			Tema miTema = temasTableView.getSelectionModel().getSelectedItem();
			this.miPrincipal.showPreguntasOverview(miTema);
		}
	}

	@FXML
	private void handleSalir() {
		this.miStage.hide();

	}

	@FXML
	void initialize() 
	{
		nombreTemasColumn.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
	}
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(nombreTemaField.getText()==null||nombreTemaField.getText().length()==0)
		{
			mensajeDeError += "El nombre del tema no es valido\n";
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Cuidado!", miStage, AlertType.WARNING);
		}
		return centinela;
	}
	public boolean isSelectedItem()
	{
		int pos = temasTableView.getSelectionModel().getSelectedIndex();
		boolean centinela = false;
		if(pos != -1)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta("No ha seleccionado tema", "", "Advertencia", miStage, AlertType.WARNING);
		}
		return centinela;
	}

}
