package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;

public class VistaListadoTapas extends VistaListadoPadre {

    private TableView tablaTapas;

    public VistaListadoTapas (List tapas){
        super();
        ObservableList miLista = FXCollections.observableArrayList(tapas);
        TableColumn column1 = crearColumnas("nombre");//Se envía el nombre del atributo.
        TableColumn column2 = crearColumnas("descripcion");
        tablaTapas = new TableView(miLista);
        tablaTapas.getColumns().addAll(column1,column2);

        contenido.getChildren().addAll(tablaTapas,getBtnCerrarTabla());
    }




}
