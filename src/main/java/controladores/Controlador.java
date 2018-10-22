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
                ArrayList<String> atributosLogin = new ArrayList<>();
                atributosLogin.add(vistaLogin.getTxUsuario().getText());
                atributosLogin.add(vistaLogin.getTxContrasena().getText());
                //modeloLogin.confirmar(atributosLogin);
                stage.setScene(vistaMenu.getScene());
                break;
            case "menu_envase":
                stage.setScene(vistaEnvase.getScene());
                break;
            case "menu_tapa":
                stage.setScene(vistaTapa.getScene());
                break;
            case "menu_cerrarSesion":
                stage.setScene(vistaLogin.getScene());
                break;
            case "listar_envase":
                List envases;
                envases = modeloEnvase.darTodosLosEnvases();
                vistaListadoEnvases = new VistaListadoEnvases(envases);
                stage.setScene(vistaListadoEnvases.getScene());
                break;
            case "envase_guardar":
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
                break;
            case "envase_cancelar":
                stage.setScene(vistaMenu.getScene());
                break;
            case "tapa_guardar":
                TapaGuardar();
                break;
            case "tapa_cancelar":
                TapaCancelar();
                break;

        }

    }

    public void TapaGuardar() {
        Tapa tapa = new Tapa(vistaTapa.getTxTipo().getText(), vistaTapa.getTxDescripcion().getText());
        if (modeloTapa.repetido(tapa)) {
            VentanaPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
        } else {
            try {
                modeloTapa.insert(tapa);
                VentanaPopUp.display("Los datos se han cargado correctamente.");
                vistaTapa.getTxTipo().clear();
                vistaTapa.getTxDescripcion().clear();
            } catch (Exception e) {
                VentanaPopUp.display("Ups, ocurrio un error.");
            }
        }
    }
    
    public void TapaCancelar() {
        stage.setScene(vistaMenu.getScene());
    }
}
