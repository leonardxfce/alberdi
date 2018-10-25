package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelos.ModeloEnvase;
import modelos.ModeloLogin;
import vistas.VistaLogin;
import vistas.VistaEnvase;
import vistas.VistaTapa;
import vistas.VistaMenu;

import java.util.ArrayList;
import java.util.List;
import modelos.Envase;
import modelos.ModeloTapa;
import modelos.Tapa;
import vistas.VentanaPopUp;
import vistas.VistaListadoEnvases;

public class Controlador implements EventHandler<ActionEvent> {

    Stage stage;
    //Vistas
    VistaTapa vistaTapa;
    VistaMenu vistaMenu;
    VistaEnvase vistaEnvase;
    VistaLogin vistaLogin;
    //Modelos
    ModeloEnvase modeloEnvase;
    ModeloTapa modeloTapa;
    ModeloLogin modeloLogin;
    VistaListadoEnvases vistaListadoEnvases;

    public Controlador(Stage primaryStage) {

        stage = primaryStage;
        //Instancias de Vistas
        vistaEnvase = new VistaEnvase();
        vistaLogin = new VistaLogin();
        vistaTapa = new VistaTapa();
        vistaMenu = new VistaMenu();

        //Intancias de Modelos
        modeloEnvase = new ModeloEnvase();
        modeloTapa = new ModeloTapa();
        //modeloLogin=new ModeloLogin();
        //Configuracion de las Vistas
        vistaEnvase.config();
        vistaLogin.config();
        vistaTapa.config();
        vistaMenu.config();
        //Activacion de Botones de las Vistas
        vistaLogin.getBtnIngresar().setOnAction(this);
        vistaMenu.getBtnEnvase().setOnAction(this);
        vistaMenu.getBtnTapas().setOnAction(this);
        vistaMenu.getBtnCerrarSesion().setOnAction(this);
        vistaEnvase.getBtnGuardarEv().setOnAction(this);
        vistaEnvase.getBtnCancelar().setOnAction(this);
        vistaTapa.getBtnAceptar().setOnAction(this);
        vistaTapa.getBtnCancelar().setOnAction(this);

        stage.setTitle("Sistema Alberdi");
        stage.setScene(vistaLogin.getScene());
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        Button botonSeleccionado = (Button) event.getSource();
        String botonID = botonSeleccionado.getId();
        switch (botonID) {
            case "login_ingresar":
                loginIngresar();
                break;
            case "menu_envase":
                menuEnvase();

                break;
            case "menu_tapa":
                menuTapa();
                break;
            case "menu_cerrarSesion":
                menuCerrarSesion();
                break;
            case "listar_envase":
                listarEnvases();
                break;
            case "envase_guardar":
                envaseGuardar();
                break;
            case "envase_cancelar":
                envaseCancelar();
                break;
            case "tapa_guardar":
                tapaGuardar();
                break;
            case "tapa_cancelar":
                tapaCancelar();
                break;

        }

    }

    public void loginIngresar() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add(vistaLogin.getTxUsuario().getText());
        atributosLogin.add(vistaLogin.getTxContrasena().getText());
        //modeloLogin.confirmar(atributosLogin);
        stage.setScene(vistaMenu.getScene());

    }

    public void menuEnvase() {
        stage.setScene(vistaEnvase.getScene());
    }

    public void menuTapa() {
        stage.setScene(vistaTapa.getScene());
    }

    public void menuCerrarSesion() {
        stage.setScene(vistaLogin.getScene());
    }

    public void listarEnvases() {
        List envases;
        envases = modeloEnvase.darTodosLosEnvases();
        vistaListadoEnvases = new VistaListadoEnvases(envases);
        stage.setScene(vistaListadoEnvases.getScene());
    }

    public void envaseGuardar() {
        Envase envase = new Envase();
        envase.setNombre(vistaEnvase.getTextNombre().getText().toUpperCase());
        envase.setTipo(vistaEnvase.getTextTipo().getText().toUpperCase());
        if (vistaEnvase.getTextVol().getText().equals("")) {
            envase.setVolumen(0);
        } else {
            envase.setVolumen(Integer.parseInt(vistaEnvase.getTextVol().getText()));
        }
        envase.setDescripcion(vistaEnvase.getTextDescrip().getText().toUpperCase());
        if (!modeloEnvase.repetido(envase)) {
            modeloEnvase.guardarEnvaseNuevo(envase);
            VentanaPopUp.display("Se guardaron los datos.");
        } else {
            VentanaPopUp.display("Los datos estan repetidos.");
        }
        vistaEnvase.getTextNombre().clear();
        vistaEnvase.getTextTipo().clear();
        vistaEnvase.getTextVol().clear();
        vistaEnvase.getTextDescrip().clear();
    }

    public void envaseCancelar() {
        stage.setScene(vistaMenu.getScene());
    }

    public void tapaGuardar() {
        Tapa tapa = new Tapa(vistaTapa.getTxTipo().getText(), vistaTapa.getTxDescripcion().getText());
        if (modeloTapa.repetido(tapa)) {
            VentanaPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
        } else {
            modeloTapa.insert(tapa);
            VentanaPopUp.display("Los datos se han cargado correctamente.");
            vistaTapa.getTxTipo().clear();
            vistaTapa.getTxDescripcion().clear();
        }
    }

    public void tapaCancelar() {
        stage.setScene(vistaMenu.getScene());
    }
    public void configurarForm(int id){
        //Acá deberíamos conectarnos a la base de datos
        modeloEnvase.darUno(id);
        Envase env = new Envase();
        vistaEnvase.prepararFormulario(env);
        stage.setScene(vistaEnvase.getScene());
    }
}
