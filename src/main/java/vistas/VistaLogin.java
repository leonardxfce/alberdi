package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaLogin extends VistaPadre {
    //Atributos
    private VBox datos;
    private HBox botones;
    private Label labelUsuario;
    private Label labelContrasena;
    private TextField txUsuario;
    private PasswordField txContrasena;
    private Button btnIngresar;
    private Button btnRegistrar;
    private Button btnCancelar;
    private String mensajeDeError;

    //Controlador
    public VistaLogin() {
        super();
        setDatos(new VBox());
        setBotones(new HBox());
        setLabelUsuario(new Label("Usuario"));
        getLabelUsuario().setId("user");
        setLabelContrasena(new Label("Contraseña"));
        getLabelContrasena().setId("pass");
        setTxUsuario(new TextField());
        setTxContrasena(new PasswordField());
        setBtnIngresar(new Button("Ingresar"));
        setBtnRegistrar(new Button("Registrar"));
        setBtnCancelar(new Button("Cancelar"));
    }

    //Metodos
    public void config() {
        //IDs
        getBtnIngresar().setId("login_ingresar");
        getBtnRegistrar().setId("login_registrarUser");
        getBtnCancelar().setId("volver_menu");
        //Controles
        this.mostrarBotonesLogin();
        getDatos().getChildren().addAll(getLabelUsuario(), getTxUsuario(), getLabelContrasena(), getTxContrasena());
        getDatos().setSpacing(5);
        getBotones().getChildren().addAll(getBtnIngresar(), getBtnRegistrar(), getBtnCancelar());
        getBotones().setAlignment(Pos.CENTER);
        getBotones().setSpacing(5);
        contenido.getChildren().addAll(getDatos(), getBotones());
        contenido.setSpacing(5);
        escucharEnter();
    }

    public void prepararBotonesIngresarUserNuevo() {
        getBtnIngresar().setVisible(false);
        getBtnIngresar().setManaged(false);
        getBtnRegistrar().setVisible(true);
        getBtnRegistrar().setManaged(true);
        getBtnCancelar().setVisible(true);
        getBtnCancelar().setManaged(true);
        eliminarContenido();
    }

    public void mostrarBotonesLogin() {
        getBtnIngresar().setVisible(true);
        getBtnIngresar().setManaged(true);
        getBtnRegistrar().setVisible(false);
        getBtnRegistrar().setManaged(false);
        getBtnCancelar().setVisible(false);
        getBtnCancelar().setManaged(false);
        eliminarContenido();
    }

    //este metodo se encarga de validar qeu los campos no esten vacios. Agregado por Santiago
    public boolean validarCampos() {
        boolean camposVacios = false;
        String mensajeError = "";
        if (getTxUsuario().getText().equals("")) {
            camposVacios = true;
            mensajeError = "No ingresó un Usuario.\n";
        }
        if (getTxContrasena().getText().equals("")) {
            camposVacios = true;
            mensajeError += "No ingresó una Contraseña.";
        }
        setMensajeDeError(mensajeError);
        return camposVacios;
    }

    public void eliminarContenido() {
        getTxUsuario().clear();
        getTxContrasena().clear();
    }

    public void escucharEnter() {
        getBtnRegistrar().defaultButtonProperty().bind(getBtnRegistrar().focusedProperty());
        getBtnCancelar().defaultButtonProperty().bind(getBtnCancelar().focusedProperty());
    }

    //Setters && Getters
    public Label getLabelUsuario() {
        return labelUsuario;
    }

    public void setLabelUsuario(Label labelUsuario) {
        this.labelUsuario = labelUsuario;
    }

    public Label getLabelContrasena() {
        return labelContrasena;
    }

    public void setLabelContrasena(Label labelContrasena) {
        this.labelContrasena = labelContrasena;
    }

    public void setTxUsuario(TextField txUsuario) {
        this.txUsuario = txUsuario;
    }

    public TextField getTxUsuario() {
        return txUsuario;
    }

    public void setTxContrasena(PasswordField txContrasena) {
        this.txContrasena = txContrasena;
    }

    public TextField getTxContrasena() {
        return txContrasena;
    }

    public void setBtnIngresar(Button btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public Button getBtnIngresar() {
        return btnIngresar;

    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(Button btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public VBox getDatos() {
        return datos;
    }

    public void setDatos(VBox datos) {
        this.datos = datos;
    }

    public HBox getBotones() {
        return botones;
    }

    public void setBotones(HBox botones) {
        this.botones = botones;
    }

    public String getMensajeDeError() {
        return mensajeDeError;
    }

    public void setMensajeDeError(String mensajeDeError) {
        this.mensajeDeError = mensajeDeError;
    }
}
