/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
public class ValidadorTest {
    
    public ValidadorTest() {
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
     * Test of validarTapa method, of class Validador.
     */
    @Test
    public void testValidarTapa() {
        System.out.println("validarTapa");
        String nombre = "";
        String descripcion = "";
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarTapa(nombre, descripcion);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarEnvase method, of class Validador.
     */
    @Test
    public void testValidarEnvase() {
        System.out.println("validarEnvase");
        String nombre = "";
        String tipo = "";
        int volumen = 0;
        String descripcion = "";
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarEnvase(nombre, tipo, volumen, descripcion);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarLetrasEnvase method, of class Validador.
     */
    @Test
    public void testValidarLetrasEnvase() {
        System.out.println("validarLetrasEnvase");
        String nombre = "123bote";
        String tipo = "axial";
        String descripcion = "asd";
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarLetrasEnvase(nombre, tipo, descripcion);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarLetrasTapa method, of class Validador.
     */
    @Test
    public void testValidarLetrasTapa() {
        System.out.println("validarLetrasTapa");
        String descripcion = "12asdf";
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarLetrasTapa(descripcion);
        assertEquals(expResult, result);
    }
    
}
