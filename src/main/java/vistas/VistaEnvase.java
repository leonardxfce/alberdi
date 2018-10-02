package vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaEnvase extends VistaPadre {

    private TextField textNombre;
    private TextField textTipo;
    private TextField textCap;
    private Label labelNom;
    private Label labelTipo;
    private Label labelCap;
    private Button btnGuardarEv;
    private Button btnCancelar;
    HBox bxNombre;
    HBox bxTipo;
    HBox bxCap;
    HBox bxButton;

    public VistaEnvase() {
        super();
        labelNom = new Label("Nombre");
        labelTipo = new Label("Tipo");
        labelCap = new Label("Capacidad");

        textNombre = new TextField();
        textTipo = new TextField();
        textCap = new TextField();

        btnGuardarEv = new Button("Guardar Envase");
        btnCancelar = new Button("Cancelar");

        bxNombre = new HBox(5);
        bxTipo = new HBox(5);
        bxCap = new HBox(5);
        bxButton = new HBox(5);


    }

    public TextField getTextNombre() {
        return textNombre;
    }

    public TextField getTextTipo() {
        return textTipo;
    }

    public TextField getTextCap() {
        return textCap;
    }

    public Button getBtnGuardarEv() {
        return btnGuardarEv;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void config() {
        bxNombre.getChildren().addAll(labelNom,textNombre);
        bxTipo.getChildren().addAll(labelTipo,textTipo);
        bxCap.getChildren().addAll(labelCap,textCap);
        bxButton.getChildren().addAll(btnGuardarEv,btnCancelar);
        bxButton.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(bxNombre,bxTipo,bxCap,bxButton);
        contenido.setSpacing(5);
    }
}
