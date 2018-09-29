package controladorVistas;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ControladorVistasTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        new Controlador(primaryStage);
    }

    @Test
    public void test_se_hace_clic() {
        clickOn(".button");
        verifyThat(".button", hasText("Formulario Envase"));
    }

}
