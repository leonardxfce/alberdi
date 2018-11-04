package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelos.Tapa;

public class VistaTapa extends VistaPadre {
    private Label labelTipo;
    private Label labelDescripcion;
    private TextField txId;
    private TextField txTipo;
    private TextField txDescripcion;
    private Button btnAceptar;
    private Button btnCancelar;
    private Button btnModificar;

    VBox bxLabel;
    VBox bxTextField;
    HBox bxEdicion;
    HBox bxBotones;

    public VistaTapa() {
        super();
        labelTipo = new Label("Nombre");
        labelDescripcion = new Label("Descripción");

        txId = new TextField();
        txTipo = new TextField();
        txDescripcion = new TextField();

        btnAceptar = new Button("Aceptar");
        btnCancelar = new Button("Cancelar");
        btnModificar = new Button("Modificar");

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

    public TextField getTxId() {
        return txId;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public Button getBtnModificar() {
        return btnModificar;
    }

    public void config() {
        //IDs
        btnModificar.setId("tapa_modificar");
        btnAceptar.setId("tapa_guardar");
        btnCancelar.setId("tapa_cancelar");
        //controles
        this.mostrarBotones();
        bxLabel.getChildren().addAll(labelTipo, labelDescripcion);
        bxLabel.setAlignment(Pos.CENTER_RIGHT);
        bxTextField.getChildren().addAll(txTipo, txDescripcion);
        bxEdicion.getChildren().addAll(bxLabel, bxTextField);
        bxBotones.getChildren().addAll(btnAceptar,btnModificar,btnCancelar);
        bxBotones.setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(bxEdicion, bxBotones);
        contenido.setSpacing(5);
    }

    public void prepararFormulario(Tapa tapa){
        btnAceptar.setVisible(false);
        btnModificar.setVisible(true);
        btnAceptar.setManaged(false);
        btnModificar.setManaged(true);
        txId.setText(Integer.toString(tapa.getIdTapa()));
        txTipo.setText(tapa.getNombre());
        txDescripcion.setText(tapa.getDescripcion());
    }
    public void mostrarBotones(){
        btnAceptar.setVisible(true);
        btnModificar.setVisible(false);
        btnAceptar.setManaged(true);
        btnModificar.setManaged(false);
    }
}