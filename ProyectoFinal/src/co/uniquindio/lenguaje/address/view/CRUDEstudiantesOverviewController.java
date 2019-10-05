package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.EstudianteRepeatException;
import co.uniquindio.lenguaje.address.model.ProgramaAcademico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CRUDEstudiantesOverviewController 
{
	@FXML TextField nombreField;
	@FXML TextField apellidoField;
	@FXML TextField codigoField;
	@FXML TextField usuarioField;
	@FXML PasswordField contraseniaField;
	@FXML TextField telefonoField;
	@FXML ComboBox<String> combo;
	private Principal miPrincipal;
	private Stage miStage;
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) 
	{
		this.miPrincipal = miPrincipal;
		initCombo();
	}
	public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(nombreField.getText()==null||nombreField.getText().length()==0)
		{
			mensajeDeError += "El nombre no es valido\n";
		}
		if(apellidoField.getText()==null||apellidoField.getText().length()==0)
		{
			mensajeDeError += "El apellido no es valido\n";
		}
		if(usuarioField.getText()==null||usuarioField.getText().length()==0)
		{
			mensajeDeError += "El usuario no es valido\n";
		}
		if(contraseniaField.getText()==null||contraseniaField.getText().length()==0)
		{
			mensajeDeError += "La contraseña no es valida\n";
		}
		if(codigoField.getText()==null||codigoField.getText().length()==0)
		{
			mensajeDeError += "El codigo no es valido\n";
		}
		if(telefonoField.getText()==null||telefonoField.getText().length()==0)
		{
			mensajeDeError += "El telefono no es valido\n";
		}
		try 
		{
			Long.parseLong(telefonoField.getText());
		} 
		catch (Exception e) 
		{
			mensajeDeError += "El telefono debe tener numeros\n";
		}
		if(combo.getSelectionModel().getSelectedItem()==null)
		{
			mensajeDeError += "Elija un programa\n";
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Precaucion", miStage, AlertType.WARNING);
		}
		return centinela;
	}
	public void initCombo()
	{
		ObservableList<String> misProgramasSNIES = FXCollections.observableArrayList();
		ArrayList<String> informacion = new ArrayList<String>();
		ProgramaAcademico aux = null;
		for (int i = 0; i < this.miPrincipal.getMiUniversidad().getMisProgramasAcademicos().size(); i++) 
		{
			aux = getMiPrincipal().getMiUniversidad().getMisProgramasAcademicos().get(i);
			informacion.add(aux.getCodigoSNIES());
		}
		misProgramasSNIES.addAll(informacion);
		combo.setItems(misProgramasSNIES);
	}
	public ProgramaAcademico obtenerProgramaSeleccionado()
	{
		return this.miPrincipal.obtenerProgramaAcademico(combo.getSelectionModel().getSelectedItem());
	}
	@FXML
	private void handleAgregarButton()
	{
		if(isInputValid())
		{
			try 
			{
				this.miPrincipal.agregarEstudiante(nombreField.getText(), apellidoField.getText(), codigoField.getText(), usuarioField.getText(), contraseniaField.getText(), telefonoField.getText(), obtenerProgramaSeleccionado());
				
				this.miPrincipal.getEstudiantesData().add(getMiPrincipal().obtenerEstudiante(codigoField.getText()));
				this.miPrincipal.mostrarAlerta("El estudiante: "+ codigoField.getText()+" ha sido ingresado a la Universidad", "", "Informacion", miStage, AlertType.INFORMATION);

				nombreField.setText("");
				apellidoField.setText("");
				codigoField.setText("");
				usuarioField.setText("");
				contraseniaField.setText("");
				telefonoField.setText("");
			}
			catch (EstudianteRepeatException e) 
			{
				getMiPrincipal().mostrarAlerta(e.getMessage(), "", "ErRoR", miStage, AlertType.ERROR);
			}
		}
	}
	@FXML
	private void handleCancelarButton()
	{
		this.miStage.hide();
	}
	

}
