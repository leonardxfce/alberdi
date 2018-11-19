package modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import principal.Configurar;

public class ModeloMovimientoEnvaseTest {
    public ModeloMovimientoEnvaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
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
        List lista=instance.darTodosLosMovimientosConNombre();
        assertEquals(false,lista.isEmpty());
    }

}

