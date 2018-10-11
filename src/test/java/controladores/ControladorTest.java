package controladores;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ControladorTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        new Controlador(primaryStage);
    }

    @Test
    public void test_se_hace_clic() {
        verifyThat(".button", hasText("Ingresar"));
        sleep(1000);
        clickOn(".button");
        sleep(1000);
        verifyThat(".button", hasText("Cargar Envase"));
        sleep(1000);
        clickOn("Cargar Tapa");
        sleep(1000);
        verifyThat(".button", hasText("Aceptar"));
        sleep(1000);
        clickOn("Cancelar");
        verifyThat(".button", hasText("Cargar Envase"));
    }

    @Test
    public void test_click_GuardarEnvase() {
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        verifyThat(".button", hasText("Guardar"));
        //clickOn("Guardar");
    }

    @Test
    public void test_click_GuardarEnvase_Popup() {
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        clickOn("Guardar");
        clickOn("OK");
        verifyThat(".button", hasText("Guardar"));
        //clickOn("Guardar");
    }

}
