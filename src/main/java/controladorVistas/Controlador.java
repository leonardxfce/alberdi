package controladorVistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modeloSQL_Envase.Envase_Modelo;
import org.apache.log4j.Logger;
import vistas.Login;
import vistas.VistaEnvase;
import vistas.VistaTapa;
import vistas.vistaMenu;

public class Controlador implements EventHandler<ActionEvent> {

    VistaEnvase vistaEnvase;
    Login vistaLogin;
    Logger logger;
    Stage stage;
    VistaTapa vistaTapa;
    vistaMenu menuIntermedioParaElegirFormulario;

    Controlador(Stage primaryStage) {
        logger = Logger.getLogger(Controlador.class);
        stage = primaryStage;
        vistaEnvase = new VistaEnvase();
        vistaLogin = new Login();
        vistaTapa = new VistaTapa();
        menuIntermedioParaElegirFormulario = new vistaMenu();
        vistaEnvase.config();
        vistaLogin.config();
        vistaTapa.config();
        menuIntermedioParaElegirFormulario.config();
        vistaLogin.btnIngresar.setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnEnvase().setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnTapas().setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnCerrarSesion().setOnAction(this);
        vistaEnvase.getAceptar().setOnAction(this);
        vistaEnvase.getCancelar().setOnAction(this);
        vistaTapa.getBtnAceptar().setOnAction(this);
        vistaTapa.getBtnCancelar().setOnAction(this);
        stage.setTitle("Formulario Envase");
        stage.setScene(vistaLogin.getScene());
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        Button botonSeleccionado = (Button) event.getSource();
        String dato = event.getClass().toString();

        String textoDelBoton = botonSeleccionado.getText();
        switch (textoDelBoton) {
            case "Ingresar":
                //   String usuario = vistaLogin.usuario_campo.getText();
                // String contrasena = vistaLogin.contrasena_campo.getText();
                // ModeloLogin mL = new ModeloLogin(usuario,contrasena);
                //mL.insertar();
                stage.setScene(menuIntermedioParaElegirFormulario.getScene());
                break;
            case "Cerrar Sesion":
                stage.setScene(vistaLogin.getScene());
                break;
            case "Formulario Envase":
                stage.setScene(vistaEnvase.getScene());
                break;
            case "Formulario Tapa":
                stage.setScene(vistaTapa.getScene());
                break;
            case "Aceptar":
                stage.setScene(menuIntermedioParaElegirFormulario.getScene());
                break;
            case "Cancelar":
                stage.setScene(menuIntermedioParaElegirFormulario.getScene());
                break;
            case "Guardar Envase":
                String nombre = vistaEnvase.textField.getText();
                Envase_Modelo modelo = new Envase_Modelo("A", "B", "C", 1);
                modelo.insert();
                break;

        }

    }

}
