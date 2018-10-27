package controladores;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
        System.out.println("CARGAR ENVASE");
        write("marcelo").push(KeyCode.TAB);
        write("123").push(KeyCode.ENTER);
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
        System.out.println("GUARDAR ");
        write("marcelo").push(KeyCode.TAB);
        write("123").push(KeyCode.ENTER);
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarEnvase_Popup() {
        System.out.println("POPOUT");
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        clickOn("Guardar");
        clickOn("OK");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarTapa_Popup() {
        System.out.println("POPOUT 2");
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Ingresar");
        clickOn("Cargar Tapa");
        clickOn("Aceptar");
        clickOn("OK");
        verifyThat(".button", hasText("Aceptar"));
    }

    @Test
    public void test_click_listados (){
        System.out.println("LISTADOS");
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Ingresar");
        clickOn("Ver Listado de Envases");
        clickOn("Cancelar");
        clickOn("Ver Listado de Tapas");
        clickOn("Cancelar");
    }

}
