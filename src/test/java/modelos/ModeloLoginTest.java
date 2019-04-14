/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.junit.BeforeClass;
import org.junit.Test;
import principal.Configurar;

import java.util.ArrayList;

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
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("leo");
        atributosLogin.add("2221");
        ModeloLogin instance = new ModeloLogin("leo", "2221");
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(false, result);
    }

    public void testInsert() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("JUANES");
        atributosLogin.add("2610");
        ModeloLogin instance = new ModeloLogin("JUANES", "2610");
        instance.insertar();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(true, result);
    }

}
