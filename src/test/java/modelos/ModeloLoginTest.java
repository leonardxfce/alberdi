/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author lauta
 */
public class ModeloLoginTest {

    public ModeloLoginTest() {
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
     * Test of seleccionar method, of class ModeloLogin.
     */
    @Test
    public void testSeleccionar() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("LISA");
        atributosLogin.add("1234");
        ModeloLogin instance = new ModeloLogin();
        String result = instance.seleccionar("LISA","1234");
        assertEquals("LISA", result);
    }

    @Test
    public void testExistencia() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("leo");
        atributosLogin.add("2221");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(false, result);
    }

    @Test
    public void testExistencia2() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("LISA");
        atributosLogin.add("1234");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(true, result);
    }
/**
    @Test
    public void testinsert() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("JUANES");
        atributosLogin.add("2610");
        ModeloLogin instance = new ModeloLogin();
        instance.insertar();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(true, result);
    }
**/
}
