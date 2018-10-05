/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

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
        System.out.println("seleccionar");

        ModeloLogin instance = new ModeloLogin("LISA", "1234");
        String result = instance.seleccionar();
        assertEquals("LISA", result);
    } 
    @Test
    public void testExistencia(){
        System.out.println("existe, o no existe?");
        ModeloLogin instance = new ModeloLogin("Lauta","2221");
        boolean result = instance.comprobarExistencia("Lauta",2221);
        assertEquals(false,result);
    }
    @Test
    public void testExistencia2(){
        System.out.println("no existe mepa");
        ModeloLogin instance = new ModeloLogin("LISA","1234");
        boolean result = instance.comprobarExistencia("LISA",1234);
        assertEquals(true,result);
    }

}
