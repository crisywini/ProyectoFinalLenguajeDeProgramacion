package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.Examen;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class StatEstudiantesOverviewController {
	@FXML
	private BarChart<String, Number> barChart;

	@FXML
	private NumberAxis ejeY;
	@FXML AnchorPane panelStatsEstudiantes;
	@FXML
	private CategoryAxis ejeX;
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
	public void cargarInformacionBarChar()
	{
		XYChart.Series<String, Number> barras = new XYChart.Series<>();
		barras.setName("Estudiantes que presentaron el examen");
		Estudiante miEstudiante = null;
		Examen examenEstudiante = null;
		for (int i = 0; i < getMiExamen().getMisEstudiantes().size(); i++) 
		{
			miEstudiante = getMiExamen().getMisEstudiantes().get(i);
			examenEstudiante = miEstudiante.obtenerExamenSegunTitulo(getMiExamen().getTitulo());
			barras.getData().add(new XYChart.Data<>(miEstudiante.getNombre(),examenEstudiante.getNotaTotal()));
		}
		barChart.getData().add(barras);
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
		cargarInformacionBarChar();
	}
}