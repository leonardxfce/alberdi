package acciones;

import acciones.Command;
import controladores.Controlador;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelos.ModeloLogin;
import modelos.Usuario;
import vistas.VistaLogin;
import vistas.VistaMenu;
import vistas.VistaPadre;

import javax.swing.*;

public class Ingresar implements Command {

    private Stage stage;

    public Ingresar(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void excute() {
        loginIngresar();
    }

    private void loginIngresar() {

    }
}
