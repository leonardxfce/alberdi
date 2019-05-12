package vistas;

import controladores.Controlador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelos.Envase;

public class VistaEnvase extends VistaPadre {
    
    private TextField textId;
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
    private Button btnModificar;
    private VBox bxLabel;
    private VBox bxTextField;
    private HBox edicion;
    private HBox bxButton;

    public VistaEnvase(Controlador c) {
        super();
        labelNom = new Label("Nombre");
        labelTipo = new Label("Tipo");
        labelVol = new Label("Volumen");
        labelDescrip = new Label("Descripción");

        textId = new TextField();
        textNombre = new TextField();
        textTipo = new TextField();
        textVol = new TextField();
        textDescrip = new TextField();

        btnGuardarEv = new Button("Guardar");
        btnCancelar = new Button("Cancelar");
        btnModificar = new Button("Modificar");

        bxLabel = new VBox(13);
        bxTextField = new VBox(5);
        edicion=new HBox(8);
        bxButton = new HBox(5);
        bindEventController(c);
        config();
    }

    public void bindEventController(Controlador c){
        getBtnGuardarEv().setOnAction(c::handle);
        getBtnCancelar().setOnAction(c::handle);
        getBtnModificar().setOnAction(c::handle);
    }
    //Getters
    public TextField getTextId() { return textId; }
    
    public TextField getTextNombre() { return textNombre; }

    public TextField getTextTipo() { return textTipo; }

    public TextField getTextVol() { return textVol; }

    public TextField getTextDescrip() { return textDescrip; }

    public Button getBtnGuardarEv() { return btnGuardarEv; }

    public Button getBtnCancelar() { return btnCancelar; }
    
    public Button getBtnModificar() { return btnModificar; }

    public void config() {
        //ID
        btnGuardarEv.setId("envase_guardar");
        btnCancelar.setId("envase_cancelar");
        btnModificar.setId("envase_modificar");
        //Controles
        this.mostrarBotones();
        bxLabel.getChildren().addAll(labelNom, labelTipo,labelVol,labelDescrip);
        bxLabel.setAlignment(Pos.CENTER_RIGHT);
        bxTextField.getChildren().addAll(textNombre, textTipo, textVol,textDescrip);
        edicion.getChildren().addAll(bxLabel,bxTextField);
        bxButton.getChildren().addAll(btnGuardarEv,btnModificar, btnCancelar);
        bxButton.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(edicion, bxButton);
        contenido.setSpacing(5);
    }
    public void prepararFormulario(Envase env){
        btnGuardarEv.setVisible(false);
        btnModificar.setVisible(true);
        btnGuardarEv.setManaged(false);
        btnModificar.setManaged(true);
        textId.setText(Integer.toString(env.getId()));
        textNombre.setText(env.getNombre());
        textTipo.setText(env.getTipo());
        textVol.setText(Integer.toString(env.getVolumen()));
        textDescrip.setText(env.getDescripcion());
    }
    public void mostrarBotones(){
        btnGuardarEv.setVisible(true);
        btnModificar.setVisible(false);
        btnGuardarEv.setManaged(true);
        btnModificar.setManaged(false);
    }
}