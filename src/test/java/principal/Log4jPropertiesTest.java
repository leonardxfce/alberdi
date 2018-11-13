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
public class Log4jPropertiesTest {
    
    public Log4jPropertiesTest() {
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
    public void testLeerPropiedadLog4j() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.rootLogger");
        String expResult = "DEBUG, stdout, file";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j1() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.stdout");
        String expResult = "org.apache.log4j.ConsoleAppender";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j2() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.stdout.Target");
        String expResult = "System.out";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j3() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.stdout.layout");
        String expResult = "org.apache.log4j.PatternLayout";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j4() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.stdout.layout.ConversionPattern");
        String expResult = "%m%n";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j5() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file");
        String expResult = "org.apache.log4j.RollingFileAppender";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j6() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file.File");
        String expResult = "juegos.log";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j7() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file.MaxFileSize");
        String expResult = "5MB";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j8() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file.MaxBackupIndex");
        String expResult = "10";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j9() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file.layout");
        String expResult = "org.apache.log4j.PatternLayout";
        assertEquals(expResult, resultado);
    }
    @Test
    public void testLeerPropiedadLog4j10() {
        ManejadorProperties log4j = new ManejadorProperties(2);
        String resultado  = log4j.leerPropiedad("log4j.appender.file.layout.ConversionPattern");
        String expResult = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
        assertEquals(expResult, resultado);
    }
}
