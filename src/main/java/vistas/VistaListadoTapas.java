package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;

public class VistaListadoTapas extends VistaListadoPadre {

    private TableView tablaTapas;
    private TableColumn column0;
    private TableColumn column1;
    private TableColumn column2;
    private TableColumn column3;
    
    public VistaListadoTapas (List tapas){
        super();
        ObservableList miLista = FXCollections.observableArrayList(tapas);
        column0 = crearColumnas("idTapa");
        column1 = crearColumnas("nombre");//Se envía el nombre del atributo.
        column2 = crearColumnas("descripcion");
        column3 = crearColumnas("cantidad");
        tablaTapas = new TableView(miLista);
        tablaTapas.getColumns().addAll(column0,column1,column2,column3);

        contenido.getChildren().addAll(tablaTapas,getBtnCerrarTabla());
    }

    public TableColumn getColumn0() {return column0;}

    public TableColumn getColumn1() {return column1;}

    public TableColumn getColumn2() {return column2;}
    
    public TableColumn getColumn3() {return column3;}

    public TableView getTableView() {
        return tablaTapas;
    }




}
