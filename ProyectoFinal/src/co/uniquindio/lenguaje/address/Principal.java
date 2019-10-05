package co.uniquindio.lenguaje.address;

import java.io.File;


import java.io.IOException;

import co.uniquindio.lenguaje.address.model.*;
import co.uniquindio.lenguaje.address.exceptions.*;
import co.uniquindio.lenguaje.address.view.*;
import co.uniquindio.lenguaje.address.persistencia.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Principal extends Application implements IControUniversidad {
	private final ObservableList<ComunidadAcademica> comunidadAcademicaData = FXCollections.observableArrayList();
	private final ObservableList<Estudiante> estudiantesData = FXCollections.observableArrayList();
	private final ObservableList<Docente> docenteData = FXCollections.observableArrayList();
	private final ObservableList<ProgramaAcademico> programasAcademicosData = FXCollections.observableArrayList();
	private final ObservableList<Administrador> administradoresData = FXCollections.observableArrayList();
	private Universidad miUniversidad;
	private Stage escenarioPrincipal;
	private BorderPane layoutPrincipal;

	@Override
	public void start(Stage primaryStage) {
		cargarDatos();
		if (this.miUniversidad == null) {
			this.miUniversidad = new Universidad();
		}
		this.escenarioPrincipal = primaryStage;
		this.escenarioPrincipal.getIcons().add(new Image(
				"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_character_avatar_dragon_4527371.png"));
		initPrincipalOverview();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initPrincipalOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/PrincipalOverview.fxml"));
			layoutPrincipal = (BorderPane) cargador.load();

			Scene principalScene = new Scene(layoutPrincipal);
			escenarioPrincipal.setScene(principalScene);
			escenarioPrincipal.setMinWidth(630);
			escenarioPrincipal.setMinHeight(415);

			PrincipalOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			escenarioPrincipal.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void showCreateAdminOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/CreateAdminOverview.fxml"));
			VBox layout = (VBox) cargador.load();

			Stage escenario = new Stage();
			escenario.initModality(Modality.WINDOW_MODAL);
			escenario.initOwner(escenarioPrincipal);
			escenario.setTitle("Crear Administrador");
			Scene scene = new Scene(layout);
			escenario.setScene(scene);
			escenario.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_chair_iron_throne__4528250.png"));
			CreateAdminOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setThisStage(escenario);
			escenario.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void showProgramaAcademicoOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/ProgramaAcademicoOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			Stage escenario = new Stage();
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.initOwner(escenarioPrincipal);
			escenario.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_chair_iron_throne__4528250.png"));
			Scene scene = new Scene(layout);
			escenario.setScene(scene);
			ProgramaAcademicoOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(escenario);
			escenario.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void showPrincipalStageAdminOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/PrincipalStageAdminOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			Stage escenario = new Stage();
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_fire_flame_heat_4527379.png"));
			Scene scene = new Scene(layout);
			escenario.setScene(scene);
			PrincipalStageAdminOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(escenario);
			escenario.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void showCRUDDocentesOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/CRUDDocentesOverview.fxml"));
			VBox layout = (VBox) cargador.load();

			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(getEscenarioPrincipal());
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			miStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_ice_cold_winder_4527370.png"));
			CRUDDocentesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			miStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCRUDEstudiantesOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/CRUDEstudiantesOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(escenarioPrincipal);
			miStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_ice_cold_winder_4527370.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			CRUDEstudiantesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			miStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showDocentesOverview(Docente miDocente) {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/DocentesOverview.fxml"));
			HBox layout = (HBox) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(escenarioPrincipal);
			miStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_fire_flame_heat_4527379.png"));
			miStage.setMinWidth(905);
			miStage.setMinHeight(463);
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			DocentesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiDocente(miDocente);
			controlador.setMiStage(miStage);
			miStage.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showLoginDocentesOverview() {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/LoginDocentesOverview.fxml"));
			BorderPane layout = (BorderPane) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(escenarioPrincipal);
			miStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_ice_cold_winder_4527370.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			LoginDocentesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			miStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCreateExamenOverview(Docente miDocente) {
		try {
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/CreateExamenOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.initOwner(escenarioPrincipal);
			miStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_fire_flame_heat_4527379.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			CreateExamenOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			controlador.setMiDocente(miDocente);
			miStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void showTemasOverviewController(Docente miDocente)
	{
		try 
		{
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/TemaOverview.fxml"));
			VBox layout = (VBox) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_element_ice_cold_winder_4527370.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			TemasOverviewController controlador = cargador.getController();
			controlador.setMiDocente(miDocente);
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			miStage.showAndWait();
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public void showPreguntasOverview(Tema miTema)
	{
		try 
		{
			FXMLLoader cargador  = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/PreguntasOverview.fxml"));
			VBox layout = (VBox)cargador.load();
			
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_ice_fire__4527380.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			PreguntasOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			controlador.setMiTema(miTema);
			miStage.showAndWait();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void cargarVentanaPrincipalEstadisticos(Examen miExamen)
	{
		try 
		{
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/PrincipalEstadisticos.fxml"));
			BorderPane panelPrincipal = (BorderPane)cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_character_avatar_ice_dragon_4527369.png"));
			Scene scene = new Scene(panelPrincipal);
			miStage.setScene(scene);
			VentanaPrincipalController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			controlador.setMiExamen(miExamen);
			miStage.showAndWait();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void cargarPrincipalEstudiantesOverview()
	{
		try 
		{
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Principal.class.getResource("view/PrincipalEstudiantesOverview.fxml"));
			BorderPane layout = (BorderPane) cargador.load();
			Stage miStage = new Stage();
			miStage.initModality(Modality.APPLICATION_MODAL);
			miStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_lenguaje/Proyecto_final/workspace/ProyectoFinal/src/images/iconfinder_game_of_thrones_game_thrones_series_character_avatar_unburned_daenerys_dragons_queen_4528249.png"));
			Scene scene = new Scene(layout);
			miStage.setScene(scene);
			PrincipalEstudiantesOverviewController controlador = cargador.getController();
			controlador.setMiPrincipal(this);
			controlador.setMiStage(miStage);
			miStage.showAndWait();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

//-----------Getters and Setters---------------

	public Stage getEscenarioPrincipal() {
		return escenarioPrincipal;
	}

	public BorderPane getLayoutPrincipal() {
		return layoutPrincipal;
	}

	public ObservableList<Administrador> getAdministradoresData() {
		return administradoresData;
	}

	public ObservableList<ComunidadAcademica> getComunidadAcademicaData() {
		return comunidadAcademicaData;
	}

	public ObservableList<Estudiante> getEstudiantesData() {
		return estudiantesData;
	}

	public ObservableList<Docente> getDocenteData() {
		return docenteData;
	}

	public ObservableList<ProgramaAcademico> getProgramasAcademicosData() {
		return programasAcademicosData;
	}

	public Universidad getMiUniversidad() {
		return miUniversidad;
	}

	public void setMiUniversidad(Universidad miUniversidad) {
		this.miUniversidad = miUniversidad;
	}

	public void mostrarAlerta(String mensaje, String cabecera, String titulo, Stage miStage, AlertType tipo) {
		Alert miAlert = new Alert(tipo);
		miAlert.initOwner(miStage);
		miAlert.setHeaderText(cabecera);
		miAlert.setContentText(mensaje);
		miAlert.setTitle(titulo);
		miAlert.showAndWait();
	}

	// --------------Files-------------
	public void guardarUniversidad() throws IOException {
		Persistencia.serializarObjetoXML(Persistencia.RUTA_UNIVERSIDAD, this.miUniversidad);
	}

	public void cargarDatos() {
		File archivoOrigin = new File(Persistencia.RUTA_UNIVERSIDAD);
		Universidad miUniversidadAux = null;
		if (archivoOrigin.exists()) {
			try {
				miUniversidadAux = (Universidad) Persistencia.deserializaObjetoXML(Persistencia.RUTA_UNIVERSIDAD);
				setMiUniversidad(miUniversidadAux);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void guardarAdministradoresEnArchivo() throws IOException {
		Persistencia.guardarAdministradoresEnArchivo(getMiUniversidad().getMisAdministradores());
	}

	public void cargarColecciones() {

	}
	// Faltan metodos boolean

	@Override
	public int obtenerPosMiComunidadAcademica(String codigo) {
		return this.miUniversidad.obtenerPosMiComunidadAcademica(codigo);
	}

	@Override
	public ComunidadAcademica obtenerComunidadAcademica(String codigo) throws PersonaNoEncontradaException {
		return this.miUniversidad.obtenerComunidadAcademica(codigo);
	}

	@Override
	public void agregarComunidadAcademica(ComunidadAcademica miComunidadAcademica) throws PersonaRepetidaException {
		this.miUniversidad.agregarComunidadAcademica(miComunidadAcademica);
	}

	@Override
	public void eliminarComunidadAcademica(String codigo) throws PersonaNoEncontradaException {
		this.miUniversidad.eliminarComunidadAcademica(codigo);
	}

	@Override
	public int obtenerPosEstudiante(String codigo) {
		return this.miUniversidad.obtenerPosEstudiante(codigo);
	}

	@Override
	public Estudiante obtenerEstudiante(String codigo) throws EstudianteNullException {
		return this.miUniversidad.obtenerEstudiante(codigo);
	}

	@Override
	public void eliminarEstudiante(String codigo) throws EstudianteNullException {
		this.miUniversidad.eliminarEstudiante(codigo);
	}

	@Override
	public int obtenerPosDocente(String codigo) {
		return this.miUniversidad.obtenerPosDocente(codigo);
	}

	@Override
	public Docente obtenerDocente(String codigo) throws DocenteNullException {
		return this.miUniversidad.obtenerDocente(codigo);
	}

	@Override
	public void agregarDocente(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, String profesion) throws DocenteRepeatException {
		this.miUniversidad.agregarDocente(nombre, apellido, codigo, usuario, contrasenia, telefono, profesion);
	}

	@Override
	public void eliminarDocente(String codigo) throws DocenteNullException {
		this.miUniversidad.eliminarDocente(codigo);
	}

	@Override
	public int obtenerPosProgramaAcademico(String codigoSNIES) {
		return this.miUniversidad.obtenerPosProgramaAcademico(codigoSNIES);
	}

	@Override
	public ProgramaAcademico obtenerProgramaAcademico(String codigoSNIES) throws ProgramaAcademicoNullException {
		return this.miUniversidad.obtenerProgramaAcademico(codigoSNIES);
	}

	@Override
	public void agregarProgramaAcademico(String nombre, String codigoSNIES, int numeroCreditos,
			String lugarDeDesarrollo, Metodologia miMetodologia, Jornada miJordana)
			throws ProgramaAcademicoRepeatException {
		this.miUniversidad.agregarProgramaAcademico(nombre, codigoSNIES, numeroCreditos, lugarDeDesarrollo,
				miMetodologia, miJordana);
	}

	@Override
	public void eliminarProgramaAcademico(String codigoSNIES) throws ProgramaAcademicoNullException {
		this.miUniversidad.eliminarProgramaAcademico(codigoSNIES);
	}

	@Override
	public int obtenerPosAdministrador(String codigo) {
		return this.miUniversidad.obtenerPosAdministrador(codigo);
	}

	@Override
	public Administrador obtenerAdministrador(String codigo) throws PersonaNoEncontradaException {
		return this.miUniversidad.obtenerAdministrador(codigo);
	}

	@Override
	public void agregarAdministrador(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono) throws PersonaRepetidaException {
		this.miUniversidad.agregarAdministrador(nombre, apellido, codigo, usuario, contrasenia, telefono);
	}

	@Override
	public void eliminarAdministrador(String codigo) throws PersonaNoEncontradaException {
		this.miUniversidad.eliminarAdministrador(codigo);
	}

	@Override
	public int obtenerPosAdministradorSegunUsuario(String usuario) {
		return this.miUniversidad.obtenerPosAdministradorSegunUsuario(usuario);
	}

	@Override
	public Administrador obtenerAdministradorSegunUsuario(String usuario) throws PersonaNoEncontradaException {
		return this.miUniversidad.obtenerAdministradorSegunUsuario(usuario);
	}

	@Override
	public void agregarEstudiante(String nombre, String apellido, String codigo, String usuario, String contrasenia,
			String telefono, ProgramaAcademico miProgramaAcademico) throws EstudianteRepeatException {
		this.miUniversidad.agregarEstudiante(nombre, apellido, codigo, usuario, contrasenia, telefono,
				miProgramaAcademico);
	}
}