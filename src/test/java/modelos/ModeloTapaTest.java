/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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
     * Test of select method, of class ModeloTapa.
     */
    @Test
    public void testSelect() {
        System.out.println("select");

        int dato = 1;
        int id = 1;
        String nombre = "tapas";
        String descripcion = "esta es la decripcion";
        String url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10259965";

        ModeloTapa instance = new ModeloTapa(id, nombre, descripcion, url);
        String result = instance.select(dato);

        String expResult = "tapas";

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class ModeloTapa.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");

        int id = 1;
        String nombre = "tapas";
        String descripcion = "esta es la decripcion";
        String url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10259965";

        ModeloTapa instance = new ModeloTapa(id, nombre, descripcion, url);
        instance.insert();

        String result = instance.select(id);
        String expResult = nombre;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
