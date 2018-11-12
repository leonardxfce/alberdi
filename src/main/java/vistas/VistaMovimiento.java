package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import modelos.Envase;
import java.util.List;

public class VistaMovimiento extends VistaPadre {
    private ComboBox<String> listadoInsumos;
    private TextField cuadroCantidad;
    private Button btnAgregar;
    private Button btnQuitar;
    private Button btnCancelar;
    private HBox editado;
    private HBox botones;
    private DatePicker datePicker;
    private ObservableList<String> idEnvases;


    public VistaMovimiento(List<Envase> envases) {
        idEnvases = FXCollections.observableArrayList();
        ObservableList<String> nombreEnvase = FXCollections.observableArrayList();
        for (int i = 0; i < envases.size(); i++) {
            String id = Integer.toString(envases.get(i).getId());
            String nombre = envases.get(i).getNombre() + " " + envases.get(i).getTipo() + " " + envases.get(i).getVolumen();
            idEnvases.add(id);
            nombreEnvase.add(nombre);
        }

        cuadroCantidad = new TextField();
        listadoInsumos = new ComboBox<>();
        datePicker = new DatePicker();
        btnAgregar = new Button("Agregar");
        btnQuitar = new Button("Quitar");
        btnCancelar = new Button("Cancelar");
        editado = new HBox(5);
        botones = new HBox(3);

        cuadroCantidad.setPrefWidth(50);
        listadoInsumos.setItems(nombreEnvase);
        btnAgregar.setId("movimiento_agregar");
        btnQuitar.setId("movimiento_quitar");
        btnCancelar.setId("volver_menu");
        botones.setAlignment(Pos.TOP_RIGHT);
        contenido.setSpacing(5);

        botones.getChildren().addAll(btnAgregar, btnQuitar, btnCancelar);
        editado.getChildren().addAll(cuadroCantidad, listadoInsumos, datePicker);
        contenido.getChildren().addAll(editado, botones);
    }

    //Getters
    public TextField getCuadroCantidad() { return this.cuadroCantidad; }

    public ComboBox<String> getListadoInsumos() { return this.listadoInsumos; }

    public DatePicker getDatePicker() { return this.datePicker; }

    public Button getBtnAgregar() { return this.btnAgregar; }

    public Button getBtnQuitar() { return this.btnQuitar; }

    public Button getBtnCancelar() { return this.btnCancelar; }

    public ObservableList<String> getIdEnvases() { return this.idEnvases; }

}


