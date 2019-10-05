package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.model.Examen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

public class StatGanadoresOverviewController 
{
    @FXML
    private AnchorPane panelDiagramaCircular;

    @FXML
    private PieChart diagramaCircular;
    private VentanaPrincipalController ventanaPrincipal;
    private Examen miExamen;

    @FXML
    private void initialize() 
    {
//    	ObservableList<PieChart.Data> informacionDiagramaCircular = FXCollections.observableArrayList(new PieChart.Data("Ganadores",50), new PieChart.Data("No ganadores", 40));
//    	diagramaCircular.setData(informacionDiagramaCircular);
//    	diagramaCircular.setTitle("Informacion");
    }
    public void cargarDatosDiagramaCircular()
    {
    	ArrayList<PieChart.Data> informacionDiagrama = new ArrayList<>();
    	informacionDiagrama.add(new PieChart.Data("Ganadores", getMiExamen().obtenerEstudiantesGanadores().size()));
    	informacionDiagrama.add(new PieChart.Data("No ganadores", getMiExamen().obtenerEstudiantesNoGanadores().size()));
    	ObservableList<PieChart.Data> informacionDiagramaCircular = FXCollections.observableArrayList(informacionDiagrama);
    	diagramaCircular.setData(informacionDiagramaCircular);
    	diagramaCircular.setTitle("informacion");
    }

    @FXML
    private void handleSalirButton()
    {
    	this.ventanaPrincipal.cerrarVentana();
    }
	public VentanaPrincipalController getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipalController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public Examen getMiExamen() {
		return miExamen;
	}

	public void setMiExamen(Examen miExamen) {
		this.miExamen = miExamen;
		cargarDatosDiagramaCircular();
	}
}