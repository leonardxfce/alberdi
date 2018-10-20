/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import modelos.Tapa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santiagopc
 */
public class ModeloTapaTest {
    
    public ModeloTapaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of insert method, of class ModeloTapa.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Tapa tapa = new Tapa("corona","106");
        ModeloTapa instance = new ModeloTapa();
        instance.insert(tapa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DarTodosLosEnvases  method, of class ModeloTapa.
     */
    @Test
    public void testDarTodosLosEnvases() {
        System.out.println("DarTodosLosEnvases");
        Tapa tapa = new Tapa("100","axial");
        ModeloTapa instance = new ModeloTapa();
        instance.insert(tapa);
        List lista = instance.darTodosLosEnvases();
        assertEquals(false,lista.isEmpty());
    }

    /**
     * Test of repetido method, of class ModeloTapa.
     */
    @Test
    public void testRepetido1() {
        System.out.println("repetido");
        Tapa tapa = new Tapa("106","corona"); 
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
        System.out.println("repetido");
        Tapa tapa = new Tapa("105","corona"); 
        ModeloTapa instance = new ModeloTapa();
        boolean expResult = false;
        boolean result = instance.repetido(tapa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
