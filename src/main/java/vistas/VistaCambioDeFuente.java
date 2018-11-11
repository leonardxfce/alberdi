/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author santiagopc
 */
public class VistaCambioDeFuente extends VistaPadre {

    private Label labelInstruccion;
    private Label labelPista;
    private TextField tsf;
    private Button btnCambiar;
    private Button btnCancelar;

    HBox hBox1;
    HBox hBox2;
    HBox hBox3;
    VBox vBox;

    public VistaCambioDeFuente() {
        super();

        labelInstruccion = new Label("Ingrese el tamaño de la fuente:");
        tsf = new TextField();
        labelPista = new Label("El tamaño por defecto es 10.");
        btnCambiar = new Button("Cambiar Fuente");
        btnCancelar = new Button("Cancelar");

        hBox1 = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox();

    }

    public void config() {
        //IDs
        btnCambiar.setId("cambiar_tamaño_fuente");
        btnCancelar.setId("salir_cambio_tamaño_fuente");

        //controles
        hBox1.getChildren().addAll(getLabelInstruccion(), getTsf());
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(5);
        hBox2.getChildren().addAll(getBtnCambiar(), getBtnCancelar());
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(5);
        hBox3.getChildren().add(getLabelPista());
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setSpacing(5);

        contenido.getChildren().addAll(hBox1, hBox2);
        contenido.setSpacing(5);
        contenido.setPadding(margenes);
    }

    @Override
    public void cambioTamanoFuente(int tamano) {
        Font fuente = new Font("Times New Roman", tamano);
        getLabelInstruccion().setFont(fuente);
        getLabelPista().setFont(fuente);
        getTsf().setFont(fuente);
        getBtnCambiar().setFont(fuente);
        getBtnCancelar().setFont(fuente);
    }

    /**
     * @return the labelInstruccion
     */
    public Label getLabelInstruccion() {
        return labelInstruccion;
    }

    /**
     * @param labelInstruccion the labelInstruccion to set
     */
    public void setLabelInstruccion(Label labelInstruccion) {
        this.labelInstruccion = labelInstruccion;
    }

    /**
     * @return the labelPista
     */
    public Label getLabelPista() {
        return labelPista;
    }

    /**
     * @param labelPista the labelPista to set
     */
    public void setLabelPista(Label labelPista) {
        this.labelPista = labelPista;
    }

    /**
     * @return the tsf
     */
    public TextField getTsf() {
        return tsf;
    }

    /**
     * @param tsf the tsf to set
     */
    public void setTsf(TextField tsf) {
        this.tsf = tsf;
    }

    /**
     * @return the btnCambiar
     */
    public Button getBtnCambiar() {
        return btnCambiar;
    }

    /**
     * @param btnCambiar the btnCambiar to set
     */
    public void setBtnCambiar(Button btnCambiar) {
        this.btnCambiar = btnCambiar;
    }

    /**
     * @return the btnCancelar
     */
    public Button getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * @param btnCancelar the btnCancelar to set
     */
    public void setBtnCancelar(Button btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
}
