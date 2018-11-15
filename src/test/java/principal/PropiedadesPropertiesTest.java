/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author hp
 */
public class PropiedadesPropertiesTest {
    
    public PropiedadesPropertiesTest() {
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
     * Test of leerPropiedad method, of class ManejadorProperties.
     */ 
    @Test
    public void testLeerPropiedadModeloLogin() {
        ManejadorProperties ModeloLogin = new ManejadorProperties(1);
        String resultado  = ModeloLogin.leerPropiedad("usuario");
        String expResult = "marcelo" ;
        assertEquals(expResult, resultado);
    }
     @Test
    public void testLeerPropiedadModeloLogin1() {
        ManejadorProperties ModeloLogin = new ManejadorProperties(1);
        String resultado  = ModeloLogin.leerPropiedad("password");
        String expResult = "123" ;
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadModeloPadre() {
        ManejadorProperties ModeloPadre = new ManejadorProperties(1);
        String resultado  = ModeloPadre.leerPropiedad("url");
        String expResult = "jdbc:sqlite:sample.db";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadTitulo() {
        ManejadorProperties Titulo = new ManejadorProperties(1);
        String resultado  = Titulo.leerPropiedad("titulo");
        String expResult = "Sistemas Segundo";
        assertEquals(expResult, resultado);
    }
    
}
