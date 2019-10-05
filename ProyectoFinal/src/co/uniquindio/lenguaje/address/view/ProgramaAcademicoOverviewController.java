package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.ProgramaAcademicoRepeatException;
import co.uniquindio.lenguaje.address.model.Docente;
import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.Jornada;
import co.uniquindio.lenguaje.address.model.Metodologia;
import co.uniquindio.lenguaje.address.model.ProgramaAcademico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProgramaAcademicoOverviewController 
{
	private String codigoSNIES;
	@FXML TextField nombreField;
	@FXML TextField codigoSNIESField;
	@FXML TextField numeroCreditosField;
	@FXML TextField lugarDeDesarrollo;
	@FXML ComboBox<Metodologia> metodologiaBox;
	@FXML ComboBox<Jornada> jornadaBox;
	//----------Profesores table
	@FXML TextField codigoDocenteField;
	@FXML TableView<Docente> docentesTableView;
	@FXML TableColumn<Docente, String> codigoColumn;
	@FXML TableColumn<Docente, String> nombreColumn;
	@FXML TableColumn<Docente, String> apellidoColumn;
	@FXML TableColumn<Docente, String> usuarioColumn;
	@FXML TableColumn<Docente, String> profesionColumn;
	//----------Students table
	@FXML TextField codigoEstudianteField;
	@FXML TableView<Estudiante> estudiantesTableView;
	@FXML TableColumn<Estudiante, String> codigoEstudianteColumn;
	@FXML TableColumn<Estudiante, String> nombreEstudianteColumn;
	@FXML TableColumn<Estudiante, String> apellidoEstudianteColumn;
	@FXML TableColumn<Estudiante, String> usuarioEstudianteColumn;
	private boolean isOnlyOneTimeClicked = true;
	private ProgramaAcademico miAcademico;
	private Principal miPrincipal;
	private Stage miStage;
	public Principal getMiPrincipal() {
		return miPrincipal;
	}
	public void setMiPrincipal(Principal miPrincipal) 
	{
		this.miPrincipal = miPrincipal;
		initializeCombos();
		initializeTableDocentes();
		docentesTableView.setItems(this.miPrincipal.getDocenteData());
		initializeTableEstudiantes();
		estudiantesTableView.setItems(this.miPrincipal.getEstudiantesData());
	}
	public Stage getMiStage() {
		return miStage;
	}
	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}
	public boolean isInputValidOnlyProgram()
	{
		boolean salida = false;
		String mensajeDeError = "";
		if(nombreField.getText()==null|| nombreField.getText().length()==0)
		{
			mensajeDeError += "El nombre no es valido\n";
		}
		if(codigoSNIESField.getText() == null|| codigoSNIESField.getText().length() == 0)
		{
			mensajeDeError += "El codigo SNIES no es valido\n";
		}
		try 
		{
			Long.parseLong(codigoSNIESField.getText());
		} 
		catch (Exception e) 
		{
			mensajeDeError += "El codigo debe tener solo numeros\n";
		}
		if(numeroCreditosField.getText() == null||numeroCreditosField.getText().length()==0)
		{
			mensajeDeError += "El numero de creditos no es valido\n";
		}
		try
		{
			Integer.parseInt(numeroCreditosField.getText());
		} 
		catch (Exception e)
		{
			mensajeDeError += "El numero de creditos debe ser un numero\n";
		}
		if(metodologiaBox.getSelectionModel().getSelectedItem()==null)
		{
			mensajeDeError += "Debe escoger una metodologia\n";
		}
		if(jornadaBox.getSelectionModel().getSelectedItem() == null)
		{
			mensajeDeError += "Debe escoger una jornada\n";
		}
		if(mensajeDeError.length() == 0)
		{
			salida = true;
		}
		else
		{
			getMiPrincipal().mostrarAlerta(mensajeDeError, "Tenga cuidado", "Error", miStage, AlertType.WARNING);
		}
		return salida;
	}
	public boolean isInputValidOnlyDocentes()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(codigoDocenteField.getText() == null||codigoDocenteField.getText().length()==0)
		{
			mensajeDeError += "El codigo no está permitido\n";
		}
		if(codigoDocenteField.getText()!=null)
		{
			if(getMiPrincipal().obtenerPosDocente(codigoDocenteField.getText())==-1)
			{
				mensajeDeError += "El docente no se encuentra en la Universidad\n";
			}
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			getMiPrincipal().mostrarAlerta(mensajeDeError, "Error al ingresar el docente", "Error", miStage, AlertType.WARNING);
		}
		return centinela;
	}
	@FXML
	private void handleAgregarDocenteAlProgramaButton()
	{
		if(isInputValidOnlyDocentes())
		{
			codigoSNIES = codigoSNIESField.getText();
			int pos = this.miPrincipal.obtenerPosProgramaAcademico(codigoSNIES);
			if(pos == -1)
			{
				this.miPrincipal.mostrarAlerta("El programa academico con codigoSNIES: "+ codigoSNIES+" no se encuentra en la Universidad", "", "ERror", miStage, AlertType.ERROR);
			}
			else
			{
				ProgramaAcademico miAcademico = getMiPrincipal().obtenerProgramaAcademico(codigoSNIES);
				this.setMiAcademico(miAcademico);
				int posDocente = miAcademico.obtenerPosDocente(codigoDocenteField.getText());
				if(posDocente!=-1)
				{
					this.miPrincipal.mostrarAlerta("El docente ya se encuentra en el programa", "", "ErrOr", miStage, AlertType.ERROR);
				}
				else
				{
					miAcademico.getMisDocentes().add(getMiPrincipal().obtenerDocente(codigoDocenteField.getText()));
					getMiPrincipal().getDocenteData().add(miAcademico.getMisDocentes().get(pos));
					getMiPrincipal().mostrarAlerta("El docente: "+codigoDocenteField.getText()+" ha sido agregado al programa.", "Informacion", "Agregado con exito", miStage, AlertType.INFORMATION);
					codigoDocenteField.setText("");
				}
				
			}
			
		}
	}
	public boolean isInputValidOnlyEstudiantes()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(codigoEstudianteField.getText()==null||codigoEstudianteField.getText().length()==0)
		{
			mensajeDeError += "El codigo del estudiante no es valido\n";
		}
		if(codigoEstudianteField.getText() != null)
		{
			if(getMiPrincipal().obtenerPosEstudiante(codigoEstudianteField.getText())==-1)
			{
				mensajeDeError += "El estudiante no está registrado en la Universidad\n";
			}
		}
		if(mensajeDeError.length()==0)
		{
			centinela = true;
		}
		else
		{
			getMiPrincipal().mostrarAlerta(mensajeDeError, "ERROR", "Error", miStage, AlertType.ERROR);
		}
		return centinela;
	}
	@FXML
	private void handleAgregarEstudianteAlProgramaButton()
	{
		if(isInputValidOnlyEstudiantes())
		{
			ProgramaAcademico miAcademico = getMiPrincipal().obtenerProgramaAcademico(codigoSNIES);
			miAcademico.getMisEstudiantes().add(getMiPrincipal().obtenerEstudiante(codigoEstudianteField.getText()));
			getMiPrincipal().mostrarAlerta("El estudiante: "+ codigoEstudianteField.getText()+" ha sido incorporado al programa.", "Informacion", "Agregado con exito", miStage, AlertType.INFORMATION);
			codigoEstudianteField.setText("");
		}
	}
	@FXML
	private void handleAgregarProgramaButton()
	{
		if(isInputValidOnlyProgram())
		{
			try 
			{
				getMiPrincipal().agregarProgramaAcademico(nombreField.getText(), codigoSNIESField.getText(), Integer.parseInt(numeroCreditosField.getText()), lugarDeDesarrollo.getText(), metodologiaBox.getSelectionModel().getSelectedItem(), jornadaBox.getSelectionModel().getSelectedItem());
				getMiPrincipal().mostrarAlerta("El programa: "+nombreField.getText()+","+codigoSNIESField.getText()+" ha sido agregado a la Universidad.", "Informacion", "Exito", miStage, AlertType.INFORMATION);
				this.codigoSNIES = codigoSNIESField.getText();
				nombreField.setText("");
				codigoSNIESField.setText("");
				numeroCreditosField.setText("");
				lugarDeDesarrollo.setText("");
			} 
			catch (ProgramaAcademicoRepeatException e) 
			{
				getMiPrincipal().mostrarAlerta(e.getMessage(), "Error", "ERROR", miStage, AlertType.ERROR);
			}
		}
	}
	@FXML
	private void handleExitButton()
	{
		this.miStage.hide();
	}
	public void initializeTableDocentes()
	{
		codigoColumn.setCellValueFactory(cellData->cellData.getValue().codigoProperty());
		nombreColumn.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
		apellidoColumn.setCellValueFactory(cellData->cellData.getValue().apellidoProperty());
		usuarioColumn.setCellValueFactory(cellData->cellData.getValue().usuarioProperty());
		profesionColumn.setCellValueFactory(cellData->cellData.getValue().profesionProperty());
	}
	public void initializeTableEstudiantes()
	{
		codigoEstudianteColumn.setCellValueFactory(cellData->cellData.getValue().codigoProperty());
		nombreEstudianteColumn.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
		apellidoEstudianteColumn.setCellValueFactory(cellData->cellData.getValue().apellidoProperty());
		usuarioEstudianteColumn.setCellValueFactory(cellData->cellData.getValue().usuarioProperty());
	}
	@FXML
	private void handleAgregarCursosButton()
	{
		if(codigoSNIESField.getText()!=null||codigoSNIESField.getText().length()!=0)
		{
			if(getMiPrincipal().obtenerPosProgramaAcademico(codigoSNIESField.getText())!=-1)
			{
				setMiAcademico(getMiPrincipal().obtenerProgramaAcademico(codigoSNIESField.getText()));
			}
			else
			{
				getMiPrincipal().mostrarAlerta("El programa academico: "+codigoSNIESField.getText()+" no se encuentra en la Universidad",
						                        "Error", "ErRor", miStage, AlertType.WARNING);
			}
		}
		else
		{
			if(getMiAcademico()!=null)
			{
			}
			else
			{
				getMiPrincipal().mostrarAlerta("No se ha creado el programa academico", "Error", "Error", miStage, AlertType.WARNING);
			}
		}

	}
	public void initializeCombos()
	{
		ObservableList<Jornada> miListJornadas = FXCollections.observableArrayList(Jornada.DIURNA,Jornada.NOCTURNA);
		jornadaBox.setItems(miListJornadas);
		ObservableList<Metodologia> miListMetodologias = FXCollections.observableArrayList(Metodologia.DISTANCIA,Metodologia.PRESENCIAL, Metodologia.VIRTUAL);
		metodologiaBox.setItems(miListMetodologias);
	}
	public ProgramaAcademico getMiAcademico() {
		return miAcademico;
	}
	public void setMiAcademico(ProgramaAcademico miAcademico) {
		this.miAcademico = miAcademico;
	}
	public boolean isOnlyOneTimeClicked() {
		return isOnlyOneTimeClicked;
	}
	public void setOnlyOneTimeClicked(boolean isOnlyOneTimeClicked) {
		this.isOnlyOneTimeClicked = isOnlyOneTimeClicked;
	}
}
