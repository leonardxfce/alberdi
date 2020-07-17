/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.junit.*;
import principal.Configurar;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author caro_
 */
public class ModeloEnvaseTest {

    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @Test
    public void testRepetido() {
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
        Envase miAl = new Envase();
        miAl.setNombre("bote");
        miAl.setTipo("corona");
        miAl.setVolumen(150);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        instance.guardarEnvaseNuevo(miAl);
    }
    
    @Test
    public void testGuardarEnvSinRepetir(){
        Envase envase = new Envase();
        envase.setNombre("bote");
        envase.setTipo("corona");
        envase.setVolumen(150);
        envase.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        boolean result= instance.repetido(envase);
        assertEquals(true,result);
       
    }
   

    @Test
    public void testDarTodosLosEnvases() {
        Envase miAl = new Envase();
        miAl.setNombre("bote");
        miAl.setTipo("corona");
        miAl.setVolumen(150);
        miAl.setDescripcion("vidrio");
        ModeloEnvase instance = new ModeloEnvase();
        instance.guardarEnvaseNuevo(miAl);
        List andrea = instance.darTodosLosEnvases();
        assertEquals(false, andrea.isEmpty());
    }

    @Test
    public void testDarUnEnvase() {
        int uno = 1;
        ModeloEnvase instance = new ModeloEnvase();
        Envase env = instance.darUno(uno);
        assertTrue(env instanceof Envase);
    }

    @Test
    public void testModificarEnvase() {
        int uno = 1;
        ModeloEnvase instance = new ModeloEnvase();
        Envase env = instance.darUno(uno);
        env.setNombre("bote1");
        instance.modificarEnvase(env);
        Envase env2 = instance.darUno(uno);
        assertNotEquals(env, env2);
    }

}
