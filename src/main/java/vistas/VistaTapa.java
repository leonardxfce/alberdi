package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author ikariRules
 */
public class VistaTapa extends VistaPadre {
    Label labelTipo;
    Label labelDescripcion;
    TextField txTipo;
    TextField txDescripcion;
    Button btnAceptar;
    Button btnCancelar;

    HBox bxTipo;
    HBox bxDescripcion;
    HBox bxBotones;

    public VistaTapa() {
        super();
        labelTipo = new Label("Tipo");
        labelDescripcion = new Label("Descripción");
        txTipo = new TextField();
        txDescripcion = new TextField();
        btnAceptar = new Button("Aceptar");
        btnCancelar = new Button("Cancelar");
        bxTipo = new HBox();
        bxDescripcion = new HBox();
        bxBotones = new HBox();
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void config() {
        bxTipo.getChildren().addAll(labelTipo, txTipo);
        bxDescripcion.getChildren().addAll(labelDescripcion, txDescripcion);
        bxBotones.getChildren().addAll(btnAceptar, btnCancelar);
        bxBotones.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(bxTipo, bxDescripcion, bxBotones);
    }

}
