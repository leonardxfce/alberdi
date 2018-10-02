package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author SantiagoLisa
 */
public class VistaMenu extends VistaPadre {

    Button btnEnvase;
    Button btnTapas;
    Button btnCerrarSesion;
    Label titulo;

    public VistaMenu() {
        super();
        btnEnvase = new Button("Cargar Envase");
        btnTapas = new Button("Cargar Tapa");
        btnCerrarSesion = new Button("Cerrar Sesion");
        titulo = new Label("-----");
    }


    public Button getBtnEnvase() {
        return btnEnvase;
    }

    public Button getBtnTapas() {
        return btnTapas;
    }

    public Button getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void config() {
        contenido.getChildren().addAll(titulo, getBtnEnvase(), getBtnTapas(), getBtnCerrarSesion());
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);
    }

}
