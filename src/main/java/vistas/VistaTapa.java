package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTapa extends VistaPadre {
    private Label labelTipo;
    private Label labelDescripcion;
    private TextField txTipo;
    private TextField txDescripcion;
    private Button btnAceptar;
    private Button btnCancelar;

    VBox bxLabel;
    VBox bxTextField;
    HBox bxEdicion;
    HBox bxBotones;

    public VistaTapa() {
        super();
        labelTipo = new Label("Nombre");
        labelDescripcion = new Label("Descripción");

        txTipo = new TextField();
        txDescripcion = new TextField();

        btnAceptar = new Button("Aceptar");
        btnCancelar = new Button("Cancelar");

        bxLabel = new VBox(13);
        bxTextField = new VBox(5);
        bxEdicion = new HBox(8);
        bxBotones = new HBox(5);
    }

    public TextField getTxTipo() {
        return txTipo;
    }

    public TextField getTxDescripcion() {
        return txDescripcion;
    }

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
        //controles
        bxLabel.getChildren().addAll(labelTipo, labelDescripcion);
        bxLabel.setAlignment(Pos.CENTER_RIGHT);
        bxTextField.getChildren().addAll(txTipo, txDescripcion);
        bxEdicion.getChildren().addAll(bxLabel, bxTextField);
        bxBotones.getChildren().addAll(btnAceptar, btnCancelar);
        bxBotones.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(bxEdicion, bxBotones);
        contenido.setSpacing(5);
    }

}