/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class ModeloEnvaseTest {

    public ModeloEnvaseTest() {
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
    @Test
    public void testRepetido() {
        System.out.println("repetido");
        Envase miAl = new Envase();
        miAl.setNombre("frasco");
        miAl.setTipo("amanecer");
        miAl.setVolumen(10);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        boolean expResult = false;
        boolean result = instance.repetido(miAl);
        assertEquals(expResult, result);
    }

    @Test
    public void testRepetido2() {
        System.out.println("repetido");
        
        Envase miAl = new Envase();
        miAl.setNombre("bote");
        miAl.setTipo("corona");
        miAl.setVolumen(250);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        boolean expResult = false;
        boolean result = instance.repetido(miAl);
        assertEquals(expResult, result);
    }

    @Test
    public void testGuardarEnvaseNuevo() {
        System.out.println("guardarEnvaseNuevo");
        Envase miAl = new Envase();
        miAl.setNombre("bote");
        miAl.setTipo("corona");
        miAl.setVolumen(150);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        instance.guardarEnvaseNuevo(miAl);
    }
    @Test
    public void testDarTodosLosEnvases() {
        System.out.println("DarTodosLosEnvases");
        Envase miAl = new Envase();
        miAl.setNombre("bote");
        miAl.setTipo("corona");
        miAl.setVolumen(150);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        instance.guardarEnvaseNuevo(miAl);
        List andrea = instance.darTodosLosEnvases();
        assertEquals(false,andrea.isEmpty());
    }
    @Test
    public void testDarUnEnvase(){
        System.out.println("DAR ENVASE");
        int uno = 1;
        ModeloEnvase instance = new ModeloEnvase();
        Envase env = instance.darUno(uno);
        assertTrue(env instanceof Envase);
    }
    @Test
    public void testModificarEnvase(){
        System.out.println("MODIFICAR");
        int uno = 1;
        ModeloEnvase instance = new ModeloEnvase();
        Envase env = instance.darUno(uno);
        env.setNombre("bote1");
        instance.modificarEnvase(env);
        Envase env2 = instance.darUno(uno);
        assertNotEquals(env,env2);
    }

}
