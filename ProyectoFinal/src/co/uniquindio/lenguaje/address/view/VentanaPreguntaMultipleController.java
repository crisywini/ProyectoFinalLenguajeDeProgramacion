package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Pregunta;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.model.TipoPregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class VentanaPreguntaMultipleController 
{
    @FXML
    private Label opcionBLabel;

    @FXML
    private Label opcionDLabel;

    @FXML
    private Label nombrePreguntaLabel;

    @FXML
    private CheckBox opcionD;

    @FXML
    private Label opcionCLabel;

    @FXML
    private CheckBox opcionB;

    @FXML
    private CheckBox opcionC;

    @FXML
    private CheckBox opcionA;

    @FXML
    private Label opcionALabel;
    private PrincipalEstudiantesOverviewController ventanaPrincipal;
    private ArrayList<Tema> misTemas;
    private int indiceTema;
    private int indicePregunta;
    Tema miTemaSeleccionado = null;
    private Examen miExamen;

    /**
	 * @return the miExamen
	 */
	public Examen getMiExamen() {
		return miExamen;
	}
	/**
	 * @param miExamen the miExamen to set
	 */
	public void setMiExamen(Examen miExamen) {
		this.miExamen = miExamen;

	}
	/**
	 * @return the indicePregunta
	 */
	public int getIndicePregunta() {
		return indicePregunta;
	}
	/**
	 * @param indicePregunta the indicePregunta to set
	 */
	public void setIndicePregunta(int indicePregunta) {
		this.indicePregunta = indicePregunta;
	}
	/**
	 * @return the indiceTema
	 */
	public int getIndiceTema() {
		return indiceTema;
	}
	/**
	 * @param indiceTema the indiceTema to set
	 */
	public void setIndiceTema(int indiceTema) {
		this.indiceTema = indiceTema;
	}
	/**
	 * @return the misTemas
	 */
	public ArrayList<Tema> getMisTemas() {
		return misTemas;
	}
	/**
	 * @param misTemas the misTemas to set
	 */
	public void setMisTemas(ArrayList<Tema> misTemas) {
		this.misTemas = misTemas;
		organizarNombresDePreguntas(indicePregunta);
	}
	/**
	 * @return the ventanaPrincipal
	 */
	public PrincipalEstudiantesOverviewController getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	/**
	 * @param ventanaPrincipal the ventanaPrincipal to set
	 */
	public void setVentanaPrincipal(PrincipalEstudiantesOverviewController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	@FXML
    private void checkEvent(ActionEvent event) {

    }
    @FXML
    void handleSiguienteButton() 
    {
    	miTemaSeleccionado = getMisTemas().get(indiceTema);
		Pregunta miPregunta = null;

		if(!isChecked())
		{
			ventanaPrincipal.mostrarMensaje("Debe seleccionar alguna pregunta", "", "Advertencia", AlertType.WARNING);
		}
		else
		{
			miPregunta = miTemaSeleccionado.getMisPreguntas().get(indicePregunta);
			miExamen.getOpcionesElejidas().add(obtenerOpcionSeleccionada());
			if(indicePregunta+1 == miTemaSeleccionado.getMisPreguntas().size())
			{
				ventanaPrincipal.mostrarMensaje("Ha terminado el examen\n"+"Su calificacion fue de: "+miExamen.obtenerPorcentajeExamen(), "", "Informacion", AlertType.INFORMATION);
				ventanaPrincipal.devolverAPrincipal();
			}
			else
			{
				miPregunta = miTemaSeleccionado.getMisPreguntas().get(indicePregunta+1);
				setIndicePregunta(indicePregunta+1);
				if(miPregunta.getMiTipo()==TipoPregunta.MULTIPLE)
				{
					organizarNombresDePreguntas(indicePregunta+1);
				}
				else
				{
					this.ventanaPrincipal.cargarVentanaPreguntaNormal(getMiExamen(), indiceTema, indicePregunta+1);
				}
			}
		}
    }
    /**
     * Metodo encargado de Organizar los nombres de las Preguntas
     * @param j indice de la pregunta a organizar
     */
    public void organizarNombresDePreguntas(int j)
	{
		Tema miTema = getMisTemas().get(indiceTema);
		Pregunta miPregunta = miTema.getMisPreguntas().get(j);
		opcionALabel.setText(miPregunta.getOpciones().get(0));
		opcionBLabel.setText(miPregunta.getOpciones().get(1));
		opcionCLabel.setText(miPregunta.getOpciones().get(2));
		opcionDLabel.setText(miPregunta.getOpciones().get(3));
	}

    @FXML
    void initialize() {
    	
    }
    /**
     * Metodo que verifica si se selecciono algun checkBox
     * @return
     */
    public boolean isChecked()
    {
    	boolean centinela = false;
    	if(opcionA.isSelected()||opcionB.isSelected()||opcionC.isSelected()||opcionD.isSelected())
    	{
    		centinela = true;
    	}
    	else
    	{
    		centinela = false;
    	}
    	return centinela;
    }
    /**
     * Metodo que devuelve un String con la opcion seleccionada por los checks
     * @return
     */
    public String obtenerOpcionSeleccionada()
    {
    	String salida = "";
    	if(opcionA.isSelected())
    	{
    		salida += opcionALabel.getText()+" ";
    	}
    	if(opcionB.isSelected())
    	{
    		salida += opcionBLabel.getText()+" ";
    	}
    	if(opcionC.isSelected())
    	{
    		salida += opcionCLabel.getText()+" ";
    	}
    	if(opcionD.isSelected())
    	{
    		salida += opcionDLabel.getText()+" ";
    	}
    	return salida;
    }
}