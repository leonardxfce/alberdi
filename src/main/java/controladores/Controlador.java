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

    public Controlador(Stage primaryStage) {

        stage = primaryStage;
        //Instancias de Vistas
        vistaEnvase = new VistaEnvase();
        vistaLogin = new VistaLogin();
        vistaTapa = new VistaTapa();
        vistaMenu = new VistaMenu();
        //Intancias de Modelos
        modeloEnvase=new ModeloEnvase();
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
                ArrayList<String> atributosLogin=new ArrayList<>();
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
            case "envase_guardar":
                ArrayList<String> atributosEnvase = new ArrayList<>();
                atributosEnvase.add(vistaEnvase.getTextNombre().getText());
                atributosEnvase.add(vistaEnvase.getTextTipo().getText());
                atributosEnvase.add(vistaEnvase.getTextVol().getText());
                atributosEnvase.add(vistaEnvase.getTextDescrip().getText());
                System.out.println(atributosEnvase);
                if(!modeloEnvase.repetido(atributosEnvase)){
                    modeloEnvase.guardarEnvaseNuevo(atributosEnvase);
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
                ArrayList<String> atributosTapa = new ArrayList<>();
                atributosTapa.add(vistaTapa.getTxTipo().getText());
                atributosTapa.add(vistaTapa.getTxDescripcion().getText());
               // modeloTapa.repetido(atributosTapa);
                vistaTapa.getTxTipo().clear();
                vistaTapa.getTxDescripcion().clear();
                break;
            case "tapa_cancelar":
                stage.setScene(vistaMenu.getScene());
                break;

        }

    }

}
