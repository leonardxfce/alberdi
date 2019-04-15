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
    private Button btnRegistrar;

    public VistaLogin() {
        super();
        labelUsuario = new Label("Usuario");
        labelUsuario.setId("user");
        labelContrasena = new Label("Contraseña");
        labelContrasena.setId("pass");
        txUsuario = new TextField();
        txContrasena = new PasswordField();
        btnIngresar = new Button("Ingresar");
        btnRegistrar = new Button("Registrar");
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
    public Button getBtnRegresar(){
        return btnRegistrar;
    }

    public void config() {
        //IDs
        btnIngresar.setId("login_ingresar");
        btnRegistrar.setId("registrarUser");
        //Controles
        this.mostrarBotonesLogin();
        contenido.getChildren().addAll(labelUsuario, txUsuario, labelContrasena, txContrasena, btnIngresar,btnRegistrar);
        contenido.setSpacing(5);
    }
    
    public void prepararBotones(){
        btnIngresar.setVisible(false);
        btnRegistrar.setVisible(true);
        btnIngresar.setManaged(false);
        btnRegistrar.setManaged(true);
        txUsuario.clear();
        txContrasena.clear();
    }
    
    public void mostrarBotonesLogin(){
        btnIngresar.setVisible(true);
        btnRegistrar.setVisible(false);
        btnIngresar.setManaged(true);
        btnRegistrar.setManaged(false);
    }
}
