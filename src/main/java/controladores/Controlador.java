package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelos.*;
import vistas.*;

import java.util.ArrayList;
import java.util.List;

public class Controlador implements EventHandler<ActionEvent> {

    Stage stage;
    //Vistas
    VistaTapa vistaTapa;
    VistaMenu vistaMenu;
    VistaEnvase vistaEnvase;
    VistaLogin vistaLogin;
    //Modelos
    ModeloEnvase modeloEnvase;
    ModeloLogin modeloLogin;
    ModeloTapa modeloTapa;
    VistaListadoEnvases vistaListadoEnvases;
    VistaListadoTapas vistaListadoTapas;

    public Controlador(Stage primaryStage) {

        stage = primaryStage;
        //Instancias de Vistas
        vistaEnvase = new VistaEnvase();
        vistaLogin = new VistaLogin();
        vistaTapa = new VistaTapa();
        vistaMenu = new VistaMenu();


        //Intancias de Modelos
        modeloEnvase = new ModeloEnvase();
        modeloTapa=new ModeloTapa();
        //Configuracion de las Vistas
        vistaEnvase.config();
        vistaLogin.config();
        vistaTapa.config();
        vistaMenu.config();
        //Alta de Botones de las Vistas
        vistaLogin.getBtnIngresar().setOnAction(this);
        vistaMenu.getBtnEnvase().setOnAction(this);
        vistaMenu.getBtnTapas().setOnAction(this);
        vistaMenu.getBtnListadoEnvases().setOnAction(this);
        vistaMenu.getBtnListadoTapas().setOnAction(this);
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
            case "menu_listarEnvases":
                listarEnvases();
                break;
            case "menu_listarTapas":
                List tapas;
                tapas = modeloTapa.darTodasLasTapas();
                vistaListadoTapas=new VistaListadoTapas(tapas);
                vistaListadoTapas.getBtnCerrarTabla().setOnAction(this);
                stage.setScene(vistaListadoTapas.getScene());
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
            case "volver_menu":
                stage.setScene(vistaMenu.getScene());

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
        vistaListadoEnvases.getBtnCerrarTabla().setOnAction(this);
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
