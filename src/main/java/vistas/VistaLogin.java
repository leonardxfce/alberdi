package vistas;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaLogin extends VistaPadre {
    //Atributos
    private Label labelUsuario;
    private Label labelContrasena;
    private TextField tfUsuario;
    private PasswordField tfContrasena;
    private Button btnIngresar;
    private Button btnRegistrar;
    private Button btnVolver;
    private VBox datos;
    private HBox botones;
    private Insets margenBotones;
    private String mensajeError;

    //Constructor
    public VistaLogin() {
        super();
        implementarElementos();
        asignarIDs();
        escucharEnter();
        mostrarBotonesLogin();
    }

    //Metodos
    //Este metodo implementa todos los elementos que componen la vista
    public void implementarElementos(){
        setLabelUsuario(new Label("Usuario"));
        setLabelContrasena(new Label("Contraseña"));
        setTfUsuario(new TextField());
        setTfContrasena(new PasswordField());
        setBtnIngresar(new Button("Ingresar"));
        setBtnRegistrar(new Button("Registrar"));
        setBtnVolver(new Button("Volver"));
        setDatos(new VBox());
        setBotones(new HBox());
        setMargenBotones(new Insets(7, 0, 0, 0));
    }

    //este metodo asigna Ids a los botones y textfields para poder trabajar con ellos más facilmente
    //desde el controlador
    public void asignarIDs(){
        getBtnIngresar().setId("login_ingresar");
        getBtnRegistrar().setId("registrarNuevoUsuario");
        getBtnVolver().setId("volver_menu");
        getLabelUsuario().setId("user");
        getLabelContrasena().setId("pass");
    }

    public void config() {
        //se asigna un tamaño unico a los botones que componen esta vista
        getBtnIngresar().setPrefSize(70,20);
        getBtnRegistrar().setPrefSize(70,20);
        getBtnVolver().setPrefSize(70,20);
        //se cargan los elementos de la vista en los contenedores y ce definen los margenes, pocision
        //y espaciamiento de los mismos
        getDatos().getChildren().addAll(getLabelUsuario(), getTfUsuario(), getLabelContrasena(), getTfContrasena());
        getDatos().setSpacing(5);
        getBotones().getChildren().addAll(getBtnIngresar(), getBtnRegistrar(), getBtnVolver());
        getBotones().setPadding(getMargenBotones());
        getBotones().setSpacing(5);
        getBotones().setAlignment(Pos.CENTER);
        contenido.getChildren().addAll(getDatos(), getBotones());
    }

    //este metodo define que botones se mostraran cuando la vista se utilice para loguearse en el programa
    public void mostrarBotonesLogin() {
        getBtnIngresar().setVisible(true);
        getBtnIngresar().setManaged(true);
        getBtnRegistrar().setVisible(false);
        getBtnRegistrar().setManaged(false);
        getBtnVolver().setVisible(false);
        getBtnVolver().setManaged(false);
    }

    //este metodo define que botones se mostraran cuando la vista se utilice para ingresar un nuevo usuario
    //a la base de datos
    public void prepararBotonesRegistrarUsuario() {
        getBtnIngresar().setVisible(false);
        getBtnIngresar().setManaged(false);
        getBtnRegistrar().setVisible(true);
        getBtnRegistrar().setManaged(true);
        getBtnVolver().setVisible(true);
        getBtnVolver().setManaged(true);
        vaciarCampos();
    }

    //este metodo se usa para validar que los campos usuario y contraseña no esten vacios
    public boolean validarCampos(){
        boolean error = false;
        String mensajeDeError = "";
        if (getTfUsuario().getText().equals("")) {
            mensajeDeError += "No ingresó un nombre de usuario\n";
            error = true;
        }
        if (getTfContrasena().getText().equals("")) {
            mensajeDeError += "No ingresó una contraseña";
            error = true;
        }
        setMensajeError(mensajeDeError);
        return error;
    }

    //este metodo hace que los botones reaccionen a la tecla enter en ves de a espacio
    public void escucharEnter(){
        getBtnRegistrar().defaultButtonProperty().bind(getBtnRegistrar().focusedProperty());
        getBtnVolver().defaultButtonProperty().bind(getBtnVolver().focusedProperty());
    }

    //este metodo se usa para eliminar en contenido de los campos usuario y contraseña, esto sirve para no tener que
    //repetir el mismo codigo varias veces
    public void vaciarCampos(){
        getTfUsuario().clear();
        getTfContrasena().clear();
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

    public TextField getTfUsuario() {
        return tfUsuario;
    }

    public void setTfUsuario(TextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    public PasswordField getTfContrasena() {
        return tfContrasena;
    }

    public void setTfContrasena(PasswordField tfContrasena) {
        this.tfContrasena = tfContrasena;
    }

    public Button getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(Button btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Button getBtnVolver() {
        return btnVolver;
    }

    public void setBtnVolver(Button btnVolver) {
        this.btnVolver = btnVolver;
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

    public Insets getMargenBotones() {
        return margenBotones;
    }

    public void setMargenBotones(Insets margenBotones) {
        this.margenBotones = margenBotones;
    }
}
