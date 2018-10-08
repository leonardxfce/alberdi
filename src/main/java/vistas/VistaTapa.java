package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

        bxTipo = new HBox(5);
        bxDescripcion = new HBox(5);
        bxBotones = new HBox(5);
    }

    public TextField getTxTipo() { return txTipo; }

    public TextField getTxDescripcion() { return txDescripcion; }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void config() {
        //IDs
        btnAceptar.setId("tapa_guardar");
        btnCancelar.setId("tapa_cancelar");
        bxTipo.getChildren().addAll(labelTipo, txTipo);
        bxDescripcion.getChildren().addAll(labelDescripcion, txDescripcion);
        bxBotones.getChildren().addAll(btnAceptar, btnCancelar);
        bxBotones.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(bxTipo, bxDescripcion, bxBotones);
        contenido.setSpacing(5);
    }

}
