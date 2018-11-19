package vistas;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VistaListadoEnvases extends VistaListadoPadre {

    private TableView miTabla;
    private TableColumn column0;
    private TableColumn column1;
    private TableColumn column2;
    private TableColumn column3;
    private TableColumn column4;
    private TableColumn column5;

    public VistaListadoEnvases(List envases) {
        super();
        ObservableList miLista = FXCollections.observableArrayList(envases);
        column0 = crearColumnas("id");
        column1 = crearColumnas("nombre");//Se envía el nombre del atributo.
        column2 = crearColumnas("tipo");
        column3 = crearColumnas("volumen");
        column4 = crearColumnas("descripcion");
        column5 = crearColumnas("cantidad");
        miTabla = new TableView(miLista);
        miTabla.getColumns().addAll(column0, column1, column2, column3, column4,column5);
        contenido.getChildren().addAll(miTabla, getBtnCerrarTabla());
    }

    public TableView getTableView() {
        return miTabla;
    }

    public TableColumn getColumn0() {
        return column0;
    }

    public TableColumn getColumn1() {
        return column1;
    }

    public TableColumn getColumn2() {
        return column2;
    }

    public TableColumn getColumn3() {
        return column3;
    }

    public TableColumn getColumn4() {
        return column4;
    }

}
