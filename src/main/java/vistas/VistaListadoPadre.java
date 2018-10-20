/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author caro_
 */
public class VistaListadoPadre extends VistaPadre{
    public TableColumn crearColumnas(String dato){
        TableColumn columna1 = new TableColumn(dato.substring(0,1).toUpperCase() + dato.substring(1).toLowerCase());
        PropertyValueFactory leo = new PropertyValueFactory(dato);
        columna1.setCellValueFactory(leo);
        return columna1;
    }
}
