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
    private TextField textVol;
    private TextField textDescrip;
    private Label labelNom;
    private Label labelTipo;
    private Label labelVol;
    private Label labelDescrip;
    private Button btnGuardarEv;
    private Button btnCancelar;
    private VBox bxLabel;
    private VBox bxTextField;
    private HBox edicion;
    private HBox bxButton;

    public VistaEnvase() {
        super();
        labelNom = new Label("Nombre");
        labelTipo = new Label("Tipo");
        labelVol = new Label("Volumen");
        labelDescrip = new Label("Descripción");

        textNombre = new TextField();
        textTipo = new TextField();
        textVol = new TextField();
        textDescrip = new TextField();

        btnGuardarEv = new Button("Guardar");
        btnCancelar = new Button("Cancelar");

        bxLabel = new VBox(13);
        bxTextField = new VBox(5);
        edicion=new HBox(8);
        bxButton = new HBox(5);
    }
    //Getters
    public TextField getTextNombre() { return textNombre; }

    public TextField getTextTipo() { return textTipo; }

    public TextField getTextVol() { return textVol; }

    public TextField getTextDescrip() { return textDescrip; }

    public Button getBtnGuardarEv() { return btnGuardarEv; }

    public Button getBtnCancelar() { return btnCancelar; }

    public void config() {
        //ID
        btnGuardarEv.setId("envase_guardar");
        btnCancelar.setId("envase_cancelar");
        //Controles
        bxLabel.getChildren().addAll(labelNom, labelTipo,labelVol,labelDescrip);
        bxLabel.setAlignment(Pos.CENTER_RIGHT);
        bxTextField.getChildren().addAll(textNombre, textTipo, textVol,textDescrip);
        edicion.getChildren().addAll(bxLabel,bxTextField);
        bxButton.getChildren().addAll(btnGuardarEv, btnCancelar);
        bxButton.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(edicion, bxButton);
        contenido.setSpacing(5);
    }
}