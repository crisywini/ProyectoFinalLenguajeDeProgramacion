package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Pregunta;
import co.uniquindio.lenguaje.address.model.Tema;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class StatAciertoPreguntasOverviewController 
{

    @FXML
    private BarChart<String, Number> diagramaDeBarras;

    @FXML
    private NumberAxis ejeY;

    @FXML
    private CategoryAxis ejeX;

    @FXML
    private AnchorPane panelAciertos;
    private VentanaPrincipalController ventanaPrincipal;
    private Examen miExamen;
    @FXML
    private void handleExitButton() {
    	ventanaPrincipal.cerrarVentana();
    }

    @FXML
    private void initialize() 
    {
    	
    }
    public void cargarInformacionBarChart()
    {
    	XYChart.Series<String, Number> barras = new XYChart.Series<>();
    	barras.setName("Acierto de cada pregunta");
    	Tema miTema = null;
    	Pregunta miPregunta = null;
    	for (int i = 0; i < getMiExamen().getMisTemas().size(); i++) 
    	{
			miTema = getMiExamen().getMisTemas().get(i);
			for (int j = 0; j < miTema.getMisPreguntas().size(); j++) 
			{
				miPregunta = miTema.getMisPreguntas().get(j);
				barras.getData().add(new XYChart.Data<>(miPregunta.getNombre(), miExamen.obtenerOpcionesCorrectas(miPregunta, j)));
			}
		}
    	diagramaDeBarras.getData().add(barras);
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
		cargarInformacionBarChart();
	}

}
