package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VistaLogin extends VistaPadre {
    Label labelUsuario;
    Label labelContrasena;
    TextField txUsuario;
    TextField txContrasena;
    Button btnIngresar;


    public VistaLogin() {
        super();
        labelUsuario = new Label("Usuario");
        labelContrasena = new Label("Contraseña");
        txUsuario = new TextField();
        txContrasena = new TextField();
        btnIngresar = new Button("Ingresar");
    }

    public TextField getTxUsuario() {
        return txUsuario;
    }

    public TextField getTxContrasena() {
        return txContrasena;
    }

    public Button getBtnIngresar() {
        return btnIngresar;
    }

    public void config() {
        contenido.getChildren().addAll(labelUsuario, txUsuario, labelContrasena, txContrasena, btnIngresar);
        contenido.setSpacing(5);
    }

}
