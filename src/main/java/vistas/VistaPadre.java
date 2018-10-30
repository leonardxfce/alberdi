package vistas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class VistaPadre {
    Scene scene;
    VBox contenido;
    Insets margenes;

    public VistaPadre() {
        contenido = new VBox();

        scene = new Scene(contenido);
        margenes = new Insets(20, 20, 20, 20);
        contenido.setPadding(margenes);
        
    }

    public Scene getScene() {
        return scene;
    }
    
}
