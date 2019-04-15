/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        Usuario user = new Usuario("lautaro","12345");
        boolean result = instance.insertar(user);
        assertEquals(false,result);
    }
    
    @Test
    public void testInsertNewUser()  {
        ModeloLogin instance = new ModeloLogin();
        Usuario user = new Usuario("PABLO","445");
        boolean result = instance.insertar(user);
        assertEquals(true,result);
    }
    @Test
    public void testInsertarwhitComprobacion(){
        ModeloLogin instance = new ModeloLogin();
        Usuario usuario = new Usuario("carla","12399");
        instance.insertar(usuario);
        boolean result = instance.comprobarExistencia(usuario);
        assertEquals(true,result);
    }
    @Test
    public void testEliminar() {
        Usuario user = new Usuario("carlos","247");
        ModeloLogin instance = new ModeloLogin();
        instance.insertar(user);
        boolean result = instance.comprobarExistencia(user);
        assertEquals(true,result);
    }

    public void test(){
        assertTrue("gooa", true);
    }
}
