/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import principal.Configurar;

/**
 * @author lauta
 */
public class ModeloLoginTest {


    public ModeloLoginTest() {
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

    /**
     * Test of seleccionar method, of class ModeloLogin.
     */
    @Test
    public void testExistencia() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("leo");
        atributosLogin.add("2221");
        ModeloLogin instance = new ModeloLogin("leo", "2221");
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(false, result);
    }

    public void testinsert() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("JUANES");
        atributosLogin.add("2610");
        ModeloLogin instance = new ModeloLogin("JUANES", "2610");
        instance.insertar();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(true, result);
    }

    public void test(){
        assertTrue("gooa", true);
    }
}
