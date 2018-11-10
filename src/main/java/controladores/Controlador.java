package controladores;

import utilidades.Validador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelos.*;
import vistas.*;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.swing.JOptionPane;

import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import modelos.Envase;
import modelos.ModeloTapa;
import modelos.Tapa;
import utilidades.Exportar;
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
    ModeloLogin modeloLogin;
    ModeloTapa modeloTapa;
    VistaListadoEnvases vistaListadoEnvases;
    VistaListadoTapas vistaListadoTapas;
    VentanaPopUp msjPopUp;
    Validador validador;
    Exportar exportar;

    public Controlador(Stage primaryStage) {

        stage = primaryStage;

        primaryStage.setOnCloseRequest(evt -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Está seguro que desea salir?", ButtonType.YES, ButtonType.NO);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);

            if (ButtonType.NO.equals(result)) {
                // no choice or no clicked -> don't close
                evt.consume();
            }
        });
        //Instancias de Vistas
        vistaEnvase = new VistaEnvase();
        vistaLogin = new VistaLogin();
        vistaTapa = new VistaTapa();
        vistaMenu = new VistaMenu();

        validador = new Validador();
        exportar = new Exportar();

        //Intancias de Modelos
        modeloEnvase = new ModeloEnvase();
        modeloTapa = new ModeloTapa();
        modeloLogin = new ModeloLogin();
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
        vistaEnvase.getBtnModificar().setOnAction(this);
        vistaTapa.getBtnAceptar().setOnAction(this);
        vistaTapa.getBtnCancelar().setOnAction(this);
        vistaTapa.getBtnModificar().setOnAction(this);
        
        vistaMenu.getBtnExportar().setOnAction(this);

        stage.setTitle("Sistema Alberdi");
        stage.setScene(vistaLogin.getScene());
        stage.setResizable(false);
        stage.show();

        msjPopUp = new VentanaPopUp();
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
            case "exportar_dato":
                exportar.exportarDatos();
                break;
            case "envase_modificar":
                modificarEnv();
                break;
            case "menu_listarTapas":
                listarTapas();
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
            case "tapa_modificar":
                modificarTapa();
                break;
            case "tapa_cancelar":
                tapaCancelar();
                break;
            case "volver_menu":
                stage.setScene(vistaMenu.getScene());

        }

    }
    String letras = "Los campos deben ser completados sólo con letras";
    public void loginIngresar() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add(vistaLogin.getTxUsuario().getText());
        atributosLogin.add(vistaLogin.getTxContrasena().getText());

        boolean resultado = modeloLogin.comprobarExistencia(atributosLogin);
        if (resultado) {
            stage.setScene(vistaMenu.getScene());
        } else {
            JOptionPane.showMessageDialog(null, "El Usuario ingresado no existe", "Error de petición", JOptionPane.ERROR_MESSAGE);
        }


    }

    public void menuEnvase() {
        vistaEnvase.mostrarBotones();
        stage.setScene(vistaEnvase.getScene());
    }

    public void menuTapa() {
        vistaTapa.mostrarBotones();
        stage.setScene(vistaTapa.getScene());
    }

    public void menuCerrarSesion() {
        stage.setScene(vistaLogin.getScene());
        vistaLogin.getTxUsuario().clear();
        vistaLogin.getTxContrasena().clear();
    }

    public void listarEnvases() {
        List envases;
        envases = modeloEnvase.darTodosLosEnvases();
        vistaListadoEnvases = new VistaListadoEnvases(envases);
        modificarTabla();
        vistaListadoEnvases.getBtnCerrarTabla().setOnAction(this);
        stage.setScene(vistaListadoEnvases.getScene());
    }

    public void listarTapas() {
        List tapas;
        tapas = modeloTapa.darTodasLasTapas();
        vistaListadoTapas = new VistaListadoTapas(tapas);
        modificarTablaTapa();
        vistaListadoTapas.getBtnCerrarTabla().setOnAction(this);
        stage.setScene(vistaListadoTapas.getScene());
    }

    public void envaseGuardar() {
        Envase envase = new Envase();
        envase.setNombre(vistaEnvase.getTextNombre().getText().toUpperCase().trim());
        envase.setTipo(vistaEnvase.getTextTipo().getText().toUpperCase().trim());
        if (vistaEnvase.getTextVol().getText().equals("")) {
            envase.setVolumen(0);
        } else {
            envase.setVolumen(Integer.parseInt(vistaEnvase.getTextVol().getText().trim()));
        }
        envase.setDescripcion(vistaEnvase.getTextDescrip().getText().toUpperCase().trim());
        boolean validar = validador.validarEnvase(envase.getNombre(), envase.getTipo(), envase.getDescripcion());
        boolean validarLetras = validador.validarLetrasEnvase(envase.getNombre(), envase.getTipo(), envase.getDescripcion());
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacíos");
        } else {
            if (!validarLetras) {
                msjPopUp.display(letras);
            } else {
                if (!modeloEnvase.repetido(envase)) {
                    modeloEnvase.guardarEnvaseNuevo(envase);
                    msjPopUp.display("Se guardaron los datos.");
                } else {
                    msjPopUp.display("Los datos estan repetidos.");
                }
            }
        }

        vistaEnvase.getTextNombre().clear();
        vistaEnvase.getTextTipo().clear();
        vistaEnvase.getTextVol().clear();
        vistaEnvase.getTextDescrip().clear();
    }

    public void envaseCancelar() {
        stage.setScene(vistaMenu.getScene());
        vistaEnvase.getTextNombre().clear();
        vistaEnvase.getTextTipo().clear();
        vistaEnvase.getTextVol().clear();
        vistaEnvase.getTextDescrip().clear();
    }

    public void tapaGuardar() {
        Tapa tapa = new Tapa(vistaTapa.getTxTipo().getText().trim(), vistaTapa.getTxDescripcion().getText().trim());
        boolean validar = validador.validarTapa(tapa.getNombre(), tapa.getDescripcion());
        boolean validarLetras = validador.validarLetrasTapa(tapa.getDescripcion());
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacios");
        } else {
            if (!validarLetras) {
                msjPopUp.display(letras);
            } else {
                if (modeloTapa.repetido(tapa)) {
                    msjPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
                } else {
                    modeloTapa.insert(tapa);
                    msjPopUp.display("Los datos se han cargado correctamente.");
                    vistaTapa.getTxTipo().clear();
                    vistaTapa.getTxDescripcion().clear();
                }
            }
        }
    }

    public void tapaCancelar() {
        stage.setScene(vistaMenu.getScene());
        vistaTapa.getTxTipo().clear();
        vistaTapa.getTxDescripcion().clear();
    }

    public void modificarEnv() {
        Envase envase = new Envase();
        envase.setId(Integer.parseInt(vistaEnvase.getTextId().getText().trim()));
        envase.setNombre(vistaEnvase.getTextNombre().getText().toUpperCase().trim());
        envase.setTipo(vistaEnvase.getTextTipo().getText().toUpperCase().trim());
        if (vistaEnvase.getTextVol().getText().equals("")) {
            envase.setVolumen(0);
        } else {
            envase.setVolumen(Integer.parseInt(vistaEnvase.getTextVol().getText().trim()));
        }
        envase.setDescripcion(vistaEnvase.getTextDescrip().getText().toUpperCase().trim());
        boolean validar = validador.validarEnvase(envase.getNombre(), envase.getTipo(), envase.getDescripcion());
        boolean validarLetras = validador.validarLetrasEnvase(envase.getNombre(), envase.getTipo(), envase.getDescripcion());
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacíos");
        } else {
            if (!validarLetras) {
                msjPopUp.display(letras);
            } else {
                if (!modeloEnvase.repetido(envase)) {
                    modeloEnvase.modificarEnvase(envase);
                    msjPopUp.display("Se modificaron los datos.");
                    stage.setScene(vistaMenu.getScene());
                } else {
                    msjPopUp.display("Los datos estan repetidos.");
                }
            }
        }
        vistaEnvase.getTextNombre().clear();
        vistaEnvase.getTextTipo().clear();
        vistaEnvase.getTextVol().clear();
        vistaEnvase.getTextDescrip().clear();

    }

    public void modificarTabla() {
        vistaListadoEnvases.getTableView().setRowFactory(e -> {
            TableRow row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    TableView.TableViewSelectionModel<Envase> sm = vistaListadoEnvases.getTableView().getSelectionModel();
                    int indice = sm.getSelectedIndex();
                    Integer id = new Integer(vistaListadoEnvases.getColumn0().getCellObservableValue(indice).getValue().toString().trim());
                    String nombre = vistaListadoEnvases.getColumn1().getCellObservableValue(indice).getValue().toString().trim();
                    String tipo = vistaListadoEnvases.getColumn2().getCellObservableValue(indice).getValue().toString().trim();
                    Integer volumen = new Integer(vistaListadoEnvases.getColumn3().getCellObservableValue(indice).getValue().toString().trim());
                    String descripcion = vistaListadoEnvases.getColumn4().getCellObservableValue(indice).getValue().toString().trim();
                    Envase env = new Envase(id, nombre, tipo, volumen, descripcion);
                    vistaEnvase.prepararFormulario(env);
                    stage.setScene(vistaEnvase.getScene());
                }
            });
            return row;
        });
    }

    public void modificarTapa() {
        Integer id = new Integer(vistaTapa.getTxId().getText().trim());
        Tapa tapa = new Tapa(id, vistaTapa.getTxTipo().getText().trim(), vistaTapa.getTxDescripcion().getText().trim());
        boolean validar = validador.validarTapa(tapa.getNombre(), tapa.getDescripcion());
        boolean validarLetras = validador.validarLetrasTapa(tapa.getDescripcion());
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacios");
        } else {
            if (!validarLetras) {
                msjPopUp.display(letras);
            } else {
                if (modeloTapa.repetido(tapa)) {
                    msjPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
                } else {
                    modeloTapa.modificarTapa(tapa);
                    msjPopUp.display("Los datos se han cargado correctamente.");
                    vistaTapa.getTxTipo().clear();
                    vistaTapa.getTxDescripcion().clear();
                    stage.setScene(vistaMenu.getScene());
                }
            }
        }
        vistaTapa.getTxTipo().clear();
        vistaTapa.getTxDescripcion().clear();
    }

    public void modificarTablaTapa() {
        vistaListadoTapas.getTableView().setRowFactory(e -> {
            TableRow row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    TableView.TableViewSelectionModel<Tapa> sm = vistaListadoTapas.getTableView().getSelectionModel();
                    int indice = sm.getSelectedIndex();
                    Integer id = new Integer(vistaListadoTapas.getColumn0().getCellObservableValue(indice).getValue().toString().trim());
                    String nombre = vistaListadoTapas.getColumn1().getCellObservableValue(indice).getValue().toString().trim();
                    String descripcion = vistaListadoTapas.getColumn2().getCellObservableValue(indice).getValue().toString().trim();
                    Tapa tapa = new Tapa(id, nombre, descripcion);
                    vistaTapa.prepararFormulario(tapa);
                    stage.setScene(vistaTapa.getScene());
                }
            });
            return row;
        });
    }
}
