package vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login extends VistaPadre {

    public TextField usuario_campo;
    public TextField contrasena_campo;
    public Button btnIngresar;
    Label usuario;
    Label contrasena;

    public Login() {
        super();
        usuario = new Label("Usuario");
        contrasena = new Label("Contraseña");
        usuario_campo = new TextField();
        contrasena_campo = new TextField();
        btnIngresar = new Button("Ingresar");
    }

    public Scene getScene() {
        return scene;
    }

    public void config() {
        contenido.getChildren().addAll(usuario, contrasena, usuario_campo, contrasena_campo, btnIngresar);
        contenedor.getChildren().add(contenido);
    }

}
