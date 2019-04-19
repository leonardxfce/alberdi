/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.nio.charset.Charset;
import org.junit.BeforeClass;
import org.junit.Test;
import principal.Configurar;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.assertEquals;

/**
 * @author lauta
 */
public class ModeloLoginTest {

    @BeforeClass
    public static void setUpClass() {
        new Configurar();
    }

    @Test
    public void testExistencia() {
        Usuario user = new Usuario("leo","2221");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistencia(user);
        assertEquals(false, result);
    }
    @Test
    public void testExistenciaUsuario1() {
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistenciaUser("santiago");
        assertEquals(false, result);
    }
    @Test
    public void testExistenciaUsuario2() {
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.comprobarExistenciaUser("marcelo");
        assertEquals(true, result);
    }
    @Test
    public void testInsert() {
        byte[] array = new byte[7]; // length is bounded by 7
    new Random().nextBytes(array);
    String generatedString = new String(array, Charset.forName("UTF-8"));
        Usuario user = new Usuario(generatedString,"123");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.insertar(user);
        assertEquals(true,result);
    }
    @Test
    public void testInsertRepetido() {
        Usuario user = new Usuario("lautaro","12345");
        ModeloLogin instance = new ModeloLogin();
        boolean result = instance.insertar(user);
        assertEquals(false,result);
    }


}
