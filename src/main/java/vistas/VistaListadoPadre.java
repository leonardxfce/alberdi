
package vistas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class VistaListadoPadre extends VistaPadre{
    public TableColumn crearColumnas(String dato){
        TableColumn columna1 = new TableColumn(dato.substring(0,1).toUpperCase() + dato.substring(1).toLowerCase());
        PropertyValueFactory leo = new PropertyValueFactory(dato);
        columna1.setCellValueFactory(leo);
        return columna1;
    }
}
