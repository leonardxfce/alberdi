/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.junit.BeforeClass;
import org.junit.Test;
import principal.Configurar;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author santiagopc
 */
public class ModeloTapaTest {

    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @Test
    public void testInsert() {
        Tapa tapa = new Tapa("corona", "106");
        ModeloTapa instance = new ModeloTapa();
        instance.insert(tapa);
    }

    /**
     * Test of DarTodosLosEnvases  method, of class ModeloTapa.
     */
    @Test
    public void testDarTodosLosEnvases() {
        Tapa tapa = new Tapa("100", "axial");
        ModeloTapa instance = new ModeloTapa();
        instance.insert(tapa);
        List lista = instance.darTodasLasTapas();
        assertEquals(false, lista.isEmpty());
    }

    /**
     * Test of repetido method, of class ModeloTapa.
     */
    @Test
    public void testRepetido1() {
        Tapa tapa = new Tapa("106", "corona");
        ModeloTapa instance = new ModeloTapa();
        instance.insert(tapa);
        boolean expResult = true;
        boolean result = instance.repetido(tapa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of repetido method, of class ModeloTapa.
     */
    @Test
    public void testRepetido2() {
        Tapa tapa = new Tapa("105", "corona");
        ModeloTapa instance = new ModeloTapa();
        boolean expResult = false;
        boolean result = instance.repetido(tapa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDarUnEnvase() {
        int uno = 1;
        ModeloTapa instance = new ModeloTapa();
        Tapa tapa = instance.darUno(uno);
        assertTrue(tapa instanceof Tapa);
    }

    @Test
    public void testModificarEnvase() {
        int uno = 1;
        ModeloTapa instance = new ModeloTapa();
        Tapa tapa = instance.darUno(uno);
        tapa.setNombre("tapita");
        instance.modificarTapa(tapa);
        Tapa tapa2 = instance.darUno(uno);
        assertNotEquals(tapa, tapa2);
    }


}
