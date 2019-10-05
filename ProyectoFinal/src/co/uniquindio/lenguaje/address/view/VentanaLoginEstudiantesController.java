package co.uniquindio.lenguaje.address.view;

import co.uniquindio.lenguaje.address.model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class VentanaLoginEstudiantesController 
{
    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contraseniaField;
    private PrincipalEstudiantesOverviewController ventanaPrincipal;

    @FXML
    void handleIngresarButton() {
    	if(isInputValid())
    	{
    		Estudiante miEstudiante = ventanaPrincipal.getMiPrincipal().obtenerEstudiante(usuarioField.getText());
    		usuarioField.setText("");
    		contraseniaField.setText("");
    		ventanaPrincipal.cargarVentanaEstudiantes(miEstudiante);
    	}
    }

    @FXML
    void handleSalirButton() 
    {
    	this.ventanaPrincipal.salir();
    }

    @FXML
    void initialize() 
    {
    	

    }

	public PrincipalEstudiantesOverviewController getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(PrincipalEstudiantesOverviewController ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	public boolean isInputValid()
	{
		boolean centinela = false;
		String mensajeDeError = "";
		if(usuarioField.getText()==null||usuarioField.getText().length()==0)
		{
			mensajeDeError += "Usuario no permitido\n";
		}
		else
		{
			if(ventanaPrincipal.getMiPrincipal().obtenerPosEstudiante(usuarioField.getText())==-1)
			{
				mensajeDeError += "El estudiante con codigo: "+usuarioField.getText()+" no existe\n";
			}
		}
		if(contraseniaField.getText()==null||contraseniaField.getText().length()==0)
		{
			mensajeDeError += "Contraseña no permitida\n"; 
		}
		else
		{
			if(ventanaPrincipal.getMiPrincipal().obtenerPosEstudiante(usuarioField.getText())!=-1)
			{
				if(!isContraseniaOK())
				{
					mensajeDeError += "Las contraseñas no coinciden\n";
				}
			}
		}
		if(mensajeDeError.length() == 0)
		{
			centinela = true;
		}
		else
		{
			this.ventanaPrincipal.getMiPrincipal().mostrarAlerta(mensajeDeError, "", "Advertencia", ventanaPrincipal.getMiStage(), AlertType.WARNING);
		}
		return centinela;
	}
	public boolean isContraseniaOK()
	{
		boolean centinela = true;
		if(ventanaPrincipal.getMiPrincipal().obtenerPosEstudiante(usuarioField.getText())!=-1)
		{
			Estudiante miEstudiante = ventanaPrincipal.getMiPrincipal().obtenerEstudiante(usuarioField.getText());
			char[] contrasenia = miEstudiante.getContrasenia().toCharArray();
			char[] contraseniaIngresada = contraseniaField.getText().toCharArray();
			if(contrasenia.length==contraseniaIngresada.length)
			{
				for (int i = 0; i < contraseniaIngresada.length&&centinela; i++) 
				{
					if(contrasenia[i]!=contraseniaIngresada[i])
						centinela = false;
				}
			}
		}
		else
		{
			centinela = false;
		}
		return centinela;
	}
}