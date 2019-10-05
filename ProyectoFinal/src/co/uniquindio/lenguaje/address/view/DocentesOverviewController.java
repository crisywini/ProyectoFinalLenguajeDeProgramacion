package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.model.Docente;
import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Tema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DocentesOverviewController 
{
	@FXML Label nombreDocente; 
	@FXML Label codgioDocente;
	@FXML Label profesionDocente;
	@FXML TableView<Tema> misTemasTable;
	@FXML TableColumn<Tema, String> nombreTema;
	@FXML TableView<Examen> misExamenesTableView;
	@FXML TableColumn<Examen, String> descripcionColumn;
	@FXML TableColumn<Examen, String> tituloColumn;
	@FXML TableColumn<Examen, String> porcentajeExitoColumn;
	@FXML TableColumn<Examen, String> tipoExamen;
	@FXML TableColumn<Examen, String> tiempoLimite;
	private Principal miPrincipal;
	private Stage miStage;
	private Docente miDocente;
	
	public Principal getMiPrincipal() {
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
	public Docente getMiDocente() {
		return miDocente;
	}
	public void setMiDocente(Docente miDocente) 
	{
		this.miDocente = miDocente;
		this.codgioDocente.setText(miDocente.getCodigo());
		this.nombreDocente.setText(this.miDocente.getNombre());
		this.profesionDocente.setText(miDocente.getProfesion());
		initTableTemas();
		initTableExamenes();
	}
	
	@FXML
	private void handleSalir()
	{
		this.miStage.hide();
	}
	@FXML
	private void handleCrearNuevoExamen()
	{
		this.miPrincipal.showCreateExamenOverview(miDocente);
	}

	@FXML
	private void handleBorrarExamen()
	{
		if(isSelectedItem())
		{
			int pos = misExamenesTableView.getSelectionModel().getSelectedIndex();
			misExamenesTableView.getItems().remove(pos);
			miDocente.getMisExamenes().remove(pos);
			this.miPrincipal.mostrarAlerta("El examen numero: "+pos+" Ha sido eliminado", "", "Informacion", miStage, AlertType.INFORMATION);
		}
	}
	@FXML
	private void handleMostrarEstadisticosExamen()
	{
		if(isSelectedItem())
		{
			Examen miExamen = this.misExamenesTableView.getSelectionModel().getSelectedItem();
			this.miPrincipal.cargarVentanaPrincipalEstadisticos(miExamen);
		}
		
	}
	public boolean isSelectedItem()
	{
		boolean salida = false;
		String mensajeDeError = "";
		if(misExamenesTableView.getSelectionModel().getSelectedIndex()!=-1)
		{
			salida = true;
		}
		else
		{
			mensajeDeError += "Debe seleccionar un examen para modificarlo\n";
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Advertencia", miStage, AlertType.WARNING);
		}
		return salida;
	}
	public void initTableTemas()
	{
		nombreTema.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
		ObservableList<Tema> misTemas = FXCollections.observableArrayList(miDocente.getMisTemas());
		misTemasTable.setItems(misTemas);
	}
	public void initTableExamenes()
	{
		tituloColumn.setCellValueFactory(cellData->cellData.getValue().tituloProperty());
		descripcionColumn.setCellValueFactory(cellData->cellData.getValue().descripcionProperty());
		porcentajeExitoColumn.setCellValueFactory(cellData->cellData.getValue().porcentajeExitoProperty());
		tipoExamen.setCellValueFactory(cellData->cellData.getValue().miTipoExamenProperty());
		tiempoLimite.setCellValueFactory(cellData->cellData.getValue().tiempoLimiteProperty());
		
		ObservableList<Examen> misExamenes = FXCollections.observableArrayList(miDocente.getMisExamenes());
		misExamenesTableView.setItems(misExamenes);
	}
}
