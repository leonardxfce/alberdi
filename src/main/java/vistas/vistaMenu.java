package vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author SantiagoLisa
 */
public class vistaMenu extends VistaPadre {

    Button btnEnvase;
    Button btnTapas;
    Button btnCerrarSesion;
    Label titulo;

    public vistaMenu() {
        super();
        btnEnvase = new Button("Formulario Envase");
        btnTapas = new Button("Formulario Tapa");
        btnCerrarSesion = new Button("Cerrar Sesion");
        titulo = new Label("-----");
    }

    public Scene getScene() {
        return this.scene;
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
        contenedor.getChildren().add(contenido);
    }

}
