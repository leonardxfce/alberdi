package controladores;

import javafx.scene.image.Image;
import utilidades.Validador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelos.*;
import vistas.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import principal.ManejadorProperties;
import utilidades.Exportar;
import vistas.VistaListadoEnvases;


public class Controlador implements EventHandler<ActionEvent> {

    Stage stage;
    //Vistas
    VistaTapa vistaTapa;
    VistaMenu vistaMenu;
    VistaEnvase vistaEnvase;
    VistaLogin vistaLogin;
    VistaMovimiento vistaMovimiento;
    //Modelos
    ModeloEnvase modeloEnvase;
    ModeloLogin modeloLogin;
    ModeloTapa modeloTapa;
    ManejadorProperties ManejadorProperties;
    VistaListadoEnvases vistaListadoEnvases;
    VistaListadoTapas vistaListadoTapas;
    VentanaPopUp msjPopUp;
    Validador validador;
    Exportar exportar;
    ModeloMovimientoEnvase modeloMovimientoEnvase;
    static final int AGREGAR=1;//variable que se utilizara como indicador para agregar en el metodo agregarQuitar
    static final int QUITAR=-1;//variable que se utilizara como indicador para quitar en el metodo agregarQuitar
    static final String CARGACORRECTA="Los datos se han cargado correctamente.";

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
        stage.getIcons().add(new Image("/ies.png"));
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
        modeloMovimientoEnvase = new ModeloMovimientoEnvase();
        //Configuracion de las Vistas
        vistaEnvase.config();
        vistaLogin.config();
        vistaTapa.config();
        vistaMenu.config();
        //Alta de Botones de las Vistas
        vistaLogin.getBtnIngresar().setOnAction(this);
        vistaLogin.getBtnIngresar().setDefaultButton(true); //Responde a ENTER el BtnIngresar
        vistaMenu.getBtnEnvase().setOnAction(this);
        vistaMenu.getBtnTapas().setOnAction(this);
        vistaMenu.getBtnListadoEnvases().setOnAction(this);
        vistaMenu.getBtnListadoTapas().setOnAction(this);
        vistaMenu.getBtnCerrarSesion().setOnAction(this);
        vistaMenu.getBtnMovimientos().setOnAction(this);
        vistaEnvase.getBtnGuardarEv().setOnAction(this);
        vistaEnvase.getBtnCancelar().setOnAction(this);
        vistaEnvase.getBtnModificar().setOnAction(this);
        vistaTapa.getBtnAceptar().setOnAction(this);
        vistaTapa.getBtnCancelar().setOnAction(this);
        vistaTapa.getBtnModificar().setOnAction(this);
        vistaMenu.getBtnExportar().setOnAction(this);
        //Instanciamos la clase ManejadorProperties
        ManejadorProperties propiedades = new ManejadorProperties(1);
        stage.setTitle(propiedades.leerPropiedad("titulo"));
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
                break;
            case "movimiento":
                movimientoEnvase();
                break;
            case "movimiento_agregar":
                movimientoAgregar();
                break;
            case "movimiento_quitar":
                movimientoQuitar();
        }
    }

    String letras = "Los campos deben ser completados sólo con letras";

    public void movimientoEnvase(){
        vistaMovimiento = new VistaMovimiento(modeloEnvase.darTodosLosEnvases());
        vistaMovimiento.configTablaMovimientos(modeloMovimientoEnvase.darTodosLosMovimientosConNombre());
        vistaMovimiento.config();
        vistaMovimiento.getBtnAgregar().setOnAction(this);
        vistaMovimiento.getBtnQuitar().setOnAction(this);
        vistaMovimiento.getBtnCancelar().setOnAction(this);
        stage.setScene(vistaMovimiento.getScene());
    }
    
    public void loginIngresar() {
        Usuario usuario = new Usuario(vistaLogin.getTxUsuario().getText(),vistaLogin.getTxContrasena().getText());
        boolean resultado = modeloLogin.comprobarExistencia(usuario);
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
        boolean validarVacio = validador.validarEnvase(envase);
        if (!validarVacio) {
            msjPopUp.display("Los campos se encuentran vacíos");
        } else {
            
            if (!modeloEnvase.repetido(envase)) {
                modeloEnvase.guardarEnvaseNuevo(envase);
                msjPopUp.display("Se guardaron los datos.");
            } else {
                msjPopUp.display("Los datos estan repetidos.");
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
        boolean validarVacio = validador.validarTapa(tapa);
        if (!validarVacio) {
            msjPopUp.display("Los campos se encuentran vacios");
        } else {
            
            if (modeloTapa.repetido(tapa)) {
                msjPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
            } else {
                modeloTapa.insert(tapa);
                msjPopUp.display(CARGACORRECTA);
                vistaTapa.getTxTipo().clear();
                vistaTapa.getTxDescripcion().clear();
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
        boolean validar = validador.validarEnvase(envase);
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacíos");
        } else {
            
            if (!modeloEnvase.repetido(envase)) {
                modeloEnvase.modificarEnvase(envase);
                msjPopUp.display("Se modificaron los datos.");
                stage.setScene(vistaMenu.getScene());
            } else {
                msjPopUp.display("Los datos estan repetidos.");
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
        boolean validar = validador.validarTapa(tapa);
        if (!validar) {
            msjPopUp.display("Los campos se encuentran vacios");
        } else {
            if (modeloTapa.repetido(tapa)) {
                    msjPopUp.display("Los datos que intenta cargar ya estan en la base de datos.");
            } else {
                modeloTapa.modificarTapa(tapa);
                msjPopUp.display(CARGACORRECTA);
                vistaTapa.getTxTipo().clear();
                vistaTapa.getTxDescripcion().clear();
                stage.setScene(vistaMenu.getScene());
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
    //metodo encargado crear un nuevo Movimiento, con las cantidades para agregar o quitar, dependiendo si la variable es 1 o -1 respectivamente
    public MovimientoEnvase agregarQuitar(int variable) {
        int cantidadInsumo = (Integer.parseInt(vistaMovimiento.getCuadroCantidad().getText())) * variable; //toma el valor del TextField, lo castea a int y lo multiplica,por 1 si se agregan cantidades, o por -1 para quitar cantidades y que este quede con valor negativo
        int indiceSeleccionado = vistaMovimiento.getListadoInsumos().getSelectionModel().getSelectedIndex();//se toma el indice del la opcion seleccionada del ComboBox
        LocalDate date = vistaMovimiento.getDatePicker().getValue(); //Se coloca en un LocalDate la fecha seleccionada del DataPicker
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//Se configura el formato de la fecha
        String fecha = (date).format(formatter);//se le coloca el formato a la fecha, y lo pasa a un String
        int idIndice = Integer.parseInt(vistaMovimiento.getIdEnvases().get(indiceSeleccionado));//busca el contenido que hay en la observable list que tiene los IDs de los envases, dependiendo del indice de la opcion que se selecciono en el ComboBox y lo castea a int

        return new MovimientoEnvase(idIndice, cantidadInsumo, fecha);
    }

    public void movimientoAgregar(){
        if (validador.validarMovimiento(vistaMovimiento.getCuadroCantidad().getText(),
                vistaMovimiento.getListadoInsumos().getSelectionModel().getSelectedIndex(),
                vistaMovimiento.getDatePicker().getValue())) {
                MovimientoEnvase movimientoEnvase = agregarQuitar(AGREGAR);
                modeloMovimientoEnvase.insertarMovimiento(movimientoEnvase);
                vistaMovimiento.configTablaMovimientos(modeloMovimientoEnvase.darTodosLosMovimientosConNombre());
                msjPopUp.display(CARGACORRECTA);
                limpiaCamposVentanaMovimiento();
        } else {
            msjPopUp.display("Por favor, complete todos los campos");
        }
    }

    public void movimientoQuitar(){
        if (validador.validarMovimiento(vistaMovimiento.getCuadroCantidad().getText(),
                vistaMovimiento.getListadoInsumos().getSelectionModel().getSelectedIndex(),
                vistaMovimiento.getDatePicker().getValue())) {
                MovimientoEnvase movimientoEnvase = agregarQuitar(QUITAR);
                modeloMovimientoEnvase.insertarMovimiento(movimientoEnvase);
                vistaMovimiento.configTablaMovimientos(modeloMovimientoEnvase.darTodosLosMovimientosConNombre());
                msjPopUp.display(CARGACORRECTA);
                limpiaCamposVentanaMovimiento();
        } else {
            msjPopUp.display("Por favor, complete todos los campos");
        }
    }

    public void limpiaCamposVentanaMovimiento(){
        vistaMovimiento.getCuadroCantidad().clear();
        vistaMovimiento.getListadoInsumos().getSelectionModel().clearSelection();
        vistaMovimiento.getDatePicker().setValue(null);
    }
}
