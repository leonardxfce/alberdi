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

        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("106");
        miAl.add("corona");
        int dato = 1;

        ModeloTapa instance = new ModeloTapa();
        instance.insert(miAl);

        String result = instance.select(dato);
        String expResult = miAl.get(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class ModeloTapa.
     */
    @Test
    public void testSelect() {
        System.out.println("select");

        int dato = 1;

        ModeloTapa instance = new ModeloTapa();
        String result = instance.select(dato);

        String expResult = "106";

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of repetido method, of class ModeloTapa.
     */
    @Test
    public void testRepetido1() {
        System.out.println("repetido");

        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("106");
        miAl.add("corona");

        ModeloTapa instance = new ModeloTapa();

        boolean expResult = true;
        boolean result = instance.repetido(miAl);

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

        ArrayList<String> miAl = new ArrayList<String>();
        miAl.add("105");
        miAl.add("corona");

        ModeloTapa instance = new ModeloTapa();

        boolean expResult = false;
        boolean result = instance.repetido(miAl);

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
