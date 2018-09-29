package vistas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaPadre {
    Scene scene;
    StackPane contenedor;
    VBox contenido;
    Insets margenes;

    public VistaPadre() {
        contenedor = new StackPane();
        scene = new Scene(contenedor);
        contenido = new VBox();
        margenes = new Insets(20, 20, 20, 20);
        contenedor.setPadding(margenes);
    }


}
