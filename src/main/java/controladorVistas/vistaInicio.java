package controladorVistas;

import javafx.application.Application;
import javafx.stage.Stage;

public class vistaInicio extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Controlador(primaryStage);
    }
}
