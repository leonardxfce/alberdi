package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelos.Envase;
import modelos.MovimientoEnvase;

import java.util.List;

public class VistaMovimiento extends VistaListadoPadre {
    private Label lbCantidad;
    private Label lbEnvase;
    private Label lbFecha;
    private ComboBox<String> listadoInsumos;
    private TextField cuadroCantidad;
    private Button btnAgregar;
    private Button btnQuitar;
    private Button btnCancelar;
    private VBox etiquetas;
    private VBox editado;
    private HBox botones;
    private HBox etiquetasEditado;
    private DatePicker datePicker;
    private ObservableList<String> idEnvases;
    private TableView <MovimientoEnvase> movimientos;
    TableColumn column0;
    TableColumn column1;
    TableColumn column2;


    public VistaMovimiento(List<Envase> envases) {
        super();
        idEnvases = FXCollections.observableArrayList();
        ObservableList<String> nombreEnvase = FXCollections.observableArrayList();
        for (int i = 0; i < envases.size(); i++) {
            String id = Integer.toString(envases.get(i).getId());
            String nombre = envases.get(i).getNombre() + " " + envases.get(i).getTipo() + " " + envases.get(i).getVolumen() + " " + envases.get(i).getDescripcion();
            idEnvases.add(id);
            nombreEnvase.add(nombre);
        }
        lbCantidad = new Label("Cantidad");
        lbEnvase = new Label("Envase");
        lbFecha = new Label("Fecha");
        cuadroCantidad = new TextField();
        listadoInsumos = new ComboBox<>();
        datePicker = new DatePicker();
        btnAgregar = new Button("Agregar");
        btnQuitar = new Button("Quitar");
        btnCancelar = new Button("Cancelar");
        etiquetas = new VBox(13);
        editado = new VBox(5);
        botones = new HBox(5);
        etiquetasEditado = new HBox(8);

        listadoInsumos.setItems(nombreEnvase);
        movimientos = new TableView<>();

    }

    //Getters
    public TextField getCuadroCantidad() {
        return this.cuadroCantidad;
    }

    public ComboBox<String> getListadoInsumos() {
        return this.listadoInsumos;
    }

    public DatePicker getDatePicker() {
        return this.datePicker;
    }

    public Button getBtnAgregar() {
        return this.btnAgregar;
    }

    public Button getBtnQuitar() {
        return this.btnQuitar;
    }

    public Button getBtnCancelar() {
        return this.btnCancelar;
    }

    public ObservableList<String> getIdEnvases() {
        return this.idEnvases;
    }

    public TableView getMovimientos() {
        return this.movimientos;
    }

    public void configTablaMovimientos(List<MovimientoEnvase> movimientoEnvases) {
        movimientos.getItems().clear();
        movimientos.getItems().addAll(movimientoEnvases);
        movimientos.getColumns().clear();
        column0 = crearColumnas("nombre");
        column1 = crearColumnas("cantidad");//Se envía el nombre del atributo.
        column2 = crearColumnas("fecha");
        movimientos.getColumns().addAll(column0, column1, column2);
    }

    public void config() {
        btnAgregar.setId("movimiento_agregar");
        btnQuitar.setId("movimiento_quitar");
        btnCancelar.setId("volver_menu");
        etiquetas.setMinWidth(50.0);
        etiquetas.setAlignment(Pos.CENTER_RIGHT);
        botones.setAlignment(Pos.CENTER_RIGHT);
        movimientos.setMinWidth(450);
        contenido.setSpacing(10);

        etiquetasEditado.setAlignment(Pos.CENTER);

        etiquetas.getChildren().addAll(lbCantidad, lbEnvase, lbFecha);
        botones.getChildren().addAll(btnAgregar, btnQuitar, btnCancelar);
        editado.getChildren().addAll(cuadroCantidad, listadoInsumos, datePicker);
        etiquetasEditado.getChildren().addAll(etiquetas, editado);
        contenido.getChildren().addAll(etiquetasEditado, botones, movimientos);
    }

}


