package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author SantiagoLisa
 */
public class VistaMenu extends VistaPadre {

    private Button btnEnvase;
    private Button btnTapas;
    private Button btnCerrarSesion;
    private Label titulo;

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
        //IDs
        btnEnvase.setId("menu_envase");
        btnTapas.setId("menu_tapa");
        btnCerrarSesion.setId("menu_cerrarSesion");
        //Controles
        contenido.getChildren().addAll(titulo, btnEnvase, btnTapas, btnCerrarSesion);
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);
        contenido.setMinSize(200, 200);
    }

}
