package modelos;

import org.junit.BeforeClass;
import org.junit.Test;
import principal.Configurar;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ModeloMovimientoEnvaseTest {

    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @Test
    public void test_insertar() {
        MovimientoEnvase movimiento = new MovimientoEnvase();
        movimiento.setIdEnvase(2);
        movimiento.setCantidad(-2);
        movimiento.setFecha("19-11-2018");
        ModeloMovimientoEnvase instance = new ModeloMovimientoEnvase();
        instance.insertarMovimiento(movimiento);
    }

    @Test
    public void test_darMovimientos() {
        MovimientoEnvase movimiento = new MovimientoEnvase();
        movimiento.setIdEnvase(2);
        movimiento.setCantidad(2);
        movimiento.setFecha("19-11-2018");
        ModeloMovimientoEnvase instance = new ModeloMovimientoEnvase();
        instance.insertarMovimiento(movimiento);
        List lista = instance.darTodosLosMovimientosConNombre();
        assertEquals(false, lista.isEmpty());
    }

}

