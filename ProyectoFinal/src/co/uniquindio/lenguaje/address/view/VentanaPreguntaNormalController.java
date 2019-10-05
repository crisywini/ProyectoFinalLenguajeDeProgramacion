package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Pregunta;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.model.TipoPregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class VentanaPreguntaNormalController {

	@FXML
	private VBox panelPreguntaNormal;
	
	@FXML
	private RadioButton opcionD;

	@FXML
	private RadioButton opcionB;

	@FXML
	private RadioButton opcionC;

	@FXML
	private RadioButton opcionA;

	@FXML
	private Label Label;

	@FXML
	private ToggleGroup MyGroup;
	private ArrayList<Tema> misTemas;
	private PrincipalEstudiantesOverviewController ventanaPrincipal;
	private int indiceTema;
	Tema miTemaSeleccionado = null;
	private int indicePregunta;
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

	public PrincipalEstudiantesOverviewController getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(PrincipalEstudiantesOverviewController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public ArrayList<Tema> getMisTemas() {
		return misTemas;
	}

	public void setMisTemas(ArrayList<Tema> misTemas) {
		this.misTemas = misTemas;
		organizarNombresDePreguntas(indicePregunta);
	}

	@FXML
	void initialize() {

	}

	@FXML
	void handleSiguienteButton()
	{
		miTemaSeleccionado = getMisTemas().get(indiceTema);
		Pregunta miPregunta = null;

		if(isSomethingSelected())
		{
			miExamen.getOpcionesElejidas().add(obtenerOpcionSeleccionada());

			if (indicePregunta + 1 == miTemaSeleccionado.getMisPreguntas().size()) {
				ventanaPrincipal.mostrarMensaje("Ha terminado el examen\n"+"Su calificacion ha sido de: "+miExamen.obtenerPorcentajeExamen(), "", "Informacion", AlertType.INFORMATION);
				ventanaPrincipal.devolverAPrincipal();
			} else {
				miPregunta = miTemaSeleccionado.getMisPreguntas().get(indicePregunta + 1);
				setIndicePregunta(indicePregunta + 1);
				if (miPregunta.getMiTipo() == TipoPregunta.SIMPLE) {
					organizarNombresDePreguntas(indicePregunta + 1);
				} else {
					this.ventanaPrincipal.cargarVentanaPreguntaMultiple(getMiExamen(), indiceTema, indicePregunta);
				}
			}
		}
		else
		{
			this.ventanaPrincipal.mostrarMensaje("Debe seleccionar alguna pregunta", "", "Advertencia", AlertType.WARNING);
		}
	}

	public void organizarNombresDePreguntas(int j) {
		Tema miTema = getMisTemas().get(indiceTema);
		Pregunta miPregunta = miTema.getMisPreguntas().get(j);
		opcionA.setText(miPregunta.getOpciones().get(0));
		opcionB.setText(miPregunta.getOpciones().get(1));
		opcionC.setText(miPregunta.getOpciones().get(2));
		opcionD.setText(miPregunta.getOpciones().get(3));
	}

	@FXML
	void radioEvent(ActionEvent event) {
		
	}
	/**
	 * Metodo que verifica si alguna respuesta esta seleccionada
	 * @return
	 */
	public boolean isSomethingSelected()
	{
		boolean centinela = false;
		if(opcionA.isSelected()||opcionB.isSelected()||opcionC.isSelected()||opcionD.isSelected())
			centinela = true;
		
		return centinela;
	}
	public String obtenerOpcionSeleccionada()
	{
		String salida = "";
		if(opcionA.isSelected())
		{
			  salida = opcionA.getText();
		}
		if(opcionB.isSelected())
		{
			 return salida += opcionB.getText();
		}
		if(opcionC.isSelected())
		{
			 return salida += opcionC.getText();
		}
		if(opcionD.isSelected())
		{
			return salida += opcionD.getText();
		}
		return salida;
	}
}