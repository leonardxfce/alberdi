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
        clickOn(".button");
        verifyThat(".button", hasText("Cargar Envase"));
        clickOn("Cargar Tapa");
        verifyThat(".button", hasText("Aceptar"));
        clickOn("Cancelar");
        verifyThat(".button", hasText("Cargar Envase"));
    }

    @Test
    public void test_click_GuardarEnvase() {
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarEnvase_Popup() {
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        clickOn("Guardar");
        clickOn("OK");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarTapa_Popup() {
        clickOn("Ingresar");
        clickOn("Cargar Tapa");
        clickOn("Aceptar");
        clickOn("OK");
        verifyThat(".button", hasText("Aceptar"));
    }

    @Test
    public void test_click_listados (){
        clickOn("Ingresar");
        clickOn("Ver Listado de Envases");
        clickOn("Cancelar");
        clickOn("Ver Listado de Tapas");
        clickOn("Cancelar");
    }

}
