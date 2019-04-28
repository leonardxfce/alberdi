package controladores;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import principal.Configurar;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

class ControladorTesters extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        new Configurar();
        new Controlador(primaryStage);
    }

    @Test
    public void test_se_hace_clic() {
        write("marcelo").push(KeyCode.TAB);
        write("123").push(KeyCode.TAB);
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
        write("marcelo").push(KeyCode.TAB);
        write("123").push(KeyCode.ENTER);
        clickOn("Cargar Envase");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarEnvase_Popup() {
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.TAB);
        clickOn("Ingresar");
        clickOn("Cargar Envase");
        clickOn("Guardar");
        clickOn("OK");
        verifyThat(".button", hasText("Guardar"));
    }

    @Test
    public void test_click_GuardarTapa_Popup() {
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.TAB);
        clickOn("Ingresar");
        clickOn("Cargar Tapa");
        clickOn("Aceptar");
        clickOn("OK");
        verifyThat(".button", hasText("Aceptar"));
    }

    @Test
    public void test_click_listados() {
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Ver Listado de Envases");
        clickOn("Cancelar");
        clickOn("Ver Listado de Tapas");
        clickOn("Cancelar");
        clickOn("Cerrar Sesion");
    }

    @Test
    public void test_click_Registrar(){
        clickOn("Registrar Usuario");
        verifyThat(".button", hasText("Registrar"));
    }
    
    @Test
    public void test_click_Movimiento_PopUp() {
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Manejo de Insumos - Envases");
        write("abc");
        verifyThat(".button", hasText("Agregar"));
        clickOn("Quitar");
        clickOn("OK");
        clickOn("Cancelar");
    }

    @Test
    public void test_click_MovimientoTapa_PopUp() {
        write("lautaro").push(KeyCode.TAB);
        write("12345").push(KeyCode.ENTER);
        clickOn("Manejo de Insumos - Tapas");
        write("abc");
        verifyThat(".button", hasText("Agregar"));
        clickOn("Quitar");
        clickOn("OK");
        clickOn("Cancelar");
    }
    
}
