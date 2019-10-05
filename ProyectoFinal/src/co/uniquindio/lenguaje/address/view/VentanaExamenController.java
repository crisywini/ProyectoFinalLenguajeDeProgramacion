package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Pregunta;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.model.TipoPregunta;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VentanaExamenController 
{
    @FXML
    private VBox panelControl;
    @FXML
    private Label nombreExamenLabel;
    @FXML
    private Label tipoExamenLabel;

    @FXML
    private Label descripcionLabel;

    @FXML
    private Label porcentajeExitoLabel;

    @FXML
    private Label tiempoLimiteLabel;
    private PrincipalEstudiantesOverviewController ventanaPrincipal;
    private Examen miExamen;

    public Examen getMiExamen() {
		return miExamen;
	}

	public void setMiExamen(Examen miExamen) {
		this.miExamen = miExamen;
		this.nombreExamenLabel.setText(miExamen.getTitulo());
		this.descripcionLabel.setText(miExamen.getDescripcion());
		this.porcentajeExitoLabel.setText(miExamen.getPorcentajeExito()+"");
		this.tiempoLimiteLabel.setText(miExamen.getTiempoLimite()+"");
		this.tipoExamenLabel.setText(miExamen.getMiTipoExamen().toString());
	}

	public PrincipalEstudiantesOverviewController getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(PrincipalEstudiantesOverviewController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}


	@FXML
    void handleVolverButton() 
	{
		this.ventanaPrincipal.devolverAPrincipal();
    }

    @FXML
    void handleEmpezarButton()//Se necesita tener la primera pregunta y el primer tema
    {
    	ArrayList<Tema> misTemas = miExamen.getMisTemas();
    	Tema miTema = misTemas.get(0);
    	Pregunta miPregunta = miTema.getMisPreguntas().get(0);
    	if(miPregunta.getMiTipo() == TipoPregunta.SIMPLE)
    	{
        	this.ventanaPrincipal.cargarVentanaPreguntaNormal(getMiExamen(), 0,0);
    	}
    	else
    	{
    		this.ventanaPrincipal.cargarVentanaPreguntaMultiple(getMiExamen(), 0,0);
    	}
    }
    @FXML
    void initialize()
    {
    	
    }   
}