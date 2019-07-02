/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import examen.Calculadora;
import modelos.Envase;
import modelos.Tapa;
import modelos.Usuario;
import utilidades.Validador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import examen.EsPar;
import examen.Saludo;
import org.junit.Assert;

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
        Tapa tapa = new Tapa(nombre,descripcion);
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarTapa(tapa);
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
        String descripcion = "";
        int volumen = 1;
        Envase envase = new Envase(nombre, tipo, volumen,descripcion);
        Validador instance = new Validador();
        boolean expResult = false;
        boolean result = instance.validarEnvase(envase);
        assertEquals(expResult, result);
    }
    @Test
    public void testValidarVolumen(){
        String nombre = "";
        String tipo = "";
        String descripcion = "";
        int volumen = 6;
        Envase envase = new Envase(nombre, tipo,volumen,descripcion);
        Validador prueba = new Validador();
        boolean resultado=prueba.validarVolumen(envase);
        assertTrue(resultado);
    }
    @Test
    public void testtValidarMovimietno(){
        Validador f = new Validador();
        boolean resultado = f.validarMovimiento("4", 5, null);
        assertFalse(resultado);

    }
    
    @Test
    public void testValidarVolumenFrasco() {
        Envase envase = new Envase();
        envase.setNombre("frasco");
        envase.setTipo("hexagonal");
        envase.setVolumen(150);
        envase.setDescripcion("vidrio");
        Validador instance = new Validador();
        boolean result= instance.validarVolumen(envase);
        assertEquals(true, result);
    } 
    
    @Test
    public void testValidarPassword(){
        Usuario usuario=new Usuario("marcelo", "12345678");
        Validador instance = new Validador();
        boolean result= instance.validarPassword(usuario);
        assertEquals(true, result);

        
    }
    
    @Test
    public void testEsPar(){
        EsPar instance= new EsPar(10);
        boolean result= instance.esPar();
        assertEquals(true,result);
        
    }
    @Test
    public void testEsImpar(){
        EsPar instance= new EsPar(5);
        boolean result= instance.esPar();
        assertEquals(false,result);
        
    }
    
    @Test
    public void testSaludo(){
        Saludo instance=new Saludo("yamila");
        String result=instance.saludo();
        String esperado="yamila";
        Assert.assertSame(esperado, result);
    }
    
    @Test
    public void testCalculadora(){
        Calculadora instance=new Calculadora();
        int result=instance.raizCuadrada(16);
        int esperado=4;
        assertEquals(esperado,result);
    }
    
    @Test
    public void testSuma(){
        Calculadora instance=new Calculadora();
        int result=instance.suma(2,2);
        int esperado=4;
        assertEquals(esperado,result);
    }
    
    @Test
    public void testDoble(){
        Calculadora instance=new Calculadora();
        int result= instance.doble(2);
        int esperado=4;
        assertEquals(esperado, result);
    }
    
    @Test
    public void testDoble1(){
        Calculadora instance=new Calculadora();
        int result= instance.doble(-2);
        int esperado=-4;
        assertEquals(esperado, result);
    }
    
    
    @Test
    public void testReemplazarSQL(){
       Calculadora c= new Calculadora();
       String resultado = c.crearINSERTAR("Leonardo");
       String esperado = "INSERT INTO ALUMNOS VALUES(NULL,'Leonardo')";
       assertEquals(esperado,resultado);
             
               
   }
    
    @Test
    public void testReemplazarTapasSQL(){
       Calculadora c= new Calculadora();
       Tapa tap = new Tapa();
       tap.setCantidad(100);
       tap.setDescripcion("tapa muy amarilla de color amarillo");
       tap.setNombre("Tapa amarilla");
       String resultado = c.crearINSERTARTapa(tap);
       String esperado = "INSERT INTO ALUMNOS VALUES(NULL,'Tapa amarilla','tapa muy amarilla de color amarillo',100)";
       assertEquals(esperado,resultado);
    }
    
    @Test 
    public void testModificarTapasSQL(){
        Calculadora c= new Calculadora();
        Tapa tap = new Tapa();
        tap.setNombre("tapa verde");
        tap.setCantidad(100);
        tap.setDescripcion("tapa muy amarilla de color amarillo");
        String resultado= c.modificarTapa(tap);
        String esperado= "UPDATE ALUMNOS SET NOMBRE ='tapa verde' where CANTIDAD=100" ;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testBorrarTapasSQL(){
        Calculadora c= new Calculadora();
        Tapa tap = new Tapa();
        tap.setNombre("tapa verde");
        tap.setCantidad(100);
        tap.setDescripcion("tapa muy amarilla de color amarillo");
        String resultado= c.borrarTapa(tap);
        String esperado= "DELETE FROM ALUMNOS WHERE CANTIDAD=100" ;
        assertEquals(esperado,resultado);
    }
    
    
   
}
