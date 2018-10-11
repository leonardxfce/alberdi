/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caro_
 */
public class ModeloEnvaseTest {
    
    public ModeloEnvaseTest() {
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
     * Test of repetido method, of class ModeloEnvase.
     */
    @Test
    public void testRepetido() {
        System.out.println("repetido");
        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("frasco");
        miAl.add("amanecer");
        miAl.add("10");
        miAl.add("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        boolean expResult = false;
        boolean result = instance.repetido(miAl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRepetido2() {
        System.out.println("repetido");
        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("bote");
        miAl.add("corona");
        miAl.add("250");
        miAl.add("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        boolean expResult = true;
        boolean result = instance.repetido(miAl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of guardarEnvaseNuevo method, of class ModeloEnvase.
     */
    @Test
    public void testGuardarEnvaseNuevo() {
        System.out.println("guardarEnvaseNuevo");
        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("bote");
        miAl.add("corona");
        miAl.add("250");
        miAl.add("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        instance.guardarEnvaseNuevo(miAl);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
