
package vistas;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class VistaListadoPadre extends VistaPadre{

    private Button btnCerrarTabla;
    VBox bxTabla; // VBox que contendrá  la tabla

    public VistaListadoPadre(){
        super();
        btnCerrarTabla= new Button("Cancelar");
        btnCerrarTabla.setId("volver_menu");
    }

    public Button getBtnCerrarTabla() { return btnCerrarTabla; }

    public TableColumn crearColumnas(String dato){
        TableColumn columna1 = new TableColumn(dato.substring(0,1).toUpperCase() + dato.substring(1).toLowerCase());
        PropertyValueFactory leo = new PropertyValueFactory(dato);
        columna1.setCellValueFactory(leo);
        return columna1;
    }
}
