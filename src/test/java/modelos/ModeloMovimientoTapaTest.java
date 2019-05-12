/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import principal.Configurar;

/**
 *
 * @author caro_
 */
public class ModeloMovimientoTapaTest {
    
    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @Test
    public void test_insertar() {
        MovimientoTapa movimiento = new MovimientoTapa();
        movimiento.setIdTapa(2);
        movimiento.setCantidad(-2);
        movimiento.setFecha("19-11-2018");
        ModeloMovimientoTapa instance = new ModeloMovimientoTapa();
        instance.insertarMovimiento(movimiento);
    }

    @Test
    public void test_darMovimientos() {
        MovimientoTapa movimiento = new MovimientoTapa();
        movimiento.setIdTapa(2);
        movimiento.setCantidad(2);
        movimiento.setFecha("19-11-2018");
        ModeloMovimientoTapa instance = new ModeloMovimientoTapa();
        instance.insertarMovimiento(movimiento);
        List lista = instance.darTodosLosMovimientosConNombre();
        assertEquals(false, lista.isEmpty());
    }
    
}
