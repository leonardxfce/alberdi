package vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author ikariRules
 */
public class VistaTapa extends VistaPadre {
    Button btnAceptar;
    Button btnCancelar;
    Label cantidad;
    Label tipoDeTapa;
    TextField seleccionTipoDeTapa;
    TextField seleccionCantidad;
    HBox boxTipo;
    HBox boxCantidad;
    HBox boxBotones;

    public VistaTapa() {
        super();
        btnAceptar = new Button("Aceptar");
        btnCancelar = new Button("Cancelar");
        cantidad = new Label("Cantidad");
        tipoDeTapa = new Label("Tipo");
        seleccionTipoDeTapa = new TextField();
        seleccionCantidad = new TextField();
        boxTipo = new HBox();
        boxCantidad = new HBox();
        boxBotones = new HBox();
    }

    public Scene getScene() {
        return this.scene;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void config() {
        boxTipo.getChildren().addAll(tipoDeTapa, seleccionTipoDeTapa);
        boxCantidad.getChildren().addAll(cantidad, seleccionCantidad);
        boxBotones.getChildren().addAll(btnAceptar, btnCancelar);
        contenido.getChildren().addAll(boxTipo, boxCantidad, boxBotones);
        contenedor.getChildren().add(contenido);
    }

}
