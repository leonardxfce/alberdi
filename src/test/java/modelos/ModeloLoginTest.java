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

/**
 * @author lauta
 */
public class ModeloLoginTest {

    private Connection connection;
    private String url = "jdbc:sqlite:sample.db";
    private Statement statement;

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
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE if not exists USUARIOS (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "USUARIO text,\n"
                    + "PASSWORD text\n"
                    + ");");
            statement.executeUpdate("CREATE TABLE if not exists ENVASE (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "NOMBRE text,\n"
                    + "TIPO text,\n"
                    + "VOLUMEN int,\n"
                    + "DESCRIPCION text\n"
                    + ");");
            statement.executeUpdate("CREATE TABLE if not exists TAPA (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "NOMBRE text,\n"
                    + "DESCRIPCION text\n"
                    + ");");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of seleccionar method, of class ModeloLogin.
     */
    @Test
    public void testExistencia() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("leo");
        atributosLogin.add("2221");
        ModeloLogin instance = new ModeloLogin("leo", "2221");
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(false, result);
    }

    public void testinsert() {
        ArrayList<String> atributosLogin = new ArrayList<>();
        atributosLogin.add("JUANES");
        atributosLogin.add("2610");
        ModeloLogin instance = new ModeloLogin("JUANES", "2610");
        instance.insertar();
        boolean result = instance.comprobarExistencia(atributosLogin);
        assertEquals(true, result);
    }

}
