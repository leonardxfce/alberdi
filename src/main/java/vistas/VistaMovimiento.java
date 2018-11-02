package vistas;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.List;

public class VistaMovimiento extends VistaPadre {
    ComboBox<List> listadoInsumos;
    TextField cuadroCantidad;
    Button btnAgregar;
    Button btnQuitar;
    Button btnCancelar;
    HBox editado;
    HBox botones;

    public VistaMovimiento (){
        listadoInsumos=new ComboBox<>();
        cuadroCantidad=new TextField();
        btnAgregar=new Button("Agregar");
        btnQuitar=new Button("Quitar");
        btnCancelar=new Button("Cancelar");
        editado=new HBox();
    }

}
