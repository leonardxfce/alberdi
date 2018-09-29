package principal;

import controladores.Controlador;
import javafx.application.Application;
import javafx.stage.Stage;

public class Inicio extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Controlador(primaryStage);
    }
}
