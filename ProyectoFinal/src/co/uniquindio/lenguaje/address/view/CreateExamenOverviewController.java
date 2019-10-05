package co.uniquindio.lenguaje.address.view;

import java.util.ArrayList;

import co.uniquindio.lenguaje.address.Principal;
import co.uniquindio.lenguaje.address.exceptions.ExamenRepeatException;
import co.uniquindio.lenguaje.address.model.Docente;
import co.uniquindio.lenguaje.address.model.Estudiante;
import co.uniquindio.lenguaje.address.model.Examen;
import co.uniquindio.lenguaje.address.model.Tema;
import co.uniquindio.lenguaje.address.model.TipoExamen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CreateExamenOverviewController {

	@FXML
	TextField porcentajeExitoField;

	@FXML
	TextField tituloField;

	@FXML
	TableColumn<Tema, String> nombreTemaColumn;

	@FXML
	TextField descripcionField;

	@FXML
	TextField tiempoLimiteField;

	@FXML
	TextField estudianteField;

	@FXML
	TableColumn<Estudiante, String> nombreEstudianteColumn;

	@FXML
	ComboBox<TipoExamen> combo;

	@FXML
	TableView<Estudiante> estudiantesTable;

	@FXML
	TableView<Tema> temasTable;

	@FXML
	TableColumn<Estudiante, String> codigoEstudianteColumn;

	private Principal miPrincipal;
	private Stage miStage;
	private Docente miDocente;
	private ArrayList<Estudiante> misEstudiantes = new ArrayList<>();
	private ArrayList<Tema> misTemas = new ArrayList<>();
	private ObservableList<Estudiante> misEstudiantesTable = FXCollections.observableArrayList();
	private ObservableList<Tema> misTemasTable = FXCollections.observableArrayList();

	@FXML
	private void handleInformacionTema() {
		if (isSelectedTema()) {
			Tema miTema = temasTable.getSelectionModel().getSelectedItem();
			this.miPrincipal.mostrarAlerta(miTema.toString(), "", miTema.getNombre(), miStage, AlertType.INFORMATION);

		}
	}

	@FXML
	private void handleAgregarTemaAlExamen() {
		if (isSelectedTema()) {
			
			Tema miTema = temasTable.getSelectionModel().getSelectedItem();
			misTemas.add(miTema);
			this.miPrincipal.mostrarAlerta("Tema agregado a la lista para el examen", "", "Informacion", miStage, AlertType.INFORMATION);
		}
	}

	@FXML
	private void handleAgregarEstudiante() {
		if (isInputValidEstudiante()) {
			if (obtenerPosEstudiante(estudianteField.getText()) == -1) {
				this.misEstudiantes.add(getMiPrincipal().obtenerEstudiante(estudianteField.getText()));
				misEstudiantesTable.add(getMiPrincipal().obtenerEstudiante(estudianteField.getText()));
				this.miPrincipal.mostrarAlerta("Estudiante agregado", "", "Informacion", miStage,
						AlertType.INFORMATION);
			} else {
				this.miPrincipal.mostrarAlerta("El estudiante ya se encuentra en la lista de examinandos", "",
						"Advertencia", miStage, AlertType.WARNING);
			}
		}
	}

	@FXML
	private void handleSalirButton() {
		this.miStage.hide();
	}

	@FXML
	private void handleAgregarExamen() {
		if (isInputValidExamInfo()) {
			try {
				this.miDocente.agregarExamen(descripcionField.getText(), tituloField.getText(),
						Double.parseDouble(porcentajeExitoField.getText()),
						Double.parseDouble(tiempoLimiteField.getText()), misTemas,
						combo.getSelectionModel().getSelectedItem(), misEstudiantes);
				Examen miExamen = null;
				miExamen = this.miDocente.obtenerExamenSegunDescripcionTitulo(descripcionField.getText(), tituloField.getText());
				miExamen.setEstudiantes();
				porcentajeExitoField.setText("");
				tituloField.setText("");
				descripcionField.setText("");
				tiempoLimiteField.setText("");
				estudianteField.setText("");
				this.miPrincipal.mostrarAlerta("El examen ya se ha creado", "", "Informacion", miStage,
						AlertType.INFORMATION);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ExamenRepeatException e) {
				this.miPrincipal.mostrarAlerta(e.getMessage(), "", "ErRor", miStage, AlertType.ERROR);
			}
		}
	}

	@FXML
	private void handleCrearNuevoTemaButton() {
		getMiPrincipal().showTemasOverviewController(getMiDocente());
	}

	public boolean isSelectedTema() {
		boolean centinela = false;
		int pos = temasTable.getSelectionModel().getSelectedIndex();
		if (pos != -1) {
			centinela = true;
		} else {
			this.miPrincipal.mostrarAlerta("Debe seleccionar un Tema", "", "Advertencia", miStage, AlertType.WARNING);
		}
		return centinela;
	}

	public boolean isInputValidEstudiante() {
		boolean centinela = false;
		String mensajeDeError = "";
		if (estudianteField.getText() == null || estudianteField.getText().length() == 0) {
			mensajeDeError += "Codigo del estudiante no permitido\n";
		} else {
			int pos = this.miPrincipal.obtenerPosEstudiante(estudianteField.getText());
			if (pos == -1) {
				mensajeDeError += "El estudiante no se encuentra en la Universidad\n";
			}
		}
		if (mensajeDeError.length() == 0) {
			centinela = true;
		} else {
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Advertencia", miStage, AlertType.WARNING);
		}
		return centinela;
	}

	public boolean isInputValidExamInfo() {
		boolean salida = false;
		String mensajeDeError = "";
		if (tituloField.getText() == null || tituloField.getText().length() == 0) {
			mensajeDeError += "El titulo no está permitido\n";
		}
		if (descripcionField.getText() == null || descripcionField.getText().length() == 0) {
			mensajeDeError += "La descripcion no está permitida\n";
		}
		if (porcentajeExitoField.getText() == null || porcentajeExitoField.getText().length() == 0) {
			mensajeDeError += "El porcentaje de exito no está permitido\n";
		}
		try {
			Double.parseDouble(porcentajeExitoField.getText());
		} catch (NumberFormatException exception) {
			mensajeDeError += "El campo porcentaje de error solo recibe numeros\n";
		}
		if (tiempoLimiteField.getText() == null || tiempoLimiteField.getText().length() == 0) {
			mensajeDeError += "El tiempo limite no está permitido\n";
		}
		try {
			Double.parseDouble(tiempoLimiteField.getText());
		} catch (NumberFormatException exception) {
			mensajeDeError += "El campo tiempo limite solo recibe numeros\n";
		}
		if (combo.getSelectionModel().getSelectedIndex() == -1) {
			mensajeDeError += "Elija un tipo de examen\n";
		} else {
			if (combo.getSelectionModel().getSelectedItem() == TipoExamen.PRIVADO && misEstudiantes.size() == 0) {
				mensajeDeError += "Debe agregar estudiantes si el examen es privado\n";
			}
		}
		if (mensajeDeError.length() == 0) {
			salida = true;
		} else {
			this.miPrincipal.mostrarAlerta(mensajeDeError, "", "Advertencia", miStage, AlertType.WARNING);
		}
		return salida;
	}

	public Principal getMiPrincipal() {
		return miPrincipal;
	}

	public void setMiPrincipal(Principal miPrincipal) {
		this.miPrincipal = miPrincipal;
	}

	public Docente getMiDocente() {
		return miDocente;
	}

	public void setMiDocente(Docente miDocente) {
		this.miDocente = miDocente;
		misTemasTable.setAll(miDocente.getMisTemas());
		initTableTemas();
		initTableEstudiantes();
		initCombo();
	}

	public Stage getMiStage() {
		return miStage;
	}

	public void setMiStage(Stage miStage) {
		this.miStage = miStage;
	}

	public int obtenerPosEstudiante(String estudiante) {
		int pos = -1;
		Estudiante miEstudiante = null;
		String codigoAux = "";
		boolean centinela = false;
		for (int i = 0; i < this.misEstudiantes.size() && !centinela; i++) {
			miEstudiante = misEstudiantes.get(i);
			codigoAux = miEstudiante.getCodigo();
			if (codigoAux.equals(estudiante)) {
				pos = i;
				centinela = true;
			}
		}
		return pos;
	}

	public void initTableTemas() {
		nombreTemaColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		temasTable.setItems(misTemasTable);
	}

	public void initTableEstudiantes() {
		codigoEstudianteColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
		nombreEstudianteColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		estudiantesTable.setItems(misEstudiantesTable);
	}

	public void initCombo() {
		ObservableList<TipoExamen> misTipos = FXCollections.observableArrayList(TipoExamen.PRIVADO, TipoExamen.PUBLICO);
		combo.setItems(misTipos);
	}

	@FXML
	void initialize() {

	}
}