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
        Usuario usuario = new Usuario("leo","2221");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(usuario);
        assertEquals(true, result);
    }
    @Test
    public void testInsertRepetido() {
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.insertar("lautaro","12345");
        assertEquals(false,result);
    }
    @Test
    public void testInsertar() {
        Usuario usuario = new Usuario("JUANES","12345");
        ModeloLogin instance = new ModeloLogin();
        instance.insertar("JUANES","12345");
        boolean result = instance.comprobarExistencia(usuario);
        assertEquals(false,result);
    }

    public void test(){
        assertTrue("gooa", true);
    }
}
