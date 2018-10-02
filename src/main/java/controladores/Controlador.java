package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelos.ModeloEnvase;
import org.apache.log4j.Logger;
import vistas.VistaLogin;
import vistas.VistaEnvase;
import vistas.VistaTapa;
import vistas.VistaMenu;

public class Controlador implements EventHandler<ActionEvent> {

    VistaEnvase vistaEnvase;
    VistaLogin vistaLogin;
    Logger logger;
    Stage stage;
    VistaTapa vistaTapa;
    VistaMenu menuIntermedioParaElegirFormulario;

    public Controlador(Stage primaryStage) {
        logger = Logger.getLogger(Controlador.class);
        stage = primaryStage;
        vistaEnvase = new VistaEnvase();
        vistaLogin = new VistaLogin();
        vistaTapa = new VistaTapa();
        menuIntermedioParaElegirFormulario = new VistaMenu();
        vistaEnvase.config();
        vistaLogin.config();
        vistaTapa.config();
        menuIntermedioParaElegirFormulario.config();
        vistaLogin.getBtnIngresar().setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnEnvase().setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnTapas().setOnAction(this);
        menuIntermedioParaElegirFormulario.getBtnCerrarSesion().setOnAction(this);
        vistaEnvase.getBtnGuardarEv().setOnAction(this);
        vistaEnvase.getBtnCancelar().setOnAction(this);
        vistaTapa.getBtnAceptar().setOnAction(this);
        vistaTapa.getBtnCancelar().setOnAction(this);

        stage.setTitle("Formulario Envase");
        stage.setScene(vistaLogin.getScene());
        stage.setResizable(false);
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
            case "Cargar Envase":
                stage.setScene(vistaEnvase.getScene());
                break;
            case "Cargar Tapa":
                stage.setScene(vistaTapa.getScene());
                break;
            case "Aceptar":
                stage.setScene(menuIntermedioParaElegirFormulario.getScene());
                break;
            case "Cancelar":
                stage.setScene(menuIntermedioParaElegirFormulario.getScene());
                break;
            case "Guardar Envase":
                //String nombre = vistaEnvase.textField.getText();
                ModeloEnvase modelo = new ModeloEnvase("A", "B", "C", 1);
                modelo.insert();
                break;

        }

    }

}
