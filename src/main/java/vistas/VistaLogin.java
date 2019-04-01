package vistas;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class VistaLogin extends VistaPadre {
    private Label labelUsuario;
    private Label labelContrasena;
    private TextField txUsuario;
    private PasswordField txContrasena;
    private Button btnIngresar;


    public VistaLogin() {
        super();
        labelUsuario = new Label("Usuario");
        labelUsuario.setId("user");
        labelContrasena = new Label("Contraseña");
        labelContrasena.setId("pass");
        txUsuario = new TextField();
        txContrasena = new PasswordField();
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
        //IDs
        btnIngresar.setId("login_ingresar");
        //Controles
        contenido.getChildren().addAll(labelUsuario, txUsuario, labelContrasena, txContrasena, btnIngresar);
        contenido.setSpacing(5);
    }

}
