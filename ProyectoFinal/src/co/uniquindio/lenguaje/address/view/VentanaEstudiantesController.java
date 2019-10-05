package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.Examen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class VentanaEstudiantesController 
{

    @FXML
    private Label usuarioLabel;

    @FXML
    private Label nombreLabel;

    @FXML
    private TableColumn<Examen, String> tiempoLimiteColumn;

    @FXML
    private TableColumn<Examen, String> notaObtenidaColumn;

    @FXML
    private TableView<Examen> examenesTable;

    @FXML
    private TableColumn<Examen, String> nombreExamenColumn;

    @FXML
    private Label programaLabel;
    private PrincipalEstudiantesOverviewController ventanaPrincipal;
    private Estudiante miEstudiante;

    @FXML
    void handleSalirButton() {
    	ventanaPrincipal.devolver();
    }

    @FXML
    void handlePresentarButton() 
    {
    	if(isSelectedItemTable())
    	{
    		Examen miExamen = examenesTable.getSelectionModel().getSelectedItem();
        	ventanaPrincipal.cargarVentanaExamen(miExamen);
    	}
    }

    @FXML
    void initialize() 
    {
        assert usuarioLabel != null : "fx:id=\"usuarioLabel\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert nombreLabel != null : "fx:id=\"nombreLabel\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert tiempoLimiteColumn != null : "fx:id=\"tiempoLimiteColumn\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert notaObtenidaColumn != null : "fx:id=\"notaObtenidaColumn\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert examenesTable != null : "fx:id=\"examenesTable\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert nombreExamenColumn != null : "fx:id=\"nombreExamenColumn\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";
        assert programaLabel != null : "fx:id=\"programaLabel\" was not injected: check your FXML file 'VentanaEstudiantes.fxml'.";

    }

	public PrincipalEstudiantesOverviewController getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(PrincipalEstudiantesOverviewController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public Estudiante getMiEstudiante() {
		return miEstudiante;
	}

	public void setMiEstudiante(Estudiante miEstudiante) {
		this.miEstudiante = miEstudiante;
		initTable();
		nombreLabel.setText(miEstudiante.getNombre()+" "+miEstudiante.getApellido());
		usuarioLabel.setText(miEstudiante.getCodigo());
		programaLabel.setText(miEstudiante.getMiProgramaAcademico().getNombre());
	}
	public boolean isSelectedItemTable()
	{
		int pos = examenesTable.getSelectionModel().getSelectedIndex();
		boolean centinela = pos != -1;
		if(!centinela)
		{
			ventanaPrincipal.mostrarMensaje("Debe seleccionar un examen para presentar", "", "Advertencia", AlertType.WARNING);
		}
		return centinela;
	}
	public void initTable()
	{
		ObservableList<Examen> examenesData = FXCollections.observableArrayList(miEstudiante.getMisExamenesAsociados());
		tiempoLimiteColumn.setCellValueFactory(cellData->cellData.getValue().tiempoLimiteProperty());
		notaObtenidaColumn.setCellValueFactory(cellData->cellData.getValue().notaTotalProperty());
		nombreExamenColumn.setCellValueFactory(cellData->cellData.getValue().tituloProperty());
		examenesTable.setItems(examenesData);
	}

}
