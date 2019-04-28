/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelos.Tapa;
import modelos.MovimientoTapa;

/**
 *
 * @author caro_
 */
public class VistaMovimientoTapa extends VistaListadoPadre{
    private Label lbCantidad;
    private Label lbTapa;
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
    private ObservableList<String> idTapas;
    private TableView <MovimientoTapa> movimientos;
    TableColumn column0;
    TableColumn column1;
    TableColumn column2;

    public VistaMovimientoTapa(List<Tapa> tapa) {
        super();
        idTapas = FXCollections.observableArrayList();
        ObservableList<String> nombreTapa = FXCollections.observableArrayList();
        for (int i = 0; i < tapa.size(); i++) {
            String id = Integer.toString(tapa.get(i).getIdTapa());
            String nombre = tapa.get(i).getNombre() + " " +  tapa.get(i).getDescripcion();
            idTapas.add(id);
            nombreTapa.add(nombre);
        }
        lbCantidad = new Label("Cantidad");
        lbTapa = new Label("Tapa");
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

        listadoInsumos.setItems(nombreTapa);
        movimientos = new TableView<>();

    }

    public ComboBox<String> getListadoInsumos() {
        return this.listadoInsumos;
    }

    public TextField getCuadroCantidad() {
        return this.cuadroCantidad;
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

    public DatePicker getDatePicker() {
        return this.datePicker;
    }

    public ObservableList<String> getIdTapas() {
        return this.idTapas;
    }

    public TableView<MovimientoTapa> getMovimientos() {
        return this.movimientos;
    }
    
    public void configTablaMovimientos(List<MovimientoTapa> movimientoTapas) {
        movimientos.getItems().clear();
        movimientos.getItems().addAll(movimientoTapas);
        movimientos.getColumns().clear();
        column0 = crearColumnas("nombre");
        column1 = crearColumnas("cantidad");//Se envía el nombre del atributo.
        column2 = crearColumnas("fecha");
        movimientos.getColumns().addAll(column0, column1, column2);
    }
    public void config() {
        btnAgregar.setId("movimientoTapa_agregar");
        btnQuitar.setId("movimientoTapa_quitar");
        btnCancelar.setId("volverTapa_menu");
        etiquetas.setMinWidth(50.0);
        etiquetas.setAlignment(Pos.CENTER_RIGHT);
        botones.setAlignment(Pos.CENTER_RIGHT);
        movimientos.setMinWidth(450);
        contenido.setSpacing(10);
        etiquetasEditado.setAlignment(Pos.CENTER);
        etiquetas.getChildren().addAll(lbCantidad, lbTapa, lbFecha);
        botones.getChildren().addAll(btnAgregar, btnQuitar, btnCancelar);
        editado.getChildren().addAll(cuadroCantidad, listadoInsumos, datePicker);
        etiquetasEditado.getChildren().addAll(etiquetas, editado);
        contenido.getChildren().addAll(etiquetasEditado, botones, movimientos);
    }
}
